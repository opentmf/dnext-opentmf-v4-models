package org.opentmf.dnext.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.opentmf.v4.common.model.CategoryRef;
import org.opentmf.v4.tmf620.model.ProductSpecificationCharacteristic;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sezer.aydin
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextProductSpecificationCharacteristic.class)
@JsonTypeName("ProductSpecificationCharacteristic")
public class DnextProductSpecificationCharacteristic extends ProductSpecificationCharacteristic {

  private boolean mandatory;

  @JsonProperty("isUnique")
  private boolean unique;

  @JsonProperty("isVisible")
  private boolean visible;

  private List<CategoryRef> category;
}
