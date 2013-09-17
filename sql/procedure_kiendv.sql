GO
create proc updateCustomer
@name nvarchar(100),
@address nvarchar(100),
@phone varchar(20),
@id int
as
update Customers set Name = @name, [Address] = @address, Phone = @phone where ID = @id
go
exec updateCustomer 'Do Van Oai', 'Ha Nam', '016765419001', 1
--SELECT
GO
create proc pagingcustomers
@page int,
@size int
as
declare @lower int =  (@page - 1) * @size
declare @upper int =  (@page    ) * @size
select * from (
select 
    ROW_NUMBER() over (order by id) lfd,
* from Customers
) as c
 where lfd between @lower and @upper
 order by ID DESC
 go
 exec pagingcustomers 1,5
 go
 create proc searchcustomerbyid
 @id int
 as
 select * from Customers c where  c.ID = @id
 go
 exec searchcustomerbyid 16
 --SEARCH
GO
create proc searchcustomer
@kw nvarchar(100),
@page int,
@size int,
@stype int
as
declare @lower int =  (@page - 1) * @size
declare @upper int =  (@page    ) * @size
if(@stype=0)
begin
select * from (
select 
    ROW_NUMBER() over (order by id) lfd,
* from Customers
) as c
 where lfd between @lower and @upper and c.Phone like '%'+@kw+'%' or c.[Address] like '%'+@kw+'%' or c.Name like '%'+@kw+'%' order by(c.ID) desc
end
else
begin
select * from Customers as c
 where c.ID = @kw or c.Phone like '%'+@kw+'%' order by(c.ID) desc
end
 go
 exec searchcustomer 'kien', 1, 10, 0
 --PAGING
GO
create proc searchcustomerall
@kw nvarchar(100),
@stype int
as
if(@stype=0)
begin
select * from Customers as c
where c.Name like '%'+@kw+'%' or c.[Address] like '%'+@kw+'%' or c.Phone like '%'+@kw+'%' order by(c.ID) desc
end
else
begin
select * from Customers as c where c.ID =@kw or c.Phone like '%'+@kw+'%'
end
GO
exec searchcustomerall '18', 1
GO
exec searchcustomer 'soc son', 1, 5.0, 0






















----SELECT DEALER
GO
create proc pagingdealers
@page int,
@size int
as
declare @lower int =  (@page - 1) * @size
declare @upper int =  (@page    ) * @size
select * from (
select 
    ROW_NUMBER() over (order by id) lfd,
* from Dealers
) as c
 where lfd between @lower and @upper
 order by ID DESC
 go
 exec pagingdealers 1,5
 go
 create proc searchdealerbyid
 @id int
 as
 select * from Dealers c where  c.ID = @id
 go
 exec searchdealerbyid 16
 --SEARCH
GO
create proc searchdealer
@kw nvarchar(100),
@page int,
@size int,
@stype int
as
declare @lower int =  (@page - 1) * @size
declare @upper int =  (@page    ) * @size
if(@stype=0)
begin
select * from (
select 
    ROW_NUMBER() over (order by id) lfd,
* from Dealers
) as c
 where lfd between @lower and @upper and c.Name like '%'+@kw+'%' or c.LoginName like '%'+@kw+'%' or c.IsManager like '%'+@kw+'%' order by(c.ID) desc
end
else
begin
select * from Dealers as c
 where c.ID = @kw order by(c.ID) desc
end
 go
 exec searchdealer 'kien', 1, 10, 0
 --PAGING
GO
create proc searchdealerall
@kw nvarchar(100),
@stype int
as
if(@stype=0)
begin
select * from Dealers as c
where c.Name like '%'+@kw+'%' or c.LoginName like '%'+@kw+'%' or c.IsManager like '%'+@kw+'%' order by(c.ID) desc
end
else
begin
select * from Dealers as c where c.ID =@kw
end
GO
exec searchdealerall '1', 1











----SELECT VEHICLE
GO
create proc pagingvehicles
@page int,
@size int
as
declare @lower int =  (@page - 1) * @size
declare @upper int =  (@page    ) * @size
select * from (
select 
    ROW_NUMBER() over (order by id) lfd,
* from Vehicles
) as c
 where lfd between @lower and @upper
 order by ID DESC
 go
 exec pagingvehicles 1,5
 go
 create proc searchvehiclebyid
 @id int
 as
 select * from Vehicles c where  c.ID = @id
 go
 exec searchvehiclebyid 16
 --SEARCH
GO
create proc searchvehicle
@kw nvarchar(100),
@page int,
@size int,
@stype int
as
declare @lower int =  (@page - 1) * @size
declare @upper int =  (@page    ) * @size
if(@stype=0)
begin
select * from (
select 
    ROW_NUMBER() over (order by id) lfd,
* from Vehicles
) as c
 where lfd between @lower and @upper and c.Name like '%'+@kw+'%' or c.Brand like '%'+@kw+'%' or c.ModelNumber like '%'+@kw+'%' order by(c.ID) desc
end
else
begin
select * from Vehicles as c
 where c.ID = @kw or c.ModelNumber like '%'+@kw+'%' or c.Price=@kw or c.Quantity=@kw order by(c.ID) desc
end
 go
 exec searchvehicle 'kien', 1, 10, 0
 --PAGING
GO
create proc searchvehicleall
@kw nvarchar(100),
@stype int
as
if(@stype=0)
begin
select * from Vehicles as c
where c.Name like '%'+@kw+'%' or c.Brand like '%'+@kw+'%' or c.ModelNumber like '%'+@kw+'%' order by(c.ID) desc
end
else
begin
select * from Vehicles as c where c.ID = @kw or c.ModelNumber like '%'+@kw+'%' or c.Price=@kw or c.Quantity=@kw order by(c.ID) desc
end
GO
exec searchvehicleall '1', 1