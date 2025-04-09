package org.opentmf.dnext.v4.tmf666.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.opentmf.dnext.v4.common.config.DnextTmfCommonJacksonConfig;
import org.opentmf.dnext.v4.tmf666.model.DnextBillingAccount;
import org.opentmf.v4.tmf666.config.Tmf666JacksonConfig;
import org.opentmf.v4.tmf666.model.BillingAccount;
import lombok.Generated;

/**
 * @author Gokhan Demir
 */
public final class DnextTmf666JacksonConfig {

    @Generated
    private DnextTmf666JacksonConfig() {
    }

    public static void registerExtensions(ObjectMapper objectMapper) {
        Tmf666JacksonConfig.registerExtensions(objectMapper);
        DnextTmfCommonJacksonConfig.registerExtensions(objectMapper);
        objectMapper.registerSubtypes(DnextBillingAccount.class);
        objectMapper.addMixIn(BillingAccount.class, DnextBillingAccount.class);
    }
}
