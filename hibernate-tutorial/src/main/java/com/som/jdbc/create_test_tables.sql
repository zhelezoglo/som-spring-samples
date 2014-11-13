CREATE TABLE employee (
  emp_id   BIGSERIAL PRIMARY KEY,
  emp_name CHARACTER VARYING(20),
  age      INTEGER,
  dep_id   INTEGER
);

CREATE TABLE department (
  dep_id   SERIAL PRIMARY KEY,
  dep_name CHARACTER VARYING(20)
);