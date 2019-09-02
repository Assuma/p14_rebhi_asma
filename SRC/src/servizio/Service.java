package servizio;

import connessione_al_database.MyDB;
import entità.Appello;
import entità.CorsoDiStudio;
import entità.Docente;
import entità.Insegnamento;
import entità.Prenotazione;
import entità.Studente;
import enumerations.AnnoDiStudi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.LoginMemberController;

public class Service implements iservizio.IService {

    MyDB myDB;

    public Service() {
        myDB = MyDB.getInstance();
    }

    @Override
    public List<Studente> listAllStudents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Studente getStudentById(int id) throws SQLException {
        Studente bp = new Studente();

        Statement stm = myDB.getConnexion().createStatement();
        ResultSet rest = stm.executeQuery("select * from utente where matricola =" + id + "");

        while (rest.next()) {
            bp.setMatricola(rest.getInt(2));
            System.out.println(rest.getInt(1));
            bp.setCellulare(rest.getString(3));
            System.out.println(rest.getInt(2));
            bp.setCognome(rest.getString(4));
            System.out.println(rest.getString(3));
            bp.setEmail(rest.getString(5));
            System.out.println(rest.getString(4));
            bp.setIndirizzo(rest.getString(6));
            System.out.println(rest.getString(5));
            bp.setNome(rest.getString(7));
            System.out.println(rest.getString(6));
            bp.setPassword(rest.getString(8));
            System.out.println(rest.getString(7));
            bp.setAnnoSt(AnnoDiStudi.valueOf(rest.getString(9)));
            // bp.set(rest.getInt(9));
            // bp.setCorsoDiStudio(rest.getInt(10));   
            // bp.setDateFabrication(rest.getInt(11));

        }
        return bp;

    }

    @Override
    public void ModificareStudent(int id, Studente prod) {

        try {

            PreparedStatement prep;
            myDB = MyDB.getInstance();
            String req;
            req = "UPDATE `utente` SET  `cellulare` = ? , `cognome` = ?, `email` = ?, `indirizzo` =?, `nome` = ?, `password` = ? WHERE matricola = " + id + "";

            prep = myDB.getConnexion().prepareStatement(req);

            // prep.setInt(1, prod.getId());
            prep.setString(1, prod.getCellulare());
            prep.setString(2, prod.getCognome());
            prep.setString(3, prod.getEmail());
            prep.setString(4, prod.getIndirizzo());
            prep.setString(5, prod.getNome());
            prep.setString(6, prod.getPassword());

            prep.executeUpdate();
            System.out.println("Modificazione fatta!");
        } catch (SQLException ex) {
            System.out.println("C'è stato un problema durante la modificazione!");
        }

    }

