public enum Habilete {
    INITIATIVE(0, "Initiative"),
    PRECISION(1, "Precision"),
    FORCE(2, "Force"),
    EQUILIBRE(3, "Equilibre");

    Habilete(int indice, String nom){
        this.indice = indice;
        this.nom = nom;
    }

    public int indice;
    public String nom;
    public static final int MAXIMUM = 20;
}
