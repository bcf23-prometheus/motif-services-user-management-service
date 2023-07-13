-- liquibase formatted sql

-- changeset surokkha:1689223150-1
CREATE TABLE public."user"
(
    id                   VARCHAR(255) NOT NULL,
    name                 VARCHAR(255) NOT NULL,
    dob                  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    email                VARCHAR(255) NOT NULL,
    password             VARCHAR(255) NOT NULL,
    nid                  VARCHAR(255),
    birth_certificate_id VARCHAR(255),
    user_role            VARCHAR(255) NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

