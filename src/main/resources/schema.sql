-- Create table for Condition
CREATE TABLE condition
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);


-- Create table for Question
CREATE TABLE question
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    text         VARCHAR(255),
    type         VARCHAR(50),
    condition_id BIGINT,
    FOREIGN KEY (condition_id) REFERENCES condition (id)
)
;
