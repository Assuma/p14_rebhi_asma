package entità;

import java.util.List;

import enumerations.AnnoDiStudi;

/**
 * 
 * @author assma
 */

/**
 * Classe:Studente 
 */
public class Studente extends Utente {
     
    /** Associations */
    private AnnoDiStudi annoSt;
    private PianoDiStudio pianoDiStudio;
    private CorsoDiStudio corsoDiStudio;
    private List<Prenotazione> listPrenotazione;

    
    /** Costruttore senza parametri*/
    public Studente() {
        super();
    }
    
    
   /** 
     * Costruttore con parametri
     * @param matricola
     * @param nome
     * @param cognome
     * @param email
     * @param password
     * @param indirizzo
     * @param cellulare
     */
    public Studente(int matricola, String nome, String cognome, String email, String password, String indirizzo, String cellulare) {
        super(matricola, nome, cognome, email, password, indirizzo, cellulare);
        this.matricola = matricola;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.indirizzo = indirizzo;
        this.cellulare = cellulare;
    }

   /**
     * @return annoSt
     */
    public AnnoDiStudi getAnnoSt() {
        return this.annoSt;
    }

    
    /**
     * @param annoSt
     */
    public void setAnnoSt(AnnoDiStudi annoSt) {
        this.annoSt = annoSt;
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
     * @return corsoDiStudio
     */
    public CorsoDiStudio getCorsoDiStudio() {
        return corsoDiStudio;
    }

    
    /**
     * @param corsoDiStudio
     */
    public void setCorsoDiStudio(CorsoDiStudio corsoDiStudio) {
        this.corsoDiStudio = corsoDiStudio;
    }
    
   /**
     * @return listPrenotazione
     */
    public List<Prenotazione> getListPrenotazione() {
        return listPrenotazione;
    }
    
    /**
     * @param listPrenotazione
     */
    public void setListPrenotazione(List<Prenotazione> listPrenotazione) {
        this.listPrenotazione = listPrenotazione;
    }

    
    public boolean accettareVoto() {
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
