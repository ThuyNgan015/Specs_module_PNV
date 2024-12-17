use student_management_12_2024;

CREATE TABLE student
(
    id    INT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255)       NULL,
    score DOUBLE             NOT NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);

INSERT INTO student(id, name, score) VALUES (10001, 'Georgi Facello', 85.5);
INSERT INTO student(id, name, score) VALUES (10002, 'Bezalel Simmel', 90.0);
INSERT INTO student(id, name, score) VALUES (10003, 'Parto Bamford', 78.5);
INSERT INTO student(id, name, score) VALUES (10004, 'Chirstian Koblick', 88.0);
INSERT INTO student(id, name, score) VALUES (10005, 'Kyoichi Maliniak', 92.5);
INSERT INTO student(id, name, score) VALUES (10006, 'Anneke Preusig', 74.0);
INSERT INTO student(id, name, score) VALUES (10007, 'Tzvetan Zielinski', 81.5);
INSERT INTO student(id, name, score) VALUES (10008, 'Saniya Kalloufi', 95.0);
INSERT INTO student(id, name, score) VALUES (10009, 'Sumant Peac', 89.0);
INSERT INTO student(id, name, score) VALUES (10010, 'Duangkaew Piveteau', 87.5);
