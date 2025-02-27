package com.pia.dnext.v4.tmf620.model;

import static com.pia.commons.util.JacksonUtil.getDefaultObjectMapper;
import static com.pia.commons.util.JacksonUtil.jsonToObject;
import static com.pia.commons.util.JacksonUtil.objectToJson;
import static com.pia.commons.util.JacksonUtil.streamToObject;
import static com.pia.commons.validation.ValidationUtil.ensureValid;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import com.pia.dnext.v4.tmf620.config.DnextTmf620JacksonConfig;
import com.pia.tmf.v4.tmf620.model.ProductSpecification;
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
class DnextTmf620ModelTests {

  @BeforeAll
  static void beforeAll() {
    DnextTmf620JacksonConfig.registerExtensions(getDefaultObjectMapper());
  }

  private InputStream stream(String jsonFileNameWithoutExtension) {
    return this.getClass().getClassLoader().getResourceAsStream(
        "tmf620/" + jsonFileNameWithoutExtension + ".json");
  }

  static Stream<Arguments> ShSampleJsonAndCorrespondingClassList() {
    return Stream.of(
        arguments("product-specification", DnextProductSpecification.class));
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
  void test_deserializeProductSpecification_usesExtendedModel() {
    var productSpec = streamToObject(stream("product-specification"), ProductSpecification.class);
    Assertions.assertInstanceOf(DnextProductSpecification.class, productSpec);
    var dnextPs = (DnextProductSpecification) productSpec;
    Assertions.assertNotNull(dnextPs.getPExtension());
    Assertions.assertEquals(1, dnextPs.getPExtension().getFulfillmentSpecificationOperation().size());
  }

  @Test
  void test_deserializeProductSpecification_usesExtendedCharacteristicModel() {
    var productSpec = streamToObject(stream("product-specification"), ProductSpecification.class);
    var dnextProductSpecificationCharacteristic = (DnextProductSpecificationCharacteristic) productSpec.getProductSpecCharacteristics().get(0);
    Assertions.assertNotNull(dnextProductSpecificationCharacteristic.getCategory());
    Assertions.assertTrue(dnextProductSpecificationCharacteristic.isMandatory());
    Assertions.assertFalse(dnextProductSpecificationCharacteristic.isUnique());
  }

  @Test
  void test_deserializeProductOffering_usesExtendedCharacteristicModel() {
    var productOffering = streamToObject(stream("product-offering"), DnextProductOffering.class);
    var prodSpecCharValueUse = (DnextProductSpecificationCharacteristicValueUse) productOffering.getProdSpecCharValueUses().get(0);
    var rules = productOffering.getRules();
    Assertions.assertEquals(1,rules.size());
    Assertions.assertNotNull(prodSpecCharValueUse.getCategory());
    Assertions.assertTrue(prodSpecCharValueUse.isMandatory());
    Assertions.assertFalse(prodSpecCharValueUse.isVisible());
    Assertions.assertTrue(prodSpecCharValueUse.isConfigurable());
    Assertions.assertNotNull(prodSpecCharValueUse.getCharacteristicType());
    Assertions.assertNotNull(prodSpecCharValueUse.getRegex());
  }
}
