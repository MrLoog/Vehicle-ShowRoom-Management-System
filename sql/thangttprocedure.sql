/****** Script for SelectTopNRows command from SSMS  ******/
SELECT TOP 1000 [ID]
      ,[ModelNumber]
      ,[Name]
      ,[Brand]
      ,[Price]
      ,[Quantity]
  FROM [ShowRoom].[dbo].[ImportOrders]