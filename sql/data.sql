USE [ShowRoom]
GO
/****** Object:  Table [dbo].[Vehicles]    Script Date: 09/23/2013 12:16:00 ******/
SET IDENTITY_INSERT [dbo].[Vehicles] ON
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity], [Category], [Created], [Modified], [IsDeleted]) VALUES (1, N'Vehicle', N'Test', 100000, N'1', 5, N'Un Known', NULL, NULL, 0)
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity], [Category], [Created], [Modified], [IsDeleted]) VALUES (2, N'Jeep', N'Jeep2', 200000, N'2', 7, N'Un Known', NULL, NULL, 0)
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity], [Category], [Created], [Modified], [IsDeleted]) VALUES (3, N'Dodge', N'Dodge', 600000, N'3', 24, N'Un Known', NULL, NULL, 0)
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity], [Category], [Created], [Modified], [IsDeleted]) VALUES (4, N'Hyundai1', N'Hyundai', 700000, N'4', 2, N'Un Known', NULL, NULL, 0)
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity], [Category], [Created], [Modified], [IsDeleted]) VALUES (5, N'asvasv', N'aavas', 300000, N'56', 0, N'Un Known', NULL, NULL, 0)
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity], [Category], [Created], [Modified], [IsDeleted]) VALUES (6, N'ACDS', N'aasgadbnd', 3000000, N'ABC123', 0, N'Un Known No No', NULL, NULL, 0)
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity], [Category], [Created], [Modified], [IsDeleted]) VALUES (8, N'Brum', N'aasgadbnd', 300000, N'C005', 30, N'Un Known', CAST(0x0000A24000000000 AS DateTime), CAST(0x0000A24000000000 AS DateTime), 0)
INSERT [dbo].[Vehicles] ([ID], [Name], [Brand], [Price], [ModelNumber], [Quantity], [Category], [Created], [Modified], [IsDeleted]) VALUES (9, N'sdbSDbs', N'aasgadbnd', 4336343, N'TEst', 0, N'Un Knownfdnfd', NULL, NULL, 0)
SET IDENTITY_INSERT [dbo].[Vehicles] OFF
/****** Object:  Table [dbo].[Dealers]    Script Date: 09/23/2013 12:16:00 ******/
SET IDENTITY_INSERT [dbo].[Dealers] ON
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager], [Created], [Modified], [IsDeleted]) VALUES (1, N'Manager', N'manager', N'123456', 0, NULL, CAST(0x0000A24100000000 AS DateTime), 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager], [Created], [Modified], [IsDeleted]) VALUES (2, N'ThangTT', N'ThangTT', N'123456', 0, NULL, NULL, 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager], [Created], [Modified], [IsDeleted]) VALUES (3, N'DucNT', N'DucNT', N'123456', 0, NULL, NULL, 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager], [Created], [Modified], [IsDeleted]) VALUES (4, N'KienDV', N'KienDV', N'123456', 0, NULL, NULL, 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager], [Created], [Modified], [IsDeleted]) VALUES (5, N'TuanNN', N'123456', N'123456', 0, NULL, NULL, 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager], [Created], [Modified], [IsDeleted]) VALUES (6, N'HoangLH', N'HoangLH', N'123456', 0, NULL, NULL, 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager], [Created], [Modified], [IsDeleted]) VALUES (7, N'TruongLM', N'TruongLM', N'123456', 0, NULL, NULL, 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager], [Created], [Modified], [IsDeleted]) VALUES (8, N'bdsb', N'dsbsd', N'123456', 0, NULL, NULL, 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager], [Created], [Modified], [IsDeleted]) VALUES (9, N'bsdbsd', N'sdbsd', N'123456', 0, NULL, NULL, 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager], [Created], [Modified], [IsDeleted]) VALUES (10, N'systemadmin', N'sa', N'�
�9I�Y��V�W��>', 1, NULL, NULL, 0)
INSERT [dbo].[Dealers] ([ID], [Name], [LoginName], [Password], [IsManager], [Created], [Modified], [IsDeleted]) VALUES (11, N'Tester', N'test', N'�
�9I�Y��V�W��>', 1, CAST(0x0000A24000000000 AS DateTime), CAST(0x0000A24100000000 AS DateTime), 1)
SET IDENTITY_INSERT [dbo].[Dealers] OFF
/****** Object:  Table [dbo].[Customers]    Script Date: 09/23/2013 12:16:00 ******/
SET IDENTITY_INSERT [dbo].[Customers] ON
INSERT [dbo].[Customers] ([ID], [Name], [Address], [Phone], [DealerID], [Created], [Modified], [IsDeleted]) VALUES (1, N'Do Van Oai', N'Ha Nam', N'016765419001', 2, NULL, NULL, 0)
INSERT [dbo].[Customers] ([ID], [Name], [Address], [Phone], [DealerID], [Created], [Modified], [IsDeleted]) VALUES (2, N'HoangLM', N'dsfbsdb', N'456789', 2, NULL, NULL, 0)
INSERT [dbo].[Customers] ([ID], [Name], [Address], [Phone], [DealerID], [Created], [Modified], [IsDeleted]) VALUES (3, N'HoangLM', N'dsfbsdb', N'5456789', 2, NULL, NULL, 0)
INSERT [dbo].[Customers] ([ID], [Name], [Address], [Phone], [DealerID], [Created], [Modified], [IsDeleted]) VALUES (4, N'AnhNV', N'dsvsdb', N'456123', 2, NULL, NULL, 0)
INSERT [dbo].[Customers] ([ID], [Name], [Address], [Phone], [DealerID], [Created], [Modified], [IsDeleted]) VALUES (5, N'AnhNVV', N'dsvsdb', N'4561237', 2, NULL, NULL, 0)
INSERT [dbo].[Customers] ([ID], [Name], [Address], [Phone], [DealerID], [Created], [Modified], [IsDeleted]) VALUES (6, N'dsbsdds', N'asdvasdva', N'124578', 1, NULL, NULL, 0)
INSERT [dbo].[Customers] ([ID], [Name], [Address], [Phone], [DealerID], [Created], [Modified], [IsDeleted]) VALUES (7, N'Do Van Van', N'Pho hue', N'00000000', 10, NULL, NULL, 0)
INSERT [dbo].[Customers] ([ID], [Name], [Address], [Phone], [DealerID], [Created], [Modified], [IsDeleted]) VALUES (8, N'ThangTT', N'sdbdsb', N'090227654321', 10, CAST(0x0000A24000000000 AS DateTime), CAST(0x0000A24000000000 AS DateTime), 0)
INSERT [dbo].[Customers] ([ID], [Name], [Address], [Phone], [DealerID], [Created], [Modified], [IsDeleted]) VALUES (10, N'ABCDEF', N'asavasvas', N'054564651', 10, CAST(0x0000A24000000000 AS DateTime), CAST(0x0000A24000000000 AS DateTime), 0)
SET IDENTITY_INSERT [dbo].[Customers] OFF
/****** Object:  Table [dbo].[Orders]    Script Date: 09/23/2013 12:16:00 ******/
SET IDENTITY_INSERT [dbo].[Orders] ON
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (3, 2, 1, 3, 600000, 1, CAST(0x0000A23800000000 AS DateTime), CAST(0x0000A23800000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (4, 2, 1, 3, 600000, 2, CAST(0x0000A23800000000 AS DateTime), CAST(0x0000A23800000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (5, 2, 1, 2, 200000, 3, CAST(0x0000A23800000000 AS DateTime), CAST(0x0000A23800000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (6, 2, 3, 3, 600000, 1, CAST(0x0000A23A00000000 AS DateTime), CAST(0x0000A23A00000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (7, 2, 2, 2, 200000, 1, CAST(0x0000A23A00000000 AS DateTime), CAST(0x0000A23A00000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (8, 2, 1, 3, 600000, 3, CAST(0x0000A23A00000000 AS DateTime), CAST(0x0000A23A00000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (9, 2, 2, 2, 200000, 3, CAST(0x0000A23A00000000 AS DateTime), CAST(0x0000A23A00000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (10, 2, 2, 1, 100000, 3, CAST(0x0000A23A00000000 AS DateTime), CAST(0x0000A23A00000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (11, 2, 1, 3, 600000, 3, CAST(0x0000A23B00000000 AS DateTime), CAST(0x0000A23B00000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (12, 2, 1, 3, 600000, 3, CAST(0x0000A23B00000000 AS DateTime), CAST(0x0000A23B00000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (13, 2, 3, 3, 600000, 1, CAST(0x0000A23C00000000 AS DateTime), CAST(0x0000A23C00000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (14, 2, 5, 3, 600000, 3, CAST(0x0000A23D00000000 AS DateTime), CAST(0x0000A23D00000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (15, 10, 1, 3, 600000, 1, CAST(0x0000A23D00000000 AS DateTime), CAST(0x0000A23D00000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (16, 10, 7, 2, 200000, 2, CAST(0x0000A23F00000000 AS DateTime), CAST(0x0000A23F00000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (17, 10, 3, 3, 600000, 2, CAST(0x0000A23F00000000 AS DateTime), CAST(0x0000A23F00000000 AS DateTime), 3, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (18, 10, 3, 2, 200000, 2, CAST(0x0000A23F00000000 AS DateTime), CAST(0x0000A23F00000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (19, 10, 1, 2, 200000, 2, CAST(0x0000A23F00000000 AS DateTime), CAST(0x0000A23F00000000 AS DateTime), 3, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (20, 10, 2, 4, 700000, 2, CAST(0x0000A23F00000000 AS DateTime), CAST(0x0000A23F00000000 AS DateTime), 2, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (21, 10, 1, 4, 700000, 2, CAST(0x0000A23F00000000 AS DateTime), CAST(0x0000A23F00000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (22, 10, 4, 4, 700000, 3, CAST(0x0000A24000000000 AS DateTime), CAST(0x0000A24100000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (24, 10, 8, 1, 100000, 3, CAST(0x0000A24000000000 AS DateTime), CAST(0x0000A24000000000 AS DateTime), 1, 0)
INSERT [dbo].[Orders] ([ID], [DealerID], [CustomerID], [VehicleID], [Price], [Status], [Created], [Modified], [Quantity], [IsDeleted]) VALUES (25, 10, 4, 2, 700000, 1, CAST(0x0000A24000000000 AS DateTime), CAST(0x0000A24000000000 AS DateTime), 2, 0)
SET IDENTITY_INSERT [dbo].[Orders] OFF
/****** Object:  Table [dbo].[ImportOrders]    Script Date: 09/23/2013 12:16:00 ******/
SET IDENTITY_INSERT [dbo].[ImportOrders] ON
INSERT [dbo].[ImportOrders] ([ID], [VehicleID], [Price], [Quantity], [DealerID], [Created], [Modified], [IsDeleted], [DealerModifiedID]) VALUES (11, 8, 350000, 15, 10, CAST(0x0000A24000000000 AS DateTime), CAST(0x0000A24000000000 AS DateTime), 0, 10)
INSERT [dbo].[ImportOrders] ([ID], [VehicleID], [Price], [Quantity], [DealerID], [Created], [Modified], [IsDeleted], [DealerModifiedID]) VALUES (12, 8, 400000, 5, 10, CAST(0x0000A24000000000 AS DateTime), CAST(0x0000A24000000000 AS DateTime), 0, 10)
SET IDENTITY_INSERT [dbo].[ImportOrders] OFF
