use ride_sharing_test;

set FOREIGN_KEY_CHECKS = 0;
truncate table passengers;
truncate table drivers;
truncate table cars;
truncate table cities;
# truncate table cars_drivers;
truncate table trips;
set FOREIGN_KEY_CHECKS = 1;

insert into passengers (name,gender,age,credit) values
  ('Parag','M','29',1200.25),
  ('Dinesh','M','29',10200.25),
  ('Geeta','F','30',12000.50),
  ('Raman','F','25',1100.25);





insert into drivers (name,gender,age,violation) values
  ('Tiru','M','29',0),
  ('Himanshu','M','21',1),
  ('DD','M','29',2);




insert into cars (model,make,year,type,driver_id) values
  ('X5','BMW',2001,'LUX',1),
  ('Swift','Maruti',2015,'BASIC',2),
  ('Hyundai','Verna',2016,'LUX',3);





insert into cities (name,state,day_rate,night_rate) values
  ('Delhi','Delhi',12.2,25.0),
  ('Mumbai','MH',20.00,30.00),
  ('Pune','MH',10.00,12.00);


INSERT INTO trips(car_id,city_id,passenger_id,cost,tripdistance)
VALUES
(1,1,1,128.10,10);


# insert into cars_drivers (car_id,driver_id) values
#   (1,1),
#   (2,1),
#   (3,1),
#   (1,2),
#   (2,2),
#   (3,2),
#   (1,3),
#   (2,3),
#   (3,3);


