package com.pia.dnext.v4.tmf622.model;

import static com.pia.commons.util.JacksonUtil.getDefaultObjectMapper;
import static com.pia.commons.util.JacksonUtil.jsonToObject;
import static com.pia.commons.util.JacksonUtil.objectToJson;
import static com.pia.commons.util.JacksonUtil.streamToObject;
import static com.pia.commons.validation.ValidationUtil.ensureValid;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import com.pia.dnext.v4.tmf622.config.DnextTmf622JacksonConfig;
import com.pia.dnext.v4.tmf622.model.DnextProductOrder;
import com.pia.dnext.v4.tmf622.model.DnextProductOrderCreate;
import com.pia.dnext.v4.tmf622.model.DnextProductOrderItem;
import com.pia.tmf.v4.tmf622.model.ProductOrder;
import com.pia.tmf.v4.tmf622.model.ProductOrderItem;
import com.pia.tmf.v4.tmf622.model.ProductOrderStateChangeEvent;
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
class DnextTmf622ModelTests {

  @BeforeAll
  static void beforeAll() {
    DnextTmf622JacksonConfig.registerExtensions(getDefaultObjectMapper());
  }

  private InputStream stream(String jsonFileNameWithoutExtension) {
    return this.getClass().getClassLoader().getResourceAsStream(
        "tmf622/" + jsonFileNameWithoutExtension + ".json");
  }

  static Stream<Arguments> ShSampleJsonAndCorrespondingClassList() {
    return Stream.of(
        arguments("product_order_create", DnextProductOrderCreate.class),
        arguments("product_order", DnextProductOrder.class),
        arguments("product_order_state_change_event", ProductOrderStateChangeEvent.class)
    );
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
  void test_deserializeProductOrder_usesExtendedModel() {
    ProductOrder productOrder = streamToObject(stream("product_order"), ProductOrder.class);
    Assertions.assertInstanceOf(DnextProductOrder.class, productOrder);
    var po = (DnextProductOrder) productOrder;
    Assertions.assertEquals(3, po.getOrderCharacteristic().size());
    for (ProductOrderItem item : po.getProductOrderItems()) {
      Assertions.assertInstanceOf(DnextProductOrderItem.class, item);
      var dnexItem = (DnextProductOrderItem) item;
      Assertions.assertEquals(2, dnexItem.getRelatedParties().size());
    }
    Assertions.assertNotNull(po.getShoppingCarts());
    Assertions.assertEquals(1, po.getShoppingCarts().size());
  }

  @Test
  void test_deserializeProductOrderCreate_usesExtendedModel() {
    var productOrderCreate = streamToObject(stream("product_order_create"),
        DnextProductOrderCreate.class);
    Assertions.assertEquals(3, productOrderCreate.getOrderCharacteristic().size());
    for (ProductOrderItem item : productOrderCreate.getProductOrderItems()) {
      Assertions.assertInstanceOf(DnextProductOrderItem.class, item);
      var dnexItem = (DnextProductOrderItem) item;
      Assertions.assertEquals(2, dnexItem.getRelatedParties().size());
    }
    Assertions.assertNotNull(productOrderCreate.getShoppingCarts());
    Assertions.assertEquals(1, productOrderCreate.getShoppingCarts().size());
  }

  @Test
  void test_deserializeEventWithProductOrder_usesExtendedModel() {
    var event = streamToObject(stream("product_order_state_change_event"),
        ProductOrderStateChangeEvent.class);
    ProductOrder productOrder = event.getEvent().getProductOrder();
    Assertions.assertInstanceOf(DnextProductOrder.class, productOrder);
    var po = (DnextProductOrder) productOrder;
    Assertions.assertEquals(3, po.getOrderCharacteristic().size());
    for (ProductOrderItem item : po.getProductOrderItems()) {
      Assertions.assertInstanceOf(DnextProductOrderItem.class, item);
      var dnexItem = (DnextProductOrderItem) item;
      Assertions.assertEquals(2, dnexItem.getRelatedParties().size());
    }
    Assertions.assertNotNull(po.getShoppingCarts());
    Assertions.assertEquals(1, po.getShoppingCarts().size());

  }
}
