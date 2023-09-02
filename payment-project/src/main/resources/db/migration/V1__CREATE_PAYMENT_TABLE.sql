CREATE TABLE payment
(
    id bigint not null auto_increment,
    amount decimal(38,2),
    state enum ('PRE_AUTH','PRE_AUTH_ERROR','AUTH','AUTH_ERROR','AUTH_AUTHORIZED'),
    primary key (id)
) engine=InnoDB