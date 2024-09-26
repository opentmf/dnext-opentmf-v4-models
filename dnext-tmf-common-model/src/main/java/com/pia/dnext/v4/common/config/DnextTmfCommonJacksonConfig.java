package com.pia.dnext.v4.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pia.dnext.v4.common.model.DnextAttachment;
import com.pia.dnext.v4.common.model.DnextAttachmentRefOrValue;
import com.pia.tmf.v4.common.model.Attachment;
import com.pia.tmf.v4.common.model.AttachmentRefOrValue;
import lombok.Generated;

/**
 * @author Gokhan Demir
 */
public final class DnextTmfCommonJacksonConfig {

  @Generated
  private DnextTmfCommonJacksonConfig() {}

  public static void registerExtensions(ObjectMapper objectMapper) {
    objectMapper.addMixIn(Attachment.class, DnextAttachment.class);
    objectMapper.addMixIn(AttachmentRefOrValue.class, DnextAttachmentRefOrValue.class);
  }
}
