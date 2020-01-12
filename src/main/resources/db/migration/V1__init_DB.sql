drop table if exists items;
drop table if exists purchase;
drop table if exists users;
create table items (id bigint not null auto_increment, hdd varchar(255), name varchar(255), ram varchar(255), price decimal(19,2), proc varchar(255), quantity bigint, primary key (id));
create table purchase (id bigint not null auto_increment, amount decimal(19,2), count bigint,dtime datetime, item_id bigint, user_id bigint, primary key (id));
create table users (id bigint not null auto_increment, username varchar(255), password varchar(255), primary key (id));
alter table purchase add constraint FKr1w12emb08i351hahqft9spj6 foreign key (item_id) references items (id);
alter table purchase add constraint FKoj7ky1v8cf4ibkk0s7alikp52 foreign key (user_id) references users (id);