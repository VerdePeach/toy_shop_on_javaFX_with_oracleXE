DROP TABLE toy;
DROP SEQUENCE toy_seq;
DROP CONSTRAINT constr_age;
CREATE TABLE toy (
                     t_id int NOT NULL,
                     t_name VARCHAR2(100) NOT NULL UNIQUE,
                     price NUMBER,
                     amount INT,
                     s_age INT,
                     e_age INT,
                     CONSTRAINT toy_pk PRIMARY KEY (t_id)
);

CREATE SEQUENCE toy_seq
    START WITH 1000
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

ALTER TABLE toy ADD CONSTRAINT constr_age CHECK (s_age <= e_age);

ALTER TABLE toy ADD CONSTRAINT constr_price CHECK (price > 0);
