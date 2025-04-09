package org.opentmf.dnext.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.v4.common.model.Characteristic;
import org.opentmf.v4.tmf641.model.ServiceOrderCreate;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.util.List;
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
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextServiceOrderCreate.class)
@JsonTypeName("ServiceOrderCreate")
public class DnextServiceOrderCreate extends ServiceOrderCreate {

  @SafeText
  @Size(max = 36)
  private String id;

  @JsonProperty("orderCharacteristic")
  private List<@Valid Characteristic> orderCharacteristics;
}
