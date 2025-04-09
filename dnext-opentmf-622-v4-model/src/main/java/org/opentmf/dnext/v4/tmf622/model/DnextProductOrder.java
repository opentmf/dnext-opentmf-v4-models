package org.opentmf.dnext.v4.tmf622.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.opentmf.v4.common.model.Characteristic;
import org.opentmf.v4.tmf622.model.ProductOrder;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
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
    defaultImpl = DnextProductOrder.class)
@JsonTypeName("ProductOrder")
public class DnextProductOrder extends ProductOrder {

  private List<@Valid Characteristic> orderCharacteristic;
  private String createdBy;
  private OffsetDateTime createdDate;
  private String updatedBy;
  private OffsetDateTime updatedDate;
  private Long revision;

  @JsonProperty("shoppingCart")
  private List<@Valid ShoppingCartRef> shoppingCarts;

}
