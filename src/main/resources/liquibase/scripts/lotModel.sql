-- liquibase formatted sql

-- changeset ofcmail:1
create table lot_model
(
    id          BIGSERIAL PRIMARY KEY,
    bid_price   integer,
    description varchar(255),
    start_price integer,
    status      varchar(255),
    title       varchar(255)
);