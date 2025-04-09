package org.opentmf.com.dnext.v4.tmf641.model;

import static org.opentmf.commons.util.JacksonUtil.getDefaultObjectMapper;
import static org.opentmf.commons.util.JacksonUtil.jsonToObject;
import static org.opentmf.commons.util.JacksonUtil.objectToJson;
import static org.opentmf.commons.util.JacksonUtil.streamToObject;
import static org.opentmf.commons.validation.ValidationUtil.ensureValid;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.opentmf.dnext.v4.tmf641.config.DnextTmf641JacksonConfig;
import org.opentmf.dnext.v4.tmf641.model.DnextCancelServiceOrder;
import org.opentmf.dnext.v4.tmf641.model.DnextCancelServiceOrderCreate;
import org.opentmf.dnext.v4.tmf641.model.DnextServiceOrder;
import org.opentmf.dnext.v4.tmf641.model.DnextServiceOrderCreate;
import org.opentmf.dnext.v4.tmf641.model.DnextServiceOrderItem;
import org.opentmf.v4.tmf641.model.ServiceOrderCreate;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Cezmi Aslan
 */
class DnextTmf641ModelTests {

  @BeforeAll
  static void beforeAll() {
    DnextTmf641JacksonConfig.registerExtensions(getDefaultObjectMapper());
  }

  private InputStream stream(String jsonFileNameWithoutExtension) {
    return this.getClass().getClassLoader().getResourceAsStream(
        "tmf641/" + jsonFileNameWithoutExtension + ".json");
  }

  static Stream<Arguments> ShSampleJsonAndCorrespondingClassList() {
    return Stream.of(
        arguments("service_order", DnextServiceOrder.class),
        arguments("service_order_create", DnextServiceOrderCreate.class),
        arguments("cancel_service_order_create", DnextCancelServiceOrderCreate.class),
        arguments("cancel_service_order_create2", DnextCancelServiceOrderCreate.class),
        arguments("cancel_service_order", DnextCancelServiceOrder.class),
        arguments("service_order_create", ServiceOrderCreate.class));
  }

  @ParameterizedTest
  @MethodSource("ShSampleJsonAndCorrespondingClassList")
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

  @Test
  void test_serviceOrderItemWithInvalidAction_throwsException() throws IOException {
    try (var invalid = stream("service_order_create_create_invalid_action");
        var valid = stream("service_order_create")) {
      assertThrows(
          IllegalArgumentException.class, () -> streamToObject(invalid, ServiceOrderCreate.class));
      var serviceOrderCreate = streamToObject(valid, ServiceOrderCreate.class);
      var item = serviceOrderCreate.getServiceOrderItems().get(0);
      assertInstanceOf(DnextServiceOrderItem.class, item);
      assertEquals("statusChange.Suspend", item.getAction());
    }
  }
}