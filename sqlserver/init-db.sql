IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'community_center_db')
BEGIN
    CREATE DATABASE [community_center_db];
END
