/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Tests Strutturali
package entità;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
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
@RunWith(Suite.class)
@SuiteClasses({ AppelloIT.class, CorsoDiStudioIT.class, DocenteIT.class, InsegnamentoIT.class,
		PianoDiStudioIT.class, PrenotazioneIT.class, SistemaIT.class, StudenteIT.class, UtenteIT.class })
public class JUnitTestSuite {

}

//    
//    public JUnitTestSuite() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    // TODO add test methods here.
//    // The methods must be annotated with annotation @Test. For example:
//    //
//    // @Test
//    // public void hello() {}
