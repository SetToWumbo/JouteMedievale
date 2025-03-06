import java.util.Random;

public class Chevalier {

    private int nbLances = 3;
    private String nomSeigneur;
    private Caracteristiques caracteristiques;


    public Chevalier(Caracteristiques caracteristiques, String nomSeigneur) {
        this.caracteristiques = caracteristiques;
        this.nomSeigneur = nomSeigneur;
    }

    public Chevalier attaquer(Chevalier chevalier) {
        Random random = new Random();

        System.out.println(chevalier.getNomSeigneur() + " tente une attaque...");
        if(random.nextInt(1, Habilete.MAXIMUM) <= caracteristiques.getNiveau(Habilete.PRECISION)){

        }
        return null;
    }

    public String getNomSeigneur() {
        return nomSeigneur;
    }

    public void setNomSeigneur(String nomSeigneur) {
        this.nomSeigneur = nomSeigneur;
    }

    public int getInitiative() {
        return caracteristiques.getNiveau(Habilete.INITIATIVE);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Habilete stat : Habilete.values()) {
            sb.append(stat);
            sb.append("[");
            sb.append(caracteristiques.getNiveau(stat));
            sb.append("] ");
        }
        return sb.toString();
    }
}
