package web.varlamov.dockerimagedemo.dto;

import java.time.LocalDateTime;

public class MessageDto {
  private int messageId;

  private String sessionUuid;
  private String serviceUuid;

  private String userName;
  private String payload;
  private LocalDateTime dateTime;

  public MessageDto() {
  }

  public MessageDto(int messageId, String sessionUuid, String serviceUuid, String userName, String payload, LocalDateTime dateTime) {
    this.messageId = messageId;
    this.sessionUuid = sessionUuid;
    this.serviceUuid = serviceUuid;
    this.userName = userName;
    this.payload = payload;
    this.dateTime = dateTime;
  }

  public int getMessageId() {
    return messageId;
  }

  public MessageDto setMessageId(int messageId) {
    this.messageId = messageId;
    return this;
  }

  public String getSessionUuid() {
    return sessionUuid;
  }

  public MessageDto setSessionUuid(String sessionUuid) {
    this.sessionUuid = sessionUuid;
    return this;
  }

  public String getServiceUuid() {
    return serviceUuid;
  }

  public MessageDto setServiceUuid(String serviceUuid) {
    this.serviceUuid = serviceUuid;
    return this;
  }

  public String getUserName() {
    return userName;
  }

  public MessageDto setUserName(String userName) {
    this.userName = userName;
    return this;
  }

  public String getPayload() {
    return payload;
  }

  public MessageDto setPayload(String payload) {
    this.payload = payload;
    return this;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public MessageDto setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
    return this;
  }
}
