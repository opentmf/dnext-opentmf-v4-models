package com.pia.dnext.v4.tmf620.model;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Cezmi Aslan
 * @author Gokhan Demir
 */
@Getter
@Setter
public class FulfillmentSpecification extends SupportedFulfillmentOperations {

    private @Valid PostFlow postFlow;
    private @Valid PreFlow preFlow;
}