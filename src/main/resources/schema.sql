CREATE TABLE products (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL ,
  price INTEGER NOT NULL CHECK (price > 0),
  description VARCHAR(255),
  img VARCHAR(255)
);