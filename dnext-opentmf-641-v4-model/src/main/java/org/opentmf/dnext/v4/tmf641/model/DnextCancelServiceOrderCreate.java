package org.opentmf.dnext.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.opentmf.v4.tmf641.model.CancelServiceOrderCreate;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Cezmi Aslan
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextCancelServiceOrderCreate.class)
@JsonTypeName("CancelServiceOrderCreate")
public class DnextCancelServiceOrderCreate extends CancelServiceOrderCreate {

  private CancellationType cancellationType;
}
