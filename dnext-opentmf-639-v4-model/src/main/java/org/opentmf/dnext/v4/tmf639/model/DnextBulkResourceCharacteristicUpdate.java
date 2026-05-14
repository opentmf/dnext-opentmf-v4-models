package org.opentmf.dnext.v4.tmf639.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Characteristic;
import org.opentmf.v4.common.model.Extensible;

/**
 * Bulk resource characteristic update payload (DNext).
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextBulkResourceCharacteristicUpdate.class)
@Required(fields = {"itemCount"})
public class DnextBulkResourceCharacteristicUpdate extends Extensible {

  private @Valid DnextBulkCharacteristic bulkCharacteristic;

  private Integer itemCount;

  private @SafeText String jobReference;

  @JsonProperty("resourceCharacteristicToUpsert")
  private List<@Valid Characteristic> resourceCharacteristicToUpserts;
}
