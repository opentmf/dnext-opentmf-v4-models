package org.opentmf.dnext.v4.tmf641.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.opentmf.dnext.v4.common.config.DnextTmfCommonJacksonConfig;
import org.opentmf.dnext.v4.tmf641.model.DnextCancelServiceOrder;
import org.opentmf.dnext.v4.tmf641.model.DnextCancelServiceOrderCreate;
import org.opentmf.dnext.v4.tmf641.model.DnextServiceOrder;
import org.opentmf.dnext.v4.tmf641.model.DnextServiceOrderCreate;
import org.opentmf.dnext.v4.tmf641.model.DnextServiceOrderItem;
import org.opentmf.v4.tmf641.config.Tmf641JacksonConfig;
import org.opentmf.v4.tmf641.model.CancelServiceOrder;
import org.opentmf.v4.tmf641.model.CancelServiceOrderCreate;
import org.opentmf.v4.tmf641.model.ServiceOrder;
import org.opentmf.v4.tmf641.model.ServiceOrderCreate;
import org.opentmf.v4.tmf641.model.ServiceOrderItem;
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
        DnextCancelServiceOrder.class,
        DnextCancelServiceOrderCreate.class);
    objectMapper.addMixIn(ServiceOrder.class, DnextServiceOrder.class);
    objectMapper.addMixIn(ServiceOrderCreate.class, DnextServiceOrderCreate.class);
    objectMapper.addMixIn(ServiceOrderItem.class, DnextServiceOrderItem.class);
    objectMapper.addMixIn(CancelServiceOrder.class, DnextCancelServiceOrder.class);
    objectMapper.addMixIn(CancelServiceOrderCreate.class, DnextCancelServiceOrderCreate.class);
  }
}
