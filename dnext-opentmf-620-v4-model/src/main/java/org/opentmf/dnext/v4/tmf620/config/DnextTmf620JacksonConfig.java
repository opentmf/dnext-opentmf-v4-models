package org.opentmf.dnext.v4.tmf620.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.opentmf.dnext.v4.common.config.DnextTmfCommonJacksonConfig;
import org.opentmf.dnext.v4.tmf620.model.DnextProductOffering;
import org.opentmf.dnext.v4.tmf620.model.DnextProductSpecification;
import org.opentmf.dnext.v4.tmf620.model.DnextProductSpecificationCharacteristic;
import org.opentmf.dnext.v4.tmf620.model.DnextProductSpecificationCharacteristicValueUse;
import org.opentmf.v4.tmf620.config.Tmf620JacksonConfig;
import org.opentmf.v4.tmf620.model.ProductOffering;
import org.opentmf.v4.tmf620.model.ProductSpecification;
import org.opentmf.v4.tmf620.model.ProductSpecificationCharacteristic;
import org.opentmf.v4.tmf620.model.ProductSpecificationCharacteristicValueUse;
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
    objectMapper.registerSubtypes(DnextProductSpecification.class, DnextProductSpecificationCharacteristic.class,
        DnextProductSpecificationCharacteristicValueUse.class, DnextProductOffering.class);
    objectMapper.addMixIn(ProductSpecification.class, DnextProductSpecification.class);
    objectMapper.addMixIn(ProductSpecificationCharacteristic.class, DnextProductSpecificationCharacteristic.class);
    objectMapper.addMixIn(ProductSpecificationCharacteristicValueUse.class, DnextProductSpecificationCharacteristicValueUse.class);
    objectMapper.addMixIn(ProductOffering.class, DnextProductOffering.class);
  }
}
