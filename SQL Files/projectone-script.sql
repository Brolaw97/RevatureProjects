-- Drop Tables
DROP TABLE ers_reimbursement;
DROP TABLE ers_users;
DROP TABLE ers_user_roles;
DROP TABLE ers_reimbursement_type;
DROP TABLE ers_status;


-- Create tables
CREATE TABLE ers_status(
	reimb_status_id serial,
	reimb_status varchar(10),
	PRIMARY KEY (reimb_status_id)
);

CREATE TABLE ers_reimbursement_type(
	reimb_type_id serial,
	reimb_type varchar(10),
	PRIMARY KEY (reimb_type_id)
);

CREATE TABLE ers_user_roles(
	ers_user_role_id serial,
	user_role varchar(10),
	PRIMARY KEY (ers_user_role_id)
);

CREATE TABLE ers_users(
	ers_user_id serial, 
	ers_username  varchar(50) UNIQUE,
	ers_password varchar(50),
	user_first_name varchar (100),
	user_last_name varchar (100),
	user_email  varchar (150) UNIQUE,
	user_role_id int NOT NULL,
	PRIMARY KEY (ers_user_id),
	FOREIGN KEY (user_role_id) REFERENCES ers_user_roles(ers_user_role_id)
);

CREATE TABLE ers_reimbursement(
	reimb_id serial,
	reimb_amount real,
	reimb_submitted varchar(100),
	reimb_resolved varchar(100),
	reimb_author int NOT NULL,
	reimb_resolver int,
	reimb_status_id int NOT NULL,
	reimb_type_id int NOT NULL,
	PRIMARY KEY (reimb_id),
	FOREIGN KEY (reimb_author) REFERENCES ers_users(ers_user_id),
	FOREIGN KEY (reimb_resolver) REFERENCES ers_users(ers_user_id),
	FOREIGN KEY (reimb_status_id) REFERENCES ers_status(reimb_status_id),
	FOREIGN KEY (reimb_type_id) REFERENCES ers_reimbursement_type(reimb_type_id)
);



-- Inserts

-- Reimbursement Types
INSERT INTO ers_reimbursement_type values(DEFAULT, 'Lodging');
INSERT INTO ers_reimbursement_type values(DEFAULT, 'Travel');
INSERT INTO ers_reimbursement_type values(DEFAULT, 'Food');
INSERT INTO ers_reimbursement_type values(DEFAULT, 'Other');

-- Status Types
INSERT INTO ers_status values(DEFAULT, 'Pending');
INSERT INTO ers_status values(DEFAULT, 'Approved');
INSERT INTO ers_status values(DEFAULT, 'Denied');

-- Role Inserts
INSERT INTO ers_user_roles VALUES(DEFAULT, 'Employee');
INSERT INTO ers_user_roles values(DEFAULT, 'Manager');

-- A few Users
INSERT INTO ers_users values(DEFAULT, 'craigd1', 'p4ssw0rd', 'Craig', 'Dylan', 'CraigDylan1@gmail.com', 2);
INSERT INTO ers_users values(DEFAULT, 'skylarj1', 'himom', 'Skylar', 'Johnson', 'SkylarJohnson2@gmail.com', 2);
INSERT INTO ers_users values(DEFAULT, 'johns1', 'hello', 'John', 'Smith', 'JohnSmith@gmail.com', 1);
INSERT INTO ers_users values(DEFAULT, 'sidneyg', 'password1', 'Sidney', 'Greenlee', 'SidneyGreenlee@gmail.com', 1);
INSERT INTO ers_users values(DEFAULT, 'brodys1', 'rolltide', 'Brody', 'Stevens', 'BrodyStevens@gmail.com', 1);

--A Reimbursement
INSERT INTO ers_reimbursement values(DEFAULT, 135.72, (SELECT now()), (SELECT now()), 3, 1, 2, 2);
INSERT INTO ers_reimbursement values(DEFAULT, 150.23, (SELECT now()), (SELECT now()), 3, 2, 2, 1);
INSERT INTO ers_reimbursement values(DEFAULT, 50.25, (SELECT now()), (SELECT now()), 3, 1, 2, 3);
INSERT INTO ers_reimbursement values(DEFAULT, 22.20, (SELECT now()), (SELECT now()), 4, 2, 2, 4);
INSERT INTO ers_reimbursement values(DEFAULT, 257.69, (SELECT now()), (SELECT now()), 4, 1, 3, 1);
INSERT INTO ers_reimbursement values(DEFAULT, 420.26, (SELECT now()), (SELECT now()), 5, 2, 3, 1);
INSERT INTO ers_reimbursement values(DEFAULT, 60.65, (SELECT now()), (SELECT now()), 5, 2, 2, 2);
INSERT INTO ers_reimbursement values(DEFAULT, 2532.25, (SELECT now()), (SELECT now()), 5, 2, 3, 4);
-- Update 
--UPDATE ers_reimbursement SET reimb_resolver =  1,  reimb_status_id =  3, reimb_resolved =  (SELECT now())  WHERE reimb_id =  4;
--UPDATE ers_reimbursement SET reimb_resolver =  1,  reimb_status_id =  3, reimb_resolved =  (SELECT now())  WHERE reimb_id =  4;
--UPDATE ers_reimbursement SET reimb_resolver =  1,  reimb_status_id =  3, reimb_resolved =  (SELECT now())  WHERE reimb_id =  4;
--UPDATE ers_reimbursement SET reimb_resolver =  1,  reimb_status_id =  3, reimb_resolved =  (SELECT now())  WHERE reimb_id =  4;

-- Selects
SELECT * FROM ers_status;
SELECT * FROM ers_reimbursement_type;
SELECT * FROM ers_user_roles;
SELECT * FROM ers_users ORDER BY ers_user_id;
SELECT * FROM ers_reimbursement ORDER BY reimb_id;
--SELECT * FROM ers_reimbursement WHERE reimb_author = 5 AND reimb_status_id = 1 ORDER BY reimb_id;






