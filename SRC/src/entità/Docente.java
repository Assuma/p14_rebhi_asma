package entità;


import java.util.ArrayList;
import java.util.List;
/** 
 * @author assma
 */


/**
 * Classe:Docente
 */

public class Docente extends Utente {
    private List<Prenotazione> listPrenotazione;
    private List<Appello> listAppello;
    private ArrayList<String> dataesame;
    private List<CorsoDiStudio> CorsoDistudi;
    private List<Insegnamento> Insegnamento;
    

    
    
   public Docente(int matricola,String nome, String cognome, String email, String password, String indirizzo, String cellulare) {
       super(matricola,nome, cognome,email,password,indirizzo,cellulare);
    }
   
   
   /**
	 * Costruttore senza parametri
	 */
     public Docente() {
        super();
    }

    /**
	 * @return listAppello
	 */
    public List<Appello> getListAppello() {
        return listAppello;
    }

    public void setListAppello(List<Appello> listAppello) {
        this.listAppello = listAppello;
    }
    
    /**
	 * @return dataesame
	 */
    public ArrayList<String> getDataesame() {
		return dataesame;
	}
    /**
	 * @return listPrenotazione
	 */
     public List<Prenotazione> getListPrenotazione() {
        return listPrenotazione;
    }

    public void setListPrenotazione(List<Prenotazione> listPrenotazione) {
        this.listPrenotazione = listPrenotazione;
    }
    /**
	 * @return CorsoDistudi
	 */
      public List<CorsoDiStudio> getCorsoDistudi() {
        return CorsoDistudi;
    }

    public void setCorsoDistudi(List<CorsoDiStudio> CorsoDistudi) {
        this.CorsoDistudi = CorsoDistudi;
    }
    /**
	 * @return Insegnamento
	 */
    public List<Insegnamento> getInsegnamento() {
        return Insegnamento;
    }

    public void setInsegnamento(List<Insegnamento> Insegnamento) {
        this.Insegnamento = Insegnamento;
    }

    
    public void setDataesame(ArrayList<String> appelloesame) {
		this.dataesame = appelloesame;
	}
    /**
	 * @param data
	 * operazione permette di aggiungere un appello
	 */
    public void addDataesame(String data ) {
    	if( !dataesame.isEmpty()){
    		dataesame.add(data);
    	}

    }
    /**
	 * @param data
	 * operazione permette di cancellare un appello
	 */
       public  void removeDataesame(String data ) {
    	for(int i=0 ;i<=dataesame.size();i++){
    		dataesame.remove(data);
         } 
       }

}