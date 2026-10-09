CREATE TABLE posts (
    id         BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title      VARCHAR(100)  NOT NULL,
    content    VARCHAR(5000) NOT NULL,
    created_at TIMESTAMPTZ(6) NOT NULL,
    updated_at TIMESTAMPTZ(6) NOT NULL,

    CONSTRAINT ck_posts_title_not_empty
        CHECK (CHAR_LENGTH(title) > 0),

    CONSTRAINT ck_posts_content_not_empty
        CHECK (CHAR_LENGTH(content) > 0)
);


