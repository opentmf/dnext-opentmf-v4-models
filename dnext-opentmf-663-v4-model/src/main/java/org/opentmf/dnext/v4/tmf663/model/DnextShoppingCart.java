package org.opentmf.dnext.v4.tmf663.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.opentmf.v4.common.model.Characteristic;
import org.opentmf.v4.tmf663.model.ShoppingCart;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * Shopping Cart resource is used for the temporarily selection and reservation
 * of product offerings in e-commerce, call center and retail purchase. Shopping
 * cart supports purchase of both physical and digital goods and service (e.g.
 * handset, telecom network service). Shopping Cart contain list of cart items,
 * a reference to customer (partyRole) or contact medium in case customer not
 * exist, and the total items price including promotions.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>Dnext TMF-663: Shopping Cart Management API</li>
 * </ul>
 * </p>
 *
 * @author Cezmi Aslan
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = DnextShoppingCart.class
)
@JsonTypeName("ShoppingCart")
public class DnextShoppingCart extends ShoppingCart {

  /**
   * Shopping cart characteristics extended property.
   */
  @JsonProperty("shoppingCartCharacteristic")
  private List<@Valid Characteristic> shoppingCartCharacteristics;
  private String createdBy;
  private OffsetDateTime createdDate;
  private String updatedBy;
  private OffsetDateTime updatedDate;
  private Long revision;
}