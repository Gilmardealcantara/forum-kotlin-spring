create table topic_response
(
    id        bigint       not null auto_increment,
    message   varchar(300) not null,
    created_at datetime     not null,
    status    varchar(20)  not null,
    topic_id  bigint       not null,
    author_id bigint       not null,
    solution  bigint       not null,
    primary key (id),
    foreign key (topic_id) references topic (id),
    foreign key (author_id) references user (id)
);

