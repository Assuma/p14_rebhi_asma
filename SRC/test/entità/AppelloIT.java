/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entità;

import java.util.Date;
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
public class AppelloIT {
    
    private static Appello appello = null;
    @BeforeClass
    public static void setUpClass()throws Exception {
         appello = new Appello();
         System.out.println("Create the call for Exam");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

  	
	
	@Test
	public void testVoto() {
		appello.setVoto(28);
		int risultato = appello.getVoto();
		assertEquals(28, risultato);
	}
	
        @Test
	public void testCodiceEsame() {
		appello.setInsegnamento(508);
		int risultato = appello.getInsegnamento();
		assertEquals(508, risultato);
	}
	
        
               @Test
	public void testAula() {
		appello.setAula("2Ga");
		String risultato = appello.getAula();
		assertEquals("2Ga", risultato);
	}
	
        	@Test
	public void testAccettaVoto() {
		Studente s = new Studente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
		appello.setStudente(s);
		boolean result = appello.isAccettareVoto(25);
              	assertTrue("Accettato", result );
		
	}
	
	@Test
	public void testNonAccettareVoto() {
		Studente s = new Studente(4394457, "Asma","Rebhi","asmarebhi@gmail.com","abcd", "Viaabcde","20054879");
		appello.setStudente(s);
		boolean risultato = appello.isAccettareVoto(15);
                assertFalse("Insufficient", risultato );
		
	}
	

}

