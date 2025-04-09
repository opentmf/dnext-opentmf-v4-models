package org.opentmf.dnext.v4.common.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.opentmf.dnext.v4.common.model.DnextAttachment;
import org.opentmf.dnext.v4.common.model.DnextAttachmentRefOrValue;
import org.opentmf.v4.common.model.Attachment;
import org.opentmf.v4.common.model.AttachmentRefOrValue;
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
