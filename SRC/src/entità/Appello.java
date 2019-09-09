package entità;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author assma
 */

/**
 * Classe:Appello
 * contiene il id ,la data dell'appello, la durata, l'aula dove si tratta l'esame 
 */

public class Appello {

    /** Attributes */
    private int id;
    private Date date;
    private String description;
    private double durata;
    private String aula;
    
    /** Associations */
    private int docente;
    private int insegnamento;
    private List<Prenotazione> listPrenotazione;
    private double voto;
    private Studente studente;

    
    
    /** Costruttore senza parametri*/
    public Appello() {
        super();
    }
    
       /** 
     * Costruttore con parametri
     * @param id
     * @param description
     * @param date
     * @param aula
     * @param durata
     * @param docente
     * @param insegnamento
     */
 
    public Appello(int id, String description, Date date, String aula, double durata, int docente, int insegnamento) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.durata = durata;
        this.aula = aula;
        this.docente = docente;
        this.insegnamento = insegnamento;
       
    }
   
    
      public Appello(int id, String description,String aula, double durata, int docente, int insegnamento,int voto) {
        this.id = id;
        this.description = description;
        this.durata = durata;
        this.aula = aula;
        this.docente = docente;
        this.insegnamento = insegnamento;
        this.voto = voto;
       
    }
    
    /**
	 * @return id
	 */
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /**
	 * @return date
	 */
    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    /**
	 * @return description
	 */
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    /**
	 * @return durata
	 */
    public double getDurata() {
        return this.durata;
    }

    public void setDurata(double durata) {
        this.durata = durata;
    }
    /**
	 * @return aula
	 */
    public String getAula() {
        return this.aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
    
    /**
	 * @return voto
	 */
        public int getVoto() {
        return (int) this.voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    /**
	 * @return docente
	 */
    public int getDocente() {
        return docente;
    }

    public void setDocente(int docente) {
        this.docente = docente;
    }
    
    public void setStudente(Studente studente) {
	this.studente=studente;
	}
    /**
	 * @return studente
	 */
    public Studente getStudente() {
     return studente;
    }
    /**
	 * @return insegnamento
	 */
    public int getInsegnamento() {
        return insegnamento;
    }

    public void setInsegnamento(int insegnamento) {
        this.insegnamento = insegnamento;
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
     * @param voto
     * operazione permette allo sutdente di accettare un voto uguale o piu' di 18
     * @return 
	 */
     
    public boolean isAccettareVoto(int voto) {
        
		if (voto>=18 &&  studente.accettareVoto()==true) {
			return true;
		} else {
			return false;
		}
	}
	
    
}