    @Override
    public void getMateria(Insegnamento mat) {

        try {
            Statement stm = myDB.getConnexion().createStatement();
            String query = "INSERT INTO `insegnamento_utente` (`listInsegnamento_codice`, `listUtente_matricola`) VALUES (" + mat.getCodice() + ", " + LoginMemberController.getIdCnx() + ");";
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Insegnamento getMateriaById(int id) throws SQLException {

        Insegnamento bp = new Insegnamento();
        Statement stm = myDB.getConnexion().createStatement();
        ResultSet rest = stm.executeQuery("select * from insegnamento where codice =" + id + "");

        while (rest.next()) {
            bp.setCodice(rest.getInt(1));
            bp.setAnnoDiStudi(AnnoDiStudi.valueOf(rest.getString(2)));
            bp.setCfu(rest.getInt(3));
            bp.setDescription(rest.getString(4));
            bp.setNome(rest.getString(5));

        }
        return bp;

    }

    @Override
    public void PrenotareEsame(int idAppello) {

        try {
            Statement stm = myDB.getConnexion().createStatement();
            String query = "INSERT INTO `prenotazione` (`idAppello`, `idStudente`, `voto`,`stato`) VALUES (" + idAppello + ", " + LoginMemberController.getIdCnx() + ",-1,'In Corso');";
            stm.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void AggiungereAppello(Appello app) {

        try {

            Statement stm = myDB.getConnexion().createStatement();
            String query = "INSERT INTO `appello` (`aula`, `date`, `description`, `durata`, `docente_matricola`, `insegnamento_codice`) VALUES ('" + app.getAula() + "', '" + app.getDate() + "', '" + app.getDescription() + "', " + app.getDurata() + ", " + app.getDocente() + ", " + app.getInsegnamento() + ");";
            stm.executeUpdate(query);
            System.out.println("Esame inserito!");
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public int getIDMateriaByNome(String nom) {

        int a = 0;

        try {
            Statement stm = myDB.getConnexion().createStatement();
            ResultSet rest = stm.executeQuery("select codice from insegnamento where nome ='" + nom + "'");

            while (rest.next()) {
                a = rest.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        return a;
    }

    @Override
    public CorsoDiStudio getSpecialitaById(int id) {

        CorsoDiStudio bp = new CorsoDiStudio();

        Statement stm;
        try {
            stm = myDB.getConnexion().createStatement();
            ResultSet rest = stm.executeQuery("select * from corsodistudio where codice =" + id + "");

            while (rest.next()) {
                bp.setCodice(rest.getInt(1));
                bp.setAnnoScolastico(rest.getDate(2));
                bp.setNome(rest.getString(3));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bp;

    }

    @Override
    public Insegnamento getMateriaByIdAppello(int id) {

        int idMat = 0;
        Insegnamento bp = new Insegnamento();

        ResultSet rest;
        try {
            Statement stm = myDB.getConnexion().createStatement();
            rest = stm.executeQuery("select * from appello where id =" + id + "");
            while (rest.next()) {

                idMat = rest.getInt(7);
            }
            bp = getMateriaById(idMat);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bp;

    }

    @Override
    public void ModificareVoto(int id, double note) {

        try {

            PreparedStatement prep;
            myDB = MyDB.getInstance();
            String req;
            req = "UPDATE `prenotazione` SET  `voto` = ? WHERE id = " + id + "";
            prep = myDB.getConnexion().prepareStatement(req);
            prep.setDouble(1, note);
            prep.executeUpdate();
            System.out.println("Modificazion fatta!");
        } catch (SQLException ex) {
            System.out.println("C'è stato un problema durante la modificazione!");
        }

    }

    @Override
    public Docente getProfByIdAppello(int id) {

        int idMat = 0;
        Docente bp = new Docente();

        ResultSet rest;
        try {
            Statement stm = myDB.getConnexion().createStatement();
            rest = stm.executeQuery("select * from appello where id =" + id + "");
            while (rest.next()) {

                idMat = rest.getInt(6);
            }
            bp = getProfById(idMat);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bp;

    }

    @Override
    public Docente getProfById(int id) throws SQLException {

        Docente bp = new Docente();

        Statement stm;
        try {
            stm = myDB.getConnexion().createStatement();
            ResultSet rest = stm.executeQuery("select * from utente where matricola =" + id + "");

            while (rest.next()) {
                bp.setMatricola(rest.getInt(2));
                System.out.println(rest.getInt(1));
                bp.setCellulare(rest.getString(3));
                System.out.println(rest.getInt(2));
                bp.setCognome(rest.getString(4));
                System.out.println(rest.getString(3));
                bp.setEmail(rest.getString(5));
                System.out.println(rest.getString(4));
                bp.setIndirizzo(rest.getString(6));
                System.out.println(rest.getString(5));
                bp.setNome(rest.getString(7));
                System.out.println(rest.getString(6));
                bp.setPassword(rest.getString(8));
                System.out.println(rest.getString(7));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bp;

    }

    @Override
    public Appello getAppelloById(int id) {

        Appello bp = new Appello();

        ResultSet rest;
        try {
            Statement stm = myDB.getConnexion().createStatement();
            rest = stm.executeQuery("select * from appello where id =" + id + "");
            while (rest.next()) {

                bp.setId(rest.getInt(1));
                bp.setAula(rest.getString(2));
                bp.setDate(rest.getDate(3));
                bp.setDescription(rest.getString(4));
                bp.setDurata(rest.getDouble(5));
                bp.setDocente(rest.getInt(6));
                bp.setInsegnamento(rest.getInt(7));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bp;

    }

    @Override
    public Prenotazione getStatoByIDMateria(int id) {

        Prenotazione bp = new Prenotazione();

        ResultSet rest;
        try {
            Statement stm = myDB.getConnexion().createStatement();
            rest = stm.executeQuery("select * from prenotazione where idAppello=(select id from appello where insegnamento_codice=" + id + ")");
            while (rest.next()) {

                bp.setPrenotazionePK(rest.getInt(1));
                bp.setAppello(rest.getInt(2));
                bp.setStudente(rest.getInt(3));
                bp.setVoto(rest.getString(4));
                bp.setStato(rest.getString(5));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bp;

    }

    @Override
    public void ModificareStato(int id) {
        try {

            PreparedStatement prep;
            myDB = MyDB.getInstance();
            String req;
            req = "UPDATE `prenotazione` SET  `stato` = ? WHERE id = " + id + "";

            prep = myDB.getConnexion().prepareStatement(req);
            prep.setString(1, "Rifiutato");
            prep.executeUpdate();
            System.out.println("Modificazione fatta!");
        } catch (SQLException ex) {
            System.out.println("C'è stato un problema durante la modificazione!");
        }
    }

    @Override
    public void ModificareStatoAccettato(int id) {

        try {

            PreparedStatement prep;
            myDB = MyDB.getInstance();
            String req;
            req = "UPDATE `prenotazione` SET  `stato` = ? WHERE id = " + id + "";

            prep = myDB.getConnexion().prepareStatement(req);
            prep.setString(1, "Accettato");
            prep.executeUpdate();
            System.out.println("Modificazione fatta!");
        } catch (SQLException ex) {
            System.out.println("C'è stato un problema durante la modificazione!");
        }
    }

    @Override
    public List<Prenotazione> getAllPrenotazione() {

        List<Prenotazione> list = new ArrayList<>();
        ResultSet rest;
        try {
            Statement stm = myDB.getConnexion().createStatement();
            rest = stm.executeQuery("select * from prenotazione where voto != -1 and stato != 'Rifiutato' and idStudente=" + LoginMemberController.getIdCnx() + "");
            while (rest.next()) {

                Prenotazione bp = new Prenotazione();

                bp.setPrenotazionePK(rest.getInt(1));
                bp.setAppello(rest.getInt(2));
                bp.setStudente(rest.getInt(3));
                bp.setVoto(rest.getString(4));
                bp.setStato(rest.getString(5));
                list.add(bp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    @Override
    public List<Insegnamento> getAllMaterieByNome(String a) {

        List<Insegnamento> list = new ArrayList<>();
        try {
            ResultSet rest = null;
            Statement stm = myDB.getConnexion().createStatement();
            if (a.length() != 0) {
                rest = stm.executeQuery("select * from insegnamento where nome LIKE '%" + a + "%'");

            }
            if (a.length() == 0) {
                rest = stm.executeQuery("select * from insegnamento");

            }

            while (rest.next()) {
                Insegnamento bp = new Insegnamento();

                bp.setCodice(rest.getInt(1));
                bp.setAnnoDiStudi(AnnoDiStudi.valueOf(rest.getString(2)));
                bp.setCfu(rest.getInt(3));
                bp.setDescription(rest.getString(4));
                bp.setNome(rest.getString(5));
                bp.setCorsoDiStudio(rest.getInt(6));
                list.add(bp);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
