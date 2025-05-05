package vjezba2;


import java.util.Scanner;

//Napiši Java konzolnu aplikaciju sa sljedećim funkcionalnostima:
//Korisniku se prikazuje izbornik sa sljedećim opcijama:
//1 – nova država
//2 - izmjena postojeće države
//3 - brisanje postojeće države
//4 – prikaz svih država sortiranih po nazivu
//5 – kraj
//
//Opcije 1 do 4 odnose se na CRUD operacije and tablicom Drzava u bazi AdventureWorks
//Odabirom opcije 2 i 3, od korisnika je potrebno tražiti ID države koje želite izmijeniti ili pobrisati
//Napomena: brišite i mijenjajte samo one države koje ste Vi ubacili (one za koje je IdDrzava veći od 3)
public class ProgramDrzava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KlaseZaSQL Tablica = new KlaseZaSQL();

        //Nova drzava umetanje
        System.out.print("Unesi naziv nove drzave: ");
       String Drzava= sc.nextLine().trim();
        Tablica.ubaciDrzavu(Drzava);


        //Izmjena drzave
        System.out.println("Upisi novu drzavu koju zelis umetnuti");
        String ImeDrzave=sc.next().trim();
        System.out.println("Upisi IDDrzave koju zelis zamjenit");
        int IDDrzave=sc.nextInt();
        Tablica.IzmjenaDrzave(ImeDrzave,IDDrzave);
        sc.close();

        //Brisanje drzave
        System.out.println("Upisi naziv tablice drzave koju zelis izbrisati");
        String NazivTab= sc.nextLine().trim();
        System.out.println("Upisi ID te drzave");
        int IDdrzave=sc.nextInt();
        Tablica.BrisanjeDrzave(NazivTab,IDdrzave);

        //Sortiranje drzave
        Tablica.SortiranjeDrzave();

    }
}
