package org.opentmf.dnext.v4.tmf663.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.opentmf.dnext.v4.common.config.DnextTmfCommonJacksonConfig;
import org.opentmf.dnext.v4.tmf663.model.DnextCartItem;
import org.opentmf.dnext.v4.tmf663.model.DnextShoppingCart;
import org.opentmf.dnext.v4.tmf663.model.DnextShoppingCartCreate;
import org.opentmf.dnext.v4.tmf663.model.DnextShoppingCartUpdate;
import org.opentmf.v4.tmf663.config.Tmf663JacksonConfig;
import org.opentmf.v4.tmf663.model.CartItem;
import org.opentmf.v4.tmf663.model.ShoppingCart;
import org.opentmf.v4.tmf663.model.ShoppingCartCreate;
import org.opentmf.v4.tmf663.model.ShoppingCartUpdate;
import lombok.Generated;

/**
 * @author Cezmi Aslan
 */
public final class DnextTmf663JacksonConfig {

  @Generated
  private DnextTmf663JacksonConfig() {}

  public static void registerExtensions(ObjectMapper objectMapper) {
    Tmf663JacksonConfig.registerExtensions(objectMapper);
    DnextTmfCommonJacksonConfig.registerExtensions(objectMapper);
    objectMapper.registerSubtypes(
        DnextShoppingCart.class,
        DnextShoppingCartCreate.class,
        DnextShoppingCartUpdate.class,
        DnextCartItem.class);
    objectMapper.addMixIn(ShoppingCart.class, DnextShoppingCart.class);
    objectMapper.addMixIn(ShoppingCartCreate.class, DnextShoppingCartCreate.class);
    objectMapper.addMixIn(ShoppingCartUpdate.class, DnextShoppingCartUpdate.class);
    objectMapper.addMixIn(CartItem.class, DnextCartItem.class);
  }
}
