package com.pia.dnext.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.pia.tmf.v4.common.model.CategoryRef;
import com.pia.tmf.v4.tmf620.model.ProductSpecificationCharacteristic;
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
  private boolean isUnique;
  @JsonProperty("isVisible")
  private boolean isVisible;
  private List<CategoryRef> category;
}
