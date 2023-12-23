create table users(
    id SERIAL PRIMARY KEY,
    login VARCHAR(200) NOT NULL,
    password VARCHAR(200) NOT NULL
);