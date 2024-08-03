-- Insert data into the Condition table
INSERT INTO condition (name) VALUES ('allergy');

-- Insert data into the Question table
INSERT INTO question (text, type, condition_id) VALUES ('Question 1', 'Symptoms', 1);
INSERT INTO question (text, type, condition_id) VALUES ('Question 2', 'Symptoms', 1);
