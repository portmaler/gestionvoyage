package gestionreservation;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

enum TypeChambre {
	Single, Double, Family
}

public class HotelReservation implements Serializable{
	
	public static int prixChambre = 100;
	
	private int NumChambre;
	private Date DebutSejour;
	private Date FinSejour;
	private int N_Nuits;
	private TypeChambre type;
	private boolean Fumer;
	
	
	public HotelReservation(int numChambre, Date debutSejour, Date finSejour, String type,
			boolean fumer) {
		super();
		NumChambre = numChambre;
		DebutSejour = debutSejour;
		FinSejour = finSejour;
		long diffInMillies = Math.abs(finSejour.getTime() - debutSejour.getTime());
	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		N_Nuits = (int)diff;
		this.type = TypeChambre.valueOf(type);
		Fumer = fumer;
	}
	
	
	public int getNumChambre() {
		return NumChambre;
	}
	public void setNumChambre(int numChambre) {
		NumChambre = numChambre;
	}
	public Date getDebutSejour() {
		return DebutSejour;
	}
	public void setDebutSejour(Date debutSejour) {
		DebutSejour = debutSejour;
	}
	public Date getFinSejour() {
		return FinSejour;
	}
	public void setFinSejour(Date finSejour) {
		FinSejour = finSejour;
	}
	public int getN_Nuits() {
		return N_Nuits;
	}
	public void setN_Nuits(int n_Nuits) {
		N_Nuits = n_Nuits;
	}
	public TypeChambre getType() {
		return type;
	}
	public void setType(TypeChambre type) {
		this.type = type;
	}
	public boolean isFumer() {
		return Fumer;
	}
	public void setFumer(boolean fumer) {
		Fumer = fumer;
	}
	
	
	
	@Override
	public String toString() {
		return "HotelReservation [NumChambre=" + NumChambre + ", DebutSejour=" + DebutSejour + ", FinSejour="
				+ FinSejour + ", N_Nuits=" + N_Nuits + ", type=" + type + ", Fumer=" + Fumer + "]";
	}
	

}
