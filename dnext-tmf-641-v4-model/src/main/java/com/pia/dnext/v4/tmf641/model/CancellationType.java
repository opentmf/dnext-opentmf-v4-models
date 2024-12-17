package com.pia.dnext.v4.tmf641.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author Gokhan Demir
 */
public enum CancellationType {
  IMMEDIATE("immediateCancel"),
  GRACEFUL("gracefulCancel");

  private final String value;

  CancellationType(String value) {
    this.value = value;
  }

  @JsonValue
  private String getValue() {
    return value;
  }

  @JsonCreator
  public static CancellationType fromValue(String text) {
    if ("immediateCancel".equals(text)) {
      return IMMEDIATE;
    } else if ("gracefulCancel".equals(text)) {
      return GRACEFUL;
    }
    return null;
  }
}
