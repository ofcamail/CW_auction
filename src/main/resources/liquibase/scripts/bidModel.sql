-- liquibase formatted sql

-- changeset ofcmail:2
create table bid_model
(
    id           BIGSERIAL PRIMARY KEY,
    bid_date     timestamp,
    bidder_name  varchar(255),
    lot_model_id bigint references lot_model
);