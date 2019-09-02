/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entità;

import enumerations.AnnoDiStudi;
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
public class StudenteIT {
    ArrayList<Insegnamento> insegnamentos = new ArrayList<>();
    ArrayList<Prenotazione> Prenotazioni=new ArrayList<>();
    ArrayList<PianoDiStudio> PianoSt = new ArrayList<>();
    ArrayList<CorsoDiStudio> CorsoDistudi = new ArrayList<>();
    
    private ArrayList<PianoDiStudio> expectedResult1;
    private ArrayList<Prenotazione> expectedResult2;
    private ArrayList<CorsoDiStudio> expectedResult3;
    private ArrayList<Insegnamento> expectedResult4;
    
    private static Studente studente=null;

    @BeforeClass
    public static void setUpClass() {
        studente = new Studente();
        System.out.println("Create Studente");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        Insegnamento i = new Insegnamento(508, 9, "Automazione", "XXXXXXXX");
	studente = new Studente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
       
    }
    
    @After
    public void tearDown() {
    }


  @Test
  public void testCostruttoreNome() {
  
    studente  = new Studente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
    assertEquals(true,studente.getNome().equals("Asma"));	
}

  @Test
  public void testCostruttoreCognome() {
	  
     studente  = new Studente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
     assertEquals(true,studente.getCognome().equals("Rebhi"));	
	}

  @Test
  
  public void testCostruttoreIndirizzo() {
	    studente  = new Studente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
		assertEquals(true,studente.getIndirizzo().equals("Viaabcde"));	
	}
  @Test
  public void testCostruttoreTel() {
	  
	    studente  = new Studente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
		assertEquals(true,studente.getCellulare().equals("20054879"));	
	}

  @Test
  public void testCostruttorePassword() {
	  
	    studente  = new Studente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
		assertEquals(true,studente.getPassword().equals("abcd"));	
	}
    
}
