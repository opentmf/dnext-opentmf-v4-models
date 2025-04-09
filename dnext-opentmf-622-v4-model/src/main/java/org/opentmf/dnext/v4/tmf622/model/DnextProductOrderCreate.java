package org.opentmf.dnext.v4.tmf622.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.v4.common.model.Characteristic;
import org.opentmf.v4.tmf622.model.ProductOrderCreate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = DnextProductOrderCreate.class
)
public class DnextProductOrderCreate extends ProductOrderCreate {

  @SafeId
  @Size(max = 100)
  private String id;

  @Valid private List<Characteristic> orderCharacteristic;

  @JsonProperty("shoppingCart")
  private List<@Valid ShoppingCartRef> shoppingCarts;
}
