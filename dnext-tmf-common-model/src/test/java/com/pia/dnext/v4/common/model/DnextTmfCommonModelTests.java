package com.pia.dnext.v4.common.model;

import static com.pia.commons.util.JacksonUtil.getDefaultObjectMapper;
import static com.pia.commons.util.JacksonUtil.inputStream;
import static com.pia.commons.util.JacksonUtil.jsonToObject;
import static com.pia.commons.util.JacksonUtil.objectToJson;
import static com.pia.commons.util.JacksonUtil.streamToObject;
import static com.pia.commons.validation.ValidationUtil.ensureValid;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pia.dnext.v4.common.config.DnextTmfCommonJacksonConfig;
import com.pia.dnext.v4.common.model.DnextAttachment;
import com.pia.dnext.v4.common.model.DnextAttachmentRefOrValue;
import com.pia.tmf.v4.common.config.TmfCommonJacksonConfig;
import com.pia.tmf.v4.common.model.Attachment;
import com.pia.tmf.v4.common.model.AttachmentRefOrValue;
import java.io.InputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Gokhan Demir
 */
class DnextTmfCommonModelTests {

  @BeforeAll
  static void beforeAll() {
    ObjectMapper objectMapper = getDefaultObjectMapper();
    TmfCommonJacksonConfig.registerExtensions(objectMapper);
    DnextTmfCommonJacksonConfig.registerExtensions(objectMapper);
  }

  private InputStream stream(String jsonFileNameWithoutExtension) {
    return inputStream("common/" + jsonFileNameWithoutExtension + ".json");
  }

  static Stream<Arguments> dnextTmfCommonSampleJsonAndCorrespondingClassList() {
    return Stream.of(
        arguments("attachment", Attachment.class),
        arguments("attachment", AttachmentRefOrValue.class)
    );
  }

  @ParameterizedTest
  @MethodSource("dnextTmfCommonSampleJsonAndCorrespondingClassList")
  void test_officialJson_deserializesSuccessfully_andProducesSameObject_whenSerializedAgain(
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
  void testAttachment_deserializesAs_DnextAttachment() {
    Object obj = streamToObject(stream("attachment"), Attachment.class);
    Assertions.assertNotNull(obj);
    Assertions.assertEquals(DnextAttachment.class, obj.getClass());
  }

  @Test
  void testAttachmentRefOrValue_deserializesAs_DnextAttachmentRefOrValue() {
    Object obj = streamToObject(stream("attachment"), AttachmentRefOrValue.class);
    Assertions.assertNotNull(obj);
    Assertions.assertEquals(DnextAttachmentRefOrValue.class, obj.getClass());
  }
}
