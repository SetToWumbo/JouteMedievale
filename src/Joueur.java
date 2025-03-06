import java.util.Scanner;

public class Joueur {

    private String nomJoueur;
    private Chevalier chevalier;


    public Joueur(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quel est votre nom, sire? : ");
        setNomJoueur(scanner.nextLine());
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }
    public String getNomJoueur(){
        return nomJoueur;
    }
    public void setChevalier(Chevalier chevalier){
        this.chevalier = chevalier;
    }
}
