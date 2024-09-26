package com.pia.dnext.v4.tmf620.model;

import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Cezmi Aslan
 * @author Gokhan Demir
 */
@Getter
@Setter
public class ProductSpecificationExtension {

  private @Valid FulfillmentSpecification fulfillmentSpecification;
  private List<@Valid FulfillmentSpecificationOperation> fulfillmentSpecificationOperation;
}
