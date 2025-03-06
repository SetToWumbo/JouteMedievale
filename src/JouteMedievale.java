import java.util.Scanner;

public class JouteMedievale {
    public enum Choix {
        OUI("oui"),
        NON("non");
        public String choix;

        Choix(String choix) {
            this.choix = choix;
        }
    }

    public static void main(String[] args) {
        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();

        joueur1.setChevalier(choisirChevalier(joueur1.getNomJoueur()));
        System.out.println();
        joueur2.setChevalier(choisirChevalier(joueur2.getNomJoueur()));
        System.out.println();
        System.out.println("Les deux chevaliers s'affrontent...");




    }




    public static Chevalier choisirChevalier(String nom) {
        Scanner scanner = new Scanner(System.in);
        Choix choix = null;
        for (int i = 0; i < 4; i++) {
            Chevalier chevalier = GenerateurChevaliers.creer();
            System.out.println(chevalier.getNomSeigneur() + " s'avance : " + chevalier.toString());
            String saisie;
            do{
                try {
                    System.out.print(nom + " : Ce chevalier se montre-t-il digne de votre confiance? [oui/non] : ");
                    saisie = scanner.nextLine().toLowerCase().trim();
                    choix = validerChoix(saisie);
                } catch (IllegalArgumentException e) {
                    choix = null;
                }
            }while(choix == null);

            switch(choix){
                case OUI:
                    System.out.println(chevalier.getNomSeigneur() + " est fier d'avoir été choisi!");
                    return chevalier;
                case NON:
                    System.out.println(chevalier.getNomSeigneur() + " est humilié par votre refus.");
            }
        }
        Chevalier chevalier = GenerateurChevaliers.creer();
        System.out.println("\nLe prêtre du village intervient en vous assignant un chevalier par la Bonté Divine.\n"
                + chevalier.getNomSeigneur() + " sera votre chevalier pour cette partie : " + chevalier.toString());
        return chevalier;
    }
    public static Choix validerChoix(String choix) {
        for (Choix option : Choix.values()) {
            if (choix.equals(option.choix)) {
                return option;
            }
        }
        throw new IllegalArgumentException("Choix invalide");
    }

}