package ma.emsi.classe;

public class Voiture {
    String matricule;
	String marque;
	String couleur;
    Double prix;
    Double kilometrage;
    Double vitesse;
	public Voiture(){

	}

    public Voiture(String matricule,String marque, String couleur, double prix, double kilometrage, double vitesse) {
        this.matricule = matricule;
		this.marque = marque;
		this.couleur = couleur;
        this.prix = prix;
        this.kilometrage = kilometrage;
        this.vitesse = vitesse;
    }
	
	public String getMatricule() {
		return matricule;
	}
	public void setmMtricule(String matricule) {
		this.matricule = matricule;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public Double getKilometrage() {
		return kilometrage;
	}
	public void setKilometrage(Double kilometrage) {
		this.kilometrage = kilometrage;
    }
    public Double getVitesse() {
		return vitesse;
	}
	public void setVitesse(Double vitesse) {
		this.vitesse = vitesse;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "marque = " + this.marque +
                ", matricule=" + this.matricule+
                ", couleur='" + this.couleur+
                ", prix=" + this.prix +
                ", kilometrage=" + this.kilometrage +
                ", vitesse=" + this.vitesse +
                '}';
    }
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Voiture)) return false;
		Voiture voiture = (Voiture) o;
		return Double.compare(voiture.getPrix(), getPrix()) == 0 && Double.compare(voiture.getKilometrage(), getKilometrage()) == 0 && Double.compare(voiture.getVitesse(), getVitesse()) == 0 && getMarque().equals(voiture.getMarque()) && getMatricule().equals(voiture.getMatricule()) && getCouleur().equals(voiture.getCouleur());
	}
}
