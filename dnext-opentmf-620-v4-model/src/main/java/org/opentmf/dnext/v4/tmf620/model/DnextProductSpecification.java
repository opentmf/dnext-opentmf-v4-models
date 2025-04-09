package org.opentmf.dnext.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.opentmf.dnext.v4.common.model.FulfillmentSpecification;
import org.opentmf.v4.tmf620.model.ProductSpecification;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Cezmi Aslan
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextProductSpecification.class)
@JsonTypeName("ProductSpecification")
public class DnextProductSpecification extends ProductSpecification {

  @JsonProperty("pExtension")
  private @Valid FulfillmentSpecification pExtension;
  private String createdBy;
  private OffsetDateTime createdDate;
  private String updatedBy;
  private OffsetDateTime updatedDate;
  private Long revision;
}
