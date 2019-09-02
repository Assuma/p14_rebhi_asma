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
public class InsegnamentoIT {
        private int cod;
      	private static Insegnamento insegnamento = null;

    
    @BeforeClass
    public static void setUpClass() throws Exception {
        insegnamento = new Insegnamento();
        System.out.println("Create a course");
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

 

    /**
     * Test of getCodice method, of class Insegnamento.
     */
    @Test
    public void testGetCodice() {
        System.out.println("getCodice");
        Insegnamento instance = new Insegnamento(805,9 , "Computer Security","Scritto + progetto");
        int expResult = 805;
        int result = instance.getCodice();
        assertEquals(expResult, result);
       
    }


    /**
     * Test of getNome method, of class Insegnamento.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Insegnamento instance = new Insegnamento(835,6, "System Identification","Scritto + progetto");
        String expResult = "System Identification";
        String result = instance.getNome();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
     @Test
    public void testNullCodice() {
        System.out.println("getCodiceNot Null");
        Insegnamento instance = new Insegnamento(835,6, "System Identification","Scritto + progetto");
        int result = instance.getCodice();
        assertTrue(result>0);

    }

    /**
     * Test of getCfu method, of class Insegnamento.
     */
    @Test
    public void testGetCfu() {
        System.out.println("getCfu");
        Insegnamento instance = new Insegnamento(835,6, "System Identification","Scritto + progetto");
        int expResult = 6;
        int result = instance.getCfu();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
        @Test
    public void testMaxCfu() {
        System.out.println("getCfu");
        Insegnamento instance = new Insegnamento(835,6, "System Identification","Scritto + progetto");
        int result = instance.getCfu();
        assertTrue(result<13);

    }
    @Test
    public void testNullCfu() {
        System.out.println("getCfu");
        Insegnamento instance = new Insegnamento(835,6, "System Identification","Scritto + progetto");
        int result = instance.getCfu();
        assertTrue(result>0);

    }
    

    @Test
    public void testGetDescription() {
        System.out.println("getThe description of the course");
        Insegnamento instance = new Insegnamento(835,6, "System Identification","Scritto + progetto");
        String expResult = "Scritto + progetto";
        String result = instance.getDescription();
        assertEquals(expResult, result);
      
    }

}
