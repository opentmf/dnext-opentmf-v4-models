package org.opentmf.dnext.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.opentmf.v4.tmf620.model.ProductOffering;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sezer.aydin
 */
@Getter
@Setter
@JsonTypeInfo(
    use = Id.NAME,
    visible = true,
    include = As.EXISTING_PROPERTY,
    defaultImpl = DnextProductOffering.class)
@JsonTypeName("ProductOffering")
public class DnextProductOffering extends ProductOffering {

  private List<DnextRulesRef> rules;

}
