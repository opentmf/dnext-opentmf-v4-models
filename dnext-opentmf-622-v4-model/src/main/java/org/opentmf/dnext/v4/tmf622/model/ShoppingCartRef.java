package org.opentmf.dnext.v4.tmf622.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Cezmi Aslan
 */

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShoppingCartRef {
    private String id = null;

    private String href = null;

    private String name = null;

    @JsonProperty("@referredType")
    private String referredType = null;
    
    @JsonProperty("@baseType")
    private String baseType = null;

    @JsonProperty("@schemaLocation")
    private String schemaLocation = null;

    @JsonProperty("@type")
    private String type = null;
}