CREATE TABLE IF NOT EXISTS invoice(
    id SERIAL,
    code SERIAL,
    create_at DATE,
    total DECIMAL,
    PRIMARY KEY(id),
    client_id SERIAL,
    FOREIGN KEY (client_id) REFERENCES client(id),
    UNIQUE(code)
);