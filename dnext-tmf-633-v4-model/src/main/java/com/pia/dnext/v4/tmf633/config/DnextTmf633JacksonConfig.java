package com.pia.dnext.v4.tmf633.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pia.dnext.v4.common.config.DnextTmfCommonJacksonConfig;
import com.pia.dnext.v4.tmf633.model.DNextServiceSpecification;
import com.pia.tmf.v4.tmf633.config.Tmf633JacksonConfig;
import com.pia.tmf.v4.tmf633.model.ServiceSpecification;
import lombok.Generated;
import lombok.experimental.UtilityClass;

/**
 * @author Gokhan Demir
 */
@UtilityClass
public class DnextTmf633JacksonConfig {

  public static void registerExtensions(ObjectMapper objectMapper) {
    Tmf633JacksonConfig.registerExtensions(objectMapper);
    DnextTmfCommonJacksonConfig.registerExtensions(objectMapper);
    objectMapper.registerSubtypes(DNextServiceSpecification.class);
    objectMapper.addMixIn(ServiceSpecification.class, DNextServiceSpecification.class);
  }
}
