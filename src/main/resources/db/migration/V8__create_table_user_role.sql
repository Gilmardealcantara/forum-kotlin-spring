create table user_role
(
    id      bigint not null auto_increment,
    user_id bigint not null,
    role_id bigint not null,
    primary key (id),
    foreign key (user_id) references user(id),
    foreign key (role_id) references role(id)
);

insert into user_role(id, user_id, role_id) values (1, 1, 1);
