package web.varlamov.dockerimagedemo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.varlamov.dockerimagedemo.DockerimagedemoApplication;
import web.varlamov.dockerimagedemo.converter.MessageConverter;
import web.varlamov.dockerimagedemo.dao.MessageDao;
import web.varlamov.dockerimagedemo.dto.MessageDto;

@RestController
@RequestMapping("/message")
public class MessageRestController {
  @Autowired
  private MessageDao messageDao;

  @GetMapping
  @RequestMapping("/getMessages")
  public List<MessageDto> getMessages() {
    return messageDao.getLastMessages(100).stream()
        .map(MessageConverter::toDto)
        .toList();
  }

  @GetMapping
  @RequestMapping("/saveMessage")
  public MessageDto saveMessage(@RequestBody MessageDto messageDto) {
    messageDto.setServiceUuid(DockerimagedemoApplication.SERVICE_UUID);
    return MessageConverter.toDto(
        this.messageDao.saveMessage(MessageConverter.fromDto(messageDto))
    );
  }
}
