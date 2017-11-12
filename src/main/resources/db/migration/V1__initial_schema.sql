CREATE TABLE details
(
  detail_id            SERIAL NOT NULL
    CONSTRAINT details_pkey
    PRIMARY KEY,
  blood_type           INTEGER,
  bmi                  DOUBLE PRECISION,
  degree_of_disability INTEGER,
  height               DOUBLE PRECISION,
  owner_id             INTEGER,
  rh                   VARCHAR(255),
  weight               DOUBLE PRECISION
);

CREATE TABLE diseases
(
  id                  SERIAL NOT NULL
    CONSTRAINT diseases_pkey
    PRIMARY KEY,
  disease_class       VARCHAR(255),
  disease_code        VARCHAR(255),
  disease_description VARCHAR(255),
  disease_name        VARCHAR(255),
  end_date            DATE,
  start_date          DATE
);

CREATE TABLE medical_leave
(
  medical_leave_id SERIAL NOT NULL
    CONSTRAINT medical_leave_pkey
    PRIMARY KEY,
  end_date         DATE,
  start_date       DATE
);

CREATE TABLE patients
(
  patient_id       SERIAL NOT NULL
    CONSTRAINT patients_pkey
    PRIMARY KEY,
  birth_date       TIMESTAMP,
  death_date       TIMESTAMP,
  first_name       VARCHAR(255),
  gender           VARCHAR(255),
  home_number      VARCHAR(255),
  last_change_date TIMESTAMP,
  last_name        VARCHAR(255),
  mobile_number    VARCHAR(255),
  owner_id         INTEGER
    CONSTRAINT fklroclfnn5air908qeuejk2ww3
    REFERENCES details
);

CREATE TABLE recipe
(
  recipe_id     SERIAL NOT NULL
    CONSTRAINT recipe_pkey
    PRIMARY KEY,
  dosage        VARCHAR(255),
  expire_date   DATE,
  issue_date    DATE,
  medicine_name VARCHAR(255)
);
