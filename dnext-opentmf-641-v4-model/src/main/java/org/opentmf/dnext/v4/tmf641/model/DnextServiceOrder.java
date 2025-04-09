package org.opentmf.dnext.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.opentmf.v4.common.model.Characteristic;
import org.opentmf.v4.tmf641.model.ServiceOrder;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
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

  @JsonProperty("orderCharacteristic")
  private List<@Valid Characteristic> orderCharacteristics;

  private String createdBy;
  private OffsetDateTime createdDate;
  private String updatedBy;
  private OffsetDateTime updatedDate;
  private Long revision;
}
