CREATE TABLE IF NOT EXISTS category(
  id serial primary key,
  name varchar(100) not null
);

CREATE TABLE IF NOT EXISTS element(
  id varchar(36) primary key,
  name varchar(100) not null,
  description varchar not null,
  quantity numeric not null default 0,
  category_id integer not null,
  CONSTRAINT fk_customer FOREIGN KEY(category_id) REFERENCES category(id)
)