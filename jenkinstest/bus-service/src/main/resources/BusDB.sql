DROP DATABASE IF EXISTS casestudy;
CREATE DATABASE casestudy; 
USE crudappdb;

DROP TABLE IF EXISTS bus;
CREATE TABLE IF NOT EXISTS bus (
  busId int not null AUTO_INCREMENT,
  source varchar(20) DEFAULT NULL,
  destination varchar(20) DEFAULT NULL,
  busNumber varchar(20) DEFAULT NULL,
  busType varchar(20) DEFAULT NULL,
  PRIMARY KEY (busId)
);

INSERT INTO bus(busId, source,destination, busNumber,busType) VALUES
	(1001, 'HDC1','HDC3','TS1001' ,'24-seater'),
	(1002, 'HDC2','HDC3','TS1002' ,'26-seater'),
	(1003, 'HDC3','HDC1','TS1003' ,'18-seater'),
	(1004, 'HDC3','HDC2','TS1004' ,'24-seater');
commit;
