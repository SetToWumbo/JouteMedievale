import java.io.Closeable;
import java.io.FileInputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GenerateurChevaliers {
    private static final String FICHIER_SRC = "nomsChevaliers.txt";
    static Random rng = new Random();
    private static ArrayList<String> noms = populate(FICHIER_SRC);


    public static void main(String[] args) {
        Chevalier chevalier1 = creer();
        System.out.println(chevalier1.getNomSeigneur());
    }

    public static Chevalier creer() {
        if(noms.isEmpty()){
            throw new IllegalArgumentException("Il ne reste plus de Chevaliers pour vous!");
        }
        int[] niveaux = new int[Habilete.values().length];
        for (int i = 0; i < niveaux.length; i++) {
            niveaux[i] = rng.nextInt(1, Habilete.MAXIMUM + 1);
        }
        Caracteristiques caracteristiques = null;
        do {
            try {
                caracteristiques = new Caracteristiques(niveaux);
            } catch (IllegalArgumentException e) {
                System.out.println("e");
            }
        } while (caracteristiques == null);
        return new Chevalier(caracteristiques, noms.remove(rng.nextInt(noms.size() + 1)));
    }

    /*
    Les trois méthodes suivantes chargent les noms possibles de nos chevaliers à partir d'un fichier
     */
    private static ArrayList<String> populate(String nomFichier) {
        FileInputStream fichier = ouvrirFichierLecture(nomFichier);
        Scanner scanner = new Scanner(fichier);
        ArrayList<String> listeDeNoms = new ArrayList<>();
        while (scanner.hasNext()) {
            listeDeNoms.add(scanner.nextLine());
        }
        fermerFichier(fichier);
        scanner.close();
        return listeDeNoms;
    }

    private static FileInputStream ouvrirFichierLecture(String nomFichier) {
        FileInputStream fichier = null;
        try {
            fichier = new FileInputStream(nomFichier);
        } catch (Exception e) {
            System.out.println(e);
        }
        return fichier;
    }

    private static void fermerFichier(Closeable fichier) {
        try {
            fichier.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}






























