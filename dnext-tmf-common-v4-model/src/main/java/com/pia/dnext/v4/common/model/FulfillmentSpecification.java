package com.pia.dnext.v4.common.model;

import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Gokhan Demir
 */
@Getter
@Setter
public class FulfillmentSpecification {

  private List<@Valid FulfillmentSpecificationOperation> fulfillmentSpecificationOperation;
}
