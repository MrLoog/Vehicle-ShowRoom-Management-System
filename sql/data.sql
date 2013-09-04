USE [ShowRoom]
GO
/****** Object:  Table [dbo].[Dealers]    Script Date: 09/04/2013 14:24:07 ******/
/****** Object:  Table [dbo].[Customers]    Script Date: 09/04/2013 14:24:07 ******/
/****** Object:  Table [dbo].[Brands]    Script Date: 09/04/2013 14:24:07 ******/
/****** Object:  Table [dbo].[Vehicles]    Script Date: 09/04/2013 14:24:07 ******/
SET IDENTITY_INSERT [dbo].[Vehicles] ON
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity]) VALUES (1, N'Vehicle', N'Test', 100000, N'1', 0)
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity]) VALUES (2, N'Jeep', N'Jeep', 200000, N'2', 0)
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity]) VALUES (3, N'Dodge', N'Dodge', 600000, N'3', 10)
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity]) VALUES (4, N'Hyundai', N'Hyundai', 700000, N'4', 0)
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity]) VALUES (5, N'Test', N'ABC', 500000, NULL, 10)
SET IDENTITY_INSERT [dbo].[Vehicles] OFF
/****** Object:  Table [dbo].[Orders]    Script Date: 09/04/2013 14:24:07 ******/
/****** Object:  Table [dbo].[ImportOrders]    Script Date: 09/04/2013 14:24:07 ******/
SET IDENTITY_INSERT [dbo].[ImportOrders] ON
INSERT [dbo].[ImportOrders] ([ID], [ModelNumber], [Name], [Brand], [Price], [Quantity]) VALUES (1, N'3', N'Dodge', N'Dodge', 600000, 10)
SET IDENTITY_INSERT [dbo].[ImportOrders] OFF
