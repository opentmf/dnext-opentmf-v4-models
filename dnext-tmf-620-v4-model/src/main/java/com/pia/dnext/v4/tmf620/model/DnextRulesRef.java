package com.pia.dnext.v4.tmf620.model;

import com.pia.commons.validation.constraints.SafeText;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sezer.aydin
 */
@Getter
@Setter
public class DnextRulesRef {
  private String id;
  private String href;
  private String name;
  private String role;
}
