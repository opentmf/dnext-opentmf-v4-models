package org.opentmf.dnext.v4.tmf639.model;

import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * Identifier range extension used on resource create/update (DNext).
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@Required(fields = {"quantity", "rangeStart", "rangeEnd"})
public class DnextIdentifierRange {

  private Integer quantity;

  private @SafeText String rangeEnd;

  private @SafeText String rangeStart;
}
