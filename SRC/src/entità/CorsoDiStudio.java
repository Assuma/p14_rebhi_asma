package entità;

import java.util.Date;
import java.util.List;

public class CorsoDiStudio {

  
   
    private int codice;
    private String nome;
    private Date annoScolastico;
    private List<Studente> listStudente;
    private List<Insegnamento> insegnamentos;
    
    public CorsoDiStudio(int codice, String nome) {
        this.codice = codice;
        this.nome = nome;
 
    }


    
    
    public CorsoDiStudio() {
        super();
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

    public Date getAnnoScolastico() {
        return this.annoScolastico;
    }

    public void setAnnoScolastico(Date annoScolastico) {
        this.annoScolastico = annoScolastico;
    }

    public List<Studente> getListStudente() {
        return listStudente;
    }

    public void setListStudente(List<Studente> listStudente) {
        this.listStudente = listStudente;
    }

    public List<Insegnamento> getInsegnamentos() {
        return insegnamentos;
    }

    public void setInsegnamentos(List<Insegnamento> insegnamentos) {
        this.insegnamentos = insegnamentos;
    }
    
      static void add(CorsoDiStudio CS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
