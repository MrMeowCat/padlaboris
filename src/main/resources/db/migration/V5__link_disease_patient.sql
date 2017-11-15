ALTER TABLE diseases
  ADD COLUMN patient_id INTEGER,
  ADD CONSTRAINT FK5wjb4nwl8fhor1h9ugs2ecu25
FOREIGN KEY (patient_id)
REFERENCES patients;

UPDATE diseases SET patient_id = 1;