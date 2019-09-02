package iservizio;

import entità.Appello;
import entità.CorsoDiStudio;
import entità.Docente;
import entità.Insegnamento;
import entità.Prenotazione;
import entità.Studente;
import java.sql.SQLException;
import java.util.List;


public interface IService {
    
    List<Studente> listAllStudents();
    Studente getStudentById( int id) throws SQLException;
    void ModificareStudent (int id , Studente etudiant);
    void getMateria(Insegnamento mat);
    Insegnamento getMateriaById( int id) throws SQLException;

    void AggiungereAppello(Appello app);
    void PrenotareEsame(int idAppello);
    int getIDMateriaByNome(String nom);
    CorsoDiStudio getSpecialitaById(int id);
    Insegnamento getMateriaByIdAppello(int id);
    void ModificareVoto(int id , double note);
    Docente getProfByIdAppello(int id);
    Docente getProfById(int id)throws SQLException;
    Appello getAppelloById(int id);
    Prenotazione getStatoByIDMateria(int id);
    void ModificareStato(int id);
    void ModificareStatoAccettato(int id);
    List<Prenotazione> getAllPrenotazione();
    List<Insegnamento> getAllMaterieByNome(String a);
}
