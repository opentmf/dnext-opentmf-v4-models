package org.opentmf.dnext.v4.tmf663.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.opentmf.v4.common.model.Characteristic;
import org.opentmf.v4.tmf663.model.CartItem;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @author Cezmi Aslan
 */
@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = DnextCartItem.class
)
@JsonTypeName("CartItem")
public class DnextCartItem extends CartItem{
  /**
   * Shopping cart item characteristics extended property.
   */
  @JsonProperty("cartItemCharacteristic")
  private List<@Valid Characteristic> cartItemCharacteristics;

}
