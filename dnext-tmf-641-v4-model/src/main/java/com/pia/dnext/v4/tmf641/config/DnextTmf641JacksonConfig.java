package com.pia.dnext.v4.tmf641.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pia.dnext.v4.common.config.DnextTmfCommonJacksonConfig;
import com.pia.dnext.v4.tmf641.model.DnextCancelServiceOrder;
import com.pia.dnext.v4.tmf641.model.DnextServiceOrder;
import com.pia.dnext.v4.tmf641.model.DnextServiceOrderCreate;
import com.pia.dnext.v4.tmf641.model.DnextServiceOrderItem;
import com.pia.tmf.v4.tmf641.config.Tmf641JacksonConfig;
import com.pia.tmf.v4.tmf641.model.CancelServiceOrder;
import com.pia.tmf.v4.tmf641.model.ServiceOrder;
import com.pia.tmf.v4.tmf641.model.ServiceOrderCreate;
import com.pia.tmf.v4.tmf641.model.ServiceOrderItem;
import lombok.Generated;

/**
 * @author Cezmi Aslan
 */
public class DnextTmf641JacksonConfig {

  @Generated
  private DnextTmf641JacksonConfig() {}

  public static void registerExtensions(ObjectMapper objectMapper) {
    Tmf641JacksonConfig.registerExtensions(objectMapper);
    DnextTmfCommonJacksonConfig.registerExtensions(objectMapper);
    objectMapper.registerSubtypes(
        DnextServiceOrder.class,
        DnextServiceOrderCreate.class,
        DnextServiceOrderItem.class,
        DnextCancelServiceOrder.class);
    objectMapper.addMixIn(ServiceOrder.class, DnextServiceOrder.class);
    objectMapper.addMixIn(ServiceOrderCreate.class, DnextServiceOrderCreate.class);
    objectMapper.addMixIn(ServiceOrderItem.class, DnextServiceOrderItem.class);
    objectMapper.addMixIn(CancelServiceOrder.class, DnextCancelServiceOrder.class);
  }
}
