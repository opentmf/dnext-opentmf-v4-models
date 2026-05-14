package org.opentmf.dnext.v4.tmf639.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.opentmf.dnext.v4.common.config.DnextTmfCommonJacksonConfig;
import org.opentmf.dnext.v4.tmf639.model.DnextBulkCharacteristic;
import org.opentmf.dnext.v4.tmf639.model.DnextBulkResourceCharacteristicUpdate;
import org.opentmf.dnext.v4.tmf639.model.DnextBulkResourceCreate;
import org.opentmf.dnext.v4.tmf639.model.DnextBulkResourceStatusUpdate;
import org.opentmf.dnext.v4.tmf639.model.DnextLogicalResource;
import org.opentmf.dnext.v4.tmf639.model.DnextPhysicalResource;
import org.opentmf.dnext.v4.tmf639.model.DnextRelatedResourceOrderItem;
import org.opentmf.dnext.v4.tmf639.model.DnextResourceCreate;
import org.opentmf.dnext.v4.tmf639.model.DnextResourceSnapshot;
import org.opentmf.dnext.v4.tmf639.model.DnextResourceUpdate;
import org.opentmf.v4.resource.model.LogicalResource;
import org.opentmf.v4.resource.model.PhysicalResource;
import org.opentmf.v4.resource.model.ResourceCreate;
import org.opentmf.v4.resource.model.ResourceUpdate;
import org.opentmf.v4.tmf639.config.Tmf639JacksonConfig;
import lombok.Generated;

/**
 * @author Cezmi Aslan
 */
public final class DnextTmf639JacksonConfig {

  @Generated
  private DnextTmf639JacksonConfig() {}

  public static void registerExtensions(ObjectMapper objectMapper) {
    Tmf639JacksonConfig.registerExtensions(objectMapper);
    DnextTmfCommonJacksonConfig.registerExtensions(objectMapper);
    objectMapper.registerSubtypes(
        DnextLogicalResource.class,
        DnextPhysicalResource.class,
        DnextResourceCreate.class,
        DnextResourceUpdate.class,
        DnextRelatedResourceOrderItem.class,
        DnextBulkResourceCreate.class,
        DnextBulkCharacteristic.class,
        DnextBulkResourceCharacteristicUpdate.class,
        DnextBulkResourceStatusUpdate.class,
        DnextResourceSnapshot.class);
    objectMapper.addMixIn(LogicalResource.class, DnextLogicalResource.class);
    objectMapper.addMixIn(PhysicalResource.class, DnextPhysicalResource.class);
    objectMapper.addMixIn(ResourceCreate.class, DnextResourceCreate.class);
    objectMapper.addMixIn(ResourceUpdate.class, DnextResourceUpdate.class);
  }
}
