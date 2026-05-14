package org.opentmf.dnext.v4.tmf639.model;

import static org.opentmf.commons.util.JacksonUtil.getDefaultObjectMapper;
import static org.opentmf.commons.util.JacksonUtil.jsonToObject;
import static org.opentmf.commons.util.JacksonUtil.objectToJson;
import static org.opentmf.commons.util.JacksonUtil.streamToObject;
import static org.opentmf.commons.validation.ValidationUtil.ensureValid;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.io.InputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.opentmf.dnext.v4.tmf639.config.DnextTmf639JacksonConfig;
import org.opentmf.v4.resource.model.LogicalResource;
import org.opentmf.v4.resource.model.PhysicalResource;
import org.opentmf.v4.resource.model.ResourceCreate;
import org.opentmf.v4.resource.model.ResourceUpdate;

/**
 * @author Gokhan Demir
 */
class DnextTmf639ModelTests {

  @BeforeAll
  static void beforeAll() {
    DnextTmf639JacksonConfig.registerExtensions(getDefaultObjectMapper());
  }

  private InputStream stream(String jsonFileNameWithoutExtension) {
    return this.getClass().getClassLoader().getResourceAsStream(
        "tmf639/" + jsonFileNameWithoutExtension + ".json");
  }

  static Stream<Arguments> jsonClassDuo() {
    return Stream.of(
        arguments("logical_resource_with_at_type", LogicalResource.class),
        arguments("logical_resource_without_at_type", LogicalResource.class),
        arguments("physical_resource_with_at_type", PhysicalResource.class),
        arguments("physical_resource_without_at_type", PhysicalResource.class)
    );
  }

  @ParameterizedTest
  @MethodSource("jsonClassDuo")
  void test_extendedJson_deserializesSuccessfully_andProducesSameObject_whenSerializedAgain(
      String originalJson, Class<?> clazz) {
    Object object = streamToObject(stream(originalJson), clazz);
    Assertions.assertNotNull(object);
    ensureValid(object);
    String newJson = objectToJson(object);
    org.assertj.core.api.Assertions.assertThat(object)
        .usingRecursiveComparison()
        .isEqualTo(jsonToObject(newJson, clazz));
  }

  @ParameterizedTest
  @ValueSource(strings = {"logical_resource_with_at_type", "logical_resource_without_at_type"})
  void test_deserializeLogicalResource_usesExtendedModel(String json) {
    LogicalResource resource = streamToObject(stream(json), LogicalResource.class);
    Assertions.assertInstanceOf(DnextLogicalResource.class, resource);
    var lr = (DnextLogicalResource) resource;
    Assertions.assertEquals("a", lr.getCreatedBy());
  }

  @ParameterizedTest
  @ValueSource(strings = {"physical_resource_with_at_type", "physical_resource_without_at_type"})
  void test_deserializePhysicalResource_usesExtendedModel(String json) {
    PhysicalResource resource = streamToObject(stream(json), PhysicalResource.class);
    Assertions.assertInstanceOf(DnextPhysicalResource.class, resource);
    var pr = (DnextPhysicalResource) resource;
    Assertions.assertEquals("a", pr.getCreatedBy());
  }

  @ParameterizedTest
  @ValueSource(strings = {"resource_create_with_resource_order_item"})
  void test_deserializeResourceCreate_usesExtendedModel(String json) {
    ResourceCreate rc = streamToObject(stream(json), ResourceCreate.class);
    Assertions.assertInstanceOf(DnextResourceCreate.class, rc);
    var d = (DnextResourceCreate) rc;
    Assertions.assertNotNull(d.getResourceOrderItems());
    Assertions.assertEquals("oi-1", d.getResourceOrderItems().get(0).getItemId());
  }

  @ParameterizedTest
  @ValueSource(strings = {"resource_update_with_deltas"})
  void test_deserializeResourceUpdate_usesExtendedModel(String json) {
    ResourceUpdate ru = streamToObject(stream(json), ResourceUpdate.class);
    Assertions.assertInstanceOf(DnextResourceUpdate.class, ru);
    var d = (DnextResourceUpdate) ru;
    Assertions.assertEquals("migrated", d.getStatusReason());
    Assertions.assertEquals("ro-2", d.getResourceOrderItems().get(0).getResourceOrderId());
  }

  @ParameterizedTest
  @ValueSource(strings = {"bulk_resource_create"})
  void test_deserializeBulkResourceCreate(String json) {
    DnextBulkResourceCreate bulk = streamToObject(stream(json), DnextBulkResourceCreate.class);
    Assertions.assertNotNull(bulk.getBaseResource());
    Assertions.assertInstanceOf(DnextResourceCreate.class, bulk.getBaseResource());
    Assertions.assertEquals(2, bulk.getItemCount());
    ensureValid(bulk);
  }

  @ParameterizedTest
  @ValueSource(strings = {"resource_snapshot"})
  void test_deserializeResourceSnapshot(String json) {
    DnextResourceSnapshot snap = streamToObject(stream(json), DnextResourceSnapshot.class);
    Assertions.assertEquals("ord-1", snap.getOrderId());
    Assertions.assertNotNull(snap.getSnapshotObject());
    ensureValid(snap);
  }

  @ParameterizedTest
  @ValueSource(strings = {"resource_snapshot_create"})
  void test_deserializeResourceSnapshotCreate(String json) {
    DnextResourceSnapshotCreate body = streamToObject(stream(json), DnextResourceSnapshotCreate.class);
    Assertions.assertEquals("ord-1", body.getOrderId());
    ensureValid(body);
  }
}
