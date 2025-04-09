package org.opentmf.dnext.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.opentmf.v4.tmf641.model.CancelServiceOrder;
import java.time.OffsetDateTime;
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
    defaultImpl = DnextCancelServiceOrder.class)
@JsonTypeName("CancelServiceOrder")
public class DnextCancelServiceOrder extends CancelServiceOrder {

  private CancellationType cancellationType;
  private String createdBy;
  private OffsetDateTime createdDate;
  private String updatedBy;
  private OffsetDateTime updatedDate;
  private Long revision;
}
