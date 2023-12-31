package web.varlamov.dockerimagedemo.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import web.varlamov.dockerimagedemo.entity.MessageEntity;

@Service
public class MessageDao {
  @Autowired
  JdbcTemplate jdbcTemplate;

  public MessageEntity saveMessage(MessageEntity messageEntity) {
    return jdbcTemplate.query("""
            insert into message (session_uuid, service_uuid, user_name, payload, datetime) values ('%s', '%s', '%s', '%s', now())
            returning message_id, session_uuid, service_uuid, user_name, payload, now()
            """.formatted(messageEntity.getSessionUuid(), messageEntity.getServiceUuid(), messageEntity.getUserName(), messageEntity.getPayload()),
        new BeanPropertyRowMapper<>(MessageEntity.class)
    ).get(0);
  }

  public List<MessageEntity> getLastMessages(int limit) {
    return jdbcTemplate.query("""
        select message_id, session_uuid, service_uuid, user_name, payload, dateTime from message order by dateTime asc limit %d
        """.formatted(limit), new BeanPropertyRowMapper<>(MessageEntity.class));
  }
}
