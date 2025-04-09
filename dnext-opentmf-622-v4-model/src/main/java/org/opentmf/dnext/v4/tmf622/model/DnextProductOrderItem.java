package org.opentmf.dnext.v4.tmf622.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.opentmf.v4.common.model.Characteristic;
import org.opentmf.v4.common.model.RelatedParty;
import org.opentmf.v4.tmf622.model.ProductOrderItem;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextProductOrderItem.class)
@JsonTypeName("ProductOrderItem")
public class DnextProductOrderItem extends ProductOrderItem {

  private List<@Valid Characteristic> orderItemCharacteristic;

  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;
}
