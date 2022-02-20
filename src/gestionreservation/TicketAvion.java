package gestionreservation;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TicketAvion implements Serializable{
	

	private String Trajet;
	private String ReferenceAvion; 
	
	static Map<String,Integer> trajetprix = new HashMap<String,Integer>();
	static Set<Map.Entry<String,Integer>> Trajets = trajetprix.entrySet();
	


	public TicketAvion(String referenceAvion,String trajet) {
		
		this.Trajet = trajet;
		ReferenceAvion = referenceAvion;
	}

	public String getReferenceAvion() {
		return ReferenceAvion;
	}

	public void setReferenceAvion(String referenceAvion) {
		ReferenceAvion = referenceAvion;
		
	}
	
	public String getTrajet() {
		return Trajet;
	}

	public void setTrajet(String trajet) {
		Trajet = trajet;
	}
	
	

	public static void afficherTrajet()
	{
		
		for(Map.Entry<String,Integer> entry:Trajets)
		{
			System.out.println("Trajet : " + entry.getKey() + "  prix : " + entry.getValue());
		}
	}
	
	
	
	public static void ajouterPaysOrigineDest() {
		
		trajetprix.put("MarocFrance", 400);
		trajetprix.put("FranceAlmagne", 100);
		trajetprix.put("FranceItaly", 150);
		trajetprix.put("AlmagneTurqie", 170);
		trajetprix.put("MarocSpain", 120);
		trajetprix.put("SpainFrance", 100);
		trajetprix.put("SpainAlmagne", 150);
		trajetprix.put("MarocAlmagne", 450);
		trajetprix.put("AlmagneItaly", 200);
		
		
	}
	
	public Integer prixTicket()
	{
		Iterator<Map.Entry<String, Integer>> iterator = Trajets.iterator();
		
		while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            
            if(entry.getKey().equals(getTrajet()))
            {
            	return entry.getValue();
            }
            
        }
		return 0;
	}
	
	
	

}
