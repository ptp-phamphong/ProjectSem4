package com.aptech.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtilDb {


    private Connection connection;

    public UtilDb(Connection conection) {
        this.connection = conection;
    }

    UtilDb() {
    }
    
    public Connection getConnection(){
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public void connect(){
        if(this.connection == null){
//            String dbURL = "jdbc:sqlserver://localhost\\PHAMTHANHPHONG:1433;databaseName=SportShop;user=sa;password=sa";
            String dbURL = "jdbc:sqlserver://localhost;databaseName=SportShop;user=sa;password=123456"; //Huy
            //Ai xài chuỗi kết nối nào thì điền xuống dưới rồi thôi, comment người khác lại
            try{
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                this.connection = DriverManager.getConnection(dbURL);
            }
            catch(Exception e){
                System.out.println("1111");
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void disConnect(){
        if(connection!=null){
            try{
                connection.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}
