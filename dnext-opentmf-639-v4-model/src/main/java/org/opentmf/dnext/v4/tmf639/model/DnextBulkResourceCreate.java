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
import org.opentmf.v4.common.model.Extensible;

/**
 * Bulk resource create payload (DNext).
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextBulkResourceCreate.class)
@Required(fields = {"baseResource", "bulkCharacteristic", "itemCount"})
public class DnextBulkResourceCreate extends Extensible {

  private @Valid DnextResourceCreate baseResource;

  @JsonProperty("bulkCharacteristic")
  private List<@Valid DnextBulkCharacteristic> bulkCharacteristics;

  private @SafeText String identifierCharacteristicName;

  private Integer itemCount;

  private @SafeText String jobReference;
}
