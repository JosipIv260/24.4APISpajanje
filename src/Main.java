import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        DataSource dataSource= createDataSource();

        try (Connection connection=dataSource.getConnection()) {
            System.out.println("Uspijesno ste spojeni na bazu podataka");
        }
        catch (SQLException e){
            System.err.println("Greška prilikom spajanja na bazu podataka");
            e.printStackTrace();
        }

    }
    private  static DataSource createDataSource(){
        SQLServerDataSource ds= new SQLServerDataSource();
        ds.setServerName("Localhost");
        ds.setPortNumber(1433);
        ds.setDatabaseName("AdentureWorksOBP");
        ds.setUser("sa");
        ds.setPassword("SQL");
        ds.setEncrypt(false);


        return ds;
    }
}