package org.opentmf.dnext.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.opentmf.v4.common.model.Characteristic;
import org.opentmf.v4.tmf641.model.ServiceOrderItem;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Cezmi Aslan
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextServiceOrderItem.class)
@JsonTypeName("ServiceOrderItem")
public class DnextServiceOrderItem extends ServiceOrderItem {

  @JsonProperty("orderItemCharacteristic")
  private List<@Valid Characteristic> orderItemCharacteristics;

  @Pattern(
      regexp = "add|modify|delete|noChange|statusChange.Suspend|statusChange.Resume",
      flags = Pattern.Flag.CASE_INSENSITIVE)
  @Override
  public String getAction() {
    return super.getAction();
  }
}
