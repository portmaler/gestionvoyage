package gestionreservation;

import java.io.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;


public class Voyage implements Serializable{
	
	
	
	private Client client;
	private Sejour sejour;
	
	Vector<Client> invites = new Vector<>();
	Vector<HotelReservation> listeHotel = new Vector<>();
	Vector<TicketAvion> listeTicket = new Vector<>();
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	
	
	
	public void ajouterClient(String nom, String address)
	{
		client = new Client(nom,address);
	}
	
	
	public void ajouterInvites(String nom, String address)
	{
		invites.addElement(new Client(nom,address));
	}
	
	
	
	public void ajouterSejour(String debutSejour , String finSejour)
	{
		try {
			sejour = new Sejour(format.parse(debutSejour), format.parse(finSejour));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	public void ajouterHotel(int numChambre, String debutSejour, String finSejour, String type,
			boolean fumer)
	{
		try {
			listeHotel.addElement( new HotelReservation(numChambre,format.parse(debutSejour),format.parse(finSejour), type,fumer));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void ajouterTicket(String referenceAvion,String trajet,int number)
	{
		for(int i=0 ; i < number ; i++)
			{
				listeTicket.addElement(new TicketAvion(referenceAvion,trajet));
			}
	}
	
	
	//----------Serialisation---------//
	public static void seriliser(Voyage voyage)
	{
		try {
	        FileOutputStream file = new FileOutputStream("voyage.ser");
	        ObjectOutputStream ob = new ObjectOutputStream(file);
	       
	        ob.writeObject(voyage);
	        	
	        
	        ob.close();
            file.close();

	    } catch (Exception e) {e.printStackTrace();
        System.exit(1);}
	}
	
	
	//----------Deserialisation---------//
	public static void deserilaiser() {
        try
        {   
            FileInputStream file = new FileInputStream("voyage.ser");
            ObjectInputStream in = new ObjectInputStream(file);
              
            Voyage v = null;
            while((v = (Voyage)in.readObject()) != null)	
            {
            	System.out.println(v.toString());
            }
            
            in.close();
            file.close();
            
 
        } catch (Exception e) {
        e.fillInStackTrace();
        }
	}
	
	
	
	@Override
	public String toString() {
		return "Voyage [client=" + client + ", sejour=" + sejour + "******** prixTotal: " + this.sejour.calculPrix(this) +  "]";
	}

	public static void main(String[] args)
	{
		TicketAvion.ajouterPaysOrigineDest();
//		TicketAvion.afficherTrajet();
		
		Voyage voyage1 = new Voyage();
		Voyage voyage2 = new Voyage();
		Voyage voyage3 = new Voyage();
		
		voyage1.ajouterClient("yassir", "indigo");
		voyage1.ajouterSejour("12/01/2022", "22/01/2022");
		voyage1.ajouterTicket("AIRBUS368","MarocFrance" , 1);
		voyage1.ajouterTicket("boingS368","AlmagneTurqie" , 1);
		voyage1.ajouterHotel(101, "12/01/2022", "16/01/2022", "Single" , false);
		voyage1.ajouterHotel(103, "17/01/2022", "22/01/2022", "Single" , false);
		
		voyage2.ajouterClient("samir", "idoumdah");
		voyage2.ajouterInvites("nouhaila", "moflih");
		voyage2.ajouterSejour("02/02/2022", "22/11/2022");
		voyage2.ajouterHotel(101, "02/02/2022", "16/02/2022", "Double" , false);
		voyage2.ajouterHotel(103, "15/02/2022", "20/02/2022", "Double" , false);
		voyage2.ajouterTicket("AIRBUS368","MarocFrance" , 2);
		voyage2.ajouterTicket("boingS368","FranceAlmagne" , 2);
		
		
		voyage3.ajouterClient("ayoub", "ismaili");
		voyage3.ajouterInvites("laila", "zobir");
		voyage3.ajouterInvites("nizar", "ismaili");
		voyage3.ajouterInvites("soukaina", "ismail");
		voyage3.ajouterSejour("05/02/2022", "22/02/2022");
		voyage3.ajouterHotel(101, "05/02/2022", "16/02/2022", "Family" , false);
		voyage3.ajouterHotel(103, "15/02/2022", "22/02/2022", "Family" , false);
		voyage3.ajouterTicket("AIRBUS368","MarocSpain" , 4);
		voyage3.ajouterTicket("boingS368","SpainFrance" , 4);
		voyage3.ajouterTicket("boingS368","MarocFrance" , 4);
		
		
		System.out.println(voyage1.toString());
		System.out.println(voyage2.toString());
		System.out.println(voyage3.toString());
		
	

	    
       
        //-------Serialization-------------//
      
       //seriliser(voyage1);
       //deserilaiser();
        
       
	}
	
}
