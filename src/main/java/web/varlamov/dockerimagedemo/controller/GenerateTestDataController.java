package web.varlamov.dockerimagedemo.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static web.varlamov.dockerimagedemo.DockerimagedemoApplication.SERVICE_UUID;
import web.varlamov.dockerimagedemo.dao.MessageDao;
import web.varlamov.dockerimagedemo.entity.MessageEntity;

@RestController
@RequestMapping("/test_data")
public class GenerateTestDataController {
  @Autowired
  private MessageDao messageDao;

  @GetMapping("generate")
  public void generateTestData() {
    List<List<String>> contentList = List.of(
        List.of("Женя", "Привет! Как твои дела?"),
        List.of("Вася", "Привет! Всё хорошо, спасибо. А у тебя как дела?"),
        List.of("Женя", "Тоже неплохо. Чем занимаешься сегодня?"),
        List.of("Вася", "Сегодня я собираюсь пойти в кино с друзьями. Хочешь присоединиться?"),
        List.of("Женя", "Звучит здорово! Я бы хотел пойти. Что за фильм?"),
        List.of("Вася", "Это новый боевик. Говорят, что он очень интересный."),
        List.of("Женя", "Отлично, я люблю боевики. Когда сеанс?"),
        List.of("Вася", "В 20:00. Встретимся возле кинотеатра?"),
        List.of("Женя", "Да, конечно. До встречи!"),
        List.of("Вася", "До встречи!"),
        List.of("Женя", "Привет! Как твои дела?"),
        List.of("Вася", "Привет! Всё хорошо, спасибо. А у тебя как дела?"),
        List.of("Женя", "Тоже неплохо. Чем занимаешься сегодня?"),
        List.of("Вася", "Сегодня я собираюсь пойти в кино с друзьями. Хочешь присоединиться?"),
        List.of("Женя", "Звучит здорово! Я бы хотел пойти. Что за фильм?"),
        List.of("Вася", "Это новый боевик. Говорят, что он очень интересный."),
        List.of("Женя", "Отлично, я люблю боевики. Когда сеанс?"),
        List.of("Вася", "В 20:00. Встретимся возле кинотеатра?"),
        List.of("Женя", "Да, конечно. До встречи!"),
        List.of("Вася", "До встречи!"),
        List.of("Женя", "Привет! Как твои дела?"),
        List.of("Вася", "Привет! Всё хорошо, спасибо. А у тебя как дела?"),
        List.of("Женя", "Тоже неплохо. Чем занимаешься сегодня?"),
        List.of("Вася", "Сегодня я собираюсь пойти в кино с друзьями. Хочешь присоединиться?"),
        List.of("Женя", "Звучит здорово! Я бы хотел пойти. Что за фильм?"),
        List.of("Вася", "Это новый боевик. Говорят, что он очень интересный."),
        List.of("Женя", "Отлично, я люблю боевики. Когда сеанс?"),
        List.of("Вася", "В 20:00. Встретимся возле кинотеатра?"),
        List.of("Женя", "Да, конечно. До встречи!"),
        List.of("Вася", "До встречи!"),
        List.of("Женя", "Привет! Как твои дела?"),
        List.of("Вася", "Привет! Всё хорошо, спасибо. А у тебя как дела?"),
        List.of("Женя", "Тоже неплохо. Чем занимаешься сегодня?"),
        List.of("Вася", "Сегодня я собираюсь пойти в кино с друзьями. Хочешь присоединиться?"),
        List.of("Женя", "Звучит здорово! Я бы хотел пойти. Что за фильм?"),
        List.of("Вася", "Это новый боевик. Говорят, что он очень интересный."),
        List.of("Женя", "Отлично, я люблю боевики. Когда сеанс?"),
        List.of("Вася", "В 20:00. Встретимся возле кинотеатра?"),
        List.of("Женя", "Да, конечно. До встречи!"),
        List.of("Вася", "До встречи!"),
        List.of("Женя", "Привет! Как твои дела?"),
        List.of("Вася", "Привет! Всё хорошо, спасибо. А у тебя как дела?"),
        List.of("Женя", "Тоже неплохо. Чем занимаешься сегодня?"),
        List.of("Вася", "Сегодня я собираюсь пойти в кино с друзьями. Хочешь присоединиться?"),
        List.of("Женя", "Звучит здорово! Я бы хотел пойти. Что за фильм?"),
        List.of("Вася", "Это новый боевик. Говорят, что он очень интересный."),
        List.of("Женя", "Отлично, я люблю боевики. Когда сеанс?"),
        List.of("Вася", "В 20:00. Встретимся возле кинотеатра?"),
        List.of("Женя", "Да, конечно. До встречи!"),
        List.of("Вася", "До встречи!")
    );

    contentList.forEach(content -> {
      var messageEntity =  new MessageEntity()
          .setSessionUuid(UUID.randomUUID().toString())
          .setServiceUuid(SERVICE_UUID)
          .setUserName(content.get(0))
          .setDateTime(LocalDateTime.now())
          .setPayload(content.get(1));
      messageDao.saveMessage(messageEntity);
    });
  }
}
