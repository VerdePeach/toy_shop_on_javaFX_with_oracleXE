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





INSERT INTO toy VALUES (toy_seq.NEXTVAL, 'car', 10, 100, 1, 3);
INSERT INTO toy VALUES (toy_seq.NEXTVAL, 'car1', 101, 1001, 1, 3);
INSERT INTO toy VALUES (toy_seq.NEXTVAL, 'car2', 102, 1002, 1, 3);
INSERT INTO toy VALUES (toy_seq.NEXTVAL, 'car3', 103, 1003, 1, 3);

SELECT * FROM toy;
DELETE FROM toy WHERE t_name='Doll';

SELECT * FROM toy where price is null;

UPDATE toy set t_name = 'car', price = 20, amount = 10, s_age = 10, e_age = 10 where t_name = 'car';

SELECT * FROM toy WHERE s_age >= 1 and e_age <= 10;

SELECT * FROM toy WHERE price = 1 and s_age >= 0 and e_age <= 100;