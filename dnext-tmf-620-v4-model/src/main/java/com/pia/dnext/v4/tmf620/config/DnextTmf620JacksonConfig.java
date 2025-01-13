package com.pia.dnext.v4.tmf620.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pia.dnext.v4.common.config.DnextTmfCommonJacksonConfig;
import com.pia.dnext.v4.tmf620.model.DnextProductSpecification;
import com.pia.dnext.v4.tmf620.model.DnextProductSpecificationCharacteristic;
import com.pia.tmf.v4.tmf620.config.Tmf620JacksonConfig;
import com.pia.tmf.v4.tmf620.model.ProductSpecification;
import com.pia.tmf.v4.tmf620.model.ProductSpecificationCharacteristic;
import lombok.Generated;

/**
 * @author Cezmi Aslan
 */
public final class DnextTmf620JacksonConfig {

  @Generated
  private DnextTmf620JacksonConfig() {}

  public static void registerExtensions(ObjectMapper objectMapper) {
    Tmf620JacksonConfig.registerExtensions(objectMapper);
    DnextTmfCommonJacksonConfig.registerExtensions(objectMapper);
    objectMapper.registerSubtypes(DnextProductSpecification.class);
    objectMapper.addMixIn(ProductSpecification.class, DnextProductSpecification.class);
    objectMapper.addMixIn(ProductSpecificationCharacteristic.class, DnextProductSpecificationCharacteristic.class);
  }
}
