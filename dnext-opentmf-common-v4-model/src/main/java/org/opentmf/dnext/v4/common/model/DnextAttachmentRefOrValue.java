package org.opentmf.dnext.v4.common.model;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXISTING_PROPERTY;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.AttachmentRefOrValue;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = EXISTING_PROPERTY,
    defaultImpl = DnextAttachmentRefOrValue.class
)
public class DnextAttachmentRefOrValue extends AttachmentRefOrValue {

  private @SafeText String createdBy;
  private OffsetDateTime createdDate;
  private @SafeText String updatedBy;
  private OffsetDateTime updatedDate;
}
