use ride_sharing_test;

truncate table passengers;

insert into passengers (name,gender,age,credit) values
  ('Parag','M','29',1200.25),
  ('Dinesh','M','29',10200.25),
  ('Geeta','F','30',12000.50),
  ('Raman','F','25',1100.25);



truncate table drivers;

insert into drivers (name,gender,age,violation) values
  ('Tiru','M','29',0),
  ('Himanshu','M','21',1),
  ('DD','M','29',2);


truncate table cars;


insert into cars (model,make,year,type) values
  ('X5','BMW',2001,'LUX'),
  ('Swift','Maruti',2015,'BASIC'),
  ('Hyundai','Verna',2016,'LUX');


truncate table cities;


insert into cities (name,state,day_rate,night_rate) values
  ('Delhi','Delhi',12.2,25.0),
  ('Mumbai','MH',20.00,30.00),
  ('Pune','MH',10.00,12.00);


