CREATE TABLE client (
	id BIGINT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3)
);

CREATE TABLE planet (
	id VARCHAR NOT NULL PRIMARY KEY CHECK (id  ~ '^[A-Z0-9]*$'),
    name VARCHAR(200) NOT NULL CHECK (LENGTH(name) >= 3 )
);

CREATE TABLE ticket  (
	id BIGINT NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    created_at TIMESTAMP,
    client_id BIGINT NOT NULL,
    from_planet_id VARCHAR NOT NULL CHECK (from_planet_id  ~ '^[A-Z0-9]*$'),
    to_planet_id VARCHAR NOT NULL CHECK (to_planet_id  ~ '^[A-Z0-9]*$'),
    FOREIGN KEY(client_id) REFERENCES client(id),
    FOREIGN KEY (from_planet_id) REFERENCES planet(id),
    FOREIGN KEY (to_planet_id) REFERENCES planet(id)
);

--(from_planet_id  ~ '^[A-Z0-9]*$')