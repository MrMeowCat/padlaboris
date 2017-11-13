CREATE TABLE procedures
(
  procedure_id   SERIAL NOT NULL
    CONSTRAINT procedures_pkey
    PRIMARY KEY,
  date           TIMESTAMP,
  procedure_name VARCHAR(255),
  patient_id     INTEGER
    CONSTRAINT fkthf619hgoa528mmttj04h0m0s
    REFERENCES patients
);

INSERT INTO procedures VALUES (1, TIMESTAMP '2000-10-12 21:22:23', 'EKG', 1);