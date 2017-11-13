ALTER TABLE medical_leave
  RENAME TO medical_leaves;

ALTER TABLE recipe
  RENAME TO recipes;


ALTER TABLE diseases
  ADD COLUMN medical_leave INTEGER,
  ADD CONSTRAINT fkle00xxxqc2t55auangvms1hub
FOREIGN KEY (medical_leave)
REFERENCES medical_leaves;

UPDATE diseases
SET medical_leave = 1;

ALTER TABLE recipes
  ADD COLUMN disease_id INTEGER,
  ADD CONSTRAINT fk8lrx7qp1vm4hkwb14hi8jmlsx
FOREIGN KEY (disease_id)
REFERENCES diseases;

UPDATE recipes
SET disease_id = 1;
