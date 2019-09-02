package entità;

import java.util.List;


public class Sistema {

    private int id;
    private List<Utente> listUtente;
    private List<Insegnamento> listInsegnamento;
    private List<PianoDiStudio> listPianoDiStudio;

    
      private List<Prenotazione> listPrenotazione;
    
    public Sistema() {
        super();
    }
    public Sistema(int id, List<Utente> listUtente, List<Insegnamento> listInsegnamento, List<PianoDiStudio> listPianoDiStudio) {
        this.id = id;
        this.listUtente = listUtente;
        this.listInsegnamento = listInsegnamento;
        this.listPianoDiStudio = listPianoDiStudio;
    }
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Utente> getListUtente() {
        return listUtente;
    }

    public void setListUtente(List<Utente> listUtente) {
        this.listUtente = listUtente;
    }

    public List<Insegnamento> getListInsegnamento() {
        return listInsegnamento;
    }

    public void setListInsegnamento(List<Insegnamento> listInsegnamento) {
        this.listInsegnamento = listInsegnamento;
    }

    public List<PianoDiStudio> getListPianoDiStudio() {
        return listPianoDiStudio;
    }

    public void setListPianoDiStudio(List<PianoDiStudio> listPianoDiStudio) {
        this.listPianoDiStudio = listPianoDiStudio;
    }

    public List<Prenotazione> getListPrenotazione() {
        return listPrenotazione;
    }

    public void setListPrenotazione(List<Prenotazione> listPrenotazione) {
        this.listPrenotazione = listPrenotazione;
    }

   
}
