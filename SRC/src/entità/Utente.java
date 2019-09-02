package entità;

import java.util.List;


public class Utente {
     int matricola;
     String nome;
     String cognome;
     String email;
     String password;
     String indirizzo;
     String cellulare;
     Sistema sistema;
     List<Insegnamento> listInsegnamento;


    public Utente() {
        super();
    }
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

    public String modifyAnagrafica(String nome, String cognome, String email, String password, String indirizzo,
            int cellulare) {
        return null;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public List<Insegnamento> getListInsegnamento() {
        return listInsegnamento;
    }

    public void setListInsegnamento(List<Insegnamento> listInsegnamento) {
        this.listInsegnamento = listInsegnamento;
    }

    
    public int getMatricola() {
        return matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

}
