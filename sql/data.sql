USE [ShowRoom]
GO
/****** Object:  Table [dbo].[Dealers]    Script Date: 09/13/2013 18:04:58 ******/
SET IDENTITY_INSERT [dbo].[Dealers] ON
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager]) VALUES (1, N'Manager', N'manager', N'123456', 1)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager]) VALUES (2, N'ThangTT', N'ThangTT', N'123456', 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager]) VALUES (3, N'DucNT', N'DucNT', N'123456', 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager]) VALUES (4, N'KienDV', N'KienDV', N'123456', 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager]) VALUES (5, N'TuanNN', N'123456', N'123456', 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager]) VALUES (6, N'HoangLH', N'HoangLH', N'123456', 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager]) VALUES (7, N'TruongLM', N'TruongLM', N'123456', 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager]) VALUES (8, N'bdsb', N'dsbsd', N'123456', 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager]) VALUES (9, N'bsdbsd', N'sdbsd', N'123456', 0)
SET IDENTITY_INSERT [dbo].[Dealers] OFF
/****** Object:  Table [dbo].[Customers]    Script Date: 09/13/2013 18:04:58 ******/
SET IDENTITY_INSERT [dbo].[Customers] ON
INSERT [dbo].[Customers] ([ID], [Name], [Address], [Phone], [DealerID]) VALUES (1, N'ThangTT', N'dsv', N'123456', 2)
INSERT [dbo].[Customers] ([ID], [Name], [Address], [Phone], [DealerID]) VALUES (2, N'HoangLM', N'dsfbsdb', N'456789', 2)
INSERT [dbo].[Customers] ([ID], [Name], [Address], [Phone], [DealerID]) VALUES (3, N'HoangLM', N'dsfbsdb', N'5456789', 2)
INSERT [dbo].[Customers] ([ID], [Name], [Address], [Phone], [DealerID]) VALUES (4, N'AnhNV', N'dsvsdb', N'456123', 2)
INSERT [dbo].[Customers] ([ID], [Name], [Address], [Phone], [DealerID]) VALUES (5, N'AnhNVV', N'dsvsdb', N'4561237', 2)
SET IDENTITY_INSERT [dbo].[Customers] OFF
/****** Object:  Table [dbo].[Brands]    Script Date: 09/13/2013 18:04:58 ******/
SET IDENTITY_INSERT [dbo].[Brands] ON
INSERT [dbo].[Brands] ([ID], [Name], [BrandCode], [Description]) VALUES (1, N'Dodge', NULL, NULL)
INSERT [dbo].[Brands] ([ID], [Name], [BrandCode], [Description]) VALUES (2, N'Hyundai', NULL, NULL)
INSERT [dbo].[Brands] ([ID], [Name], [BrandCode], [Description]) VALUES (3, N'Test', NULL, NULL)
INSERT [dbo].[Brands] ([ID], [Name], [BrandCode], [Description]) VALUES (4, N'Jeep', NULL, NULL)
INSERT [dbo].[Brands] ([ID], [Name], [BrandCode], [Description]) VALUES (5, N'Jeep2', NULL, NULL)
SET IDENTITY_INSERT [dbo].[Brands] OFF
/****** Object:  Table [dbo].[Vehicles]    Script Date: 09/13/2013 18:04:58 ******/
SET IDENTITY_INSERT [dbo].[Vehicles] ON
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity]) VALUES (1, N'Vehicle', N'Test', 100000, N'1', 5)
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity]) VALUES (2, N'Jeep', N'Jeep2', 200000, N'2', 8)
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity]) VALUES (3, N'Dodge', N'Dodge', 600000, N'3', 15)
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity]) VALUES (4, N'Hyundai', N'Hyundai', 700000, N'4', 3)
SET IDENTITY_INSERT [dbo].[Vehicles] OFF
/****** Object:  Table [dbo].[Orders]    Script Date: 09/13/2013 18:04:58 ******/
SET IDENTITY_INSERT [dbo].[Orders] ON
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified]) VALUES (1, 2, 0, 2, 200000, 1, CAST(0x0000A23800000000 AS DateTime), CAST(0x0000A23800000000 AS DateTime))
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified]) VALUES (2, 2, 0, 2, 200000, 1, CAST(0x0000A23800000000 AS DateTime), CAST(0x0000A23800000000 AS DateTime))
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified]) VALUES (3, 2, 1, 3, 600000, 1, CAST(0x0000A23800000000 AS DateTime), CAST(0x0000A23800000000 AS DateTime))
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified]) VALUES (4, 2, 1, 3, 600000, 1, CAST(0x0000A23800000000 AS DateTime), CAST(0x0000A23800000000 AS DateTime))
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified]) VALUES (5, 2, 1, 2, 200000, 1, CAST(0x0000A23800000000 AS DateTime), CAST(0x0000A23800000000 AS DateTime))
SET IDENTITY_INSERT [dbo].[Orders] OFF
/****** Object:  Table [dbo].[ImportOrders]    Script Date: 09/13/2013 18:04:58 ******/
SET IDENTITY_INSERT [dbo].[ImportOrders] ON
INSERT [dbo].[ImportOrders] ([ID], [ModelNumber], [Name], [Brand], [Price], [Quantity], [DealerID]) VALUES (1, N'3', N'Dodge', N'Dodge', 600000, 10, 0)
INSERT [dbo].[ImportOrders] ([ID], [ModelNumber], [Name], [Brand], [Price], [Quantity], [DealerID]) VALUES (2, N'3', N'Dodge', N'Dodge', 600000, 5, 0)
INSERT [dbo].[ImportOrders] ([ID], [ModelNumber], [Name], [Brand], [Price], [Quantity], [DealerID]) VALUES (3, N'4', N'Hyundai', N'Hyundai', 700000, 3, 0)
INSERT [dbo].[ImportOrders] ([ID], [ModelNumber], [Name], [Brand], [Price], [Quantity], [DealerID]) VALUES (4, N'1', N'Vehicle', N'Test', 100000, 5, 0)
INSERT [dbo].[ImportOrders] ([ID], [ModelNumber], [Name], [Brand], [Price], [Quantity], [DealerID]) VALUES (5, N'2', N'Jeep', N'Jeep', 200000, 5, 0)
INSERT [dbo].[ImportOrders] ([ID], [ModelNumber], [Name], [Brand], [Price], [Quantity], [DealerID]) VALUES (6, N'2', N'Jeep', N'Jeep2', 200000, 3, 0)
SET IDENTITY_INSERT [dbo].[ImportOrders] OFF
