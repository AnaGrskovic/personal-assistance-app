CREATE TABLE role (
    role_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);

CREATE TABLE user (
    user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_id BIGINT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role(role_id)
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


INSERT INTO role (role_id, role_name) VALUES
    (1, 'PersonInNeed'),
    (2, 'Volunteer'),
    (3, 'ProfessionalInCharge');

INSERT INTO user (user_id, role_id, username, password) VALUES
    (1, 1, 'PersonInNeed1', 'Password1'),
    (2, 1, 'PersonInNeed2', 'Password2'),
    (3, 2, 'Volunteer1', 'Password3'),
    (4, 2, 'Volunteer2', 'Password4'),
    (5, 3, 'Professional1', 'Password5'),
    (6, 3, 'Professional2', 'Password6');

INSERT INTO person_in_need (person_in_need_id, user_id, first_name, last_name, date_of_birth, address, city, postal_code, country) VALUES
    (1, 1, 'Person1', 'InNeed1', '1990-01-01', 'Address1', 'City1', '12345', 'Country1'),
    (2, 2, 'Person2', 'InNeed2', '1995-02-02', 'Address2', 'City2', '67890', 'Country2');

INSERT INTO professional_in_charge (professional_in_charge_id, user_id) VALUES
    (1, 3),
    (2, 4);

INSERT INTO volunteer (volunteer_id, user_id) VALUES
    (1, 5),
    (2, 6);

