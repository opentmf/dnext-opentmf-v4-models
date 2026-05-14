package org.opentmf.dnext.v4.tmf639.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.RelatedEntityRefOrValue;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.product.model.RelatedProductOrderItem;
import org.opentmf.v4.resource.model.ResourceCreate;
import org.opentmf.v4.service.model.RelatedServiceOrderItem;

/**
 * DNext extensions for {@link ResourceCreate} (same delta fields as {@link DnextResourceUpdate}).
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextResourceCreate.class)
public class DnextResourceCreate extends ResourceCreate {

  @JsonProperty("aclRelatedParty")
  private List<@Valid RelatedParty> aclRelatedParties;

  private @Valid DnextIdentifierRange extensions;

  @JsonProperty("productOrderItem")
  private List<@Valid RelatedProductOrderItem> productOrderItems;

  @JsonProperty("relatedEntity")
  private List<@Valid RelatedEntityRefOrValue> relatedEntities;

  @JsonProperty("resourceOrderItem")
  private List<@Valid DnextRelatedResourceOrderItem> resourceOrderItems;

  @JsonProperty("serviceOrderItem")
  private List<@Valid RelatedServiceOrderItem> serviceOrderItems;

  private @SafeText String statusReason;
}
