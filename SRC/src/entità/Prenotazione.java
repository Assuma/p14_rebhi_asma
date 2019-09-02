package entità;


public class Prenotazione {

   

    private int prenotazionePK;
    private String voto;
    private int studente;
    private int appello;
    private String stato ;

   
    
    
    public Prenotazione() {
        super();
    }

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
     public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
    
    
    public String getVoto() {
        return this.voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public int getPrenotazionePK() {
        return prenotazionePK;
    }

    public void setPrenotazionePK(int prenotazionePK) {
        this.prenotazionePK = prenotazionePK;
    }

    public int getStudente() {
        return studente;
    }

    public void setStudente(int studente) {
        this.studente = studente;
    }

    public int getAppello() {
        return appello;
    }

    public void setAppello(int appello) {
        this.appello = appello;
    }

//    void add(Prenotazione Prenotazioni) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

   
}
