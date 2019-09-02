/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entità;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author assma
 */
public class SistemaIT {
    
   
	private  Studente stud1 = new Studente();
	private  Studente stud2 = new Studente();
	private  ArrayList<Insegnamento> Materia1 = new ArrayList<>();
	private  ArrayList<Insegnamento> Materia2 = new ArrayList<>();
	ArrayList<Prenotazione> prenotazioni = new ArrayList<>();
	ArrayList<PianoDiStudio> pianoSt = new ArrayList<PianoDiStudio>();
	ArrayList<Utente> user = new ArrayList<Utente>();
        private static Sistema sistema = null;
    
    @BeforeClass
    public static void setUpClass() {
        sistema = new Sistema();
        System.out.println("Create Sistema");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         stud1 = new Studente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
	 stud2 = new Studente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
	 Insegnamento Materia = new Insegnamento(508, 9, "Fisica", "xxxxx");
		
    }
    @After
    public void tearDown() {
    }
    public void testSetGetPrenotazioni() {
		
		Studente stud = new Studente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
		Insegnamento i = new Insegnamento(518, 12, "Analisi", "xxxxx");
		Prenotazione p = new Prenotazione(1, 12, 1, "25","Accettato");
		prenotazioni.add(p);
		sistema.setListPrenotazione(prenotazioni);
		assertEquals(prenotazioni, sistema.getListPrenotazione());
	}
	
	@Test
	public void testSetGetPianoDiStudio() {
		//assertNotNull("Oggetto Sistema non istanziato",sistema);
		Studente s = new Studente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
		Insegnamento i = new Insegnamento(508, 9, "Fisica", "xxxxx");
		ArrayList<Insegnamento> ins = new ArrayList<>();
		ins.add(i);
		PianoDiStudio c = new PianoDiStudio(ins,s);
		pianoSt.add(c);
		sistema.setListPianoDiStudio(pianoSt);
		assertEquals(pianoSt, sistema.getListPianoDiStudio());
	}
	
	@Test
	public void testSetGetUtenti() {
		Utente u = new Utente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
		user.add(u);
		sistema.setListUtente(user);
		assertEquals(true, sistema.getListUtente().equals(user));
	}
        
        
	@Test
	public void testEmailCorretta() {
		Utente u = new Utente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		String expectedResult="asmarebhi@gmail.com";
		assertEquals(expectedResult, u.getEmail());
	}
	
	@Test
	public void testPasswordCorretta() {
		Utente u = new Utente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
		assertNotNull("Oggetto Sistema non istanziato",sistema);
		String expectedResult="abcd";
		assertEquals(expectedResult,u.getPassword());
	}


}

