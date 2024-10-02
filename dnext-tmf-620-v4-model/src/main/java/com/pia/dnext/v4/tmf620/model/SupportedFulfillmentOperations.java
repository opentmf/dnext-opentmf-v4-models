package com.pia.dnext.v4.tmf620.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * I have introduced this base class to get rid of the code repetitions
 * within ProductSpecificationExtension.
 *
 * @author Gokhan Demir
 * @since 4.0.0.16
 */
@Getter
@Setter
public abstract class SupportedFulfillmentOperations {

  private String add;
  private String modify;
  private String delete;

  @JsonProperty("modify.Migration")
  private String modifyMigration;

  @JsonProperty("modify.Relocation")
  private String modifyRelocation;

  @JsonProperty("modify.Takeover")
  private String modifyTakeover;

  private String statusChange;

  @JsonProperty("statusChange.Suspend")
  private String statusChangeSuspend;

  @JsonProperty("statusChange.Resume")
  private String statusChangeResume;
}
