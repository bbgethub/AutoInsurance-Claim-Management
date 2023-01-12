USE [tempdb]
GO

/****** Object:  Table [dbo].[customers_tbl]    Script Date: 1/10/2023 12:21:03 PM ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[claim](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[amount] [int] NOT NULL,
	[policyNumber] [int] NOT NULL,
	[created][date]NOT NULL,
	[lastModified][date]NOT NULL,
	[status][nvarchar](50) NULL,
	[notes][nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO