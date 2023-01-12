USE [tempdb]
GO

/****** Object:  Table [dbo].[customers_tbl]    Script Date: 1/10/2023 12:21:03 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[policy](
	[number] [int] IDENTITY(1,1) NOT NULL,
	[type] [nvarchar](50) NOT NULL,
	[customerId] [int]  NOT NULL,
	[created][date]NOT NULL,
	[lastModified][date]NOT NULL,
) ON [PRIMARY]
GO

