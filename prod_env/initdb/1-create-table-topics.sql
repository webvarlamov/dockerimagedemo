create table message
(
    message_id   serial not null
        constraint messages_pk
            primary key,
    session_uuid varchar not null,
    service_uuid varchar not null,
    user_name    varchar not null,
    payload      varchar not null,
    dateTime     timestamp not null
);

alter table message
    owner to messages;

create unique index messages_message_id_index
    on message (message_id);
