package com.util;

/**
 * @author : zw
 * @email : zsky@live.com,
 * @date : 2019/4/12 17:10.
 * @motto : To be, or not to be.
 */
public class Constants {
    //mysql驱动包名
    public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    //数据库连接地址
    public static final String URL = "jdbc:mysql://localhost:3306/world?serverTimezone=UTC";
    public static final String URL_ZOU0306 = "jdbc:mysql://localhost:3306/zou0306?serverTimezone=UTC";
    //用户名
    public static final String USER_NAME = "root";
    //密码
    public static final String PASSWORD = "123456";
    public static final String UBER_UDID = "UDID";
    /**
     * 查询数据库的SQL语句
     */
    public static final String SQL_SELECT_NAME = "SELECT name FROM country";
    public static final String SQL_SELECT_BOOK = "SELECT * FROM books";
    public static final String SQL_SELECT_UBER = "SELECT * FROM uber";
    public static final String SQL_SELECT_BOOK2 = "SELECT * FROM books WHERE Id_B = '6'";
    public static final String SQL_SELECT_UBER_UDID = "SELECT * FROM uber GROUPE BY UDID Where UDID = ?";
    public static final String SQL_SELECT_UBER_UDID2 = "SELECT * FROM uber Where UDID = ? or UDID = ? or UDID = ? or UDID = ? or UDID = ? or UDID = ? or UDID = ? or UDID = ? or UDID = ? or UDID = ?";
    /**
     * 創建數據庫表的語句
     */
    public static final String SQL_CREATE_PERSON = "CREATE TABLE Persons\n" +
            "(\n" +
            "Id int,\n" +
            "LastName varchar(255),\n" +
            "FirstName varchar(255),\n" +
            "Address varchar(255),\n" +
            "City varchar(255)\n" +
            ")";
    public static final String SQL_CREATE_BOOK = "CREATE TABLE Books\n" +
            "(\n" +
            "Id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
            "BookName varchar(255),\n" +
            "ISBN varchar(255),\n" +
            "Price varchar(255),\n" +
            "Author varchar(255)\n" +
            ")";

    public static final String SQL_CREATE_WORK = "CREATE TABLE Works\n" +
            "(\n" +
            "Id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
            "Name varchar(255),\n" +
            "Address varchar(255),\n" +
            "Phone varchar(255),\n" +
            "Email varchar(255)\n," +
            "Relation varchar(255),\n" +
            "Content varchar(255)\n," +
            "Contacts varchar(255),\n" +
            "City varchar(255)\n" +
            ")";

    public static final String SQL_CREATE_UBER = "CREATE TABLE Uber\n" +
            "(\n" +
            "Id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
            "UDID varchar(255),\n" +
            "Type varchar(255),\n" +
            "Departure varchar(255),\n" +
            "Destination  varchar(255),\n" +
            "Time varchar(255)\n," +
            "Seat varchar(255),\n" +
            "Cost varchar(255)\n," +
            "NickName varchar(255)\n," +
            "Phone varchar(255),\n" +
            "Automobile  varchar(255),\n" +
            "Experience varchar(255),\n" +
            "QQ varchar(255),\n" +
            "Remark varchar(255)\n" +
            ")";

    public static String SQL_INSERT_BOOKS = "INSERT INTO Books(BookName,ISBN,Price,Author) VALUES (?,?,?,?)";
    public static String SQL_INSERT_UBER = "INSERT INTO Uber(UDID,Type,Departure,Destination,Time,Seat,Cost,NickName,Phone,Automobile,Experience,QQ,Remark) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
}
