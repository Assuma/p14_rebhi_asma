package entità;

import java.util.Date;
import java.util.List;

import enumerations.TipoPianoStudi;
import java.util.ArrayList;
 

public class PianoDiStudio {

    private int id;
    private TipoPianoStudi tipo;
    private Date annoScolastico;
    private Sistema sistema;
    private List<Studente> listStudente;
    private Insegnamento insegnamentos;

   
    public PianoDiStudio() {
        super();
    }

    PianoDiStudio(ArrayList<Insegnamento> insegnamentos, Studente studente) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PianoDiStudio(int id, TipoPianoStudi tipo, List<Studente> listStudente, Insegnamento insegnamentos) {
        this.id = id;
        this.tipo = tipo;        
        this.listStudente = listStudente;
        this.insegnamentos = insegnamentos;
    }

    PianoDiStudio(Studente studente, ArrayList<Insegnamento> Materia1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoPianoStudi getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoPianoStudi tipo) {
        this.tipo = tipo;
    }

    public Date getAnnoScolastico() {
        return this.annoScolastico;
    }

    public void setAnnoScolastico(Date annoScolastico) {
        this.annoScolastico = annoScolastico;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public List<Studente> getListStudente() {
        return listStudente;
    }

    public void setListStudente(List<Studente> listStudente) {
        this.listStudente = listStudente;
    }
    
     public Insegnamento getInsegnamentos() {
        return insegnamentos;
    }

    public void setInsegnamentos(Insegnamento insegnamentos) {
        this.insegnamentos = insegnamentos;
    }

    void setInsegnamentos(ArrayList<Insegnamento> Materia1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
