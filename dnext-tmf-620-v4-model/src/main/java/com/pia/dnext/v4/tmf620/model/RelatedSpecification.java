package com.pia.dnext.v4.tmf620.model;

import com.pia.tmf.v4.product.model.ProductSpecificationRef;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Cezmi Aslan
 * @author Gokhan Demir
 */
@Getter
@Setter
public class RelatedSpecification {

    /**
     * One of the following according to Sales-UI:
     * <ul>
     *   <li>reliesOn</li>
     *   <li>uses</li>
     * </ul>
     * Can have other values in the future, so check.
     */
    @NotBlank
    private String relation;

    private @Valid ProductSpecificationRef specification;
}