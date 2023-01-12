USE [tempdb]
GO

/****** Object:  Table [dbo].[customers_tbl]    Script Date: 1/10/2023 12:21:03 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customer](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[firstname] [nvarchar](50) NOT NULL,
	[lastname] [nvarchar](50) NOT NULL,
	[dob] [date] NOT NULL,
	[address] [nvarchar](max) NOT NULL,
	[phone] [numeric](18, 0) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[gender] [char](10) NULL,
	[created][date]NOT NULL,
	[lastModified][date]NOT NULL,
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO