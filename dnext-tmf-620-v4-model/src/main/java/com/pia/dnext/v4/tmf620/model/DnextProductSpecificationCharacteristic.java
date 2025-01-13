package com.pia.dnext.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.pia.tmf.v4.tmf620.model.Category;
import com.pia.tmf.v4.tmf620.model.ProductSpecificationCharacteristic;
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
    defaultImpl = ProductSpecificationCharacteristic.class)
@JsonTypeName("productSpecCharacteristic")
public class DnextProductSpecificationCharacteristic extends ProductSpecificationCharacteristic {

  private boolean mandatory;
  private boolean isUnique;
  private boolean isVisible;
  @JsonProperty("category")
  private Category category = null;
}
