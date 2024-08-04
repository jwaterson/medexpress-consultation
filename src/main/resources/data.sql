-- Data used for testing

-- Insert data into the Condition table
INSERT INTO condition (name)
VALUES ('asthma');

INSERT INTO condition (name)
VALUES ('eczema');


-- Insert data into the Question table
INSERT INTO question (ordinal, text, type, response_required, condition_id)
VALUES (0, 'Do you consent to sharing details with a doctor?', 0, TRUE, 1);

INSERT INTO question (ordinal, text, type, response_required, condition_id)
VALUES (1, 'Have you ever been a smoker?', 1, NULL, 1);

INSERT INTO question (ordinal, text, type, response_required, condition_id)
VALUES (0, 'Do you consent to sharing details with a doctor?', 0, TRUE, 2);

INSERT INTO question (ordinal, text, type, response_required, condition_id)
VALUES (1, 'Have you ever been a smoker?', 1, FALSE, 2);

