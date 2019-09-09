package entità;

/**
 * 
 * @author assma
 */

/**
 * Classe:Prenotazione
 */
public class Prenotazione {
    
    /** Attributi */
    private int prenotazionePK;
    private String voto;
    private int studente;
    private int appello;
    private String stato ;

   
    /** Costruttore senza parametri*/
    public Prenotazione() {
        super();
    }
    
   /** 
     * Costruttore con parametri
     * @param prenotazionePK
     * @param appello
     * @param studente
     * @param voto
     * @param stato
     */
    public Prenotazione(int prenotazionePK, int appello, int studente, String voto,String stato) {
        this.prenotazionePK = prenotazionePK;
        this.appello = appello;
        this.studente = studente;
        this.voto = voto;
        this.stato = stato;
    }

    
    public Prenotazione(int prenotazionePK, int appello, int studente, String voto) {
        this.prenotazionePK = prenotazionePK;
        this.appello = appello;
        this.studente = studente;
        this.voto = voto;
    
    }
    
    /**
     * @return stato
     */
     public String getStato() {
        return stato;
    }

     
    /**
     * @param stato
     */ 
    public void setStato(String stato) {
        this.stato = stato;
    }
    
    /**
     * @return voto
     */
    public String getVoto() {
        return this.voto;
    }

    
    /**
     * @param voto
     */
    public void setVoto(String voto) {
        this.voto = voto;
    }

    /**
     * @return prenotazionePK
     */
    public int getPrenotazionePK() {
        return prenotazionePK;
    }

    /**
     * @param prenotazionePK
     */
    public void setPrenotazionePK(int prenotazionePK) {
        this.prenotazionePK = prenotazionePK;
    }

    
    /**
     * @return studente
     */
    public int getStudente() {
        return studente;
    }

    /**
     * @param studente
     */
    public void setStudente(int studente) {
        this.studente = studente;
    }

    
    /**
     * @return appello
     */
    public int getAppello() {
        return appello;
    }

    
    /**
     * @param appello
     */
    public void setAppello(int appello) {
        this.appello = appello;
    }


   
}
