package org.opentmf.dnext.v4.tmf639.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Extensible;

/**
 * Bulk characteristic template (DNext bulk resource operations).
 *
 * @author Gokhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextBulkCharacteristic.class)
@Required(fields = {"valueTo", "valueMask", "name", "valueFrom"})
public class DnextBulkCharacteristic extends Extensible {

  private @SafeText String counterType;

  private Boolean isIdentifier;

  private Boolean isPopulateCharacteristicValueToResourceName;

  private Boolean isUnique;

  private Boolean isVisible;

  private @SafeText String name;

  private @SafeText String valueFrom;

  private @SafeText String valueMask;

  private @SafeText String valueTo;
}
