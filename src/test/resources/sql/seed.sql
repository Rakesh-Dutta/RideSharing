use ride_sharing_test;

truncate table passengers;

insert into passengers (name,gender,age,credit) values
  ('Parag','M','29',1200.25),
  ('Dinesh','M','29',10200.25),
  ('Geeta','F','30',12000.50),
  ('Raman','F','25',1100.25);



truncate table driver_info;

insert into driver_info (name,gender,age,no_violation) values
  ('Tiru','M','29',0),
  ('Himanshu','M','21',1),
  ('DD','M','29',2);

