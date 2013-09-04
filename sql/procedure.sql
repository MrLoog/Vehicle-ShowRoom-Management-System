create procedure getVehicleByModelNumber
@modelnumber varchar(50)
as
select * from Vehicles where ModelNumber=@modelnumber

getVehicleByModelNumber 2