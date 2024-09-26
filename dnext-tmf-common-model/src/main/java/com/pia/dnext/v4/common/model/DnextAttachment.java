package com.pia.dnext.v4.common.model;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXISTING_PROPERTY;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.pia.tmf.v4.common.model.Attachment;
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
    defaultImpl = DnextAttachment.class
)
public class DnextAttachment extends Attachment {

  private String createdBy;
  private OffsetDateTime createdDate;
  private String updatedBy;
  private OffsetDateTime updatedDate;
}
