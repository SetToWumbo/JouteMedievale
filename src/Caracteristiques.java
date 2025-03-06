public class Caracteristiques {

    private int[] habiletes = new int[Habilete.values().length];

    public Caracteristiques(int[] niveaux) {
        for (int niveau = 0; niveau < niveaux.length; niveau++) {
            if (niveaux[niveau] < 1 || niveaux[niveau] > Habilete.MAXIMUM) {
                throw new IllegalArgumentException("Niveau invalide");
            }
            for (Habilete stat : Habilete.values()) {
                habiletes[stat.indice] = niveaux[stat.indice];
            }
        }
    }

    public int getNiveau(Habilete habilete) {
        return habiletes[habilete.indice];
    }
}
