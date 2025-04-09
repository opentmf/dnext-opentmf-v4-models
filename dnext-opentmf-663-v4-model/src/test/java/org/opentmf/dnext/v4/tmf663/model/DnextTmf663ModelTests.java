package org.opentmf.dnext.v4.tmf663.model;

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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.opentmf.dnext.v4.tmf663.config.DnextTmf663JacksonConfig;
import org.opentmf.v4.tmf663.model.CartItem;
import org.opentmf.v4.tmf663.model.ShoppingCart;
import org.opentmf.v4.tmf663.model.ShoppingCartCreateEvent;

/**
 * @author Cezmi Aslan
 */
class DnextTmf663ModelTests {

  @BeforeAll
  static void beforeAll() {
    DnextTmf663JacksonConfig.registerExtensions(getDefaultObjectMapper());
  }

  private InputStream stream(String jsonFileNameWithoutExtension) {
    return this.getClass().getClassLoader().getResourceAsStream(
        "tmf663/" + jsonFileNameWithoutExtension + ".json");
  }

  static Stream<Arguments> ShSampleJsonAndCorrespondingClassList() {
    return Stream.of(
        arguments("shopping_cart_create_event", ShoppingCartCreateEvent.class),
        arguments("shopping_cart_modify", DnextShoppingCartCreate.class),
        arguments("shopping_cart_create", DnextShoppingCartCreate.class),
        arguments("shopping_cart", DnextShoppingCart.class)
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
  void test_deserializeShoppingCart_usesExtendedModel() {
    var shoppingCart = streamToObject(stream("shopping_cart"), ShoppingCart.class);
    Assertions.assertInstanceOf(DnextShoppingCart.class, shoppingCart);
    var dnextShoppingCart = (DnextShoppingCart) shoppingCart;
    Assertions.assertEquals(1, dnextShoppingCart.getShoppingCartCharacteristics().size());
    for (CartItem item : shoppingCart.getCartItems()) {
      Assertions.assertInstanceOf(DnextCartItem.class, item);
      var dItem = (DnextCartItem) item;
      Assertions.assertEquals(1, dItem.getCartItemCharacteristics().size());
    }
  }

  @Test
  void test_deserializeShoppingCartCreate_usesExtendedModel() {
    var shoppingCartCreate = streamToObject(stream("shopping_cart_create"),
        DnextShoppingCartCreate.class);
    Assertions.assertEquals(1, shoppingCartCreate.getShoppingCartCharacteristics().size());
    for (CartItem item : shoppingCartCreate.getCartItems()) {
      Assertions.assertInstanceOf(DnextCartItem.class, item);
      var dItem = (DnextCartItem) item;
      Assertions.assertEquals(1, dItem.getCartItemCharacteristics().size());
    }
  }

  @Test
  void test_deserializeShoppingCartUpdate_usesExtendedModel() {
    var shoppingCartUpdate = streamToObject(stream("shopping_cart_modify"),
        DnextShoppingCartUpdate.class);
    Assertions.assertEquals(2, shoppingCartUpdate.getShoppingCartCharacteristics().size());
    for (CartItem item : shoppingCartUpdate.getCartItems()) {
      Assertions.assertInstanceOf(DnextCartItem.class, item);
      var dItem = (DnextCartItem) item;
      Assertions.assertEquals(1, dItem.getCartItemCharacteristics().size());
    }
  }

  @Test
  void test_deserializeEventWithShoppingCart_usesExtendedModel() {
    var event = streamToObject(stream("shopping_cart_create_event"),
        ShoppingCartCreateEvent.class);
    ShoppingCart shoppigCart = event.getEvent().getShoppingCart();
    Assertions.assertInstanceOf(DnextShoppingCart.class, shoppigCart);
    var po = (DnextShoppingCart) shoppigCart;
    Assertions.assertEquals(1, po.getShoppingCartCharacteristics().size());
    for (CartItem item : po.getCartItems()) {
      Assertions.assertInstanceOf(DnextCartItem.class, item);
      var dItem = (DnextCartItem) item;
      Assertions.assertEquals(1, dItem.getCartItemCharacteristics().size());
    }
  }
}
