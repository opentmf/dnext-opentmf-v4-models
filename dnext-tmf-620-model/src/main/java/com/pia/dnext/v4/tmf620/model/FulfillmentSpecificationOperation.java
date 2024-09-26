package com.pia.dnext.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Cezmi Aslan
 * @author Gokhan Demir
 */
@Getter
@Setter
public class FulfillmentSpecificationOperation {

    private String operationType;
    private String preFlow;
    private String postFlow;
    private String cancelFlow;
    private List<@Valid RelatedSpecification> relatedSpecifications;

    /**
     * If not dpecified, the default value will be false at the DPC backend.
     */
    @JsonProperty("isBypassInventoryTasks")
    private Boolean bypassInventoryTasks;
}