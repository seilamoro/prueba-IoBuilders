CREATE TABLE IF NOT EXISTS courses (
    id       CHAR(36)     NOT NULL,
    name     VARCHAR(255) NOT NULL,
    duration VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS courses_counter (
    id               CHAR(36) NOT NULL,
    total            INT      NOT NULL,
    existing_courses JSON     NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS steps (
    id    CHAR(36)     NOT NULL,
    title VARCHAR(155) NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS steps_challenges (
    id        CHAR(36) NOT NULL,
    statement TEXT     NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_steps_challenges__step_id FOREIGN KEY (id) REFERENCES steps(id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS steps_videos (
    id   CHAR(36)     NOT NULL,
    url  VARCHAR(255) NOT NULL,
    text TEXT         NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_steps_video__step_id FOREIGN KEY (id) REFERENCES steps(id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS domain_events (
    id           CHAR(36)     NOT NULL,
    aggregate_id CHAR(36)     NOT NULL,
    name         VARCHAR(255) NOT NULL,
    body         JSON         NOT NULL,
    occurred_on  TIMESTAMP    NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS users (
    id       CHAR(36)     NOT NULL,
    name     VARCHAR(255) NOT NULL,
    surname  VARCHAR(255) NOT NULL,
    mobile   VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    active   BOOLEAN      NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS accounts (
     number   VARCHAR(255) NOT NULL,
     amount   VARCHAR(255) NOT NULL,
     user     CHAR(36)     NOT NULL,
     active   BOOLEAN      NOT NULL,
     PRIMARY KEY (number)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS transfers (
    id             CHAR(36)     NOT NULL,
    date           VARCHAR(255) NOT NULL,
    time           VARCHAR(255) NOT NULL,
    accountOrigin  VARCHAR(255) NOT NULL,
    accountDestiny VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_unicode_ci;
