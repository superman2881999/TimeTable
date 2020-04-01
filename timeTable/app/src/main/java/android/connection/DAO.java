package android.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO  {

    String ht() throws SQLException {
        String z="";
        connection connection_db=new connection();
        Connection con= connection_db.CONN();
        if(con!=null){
            String query="select* from Test where ID=1";
            Statement stmt=con.createStatement();
            ResultSet resultSet;
            resultSet=stmt.executeQuery(query);
            if(resultSet.next()){
                z = resultSet.getString("Name");
                con.close();}
        }
        return z;
    }
}
