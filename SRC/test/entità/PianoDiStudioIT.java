/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Test Strutturale della classe piano di studio
package entità;

import enumerations.TipoPianoStudi;
import java.util.ArrayList;
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
public class PianoDiStudioIT {
    private static PianoDiStudio pianoST = null;
    private List<Studente> listStudente;
    private Insegnamento insegnamentos;
    private TipoPianoStudi tempoParziale;
    private TipoPianoStudi tempoPieno;
   
    @BeforeClass
    public static void setUpClass() {
        pianoST = new PianoDiStudio();
	System.out.println("Create Piano Di Studio");
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
     * Test of getId method, of class PianoDiStudio.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        PianoDiStudio instance = new PianoDiStudio(102,tempoParziale, listStudente, insegnamentos);
        int expResult = 102;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    
    @Test
    public void testDiffId() {
        System.out.println("Testing DiffId");
        int id = 0;
        PianoDiStudio instance1 = new PianoDiStudio(102,tempoParziale, listStudente, insegnamentos);
        PianoDiStudio instance2 = new PianoDiStudio(112,tempoParziale, listStudente, insegnamentos);
        instance1.setId(id);
        instance2.setId(id);
        assertNotSame(instance1, instance2);
       
    }

    /**
     * Test of getTipo method, of class PianoDiStudio.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        PianoDiStudio instance = new PianoDiStudio(102,tempoPieno, listStudente, insegnamentos);
        TipoPianoStudi expResult = tempoPieno;
        TipoPianoStudi result = instance.getTipo();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }


}
