USE entitymappingjpa1;

/*Insert books*/
INSERT INTO entitymappingjpa1.book (title) VALUES ('Java book 1');
INSERT INTO entitymappingjpa1.book (title) VALUES ('Java book 2');
INSERT INTO entitymappingjpa1.book (title) VALUES ('Java book 3');
INSERT INTO entitymappingjpa1.book (title) VALUES ('Java book 4');
INSERT INTO entitymappingjpa1.book (title) VALUES ('Java book 5');
INSERT INTO entitymappingjpa1.book (title) VALUES ('Java book 6');

/*Insert customers (without CustomerType)*/
INSERT INTO entitymappingjpa1.customer (firstname, lastname) VALUES ('Torben', 'Hansen');
INSERT INTO entitymappingjpa1.customer (firstname, lastname) VALUES ('Sofie', 'Thomsen');
INSERT INTO entitymappingjpa1.customer (firstname, lastname) VALUES ('Trine', 'Nybro');
INSERT INTO entitymappingjpa1.customer (firstname, lastname) VALUES ('Tom', 'Sejrsen');
INSERT INTO entitymappingjpa1.customer (firstname, lastname) VALUES ('Camilla', 'Nielsen');
INSERT INTO entitymappingjpa1.customer (firstname, lastname) VALUES ('Kim', 'Knudsen');