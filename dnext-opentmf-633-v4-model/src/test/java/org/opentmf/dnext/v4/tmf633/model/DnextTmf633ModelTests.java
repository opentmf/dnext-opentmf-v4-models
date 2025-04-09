package org.opentmf.dnext.v4.tmf633.model;

import static org.opentmf.commons.util.JacksonUtil.getDefaultObjectMapper;
import static org.opentmf.commons.util.JacksonUtil.jsonToObject;
import static org.opentmf.commons.util.JacksonUtil.objectToJson;
import static org.opentmf.commons.util.JacksonUtil.streamToObject;
import static org.opentmf.commons.validation.ValidationUtil.ensureValid;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.opentmf.dnext.v4.tmf633.config.DnextTmf633JacksonConfig;
import org.opentmf.v4.tmf633.model.ServiceSpecification;
import java.io.InputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author Gokhan Demir
 */
class DnextTmf633ModelTests {

  @BeforeAll
  static void beforeAll() {
    DnextTmf633JacksonConfig.registerExtensions(getDefaultObjectMapper());
  }

  private InputStream stream(String jsonFileNameWithoutExtension) {
    return this.getClass().getClassLoader().getResourceAsStream(
        "tmf633/" + jsonFileNameWithoutExtension + ".json");
  }

  static Stream<Arguments> sampleJsonAndCorrespondingClassList() {
    return Stream.of(
        arguments("service-specification-1", DNextServiceSpecification.class),
        arguments("service-specification-2", DNextServiceSpecification.class));
  }

  @ParameterizedTest
  @MethodSource("sampleJsonAndCorrespondingClassList")
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
  @ValueSource(strings = {"1", "2"})
  void test_deserializeProductSpecification_usesExtendedModel(String id) {
    var serviceSpec = streamToObject(stream("service-specification-" + id), ServiceSpecification.class);
    Assertions.assertInstanceOf(DNextServiceSpecification.class, serviceSpec);
    var dnextServiceSpec = (DNextServiceSpecification) serviceSpec;
    Assertions.assertNotNull(dnextServiceSpec.getPExtension());
    Assertions.assertEquals(2, dnextServiceSpec.getPExtension().getFulfillmentSpecificationOperation().size());
  }
}
