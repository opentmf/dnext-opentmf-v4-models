package org.opentmf.dnext.v4.common.model;

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
   *
   * <ul>
   *   <li>reliesOn
   *   <li>uses
   * </ul>
   *
   * Can have other values in the future, so check.
   */
  @NotBlank private String relation;

  private @Valid SpecificationRef specification;
}
