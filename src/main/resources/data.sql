-- Data used for testing

-- Insert data into the Condition table
INSERT INTO condition (name)
VALUES ('asthma');

INSERT INTO condition (name)
VALUES ('eczema');


-- Insert data into the Question table
INSERT INTO question (ordinal, text, question_type, response_required_for_medication, condition_id)
VALUES (0, 'Do you consent to sharing details with a doctor?', 'AGREEMENT', TRUE, 1);

INSERT INTO question (ordinal, text, question_type, response_required_for_medication, condition_id)
VALUES (1, 'Have you ever been a smoker?', 'MEDICAL_HISTORY', NULL, 1);

INSERT INTO question (ordinal, text, question_type, response_required_for_medication, condition_id)
VALUES (0, 'Do you consent to sharing details with a doctor?', 'AGREEMENT', TRUE, 2);

INSERT INTO question (ordinal, text, question_type, response_required_for_medication, condition_id)
VALUES (1, 'Are you a smoker?', 'CURRENT_HEALTH', FALSE, 2);

