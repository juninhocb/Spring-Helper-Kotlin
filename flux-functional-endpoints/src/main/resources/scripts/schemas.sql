use react_car;
create table if not exists car (
    velocity integer not null,
    created_at timestamp,
    id bigint not null auto_increment,
    name varchar(255) not null unique,
    primary key (id)
) engine=InnoDB