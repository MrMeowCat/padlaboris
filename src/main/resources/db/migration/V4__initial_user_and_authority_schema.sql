CREATE TABLE authorities
(
  authority_id   SERIAL NOT NULL
    CONSTRAINT authorities_pkey
    PRIMARY KEY,
  authority VARCHAR(255),
  user_id INTEGER
);
CREATE TABLE users
(
   id  SERIAL NOT NULL
     CONSTRAINT users_pkey
     PRIMARY KEY,
   username VARCHAR(255),
   password VARCHAR(255),
   user_id INTEGER
     CONSTRAINT user_user_id_fkey
     REFERENCES authorities,
   account_non_expired bit,
   account_non_locked bit,
   credentials_non_expired bit,
   enabled bit
);