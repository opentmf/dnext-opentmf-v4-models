package org.opentmf.dnext.v4.tmf639.model;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Resource snapshot create request body (DNext).
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@Required(fields = {"orderId", "orderItemId"})
public class DnextResourceSnapshotCreate {

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
}
