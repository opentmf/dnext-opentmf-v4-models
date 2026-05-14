package org.opentmf.dnext.v4.tmf639.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Entity;
import org.opentmf.v4.resource.model.Resource;

/**
 * Resource snapshot entity (DNext).
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextResourceSnapshot.class)
public class DnextResourceSnapshot extends Entity {

  private @SafeText String createdBy;

  private OffsetDateTime createdDate;

  private @SafeText String updatedBy;

  private OffsetDateTime updatedDate;

  @SafeId
  @Size(max = 100)
  private String orderId;

  @SafeId
  @Size(max = 100)
  private String orderItemId;

  @SafeId
  @Size(max = 100)
  private String parentOrderId;

  @SafeId
  @Size(max = 100)
  private String parentOrderItemId;

  private @SafeText String parentOrderType;

  private Long revision;

  private OffsetDateTime snapshotCreatedAt;

  private @Valid Resource snapshotObject;
}
