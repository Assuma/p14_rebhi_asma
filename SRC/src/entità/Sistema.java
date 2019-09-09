package entità;

import java.util.List;

/**
 * 
 * @author assma
 */

/**
 * Classe:sistema 
 */

public class Sistema {
    
    /** Attributes */
    private int id;
    
    /** Associations */
    private List<Utente> listUtente;
    private List<Insegnamento> listInsegnamento;
    private List<PianoDiStudio> listPianoDiStudio;
    private List<Prenotazione> listPrenotazione;
    
    
    
   /** 
     * Costruttore con parametri
     * @param id
     * @param listUtente
     * @param listInsegnamento
     * @param listPianoDiStudio
     */
    public Sistema(int id, List<Utente> listUtente, List<Insegnamento> listInsegnamento, List<PianoDiStudio> listPianoDiStudio) {
        this.id = id;
        this.listUtente = listUtente;
        this.listInsegnamento = listInsegnamento;
        this.listPianoDiStudio = listPianoDiStudio;
    }
  
    
    /** Costruttore senza parametri*/
     public Sistema() {
        super();
    }

   /**
     * @return id
     */
    public int getId() {
        return id;
    }

    
    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

   /**
     * @return listUtente
     */
    public List<Utente> getListUtente() {
        return listUtente;
    }

    
   /**
     * @param listUtente
     */
    public void setListUtente(List<Utente> listUtente) {
        this.listUtente = listUtente;
    }

    
   /**
     * @return listInsegnamento
     */
    public List<Insegnamento> getListInsegnamento() {
        return listInsegnamento;
    }

    
   /**
     * @param listInsegnamento
     */
    public void setListInsegnamento(List<Insegnamento> listInsegnamento) {
        this.listInsegnamento = listInsegnamento;
    }

    
   /**
     * @return listPianoDiStudio
     */
    public List<PianoDiStudio> getListPianoDiStudio() {
        return listPianoDiStudio;
    }

    
   /**
     * @param listPianoDiStudio
     */
    public void setListPianoDiStudio(List<PianoDiStudio> listPianoDiStudio) {
        this.listPianoDiStudio = listPianoDiStudio;
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

   
}
