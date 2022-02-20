package gestionreservation;

import java.io.Serializable;
import java.util.Date;

public class Sejour implements Serializable{
	
	private Date DebutSejour;
	private Date FinSejour;
	
	public Sejour(Date debutSejour, Date finSejour) {
		super();
		DebutSejour = debutSejour;
		FinSejour = finSejour;
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

	@Override
	public String toString() {
		return "Sejour [DebutSejour=" + DebutSejour + ", FinSejour=" + FinSejour + "]";
	}
	
	
	public double calculPrix(Voyage v)
	{
		double prixTickets = 0;
		double prixHotels = 0;
		
		for(TicketAvion ticket : v.listeTicket)
		{
			prixTickets += (double)ticket.prixTicket();
		}
		
		
		for(HotelReservation hotel : v.listeHotel)
		{
			double p = 0;
			switch(hotel.getType())
			{
			case Single : p = (HotelReservation.prixChambre)*(hotel.getN_Nuits()); break;
			case Double : p = (HotelReservation.prixChambre*1.2)*(hotel.getN_Nuits()); break;
			case Family : p = (HotelReservation.prixChambre*1.7)*(hotel.getN_Nuits()); break;
			default : break;
			}
			prixHotels += p;
		}
		
		return prixHotels + prixTickets;
		
	}
	
	

}
