package Helper;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBConnector {
    private Connection connect = null;
    public Connection connectDB(){

        try {
            this.connect = DriverManager.getConnection("jdbc:postgresql://localhost/tourismagenty?user=postgres&password=postgresql");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
        return this.connect;
    }
    public static Connection getInstance(){
        DBConnector dbConnector = new DBConnector();
        return dbConnector.connectDB();
    }
}