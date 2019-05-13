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

    public static String XIAO_YAO = "北冥有鱼，其名曰鲲。鲲之大，不知其几千里也；化而为鸟，其名为鹏。鹏之背，不知其几千里也；怒而飞，其翼若垂天之云。是鸟也，海运则将徙于南冥。南冥者，天池也。齐谐者，志怪者也。谐之言曰：“鹏之徙于南冥也，水击三千里，抟扶摇而上者九万里，去以六月息者也。”野马也，尘埃也，生物之以息相吹也。天之苍苍，其正色邪？其远而无所至极邪？其视下也，亦若是则已矣。且夫水之积也不厚，则其负大舟也无力。\n" +
            "\n" +
            "覆杯水于坳堂之上，则芥为之舟；置杯焉则胶，水浅而舟大也。风之积也不厚，则其负大翼也无力，故九万里则风斯在下矣。而后乃今培风，背负青天而莫之夭阏者，而后乃今将图南。蜩与学鸠笑之曰：“我决起而飞，抢榆枋，时则不至，而控于地而已矣；奚以之九万里而南为？”适莽苍者，三飡而反，腹犹果然；适百里者，宿舂粮；适千里者，三月聚粮。之二虫又何知？小知不及大知，小年不及大年。奚以知其然也？\n" +
            "\n" +
            "朝菌不知晦朔，蟪蛄不知春秋，此小年也。楚之南有冥灵者，以五百岁为春，五百岁为秋；上古有大椿者，以八千岁为春，八千岁为秋。而彭祖乃今以久特闻，众人匹之，不亦悲乎？\n" +
            "\n" +
            "汤之问棘也是已：“穷发之北有冥海者，天池也。有鱼焉，其广数千里，未有知其修者，其名曰鲲。有鸟焉，其名为鹏，背若太山，翼若垂天之云；抟扶摇、羊角而上者九万里，绝云气，负青天，然后图南，且适南冥也。斥鴳笑之曰：‘彼且奚适也？我腾跃而上，不过数仞而下，翱翔蓬蒿之间，此亦飞之至也。而彼且奚适也？’”此小大之辩也。\n" +
            "\n" +
            "故夫知效一官、行比一乡、德合一君、而徵一国者，其自视也亦若此矣。而宋荣子犹然笑之。且举世而誉之而不加劝，举世而非之而不加沮，定乎内外之分，辩乎荣辱之境，斯已矣。彼其于世，未数数然也。虽然，犹有未树也。夫列子御风而行，泠然善也，旬有五日而后反。彼于致福者，未数数然也。此虽免乎行，犹有所待者也。若夫乘天地之正，而御六气之辩，以游无穷者，彼且恶乎待哉？故曰：至人无己，神人无功，圣人无名。\n" +
            " 听风者无耳，千里眼无目，悲喜交加的时候是个真实的梦靥；\n" +
            "2019年05月07日   22时10分52秒   星期二";
}
