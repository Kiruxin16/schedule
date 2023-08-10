CREATE TABLE participants(
                id bigserial PRIMARY KEY,
                login VARCHAR(255),
                name VARCHAR(255),
                event_id bigint REFERENCES club_events(id),
                subscription_id bigserial
);