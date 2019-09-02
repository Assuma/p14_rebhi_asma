package entità;

import enumerations.AnnoDiStudi;
import java.util.ArrayList;
import java.util.List;


public class Insegnamento {

    private int codice;
    private String nome;
    private String description;
    private int cfu;
    private Sistema sistema;
    private AnnoDiStudi annoDiStudi ;
    private List<Prenotazione> prenotazioni;
    private List<Appello> listAppello;
    private PianoDiStudio pianoDiStudio;
    private int corsoDiStudio ;

    public Insegnamento() {
        super();
    }

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

  
    public int getCodice() {
        return this.codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCfu() {
        return this.cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    public List<Appello> getListAppello() {
        return listAppello;
    }

    public void setListAppello(List<Appello> listAppello) {
        this.listAppello = listAppello;
    }

    public PianoDiStudio getPianoDiStudio() {
        return pianoDiStudio;
    }

    public void setPianoDiStudio(PianoDiStudio pianoDiStudio) {
        this.pianoDiStudio = pianoDiStudio;
    }

    public AnnoDiStudi getAnnoDiStudi() {
        return annoDiStudi;
    }

    public void setAnnoDiStudi(AnnoDiStudi annoDiStudi) {
        this.annoDiStudi = annoDiStudi;
    }

    public int getCorsoDiStudio() {
        return corsoDiStudio;
    }

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
