CREATE TABLE game (
     id serial PRIMARY KEY,
     title VARCHAR(100) NOT NULL,
     description VARCHAR(255),
     release_date DATE,
     price NUMERIC(10,2),
     created_at TIMESTAMP,
     updated_at TIMESTAMP
);