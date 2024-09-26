package com.pia.dnext.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.pia.tmf.v4.tmf641.model.ServiceOrderItem;
import jakarta.validation.constraints.Pattern;

/**
 * @author Cezmi Aslan
 */
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextServiceOrderItem.class)
@JsonTypeName("ServiceOrderItem")
public class DnextServiceOrderItem extends ServiceOrderItem {

  @Pattern(
      regexp = "add|modify|delete|noChange|statusChange.Suspend|statusChange.Resume",
      flags = Pattern.Flag.CASE_INSENSITIVE)
  @Override
  public String getAction() {
    return super.getAction();
  }
}
