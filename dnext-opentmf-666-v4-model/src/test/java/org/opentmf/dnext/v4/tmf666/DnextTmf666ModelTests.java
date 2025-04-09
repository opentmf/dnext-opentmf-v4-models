package org.opentmf.dnext.v4.tmf666;


import org.opentmf.dnext.v4.tmf666.config.DnextTmf666JacksonConfig;
import org.opentmf.dnext.v4.tmf666.model.DnextBillingAccount;
import org.opentmf.v4.tmf666.model.BillingAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.InputStream;
import java.util.stream.Stream;

import static org.opentmf.commons.util.JacksonUtil.*;
import static org.opentmf.commons.util.JacksonUtil.jsonToObject;
import static org.opentmf.commons.validation.ValidationUtil.ensureValid;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/**
 * @author Gokhan Demir
 */
class DnextTmf666ModelTests
{
    @BeforeAll
    static void beforeAll() {
        DnextTmf666JacksonConfig.registerExtensions(getDefaultObjectMapper());
    }

    private InputStream stream(String jsonFileNameWithoutExtension) {
        return this.getClass().getClassLoader().getResourceAsStream(
                "tmf666/" + jsonFileNameWithoutExtension + ".json");
    }

    static Stream<Arguments> ShSampleJsonAndCorrespondingClassList() {
        return Stream.of(
                arguments("billing-account-with-at-type", DnextBillingAccount.class),
                arguments("billing-account-without-at-type", DnextBillingAccount.class)
        );
    }

    @ParameterizedTest
    @MethodSource("ShSampleJsonAndCorrespondingClassList")
    void test_extendedJson_deserializesSuccessfully_andProducesSameObject_whenSerializedAgain(
            String originalJson, Class<?> clazz) {
        Object object = streamToObject(stream(originalJson), clazz);
        Assertions.assertNotNull(object);
        ensureValid(object);
        var newJson = objectToJson(object);
        org.assertj.core.api.Assertions.assertThat(object)
                .usingRecursiveComparison()
                .isEqualTo(jsonToObject(newJson, clazz));
    }

    @ParameterizedTest
    @ValueSource(strings = {"billing-account-with-at-type", "billing-account-without-at-type"})
    void test_deserializeService_usesExtendedModel(String json) {
        var billing = streamToObject(stream(json), BillingAccount.class);
        Assertions.assertInstanceOf(DnextBillingAccount.class, billing);
        var b = (DnextBillingAccount) billing;
        Assertions.assertEquals("344a541d-8bb5-4f02-a68e-c3058d8aede6", b.getId());
    }

}
