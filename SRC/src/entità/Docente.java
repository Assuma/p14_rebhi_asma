package entità;


import java.util.ArrayList;
import java.util.List;


public class Docente extends Utente {
    private List<Prenotazione> listPrenotazione;
    private List<Appello> listAppello;
    private ArrayList<String> dataesame;
    private List<CorsoDiStudio> CorsoDistudi;
    private List<Insegnamento> Insegnamento;
    
   

  
   
//     public Docente(List<Prenotazione> listPrenotazione, List<Appello> listAppello, ArrayList<String> dataesame, List<CorsoDiStudio> CorsoDistudi, List<Insegnamento> Insegnamento) {
//        this.listPrenotazione = listPrenotazione;
//        this.listAppello = listAppello;
//        this.dataesame = dataesame;
//        this.CorsoDistudi = CorsoDistudi;
//        this.Insegnamento = Insegnamento;
//    }
   public Docente(int matricola,String nome, String cognome, String email, String password, String indirizzo, String cellulare) {
       super(matricola,nome, cognome,email,password,indirizzo,cellulare);
    }
     public Docente() {
        super();
    }


    public List<Appello> getListAppello() {
        return listAppello;
    }

    public void setListAppello(List<Appello> listAppello) {
        this.listAppello = listAppello;
    }
    
    
    public ArrayList<String> getDataesame() {
		return dataesame;
	}
    
     public List<Prenotazione> getListPrenotazione() {
        return listPrenotazione;
    }

    public void setListPrenotazione(List<Prenotazione> listPrenotazione) {
        this.listPrenotazione = listPrenotazione;
    }
    
      public List<CorsoDiStudio> getCorsoDistudi() {
        return CorsoDistudi;
    }

    public void setCorsoDistudi(List<CorsoDiStudio> CorsoDistudi) {
        this.CorsoDistudi = CorsoDistudi;
    }

    public List<Insegnamento> getInsegnamento() {
        return Insegnamento;
    }

    public void setInsegnamento(List<Insegnamento> Insegnamento) {
        this.Insegnamento = Insegnamento;
    }

    
    



    public void setDataesame(ArrayList<String> appelloesame) {
		this.dataesame = appelloesame;
	}
    
    public void addDataesame(String data ) {
    	if( !dataesame.isEmpty()){
    		dataesame.add(data);
    	}

    }
    
       public  void removeDataesame(String data ) {
    	for(int i=0 ;i<=dataesame.size();i++){
    		dataesame.remove(data);
         } 
       }

}