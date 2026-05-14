package org.opentmf.dnext.v4.tmf639.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;

/**
 * Related resource order item reference (DNext).
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextRelatedResourceOrderItem.class)
@Required(fields = {"itemId", "resourceOrderId"})
public class DnextRelatedResourceOrderItem extends Extensible {

  @JsonProperty("@referredType")
  private @SafeText String atReferredType;

  private @SafeText String itemAction;

  @SafeId
  @Size(max = 100)
  private String itemId;

  private URI resourceOrderHref;

  @SafeId
  @Size(max = 100)
  private String resourceOrderId;

  private @SafeText String role;
}
