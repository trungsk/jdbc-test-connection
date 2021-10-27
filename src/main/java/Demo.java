import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {

    static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost:3306/qlsv";
    static final String username = "root";
    static final String password = "root";

    public static void main(String[] args) {
        Connection con = null;
        Statement stm = null;

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            stm = con.createStatement();

            String sql = "select * from sv";
            ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                System.out.println(res.getInt(1) + " " + res.getString(2));
            }
            res.close();
            stm.close();
            con.close();
        } catch (Exception e) {
        }
        finally {
            try {
                if (con!=null||stm!=null)
                {

                    con.close();
                    stm.close();
                }
            }catch (Exception e){}
        }
    }
}
