-- liquibase formatted sql

-- changeset surokkha:1689223150-1
create
extension if not exists "uuid-ossp";

-- changeset surokkha:1689223150-2
create table public."user"
(
    id                   varchar(255) not null,
    name                 varchar(255) not null,
    dob                  timestamp without time zone not null,
    email                varchar(255) not null,
    password             varchar(255) not null,
    nid                  varchar(255),
    birth_certificate_id varchar(255),
    user_role            varchar(255) not null,
    constraint pk_user primary key (id)
);
