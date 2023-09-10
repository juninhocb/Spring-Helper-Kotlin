create table team (
    titles integer not null,
    created_time datetime(6),
    id bigint not null auto_increment,
    name varchar(255) not null unique,
    primary key (id)
) engine=InnoDB