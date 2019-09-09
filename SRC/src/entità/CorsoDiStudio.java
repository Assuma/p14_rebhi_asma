package entità;

import java.util.Date;
import java.util.List;

/** 
 * @author assma
 */


/**
 * Classe:CorsoDiStudio
 * contiene il codice, il nome e l'anno scolastico del corso di studio
 */
public class CorsoDiStudio {

   /** Attributes */
    private int codice;
    private String nome;
    private Date annoScolastico;
   /** Associations */
    private List<Studente> listStudente;
    private List<Insegnamento> insegnamentos;
    
    
    
    /** 
     * Costruttore con parametri
     * @param codice
     * @param nome
     */
    public CorsoDiStudio(int codice, String nome) {
        this.codice = codice;
        this.nome = nome;
 
    }
    /** 
     * Costruttore senza parametri
     */
    public CorsoDiStudio() {
        super();
    }

    /**
	 * @return codice
	 */
    public int getCodice() {
        return this.codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }
 
    /**
	 * @return nome
	 */
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
	 * @return annoScolastico
	 */
    public Date getAnnoScolastico() {
        return this.annoScolastico;
    }

    public void setAnnoScolastico(Date annoScolastico) {
        this.annoScolastico = annoScolastico;
    }
    
    /**
	 * @return listStudent
	 */
    public List<Studente> getListStudente() {
        return listStudente;
    }

    public void setListStudente(List<Studente> listStudente) {
        this.listStudente = listStudente;
    }
    /**
	 * @return insegnamentos
	 */
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
