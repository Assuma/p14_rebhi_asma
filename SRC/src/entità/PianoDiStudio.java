package entità;

import java.util.Date;
import java.util.List;

import enumerations.TipoPianoStudi;
import java.util.ArrayList;
 
/**
 * 
 * @author assma
 */

/**
 * Classe:PianoDiStudio
 * contiene il id e il tipo(parziale/tempo pieno)del piano di studio dello studente
 */
public class PianoDiStudio {
    
    /** Attributes */
    private int id;
    private TipoPianoStudi tipo;
    private Date annoScolastico;
    /** Associations */
    private Sistema sistema;
    private List<Studente> listStudente;
    private Insegnamento insegnamentos;

    
     /** 
     * Costruttore con parametri
     * @param id
     * @param tipo
     * @param listStudente
     * @param insegnamentos
     */
    public PianoDiStudio(int id, TipoPianoStudi tipo, List<Studente> listStudente, Insegnamento insegnamentos) {
        this.id = id;
        this.tipo = tipo;        
        this.listStudente = listStudente;
        this.insegnamentos = insegnamentos;
    }
   
    
     /** Costruttore senza parametri*/
    public PianoDiStudio() {
        super();
    }
    
    
    /**
     * @return id
     */
    public int getId() {
        return this.id;
    }

     /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return tipo
     */
    public TipoPianoStudi getTipo() {
        return this.tipo;
    }

     /**
     * @param tipo
     */
    public void setTipo(TipoPianoStudi tipo) {
        this.tipo = tipo;
    }

    
   /**
     * @return annoScolastico
     */
    public Date getAnnoScolastico() {
        return this.annoScolastico;
    }

    
    /**
     * @param annoScolastico
     */
    public void setAnnoScolastico(Date annoScolastico) {
        this.annoScolastico = annoScolastico;
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
     * @return listStudente
     */
    public List<Studente> getListStudente() {
        return listStudente;
    }
    

    /**
	 * @param listStudente
	 */
    public void setListStudente(List<Studente> listStudente) {
        this.listStudente = listStudente;
    }
    
    
    /**
     * @return insegnamentos
     */
    public Insegnamento getInsegnamentos() {
        return insegnamentos;
    }

    /**
	 * @param insegnamentos
	 */
    public void setInsegnamentos(Insegnamento insegnamentos) {
        this.insegnamentos = insegnamentos;
    }

    void setInsegnamentos(ArrayList<Insegnamento> Materia1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    PianoDiStudio(ArrayList<Insegnamento> insegnamentos, Studente studente) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    PianoDiStudio(Studente studente, ArrayList<Insegnamento> Materia1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      
   /**
     * @param mat
     * operazione permette di aggiungere un'insegnamento 
	 */
    public void aggiungiInsegnamento (Insegnamento mat ) {
    	if (insegnamentos.isEmpty()) {
    		ArrayList<Insegnamento> materia = new ArrayList<Insegnamento>();
    		materia.add(mat);
    		setInsegnamentos(materia);
    	} else {
    		insegnamentos.add(mat);
    		
    	}
        
}


}
