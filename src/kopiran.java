import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Kopiran {
        public static void main(String[] args) {
            DataSource dataSource = createDataSource();

            try (Connection connection = dataSource.getConnection()) {
                System.out.println("Uspješno ste spojeni na bazu podataka!");

                //Preimenovanje države
                Statement stmt = connection.createStatement();
                int rowAffected = stmt.executeUpdate("UPDATE Drzava SET Naziv='Croatia' WHERE IDDrzava=1");
                System.out.println("Država je uspiješno primrnovana ");

                //Novi upit dodaj xy drzavu u bazu
                int rowAffecteds=stmt.executeUpdate("INSERT INTO Drzava (Naziv) VALUES ('Madagaskar')");

               // Dohvacanje svih drzava

                ResultSet rs= stmt.executeQuery("SELECT IDDRZAVA, NAziv FROM Drzava");
                while (rs.next()){
                    System.out.printf("%d %s\n", rs.getInt("IDDrzava"), rs.getString("Naziv"));
                }
                rs.close();
                stmt.close();
            }

            catch (SQLException e) {
                System.err.println("Greška prilikom spajanja na bazu podataka");
                e.printStackTrace();
            }


        }

        private static DataSource createDataSource() {
            SQLServerDataSource ds = new SQLServerDataSource();
            ds.setServerName("localhost");
            //ds.setPortNumber(1433);
            ds.setDatabaseName("AdventureWorksOBP");
            ds.setUser("sa");
            ds.setPassword("SQL");
            ds.setEncrypt(false);

            return ds;
        }
    }

