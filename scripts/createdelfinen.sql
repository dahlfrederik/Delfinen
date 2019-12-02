DROP TABLE if exists members;

create table members (
	id				integer NOT NULL AUTO_INCREMENT,
    name 			varchar(30), 
    phonenr			integer, 
	age				integer,
    team			varchar(30), 
    active			boolean,
    paystatus		boolean, 
    primary key(id),
    UNIQUE KEY type_UNIQUE (phonenr));
    
DROP TABLE if exists results;

create table results ( 
	phonenr		integer references members, 
    name 		varchar(30)	references members,
    date		date, 
    result 		integer,
    primary key(phonenr, name)); 
    






