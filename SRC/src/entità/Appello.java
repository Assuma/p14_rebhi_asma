package entità;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Appello {

    private int id;
    private Date date;
    private String description;
    private double durata;
    private String aula;
    private int docente;
    private int insegnamento;
    private List<Prenotazione> listPrenotazione;
    private double voto;
    private Studente studente;

    public Appello() {
        super();
    }

 
    public Appello(int id, String description, Date date, String aula, double durata, int docente, int insegnamento) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.durata = durata;
        this.aula = aula;
        this.docente = docente;
        this.insegnamento = insegnamento;
       
    }

    
      public Appello(int id, String description,String aula, double durata, int docente, int insegnamento,int voto) {
        this.id = id;
        this.description = description;
        this.durata = durata;
        this.aula = aula;
        this.docente = docente;
        this.insegnamento = insegnamento;
        this.voto = voto;
       
    }
    
 
 

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDurata() {
        return this.durata;
    }

    public void setDurata(double durata) {
        this.durata = durata;
    }

    public String getAula() {
        return this.aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
    
        public int getVoto() {
        return (int) this.voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }


    public int getDocente() {
        return docente;
    }

    public void setDocente(int docente) {
        this.docente = docente;
    }
    
    public void setStudente(Studente studente) {
		this.studente=studente;
	}
	
	/**Operazione getStudente
	 * 	
	 * @return
	 */
	public Studente getStudente() {
		return studente;
}

    public int getInsegnamento() {
        return insegnamento;
    }

    public void setInsegnamento(int insegnamento) {
        this.insegnamento = insegnamento;
    }

  
    public List<Prenotazione> getListPrenotazione() {
        return listPrenotazione;
    }

    public void setListPrenotazione(List<Prenotazione> listPrenotazione) {
        this.listPrenotazione = listPrenotazione;
    }

    public boolean isAccettareVoto(int voto) {
        
		if (voto>=18 &&  studente.accettareVoto()==true) {
			return true;
		} else {
			return false;
		}
	}
	

//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 97 * hash + this.id;
//        hash = 97 * hash + Objects.hashCode(this.date);
//        hash = 97 * hash + Objects.hashCode(this.description);
//        hash = 97 * hash + (int) (Double.doubleToLongBits(this.durata) ^ (Double.doubleToLongBits(this.durata) >>> 32));
//        hash = 97 * hash + Objects.hashCode(this.aula);
//        hash = 97 * hash + Objects.hashCode(this.docente);
//        hash = 97 * hash + Objects.hashCode(this.insegnamento);
//        hash = 97 * hash + Objects.hashCode(this.listPrenotazione);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Appello other = (Appello) obj;
//        if (this.id != other.id) {
//            return false;
//        }
//        if (Double.doubleToLongBits(this.durata) != Double.doubleToLongBits(other.durata)) {
//            return false;
//        }
//        if (!Objects.equals(this.description, other.description)) {
//            return false;
//        }
//        if (!Objects.equals(this.aula, other.aula)) {
//            return false;
//        }
//        if (!Objects.equals(this.date, other.date)) {
//            return false;
//        }
//        if (!Objects.equals(this.docente, other.docente)) {
//            return false;
//        }
//        if (!Objects.equals(this.insegnamento, other.insegnamento)) {
//            return false;
//        }
//        if (!Objects.equals(this.listPrenotazione, other.listPrenotazione)) {
//            return false;
//        }
//        return true;
//    }

    
    
}
