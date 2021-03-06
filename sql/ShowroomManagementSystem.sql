USE [master]
GO
/****** Object:  Database [ShowRoom]    Script Date: 09/25/2013 22:23:12 ******/
CREATE DATABASE [ShowRoom] ON  PRIMARY 
( NAME = N'ShowRoom', FILENAME = N'E:\Currents\Vehicle-ShowRoom-Management-System\sql\ShowRoom.mdf' , SIZE = 2304KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ShowRoom_log', FILENAME = N'E:\Currents\Vehicle-ShowRoom-Management-System\sql\ShowRoom_log.LDF' , SIZE = 512KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ShowRoom] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ShowRoom].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ShowRoom] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [ShowRoom] SET ANSI_NULLS OFF
GO
ALTER DATABASE [ShowRoom] SET ANSI_PADDING OFF
GO
ALTER DATABASE [ShowRoom] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [ShowRoom] SET ARITHABORT OFF
GO
ALTER DATABASE [ShowRoom] SET AUTO_CLOSE ON
GO
ALTER DATABASE [ShowRoom] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [ShowRoom] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [ShowRoom] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [ShowRoom] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [ShowRoom] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [ShowRoom] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [ShowRoom] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [ShowRoom] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [ShowRoom] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [ShowRoom] SET  DISABLE_BROKER
GO
ALTER DATABASE [ShowRoom] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [ShowRoom] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [ShowRoom] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [ShowRoom] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [ShowRoom] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [ShowRoom] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [ShowRoom] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [ShowRoom] SET  READ_WRITE
GO
ALTER DATABASE [ShowRoom] SET RECOVERY SIMPLE
GO
ALTER DATABASE [ShowRoom] SET  MULTI_USER
GO
ALTER DATABASE [ShowRoom] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [ShowRoom] SET DB_CHAINING OFF
GO
USE [ShowRoom]
GO
/****** Object:  Table [dbo].[Vehicles]    Script Date: 09/25/2013 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Vehicles](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](255) NULL,
	[Brand] [nvarchar](255) NULL,
	[Price] [int] NOT NULL,
	[ModelNumber] [varchar](50) NULL,
	[Quantity] [int] NOT NULL,
	[Category] [nvarchar](255) NULL,
	[Created] [datetime] NULL,
	[Modified] [datetime] NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Vehicles] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Dealers]    Script Date: 09/25/2013 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Dealers](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](255) NULL,
	[LoginName] [nvarchar](255) NULL,
	[Password] [nvarchar](255) NULL,
	[IsManager] [bit] NOT NULL,
	[Created] [datetime] NULL,
	[Modified] [datetime] NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Dealer] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customers]    Script Date: 09/25/2013 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Customers](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](255) NULL,
	[Address] [nvarchar](255) NULL,
	[Phone] [varchar](50) NULL,
	[DealerID] [int] NOT NULL,
	[Created] [datetime] NULL,
	[Modified] [datetime] NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Customers] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 09/25/2013 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[DealerID] [int] NOT NULL,
	[CustomerID] [int] NOT NULL,
	[VehicleID] [int] NOT NULL,
	[Price] [int] NOT NULL,
	[Status] [int] NOT NULL,
	[Created] [datetime] NULL,
	[Modified] [datetime] NULL,
	[Quantity] [int] NOT NULL,
	[IsDeleted] [bit] NOT NULL,
 CONSTRAINT [PK_Orders] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ImportOrders]    Script Date: 09/25/2013 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ImportOrders](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[VehicleID] [int] NOT NULL,
	[Price] [int] NULL,
	[Quantity] [int] NULL,
	[DealerID] [int] NOT NULL,
	[Created] [datetime] NULL,
	[Modified] [datetime] NULL,
	[IsDeleted] [bit] NOT NULL,
	[DealerModifiedID] [int] NOT NULL,
 CONSTRAINT [PK_ImportOrder] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  StoredProcedure [dbo].[getVehicleByModelNumber]    Script Date: 09/25/2013 22:23:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[getVehicleByModelNumber]
@modelnumber varchar(50)
as
select * from Vehicles where ModelNumber=@modelnumber
GO
/****** Object:  StoredProcedure [dbo].[updateCustomer]    Script Date: 09/25/2013 22:23:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[updateCustomer]
@name nvarchar(100),
@address nvarchar(100),
@phone varchar(20),
@id int
as
update Customers set Name = @name, [Address] = @address, Phone = @phone where ID = @id
GO
/****** Object:  StoredProcedure [dbo].[searchvehiclebyid]    Script Date: 09/25/2013 22:23:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[searchvehiclebyid]
 @id int
 as
 select * from Vehicles c where  c.ID = @id
GO
/****** Object:  StoredProcedure [dbo].[searchvehicleall]    Script Date: 09/25/2013 22:23:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[searchvehicleall]
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
/****** Object:  StoredProcedure [dbo].[searchvehicle]    Script Date: 09/25/2013 22:23:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[searchvehicle]
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
GO
/****** Object:  StoredProcedure [dbo].[searchdealerbyid]    Script Date: 09/25/2013 22:23:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[searchdealerbyid]
 @id int
 as
 select * from Dealers c where  c.ID = @id
GO
/****** Object:  StoredProcedure [dbo].[searchdealerall]    Script Date: 09/25/2013 22:23:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[searchdealerall]
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
/****** Object:  StoredProcedure [dbo].[searchdealer]    Script Date: 09/25/2013 22:23:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[searchdealer]
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
GO
/****** Object:  StoredProcedure [dbo].[searchcustomerbyid]    Script Date: 09/25/2013 22:23:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[searchcustomerbyid]
 @id int
 as
 select * from Customers c where  c.ID = @id
GO
/****** Object:  StoredProcedure [dbo].[searchcustomerall]    Script Date: 09/25/2013 22:23:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[searchcustomerall]
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
/****** Object:  StoredProcedure [dbo].[searchcustomer]    Script Date: 09/25/2013 22:23:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[searchcustomer]
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
GO
/****** Object:  StoredProcedure [dbo].[pagingvehicles]    Script Date: 09/25/2013 22:23:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[pagingvehicles]
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
GO
/****** Object:  StoredProcedure [dbo].[pagingdealers]    Script Date: 09/25/2013 22:23:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[pagingdealers]
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
GO
/****** Object:  StoredProcedure [dbo].[pagingcustomers]    Script Date: 09/25/2013 22:23:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[pagingcustomers]
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
GO
/****** Object:  Default [DF_Vehicles_Price]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[Vehicles] ADD  CONSTRAINT [DF_Vehicles_Price]  DEFAULT ((0)) FOR [Price]
GO
/****** Object:  Default [DF_Vehicles_Quantity]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[Vehicles] ADD  CONSTRAINT [DF_Vehicles_Quantity]  DEFAULT ((0)) FOR [Quantity]
GO
/****** Object:  Default [DF_Vehicles_IsDeleted]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[Vehicles] ADD  CONSTRAINT [DF_Vehicles_IsDeleted]  DEFAULT ((0)) FOR [IsDeleted]
GO
/****** Object:  Default [DF_Dealers_IsManager]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[Dealers] ADD  CONSTRAINT [DF_Dealers_IsManager]  DEFAULT ((0)) FOR [IsManager]
GO
/****** Object:  Default [DF_Dealers_IsDeleted]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[Dealers] ADD  CONSTRAINT [DF_Dealers_IsDeleted]  DEFAULT ((0)) FOR [IsDeleted]
GO
/****** Object:  Default [DF_Customers_DealerID]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[Customers] ADD  CONSTRAINT [DF_Customers_DealerID]  DEFAULT ((0)) FOR [DealerID]
GO
/****** Object:  Default [DF_Customers_IsDeleted]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[Customers] ADD  CONSTRAINT [DF_Customers_IsDeleted]  DEFAULT ((0)) FOR [IsDeleted]
GO
/****** Object:  Default [DF_Orders_DealerID]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[Orders] ADD  CONSTRAINT [DF_Orders_DealerID]  DEFAULT ((0)) FOR [DealerID]
GO
/****** Object:  Default [DF_Orders_VehicleID]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[Orders] ADD  CONSTRAINT [DF_Orders_VehicleID]  DEFAULT ((0)) FOR [VehicleID]
GO
/****** Object:  Default [DF_Orders_Status]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[Orders] ADD  CONSTRAINT [DF_Orders_Status]  DEFAULT ((0)) FOR [Status]
GO
/****** Object:  Default [DF_Orders_Quantity]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[Orders] ADD  CONSTRAINT [DF_Orders_Quantity]  DEFAULT ((1)) FOR [Quantity]
GO
/****** Object:  Default [DF_Orders_IsDeleted]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[Orders] ADD  CONSTRAINT [DF_Orders_IsDeleted]  DEFAULT ((0)) FOR [IsDeleted]
GO
/****** Object:  Default [DF_ImportOrders_VehicleID]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[ImportOrders] ADD  CONSTRAINT [DF_ImportOrders_VehicleID]  DEFAULT ((0)) FOR [VehicleID]
GO
/****** Object:  Default [DF_ImportOrders_DealerID]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[ImportOrders] ADD  CONSTRAINT [DF_ImportOrders_DealerID]  DEFAULT ((0)) FOR [DealerID]
GO
/****** Object:  Default [DF_ImportOrders_IsDeleted]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[ImportOrders] ADD  CONSTRAINT [DF_ImportOrders_IsDeleted]  DEFAULT ((0)) FOR [IsDeleted]
GO
/****** Object:  Default [DF_ImportOrders_DealerModifiedID]    Script Date: 09/25/2013 22:23:16 ******/
ALTER TABLE [dbo].[ImportOrders] ADD  CONSTRAINT [DF_ImportOrders_DealerModifiedID]  DEFAULT ((0)) FOR [DealerModifiedID]
GO
