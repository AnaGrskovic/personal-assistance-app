CREATE TABLE user (
  user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  role VARCHAR(255) NOT NULL,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);

CREATE TABLE person_in_need (
    person_in_need_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    date_of_birth DATE,
    address VARCHAR(255),
    city VARCHAR(255),
    postal_code VARCHAR(20),
    country VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE professional_in_charge (
    professional_in_charge_id BIGINT PRIMARY KEY,
    user_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES user(user_id)
);

CREATE TABLE volunteer (
   volunteer_id BIGINT PRIMARY KEY,
   user_id BIGINT,
   FOREIGN KEY (user_id) REFERENCES user(user_id)
);