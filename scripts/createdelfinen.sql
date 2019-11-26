DROP TABLE if exists members;

create table members (
	id				integer AUTO_INCREMENT,
    name 			varchar(30), 
	age				integer,
    team			varchar(30), 
    active			boolean,
    paystatus		boolean, 
    primary key(id),
    UNIQUE KEY type_UNIQUE (id));
    


