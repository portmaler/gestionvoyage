package gestionreservation;

import java.io.Serializable;

public class Client implements Serializable{
	
	public static int Nclient=0;
	
	private String Nom;
	private String Address;
	private int ID;
	
	
	public Client(String nom, String address) {
		super();
		Nclient++;
		Nom = nom;
		Address = address;
		ID = Nclient;
	}
	
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	
	@Override
	public String toString() {
		return "Client [Nom=" + Nom + ", Address=" + Address + ", ID=" + ID + "]";
	}

}
