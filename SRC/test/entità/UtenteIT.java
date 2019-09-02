package entità;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author assma
 */
public class UtenteIT {
    private String expResult;
    private static Utente User = null;
    
    
    @BeforeClass
    public static void setUpClass() {
    User = new Utente();
		System.out.println("Create the user");
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
	public void testCostruttoreMatricola() {
		assertNotNull("Oggetto Docente non istanziato",User);
		User = new Studente(11, "asma", "rebhi","xx@gmail.com","xxx","via_abc","20054879");
		assertEquals(true,User.getNome().equals("asma"));	
	}
	
	@Test
	public void testCostruttoreNome() {
		assertNotNull("Oggetto Docente non istanziato",User);
		User = new Studente(11, "asma", "rebhi","xx@gmail.com","xxx","via_abc","20054879");
		assertEquals(true,User.getNome().equals("asma"));	
	}
	
	@Test
	public void testCostruttoreCognome() {
		assertNotNull("Oggetto Docente non istanziato",User);
		User = new Studente(11, "asma", "rebhi","xx@gmail.com","xxx","via_abc","20054879");
		assertEquals(true,User.getCognome().equals("rebhi"));	
	}
	
	@Test
	public void testCostruttoreEmail() {
		assertNotNull("Oggetto Docente non istanziato",User);
		User = new Studente(11, "asma", "rebhi","xx@gmail.com","xxx","via_abc","20054879");
		assertEquals(true,User.getEmail().equals("xx@gmail.com"));	
	}
	
	@Test
	public void testCostruttorePassword() {
		User = new Studente(11, "asma", "rebhi","xx@gmail.com","xxx","via_abc","20054879");
		assertEquals(true,User.getPassword().equals("xxx"));	
	}
	
           @Test
	public void testMatricola() {
		User.setMatricola(4394457);
		int risultato = User.getMatricola();
		assertEquals(4394457, risultato);
	}
	
	
	@Test
	public void testSetGetNome() {
		User.setNome("Hajar");
		expResult = "Hajar";
		assertEquals(this.expResult, User.getNome());
	}
	
	@Test
	public void testSetGetCognome() {
		User.setCognome("Akohar");
		expResult = "Akohar";
		assertEquals(this.expResult, User.getCognome());
	}
	
	@Test
	public void testSetGetEmail() {
		User.setEmail("xx@gmail.com");
		expResult = "xx@gmail.com";
		assertEquals(this.expResult, User.getEmail());
	}
	
	@Test
	public void testSetGetPassword() {
		User.setPassword("yyy");
		expResult = "yyy";
		assertEquals(this.expResult, User.getPassword());
	}
}