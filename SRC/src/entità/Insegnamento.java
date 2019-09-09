package entità;

import enumerations.AnnoDiStudi;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author assma
 */

/**
 * Classe:Insegnamento
 * contiene il codice ,il nome, cfu, e la descrizione della materia 
 */
public class Insegnamento {
   
    /** Attributes */
    private int codice;
    private String nome;
    private String description;
    private int cfu;
    private int corsoDiStudio ;
    /** Associations */
    private Sistema sistema;
    private AnnoDiStudi annoDiStudi ;
    private List<Prenotazione> prenotazioni;
    private List<Appello> listAppello;
    private PianoDiStudio pianoDiStudio;
    
   /**
	 * Costruttore senza parametri
	 */
    public Insegnamento() {
        super();
    }
    
    /** 
     * Costruttore con parametri
     * @param codice
     * @param nome
     * @param cfu
     * @param description
       */
    public Insegnamento(int codice, int cfu, String nome, String description) {
        this.codice = codice;
        this.nome = nome;
        this.description = description;
        this.cfu = cfu;
    }

  
 public Insegnamento(int codice,int cfu, String nome, String description,int a) {
        this.codice = codice;
        this.nome = nome;
        this.description = description;
        this.cfu = cfu;
        this.corsoDiStudio=a;
    }
 
 
    public Insegnamento(int codice, String nome, String description, int cfu, List<Prenotazione> prenotazioni) {
        this.codice = codice;
        this.nome = nome;
        this.description = description;
        this.cfu = cfu;
        this.prenotazioni = prenotazioni;
      
    }
    

    /**
	 * @return codice
	 */
    public int getCodice() {
        return this.codice;
    }

    /**
	 * @param codice
	 */
    public void setCodice(int codice) {
        this.codice = codice;
    }
    
    /**
	 * @return nome
	 */
    public String getNome() {
        return this.nome;
    }
    
    /**
	 * @param nome
	 */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
	 * @return description
	 */
    public String getDescription() {
        return this.description;
    }
    
    /**
	 * @param description
	 */

    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
	 * @return cfu
	 */
    public int getCfu() {
        return this.cfu;
    }

    /**
	 * @param cfu
	 */
    public void setCfu(int cfu) {
        this.cfu = cfu;
    }
    
    /**
	 * @return sistema
	 */
    public Sistema getSistema() {
        return sistema;
    }

    /**
	 * @param sistema
	 */
    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }
    
    /**
	 * @return prenotazioni
	 */
    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    /**
	 * @param prenotazioni
	 */
    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }
    
    /**
	 * @return listAppello
	 */
    public List<Appello> getListAppello() {
        return listAppello;
    }

    /**
	 * @param listAppello
	 */
    public void setListAppello(List<Appello> listAppello) {
        this.listAppello = listAppello;
    }
    
    /**
	 * @return pianoDiStudio
	 */
    public PianoDiStudio getPianoDiStudio() {
        return pianoDiStudio;
    }
    
    /**
	 * @param pianoDiStudio
	 */
    public void setPianoDiStudio(PianoDiStudio pianoDiStudio) {
        this.pianoDiStudio = pianoDiStudio;
    }
    
    /**
	 * @return annoDiStudi
	 */
    public AnnoDiStudi getAnnoDiStudi() {
        return annoDiStudi;
    }

    /**
	 * @param annoDiStudi
	 */ 
    public void setAnnoDiStudi(AnnoDiStudi annoDiStudi) {
        this.annoDiStudi = annoDiStudi;
    }
    
    /**
	 * @return corsoDiStudi
	 */
    public int getCorsoDiStudio() {
        return corsoDiStudio;
    }
    
    /**
	 * @param corsoDiStudio
	 */
    public void setCorsoDiStudio(int corsoDiStudio) {
        this.corsoDiStudio = corsoDiStudio;
    }

    boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void add(Insegnamento mat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
