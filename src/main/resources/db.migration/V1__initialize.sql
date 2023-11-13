-- User Table
CREATE TABLE user_table (
                            user_id SERIAL PRIMARY KEY,
                            role VARCHAR(255) NOT NULL,
                            username VARCHAR(255) NOT NULL,
                            password VARCHAR(255) NOT NULL
);

-- PersonInNeed Table
CREATE TABLE person_in_need_table (
                                      person_in_need_id SERIAL PRIMARY KEY,
                                      user_id BIGINT REFERENCES user_table(user_id),
                                      first_name VARCHAR(255) NOT NULL,
                                      last_name VARCHAR(255) NOT NULL,
                                      date_of_birth DATE,
                                      address VARCHAR(255),
                                      city VARCHAR(255),
                                      postal_code VARCHAR(20),
                                      country VARCHAR(255)
);

-- ProfessionalInCharge Table
CREATE TABLE professional_in_charge_table (
    user_id BIGINT REFERENCES user_table(user_id) PRIMARY KEY
    -- Add additional columns as needed for ProfessionalInCharge
);

-- Volunteer Table
CREATE TABLE volunteer_table (
    user_id BIGINT REFERENCES user_table(user_id) PRIMARY KEY
    -- Add additional columns as needed for Volunteer
);
