package org.opentmf.dnext.v4.tmf639.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;

/**
 * Bulk resource status update payload (DNext).
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextBulkResourceStatusUpdate.class)
@Required(fields = {"itemCount"})
public class DnextBulkResourceStatusUpdate extends Extensible {

  private @Valid DnextBulkCharacteristic bulkCharacteristic;

  private Integer itemCount;

  private @SafeText String jobReference;

  private @SafeText String resourceStatus;
}
