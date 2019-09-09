package entità;

import java.util.List;

/**
 * 
 * @author assma
 */

/**
 * Classe:Utente 
 */

public class Utente {
    /** Attributes */ 
     int matricola;
     String nome;
     String cognome;
     String email;
     String password;
     String indirizzo;
     String cellulare;
     
     /** Associations */
     Sistema sistema;
     List<Insegnamento> listInsegnamento;

     
    /** Costruttore senza parametri*/
    public Utente() {
        super();
    }
    
    /** 
     * Costruttore con parametri
     * @param matricola
     * @param nome
     * @param cognome
     * @param email
     * @param password
     * @param indirizzo
     * @param cellulare
     */
    public Utente(int matricola, String nome, String cognome,String email, String password, String indirizzo,String cellulare ) {
		super();
		this.matricola=matricola;
		this.nome=nome;
		this.cognome=cognome;
		this.email=email;
		this.password=password;
                this.indirizzo=indirizzo;
                this.cellulare=cellulare;
		
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
     * @return matricola
     */
    public int getMatricola() {
        return matricola;
    }

    
    /**
     * @param matricola
     */
    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    
    /**
     * @return nome
     */
    public String getNome() {
        return nome;
    }
    
    
    /**
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    /**
     * @return cognome
     */
    public String getCognome() {
        return cognome;
    }

    
    /**
     * @param cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    
    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    
    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    
    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /**
     * @return indirizzo
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    
    /**
     * @param indirizzo
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * @return cellulare
     */
    public String getCellulare() {
        return cellulare;
    }
    
    /**
     * @param cellulare
     */
    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }
    
    
    public String modifyAnagrafica(String nome, String cognome, String email, String password, String indirizzo,
            int cellulare) {
        return null;
    }

}
