CREATE TABLE Employee (employeeId NUMBER PRIMARY KEY, name VARCHAR2(20),
salary VARCHAR2(20), department VARCHAR2(10),designation VARCHAR2(10));

CREATE SEQUENCE employeeId_seq START WITH 1001 INCREMENT BY 1;

INSERT INTO Employee VALUES(employeeId_seq.NEXTVAL,'Avijit', 25000,'HR','Analyst');

INSERT INTO Employee VALUES(employeeId_seq.NEXTVAL,'Arijit', 35000,'TRAINER','SeniorAnalyst');

INSERT INTO Employee VALUES(employeeId_seq.NEXTVAL,'Vivek', 45000,'TRAINEE','MAJDOOR');

INSERT INTO Employee VALUES(employeeId_seq.NEXTVAL,'Singh', 55000,'SERVICE','Manager');
