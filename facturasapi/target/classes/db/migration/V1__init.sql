CREATE TABLE IF NOT EXISTS client(
    id SERIAL,
    nui VARCHAR(13) NOT NULL,
    fullname VARCHAR(100) NOT NULL,
    addrees VARCHAR(50),
    PRIMARY KEY(id),
    UNIQUE(nui)
);