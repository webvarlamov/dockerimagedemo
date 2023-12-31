package web.varlamov.dockerimagedemo.converter;

import web.varlamov.dockerimagedemo.dto.MessageDto;
import web.varlamov.dockerimagedemo.entity.MessageEntity;

public class MessageConverter {
  public static MessageDto toDto(MessageEntity messageEntity) {
    return new MessageDto()
        .setMessageId(messageEntity.getMessageId())
        .setSessionUuid(messageEntity.getSessionUuid())
        .setServiceUuid(messageEntity.getServiceUuid())
        .setUserName(messageEntity.getUserName())
        .setDateTime(messageEntity.getDateTime())
        .setPayload(messageEntity.getPayload());
  }

  public static MessageEntity fromDto(MessageDto messageDto) {
    return new MessageEntity()
        .setMessageId(messageDto.getMessageId())
        .setSessionUuid(messageDto.getSessionUuid())
        .setServiceUuid(messageDto.getServiceUuid())
        .setUserName(messageDto.getUserName())
        .setDateTime(messageDto.getDateTime())
        .setPayload(messageDto.getPayload());
  }
}
