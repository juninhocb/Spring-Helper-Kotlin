CREATE TABLE payment
(
    id bigint not null auto_increment,
    amount decimal(38,2),
    state enum ('AUTH','AUTH_ERROR','NEW','PRE_AUTH','PRE_AUTH_ERROR'),
    primary key (id)
) engine=InnoDB