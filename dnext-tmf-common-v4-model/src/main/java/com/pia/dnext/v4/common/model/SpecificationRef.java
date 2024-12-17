package com.pia.dnext.v4.common.model;

import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.EXISTING_PROPERTY;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.pia.commons.validation.constraints.SafeText;
import com.pia.tmf.v4.common.model.EntityRef;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = EXISTING_PROPERTY,
    defaultImpl = SpecificationRef.class
)
public class SpecificationRef extends EntityRef {

  /** Name of the specification. */
  private @SafeText String name;

  /** Specification version. */
  private @SafeText String version;
}
