package com.pia.dnext.v4.tmf622.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pia.dnext.v4.common.config.DnextTmfCommonJacksonConfig;
import com.pia.dnext.v4.tmf622.model.DnextProductOrder;
import com.pia.dnext.v4.tmf622.model.DnextProductOrderItem;
import com.pia.tmf.v4.tmf622.config.Tmf622JacksonConfig;
import com.pia.tmf.v4.tmf622.model.ProductOrder;
import com.pia.tmf.v4.tmf622.model.ProductOrderItem;
import lombok.Generated;

/**
 * @author Gokhan Demir
 */
public final class DnextTmf622JacksonConfig {

  @Generated
  private DnextTmf622JacksonConfig() {}

  public static void registerExtensions(ObjectMapper objectMapper) {
    Tmf622JacksonConfig.registerExtensions(objectMapper);
    DnextTmfCommonJacksonConfig.registerExtensions(objectMapper);
    objectMapper.registerSubtypes(DnextProductOrder.class, DnextProductOrderItem.class);
    objectMapper.addMixIn(ProductOrder.class, DnextProductOrder.class);
    objectMapper.addMixIn(ProductOrderItem.class, DnextProductOrderItem.class);
  }
}
