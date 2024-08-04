-- Data used for testing

CREATE TABLE condition
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE question
(
    id                               BIGINT AUTO_INCREMENT PRIMARY KEY,
    ordinal                          BIGINT,
    text                             VARCHAR(255),
    question_type                    VARCHAR(50),
    response_required_for_medication BOOLEAN,
    condition_id                     BIGINT,
    FOREIGN KEY (condition_id) REFERENCES condition (id)
);

CREATE TABLE consultation_result
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    eligibility_status VARCHAR(255)
);

CREATE TABLE answer
(
    consultation_id   BIGINT,
    question_id       BIGINT,
    response_required BOOLEAN,
    yes_no_value      BOOLEAN,
    text              VARCHAR(255),
    PRIMARY KEY (consultation_id, question_id),
    FOREIGN KEY (consultation_id) REFERENCES consultation_result (id)
);
