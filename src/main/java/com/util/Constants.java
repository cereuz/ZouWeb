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
    /**
     * 查询数据库的SQL语句
     */
    public static final String SQL_SELECT_NAME = "SELECT name FROM country";
    public static final String SQL_SELECT_BOOK = "SELECT * FROM books";
    public static final String SQL_SELECT_BOOK2 = "SELECT * FROM books WHERE Id_B = '6'";
    /**
     * 創建數據庫表的語句
     */
    public static final String SQL_CREATE_PERSON = "CREATE TABLE Persons\n" +
            "(\n" +
            "Id_P int,\n" +
            "LastName varchar(255),\n" +
            "FirstName varchar(255),\n" +
            "Address varchar(255),\n" +
            "City varchar(255)\n" +
            ")";
    public static final String SQL_CREATE_BOOK = "CREATE TABLE Books\n" +
            "(\n" +
            "Id_B int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
            "BookName varchar(255),\n" +
            "ISBN varchar(255),\n" +
            "Price varchar(255),\n" +
            "Author varchar(255)\n" +
            ")";

    public static final String SQL_CREATE_WORK = "CREATE TABLE Works\n" +
            "(\n" +
            "Id_W int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n" +
            "Name varchar(255),\n" +
            "Address varchar(255),\n" +
            "Phone varchar(255),\n" +
            "Email varchar(255)\n," +
            "Relation varchar(255),\n" +
            "Content varchar(255)\n," +
            "Contacts varchar(255),\n" +
            "City varchar(255)\n" +
            ")";

    public static String SQL_INSERT_BOOKS = "INSERT INTO Books(BookName,ISBN,Price,Author) VALUES (?,?,?,?)";
}
