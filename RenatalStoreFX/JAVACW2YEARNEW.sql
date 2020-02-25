CREATE DATABASE JAVACW2YEAR;
USE JAVACW2YEAR;
CREATE TABLE CAR
(	
	
    plateNo VARCHAR(60) NOT NULL,
    rent double not null ,
    make VARCHAR(60) NOT NULL,
    model VARCHAR(60) NOT NULL,
    seatCapacity INT NOT NULL,
    cylinderCapacity INT NOT NULL,
    topSpeed VARCHAR(10) NOT NULL,
    vehicalAvailability boolean not null,
    milage INT NOT NULL, 
    transmission VARCHAR(60) not null, 
    noOfDoors INT NOT NULL, 
    airConditionAvailability boolean NOT NULL,
    CONSTRAINT CAR_plateNo_pk PRIMARY KEY (plateNo)
);
    
    
CREATE TABLE MOTORBIKE
(
	
    plateNo VARCHAR(60) NOT NULL,
    rent double not null,
    make VARCHAR(60) NOT NULL,
    model VARCHAR(60) NOT NULL,
    seatCapacity INT NOT NULL,
    cylinderCapacity INT NOT NULL,
    topSpeed VARCHAR(10) NOT NULL,
    vehicalAvailability boolean not null,
    milage INT NOT NULL, 
    transmission VARCHAR(60) not null,
	NoOfHelmet int not null,
    boxCompartmentAvailability boolean not null,
	CONSTRAINT Bike_plateNo_pk PRIMARY KEY (plateNo)
);
 DROP TABLE Car;
DROP TABLE motorbike;
DROP TABLE Vinyl;
SELECT * FROM car;
SELECT * FROM motorbike;
DESCRIBE car;
DESCRIBE motorbike;
SHOW TABLES;
DESCRIBE Vinyl;