/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Manojeet Padhy
 * Created: Aug 3, 2018
 */

CREATE TABLE aarogyam_emp
( 
	id number(10) NOT NULL,
	emp_name varchar2(50) NOT NULL,
	emp_id varchar2(50) NOT NULL,
	emp_pass varchar2(50) NOT NULL,
	emp_mail_id varchar2(50) NOT NULL,
	emp_dob DATE NOT NULL,
	city varchar2(50),
	emp_telephone number(10) NOT NULL,
	emp_active_id number(2) NOT NULL,
	emp_role varchar2(10) NOT NULL,
	create_date DATE,
	update_date DATE,
	
	CONSTRAINT aarogyam_emp_pk PRIMARY KEY (emp_id)
);

INSERT INTO aarogyam_emp VALUES(1, 'xyz','xyz','xyz','abc@xyz.com',sysdate,'ctc','0123456789',1,'ADMIN',sysdate,sysdate);

