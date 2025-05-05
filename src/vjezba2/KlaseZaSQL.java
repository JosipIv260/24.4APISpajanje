package vjezba2;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class KlaseZaSQL {
    private String NazivDrzave;
    private String NazivIzmjene;
    private int BrojIzmjene;
    private String NazivTabliceBrisanje;
    private  int DrzavaBrisanjeID;
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
    public void ubaciDrzavu(String nazivNaziv) {
        String sql = "INSERT INTO Drzava (Naziv) VALUES (?)";
        try (Connection conn = createDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nazivNaziv);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Uspjesno dodana drzava: " + nazivNaziv);
            } else {
                System.out.println("Dodavanje drzave nije uspjelo.");
            }
        } catch (SQLException e) {
            System.err.println("Greska pri ubacivanju drzave: " + e.getMessage());
        }
        this.NazivDrzave=nazivNaziv;

    }
    public  void IzmjenaDrzave(String nazivizmjene,int brojIzmjene){

        String sql= "UPDATE Drzava SET Naziv=(?) WHERE IDDrzava=(?)";
        try (Connection conn = createDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nazivizmjene);
            ps.setInt(2,brojIzmjene);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Uspjesno je promjenjena drzava: " + nazivizmjene);
            } else {
                System.out.println("Izmjena drzave nije uspijela.");
            }
        } catch (SQLException e) {
            System.err.println("Greska pri izmjeni drzave: " + e.getMessage());
        }
        this.NazivIzmjene=nazivizmjene;
    }
    public  void BrisanjeDrzave (String nazivtablicebrisanje,int drzavabrisanjeID){
        String sql="DELETE FROM Drzava WHERE IDDrzava=?";
        try (Connection conn = createDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nazivtablicebrisanje);
            ps.setInt(2,drzavabrisanjeID);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Uspjesno je izbrisana drzava pod ID: " + drzavabrisanjeID);
            } else {
                System.out.println("Brisanje drzave nije uspijelo.");
            }
        } catch (SQLException e) {
            System.err.println("Greska pri brisanju drzave: " + e.getMessage());
        }

    }
    public void  SortiranjeDrzave(){
        String sql="SELECT Naziv FROM Drzava GROUP BY Naziv";
        try (Connection conn = createDataSource().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
          while (rs.next()){
              String naziv = rs.getString("Naziv");
              System.out.println(naziv);
          }
        } catch (SQLException e) {
            System.err.println("Greska pri sortiranju: " + e.getMessage());
        }
    }

}


