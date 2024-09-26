package com.pia.dnext.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.pia.tmf.v4.tmf641.model.ServiceOrder;
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
    defaultImpl = DnextServiceOrder.class)
@JsonTypeName("ServiceOrder")
public class DnextServiceOrder extends ServiceOrder {

  private String createdBy;
  private OffsetDateTime createdDate;
  private String updatedBy;
  private OffsetDateTime updatedDate;
  private Long revision;
}
