CREATE TABLE schedule
(
    title TEXT PRIMARY KEY
);

CREATE TABLE participant
(
    id                  SERIAL PRIMARY KEY,
    participating_title TEXT,
    first_name           TEXT,
    last_name            TEXT,
    age                 INTEGER,
    parents_first_name    TEXT,
    parents_last_name     TEXT,
    CONSTRAINT fk_schedule FOREIGN KEY (participating_title) REFERENCES schedule (title)
);