package com.pia.dnext.v4.tmf666.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.pia.tmf.v4.common.model.ExternalReference;
import com.pia.tmf.v4.tmf666.model.BillingAccount;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        visible = true,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = DnextBillingAccount.class
)
@JsonTypeName("BillingAccount")
public class DnextBillingAccount extends BillingAccount {
    @JsonProperty("externalReference")
    List<@Valid ExternalReference> externalReferences;
}