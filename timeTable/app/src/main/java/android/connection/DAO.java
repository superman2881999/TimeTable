package android.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import android.app.DangNhap;
import android.app.R;
import android.widget.EditText;

public class DAO  {

    public String ht() throws SQLException {
        EditText MSSV = null;
        MSSV = (EditText) MSSV.findViewById(R.id.MSSV);
        String z= MSSV.getText().toString();

        connection connection_db=new connection();
        Connection con= connection_db.CONN();
        if(con!=null){
            String query="select * from thong_tin_lop where MSSV ="+z;
            Statement stmt=con.createStatement();
            ResultSet resultSet;
            resultSet=stmt.executeQuery(query);
            if(resultSet.next()){
                z = resultSet.getString("MSSV");
                con.close();}
        }
        return z;
    }
}
