package com.example.kimmo;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyJDBC {

    public static Connection getConnection() {
        Connection connection = null;
        try {
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion","root2","");
              if(connection!=null){
                  System.out.println("connected");
              }
              return connection;
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

}





