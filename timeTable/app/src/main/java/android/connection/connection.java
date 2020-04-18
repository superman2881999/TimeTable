package android.connection;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class connection {
    String ip="42.118.9.247";
    String classs="net.sourceforge.jtds.jdbc.Driver";
    String db="timeTable";
    String us="letuan3112";
    String pw="Technology2312";

    public Connection CONN(){
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn=null;
        String ConnURL=null;
        try{
            Class.forName(classs);
            ConnURL="jdbc:jtds:sqlserver://"+ip+";databaseName="+db+";user="+us+";password="+pw+";";
            conn= DriverManager.getConnection(ConnURL);
        }catch (SQLException se){
            Log.e("ERRO",se.getMessage());
        }catch (ClassNotFoundException e){
            Log.e("ERRO",e.getMessage());
        }catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;

    }
}
