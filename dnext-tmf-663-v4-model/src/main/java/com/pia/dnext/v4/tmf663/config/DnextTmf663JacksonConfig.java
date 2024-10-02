package com.pia.dnext.v4.tmf663.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pia.dnext.v4.common.config.DnextTmfCommonJacksonConfig;
import com.pia.dnext.v4.tmf663.model.DnextCartItem;
import com.pia.dnext.v4.tmf663.model.DnextShoppingCart;
import com.pia.dnext.v4.tmf663.model.DnextShoppingCartCreate;
import com.pia.dnext.v4.tmf663.model.DnextShoppingCartUpdate;
import com.pia.tmf.v4.tmf663.config.Tmf663JacksonConfig;
import com.pia.tmf.v4.tmf663.model.CartItem;
import com.pia.tmf.v4.tmf663.model.ShoppingCart;
import com.pia.tmf.v4.tmf663.model.ShoppingCartCreate;
import com.pia.tmf.v4.tmf663.model.ShoppingCartUpdate;
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
