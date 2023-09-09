create user `adm`@`localhost` identified with mysql_native_password BY 'root';
grant select, insert, update, delete, create, drop, references, index, alter, execute, create view, show view,
create routine, alter routine , event, trigger on `teams`.* TO `adm`@`localhost`;
flush privileges;
