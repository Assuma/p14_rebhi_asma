/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Test Strutturale della classe Prenotazione
package entità;

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
public class PrenotazioneIT {
    private static Prenotazione pre=null;
    @BeforeClass
    public static void setUpClass() {
        pre = new Prenotazione();
        System.out.println("Create Prenotazione");
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
     * Test of getStato method, of class Prenotazione.
     */
    @Test
    public void testGetStato() {
        System.out.println("getStato");
        Prenotazione pre = new Prenotazione(0021, 15, 01,"25","Passato");
        String expResult = "Passato";
        String result = pre.getStato();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    
    /**
     * Test of getVoto method, of class Prenotazione.
     */
    @Test
    public void testGetVoto() {
        System.out.println("getVoto");
        Prenotazione pre = new Prenotazione(0021, 15, 01,"25","Passato");
        String expResult = "25";
        String result = pre.getVoto();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }


    /**
     * Test of getPrenotazionePK method, of class Prenotazione.
     */
    @Test
    public void testGetPrenotazionePK() {
        System.out.println("getPrenotazionePK");
        Prenotazione pre = new Prenotazione(0021, 15, 01,"28","Passato");
        int expResult = 0021;
        int result = pre.getPrenotazionePK();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    
        @Test
    public void testDiffPrenotazionePK() {
        System.out.println("setPrenotazionePK");
        int PrePK = 0;
        Prenotazione instance1 = new Prenotazione(0021, 15, 01,"28","Passato");
        Prenotazione instance2 = new Prenotazione(0022, 11, 02,"30","Passato");
        instance1.setPrenotazionePK(PrePK);
        instance2.setPrenotazionePK(PrePK);
        assertNotSame(instance1, instance2);
       
    }



    /**
     * Test of getStudente method, of class Prenotazione.
     */
    @Test
    public void testGetStudente() {
        System.out.println("getStudente");
        Prenotazione pre = new Prenotazione(0021, 15, 01,"25","Passato");
        int expResult = 01;
        int result = pre.getStudente();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }


    /**
     * Test of getAppello method, of class Prenotazione.
     */
    @Test
    public void testGetAppello() {
        System.out.println("getAppello");
        Prenotazione instance = new Prenotazione(0021, 15, 01,"25","Passato");
        int expResult = 15;
        int result = instance.getAppello();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }
    


}
