package entità;

import java.util.List;

import enumerations.AnnoDiStudi;


public class Studente extends Utente {

    private AnnoDiStudi annoSt;
    private PianoDiStudio pianoDiStudio;
    private CorsoDiStudio corsoDiStudio;
    private List<Prenotazione> listPrenotazione;

    public Studente() {
        super();
    }

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

    public boolean accettaVoto(int votoEsame) {
        return false;
    }

    public boolean rifiutaVoto(int votoEsame) {
        return false;
    }

    public boolean prenotaEsame(Appello a) {
        return false;
    }

    public AnnoDiStudi getAnnoSt() {
        return this.annoSt;
    }

    public void setAnnoSt(AnnoDiStudi annoSt) {
        this.annoSt = annoSt;
    }

    public PianoDiStudio getPianoDiStudio() {
        return pianoDiStudio;
    }

    public void setPianoDiStudio(PianoDiStudio pianoDiStudio) {
        this.pianoDiStudio = pianoDiStudio;
    }

    public CorsoDiStudio getCorsoDiStudio() {
        return corsoDiStudio;
    }

    public void setCorsoDiStudio(CorsoDiStudio corsoDiStudio) {
        this.corsoDiStudio = corsoDiStudio;
    }

    public List<Prenotazione> getListPrenotazione() {
        return listPrenotazione;
    }

    public void setListPrenotazione(List<Prenotazione> listPrenotazione) {
        this.listPrenotazione = listPrenotazione;
    }

    public boolean accettareVoto() {
        return true;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
