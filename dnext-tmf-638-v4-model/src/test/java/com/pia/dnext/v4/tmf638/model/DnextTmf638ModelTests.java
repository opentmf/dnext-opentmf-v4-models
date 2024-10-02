package com.pia.dnext.v4.tmf638.model;

import static com.pia.commons.util.JacksonUtil.getDefaultObjectMapper;
import static com.pia.commons.util.JacksonUtil.jsonToObject;
import static com.pia.commons.util.JacksonUtil.objectToJson;
import static com.pia.commons.util.JacksonUtil.streamToObject;
import static com.pia.commons.validation.ValidationUtil.ensureValid;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import com.pia.dnext.v4.tmf638.config.DnextTmf638JacksonConfig;
import com.pia.dnext.v4.tmf638.model.DnextService;
import com.pia.tmf.v4.service.model.Service;
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
class DnextTmf638ModelTests {

  @BeforeAll
  static void beforeAll() {
    DnextTmf638JacksonConfig.registerExtensions(getDefaultObjectMapper());
  }

  private InputStream stream(String jsonFileNameWithoutExtension) {
    return this.getClass().getClassLoader().getResourceAsStream(
        "tmf638/" + jsonFileNameWithoutExtension + ".json");
  }

  static Stream<Arguments> jsonClassDuo() {
    return Stream.of(
        arguments("service_with_at_type", Service.class),
        arguments("service_without_at_type", Service.class)
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
  @ValueSource(strings = {"service_with_at_type", "service_without_at_type"})
  void test_deserializeService_usesExtendedModel(String json) {
    Service service = streamToObject(stream(json), Service.class);
    Assertions.assertInstanceOf(DnextService.class, service);
    var s = (DnextService) service;
    Assertions.assertEquals("a", s.getCreatedBy());
  }
}
