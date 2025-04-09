package org.opentmf.dnext.v4.tmf638.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.opentmf.dnext.v4.common.config.DnextTmfCommonJacksonConfig;
import org.opentmf.dnext.v4.tmf638.model.DnextService;
import org.opentmf.v4.service.model.Service;
import org.opentmf.v4.tmf638.config.Tmf638JacksonConfig;
import lombok.Generated;

/**
 * @author Gokhan Demir
 */
public final class DnextTmf638JacksonConfig {

  @Generated
  private DnextTmf638JacksonConfig() {}

  public static void registerExtensions(ObjectMapper objectMapper) {
    Tmf638JacksonConfig.registerExtensions(objectMapper);
    DnextTmfCommonJacksonConfig.registerExtensions(objectMapper);
    objectMapper.registerSubtypes(DnextService.class);
    objectMapper.addMixIn(Service.class, DnextService.class);
  }
}
