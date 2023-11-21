CREATE TABLE role
(
    role_id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(255) NOT NULL
);

CREATE TABLE user
(
    user_id  BIGINT AUTO_INCREMENT PRIMARY KEY,
    role_id  BIGINT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (role_id) REFERENCES role (role_id)
);

CREATE TABLE person_in_need
(
    person_in_need_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id           BIGINT,
    first_name        VARCHAR(255) NOT NULL,
    last_name         VARCHAR(255) NOT NULL,
    date_of_birth     DATE,
    address           VARCHAR(255),
    city              VARCHAR(255),
    postal_code       VARCHAR(20),
    country           VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES user (user_id)
);

CREATE TABLE professional_in_charge
(
    professional_in_charge_id BIGINT PRIMARY KEY,
    user_id                   BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (user_id)
);

CREATE TABLE volunteer
(
    volunteer_id BIGINT PRIMARY KEY,
    user_id      BIGINT,
    FOREIGN KEY (user_id) REFERENCES user (user_id)
);

CREATE TABLE mission_status
(
    mission_status_id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    mission_status_name VARCHAR(255) NOT NULL
);

CREATE TABLE mission
(
    mission_id        BIGINT PRIMARY KEY,
    person_in_need_id BIGINT,
    volunteer_id BIGINT,
    mission_status_id BIGINT,
    FOREIGN KEY (person_in_need_id) REFERENCES person_in_need (person_in_need_id),
    FOREIGN KEY (volunteer_id) REFERENCES volunteer (volunteer_id),
    FOREIGN KEY (mission_status_id) REFERENCES mission_status (mission_status_id)
);


INSERT INTO role (role_id, role_name)
VALUES (1, 'PersonInNeed'),
       (2, 'Volunteer'),
       (3, 'ProfessionalInCharge');

INSERT INTO mission_status (mission_status_id, mission_status_name)
VALUES (1, 'SUGGESTED WAITING FOR APPROVAL'),
       (2, 'REQUESTED WAITING FOR APPROVAL'),
       (3, 'SUGGESTED APPROVED'),
       (4, 'REQUESTED APPROVED'),
       (5, 'SUGGESTED DENIED'),
       (6, 'REQUESTED DENIED');

INSERT INTO user (user_id, role_id, username, password)
VALUES (1, 1, 'PersonInNeed1', 'Password1'),
       (2, 1, 'PersonInNeed2', 'Password2'),
       (3, 2, 'Volunteer1', 'Password3'),
       (4, 2, 'Volunteer2', 'Password4'),
       (5, 3, 'Professional1', 'Password5'),
       (6, 3, 'Professional2', 'Password6');

INSERT INTO person_in_need (person_in_need_id, user_id, first_name, last_name, date_of_birth, address, city,
                            postal_code, country)
VALUES (1, 1, 'Person1', 'InNeed1', '1990-01-01', 'Address1', 'City1', '12345', 'Country1'),
       (2, 2, 'Person2', 'InNeed2', '1995-02-02', 'Address2', 'City2', '67890', 'Country2');

INSERT INTO professional_in_charge (professional_in_charge_id, user_id)
VALUES (1, 3),
       (2, 4);

INSERT INTO volunteer (volunteer_id, user_id)
VALUES (1, 5),
       (2, 6);

INSERT INTO mission(mission_id, person_in_need_id, volunteer_id, mission_status_id)
VALUES (1, 1, NULL, 2),
       (2, NULL, 1, 1),
       (3, 1, 1, 4),
       (4, 2, NULL, 6);


