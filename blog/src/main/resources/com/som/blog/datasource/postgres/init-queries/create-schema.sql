--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++--
--++ This script creates tables for Blog database for PostgreSQL RDBMS ++--
--+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++--

-- Scripts related to User data type -----------
CREATE TYPE USER_ROLE AS ENUM ('GUEST', 'AUTHOR', 'ADMIN');

CREATE TABLE users (
  id  BIGSERIAL PRIMARY KEY,
  login    VARCHAR(40),
  password VARCHAR(40),
  email    VARCHAR(100),
  name     VARCHAR(40),
  role     USER_ROLE
);

-- Scripts related to Article data type --------
CREATE TABLE articles (
  id BIGSERIAL PRIMARY KEY,
  topic      VARCHAR(100),
  body       VARCHAR(1000),
  author_id  BIGSERIAL REFERENCES users (user_id)
);

-- Scripts related to Comment data type --------
CREATE TABLE comments (
  id BIGSERIAL PRIMARY KEY,
  body       VARCHAR(200),
  article_id BIGSERIAL REFERENCES articles (article_id),
  author_id  BIGSERIAL REFERENCES users (user_id)
);
