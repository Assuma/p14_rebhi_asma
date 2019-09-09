/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Test Strutturale del corso di studio
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
public class CorsoDiStudioIT {
    
    	private static CorsoDiStudio corsoST = null;
	

    @BeforeClass
    public static void setUpClass() {
        corsoST = new CorsoDiStudio();
	System.out.println("scrivere corso");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        corsoST= new CorsoDiStudio(805,"ING-INF");
	}

   
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCodice method, of class CorsoDiStudio.
     */
    @Test
    public void testGetCodice() {
        System.out.println("getCodice");
        CorsoDiStudio instance = new CorsoDiStudio(805,"ING-MEC");
        int expResult = 805;
        int result = instance.getCodice();
        assertEquals(expResult, result);
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setCodice method, of class CorsoDiStudio.
     */
    @Test
    public void testDiffCodice() {
        System.out.println("setCodice");
        int codice = 0;
        CorsoDiStudio instance1 = new CorsoDiStudio(805,"ING-MEC");
        CorsoDiStudio instance2 = new CorsoDiStudio(815,"ING-INF");
        instance1.setCodice(codice);
        instance2.setCodice(codice);
        assertNotSame(instance1, instance2);
       
    }

    /**
     * Test of getNome method, of class CorsoDiStudio.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        CorsoDiStudio instance1 = new CorsoDiStudio(805,"Meccanica");
        String expResult = "Meccanica";
        String result = instance1.getNome();
        assertSame(expResult, result);	
        
    }

    /**
     * Test of setNome method, of class CorsoDiStudio.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        CorsoDiStudio instance = new CorsoDiStudio(815,"ING-INF");
        CorsoDiStudio instance1 = new CorsoDiStudio(805,"ING-MEC");
        instance.setNome(nome);
        instance1.setNome(nome);
        assertNotSame(instance1, instance);

    }

}
