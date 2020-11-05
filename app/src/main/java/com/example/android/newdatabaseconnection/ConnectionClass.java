package com.example.android.newdatabaseconnection;

import android.annotation.SuppressLint;
import android.database.SQLException;
import android.os.StrictMode;
import android.util.Log;
import java.sql.Connection;
import java.sql.DriverManager;



    public class ConnectionClass {


        //String ip = "your server ip address";
        //String classs = "net.sourceforge.jtds.jdbc.Driver";
        //String db = "Your database name";
        //String un = "your database username";
        //String password = "your database password";

        @SuppressLint("NewApi")
        public Connection CONN() {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Connection conn = null;
            String ConnURL = null;
            try {

                Class.forName("net.sourceforge.jtds.jdbc.Driver");
                ConnURL = "jdbc:jtds:sqlserver://yourServerIp/yourDatabaseName;user=yourDatabaseUsername;password=yourDatabasePassword;useNTLMv2=true;integratedSecurity=true";
                conn = DriverManager.getConnection(ConnURL);
            } catch (SQLException se) {
                Log.e("ERRO", se.getMessage());
            } catch (ClassNotFoundException e) {
                Log.e("ERRO", e.getMessage());
            } catch (Exception e) {
                Log.e("ERRO", e.getMessage());
            }
            return conn;
        }
    }




