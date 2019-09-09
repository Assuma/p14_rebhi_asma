/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Test Strutturale della classe docente
package entità;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author assma
 */
public class DocenteIT {
    ArrayList<Prenotazione> Prenotazioni=new ArrayList<Prenotazione>();
    ArrayList<Insegnamento> insegnamentos = new ArrayList<Insegnamento>();
    ArrayList<CorsoDiStudio> CorsoDistudi = new ArrayList<CorsoDiStudio>();
    private ArrayList<Insegnamento> expectedResult1;
    private ArrayList<Prenotazione> expectedResult2;
    private ArrayList<CorsoDiStudio> expectedResult3;
    private static Docente docente=null;
   
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    docente = new Docente();
    System.out.println("Create Docente");
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
	public void testMatricola() {
	        docente = new Docente(123,"asma","rebhi","asmarebhi@gmail.com","xx","Vix","20054879");
                assertEquals(true,docente.getNome().equals("asma")); 	
}

        @Test
	public void testNome() {
		docente = new Docente(123,"asma","rebhi","asmarebhi@gmail.com","xx","Viax","20054879");
                assertEquals(true,docente.getNome().equals("asma")); 	
}
        
        @Test
	public void testCognome() {
		docente = new Docente(123,"asma","rebhi","asmarebhi@gmail.com","xx","Viax","20054879");
                assertEquals(true,docente.getCognome().equals("rebhi")); 	
}

        @Test
	public void testEmail() {
		docente = new Docente(123,"asma","rebhi","asmarebhi@gmail.com","xx","Viax","20054879");
                assertEquals(true,docente.getEmail().equals("asmarebhi@gmail.com")); 	
}
        @Test
	public void testPassword() {
		docente = new Docente(123,"asma","rebhi","asmarebhi@gmail.com","xx","Viax","20054879");
                assertEquals(true,docente.getPassword().equals("xx")); 	
}
       
        
        
        @Test
	public void testIndirizzo() {
		docente = new Docente(123,"asma","rebhi","asmarebhi@gmail.com","xx","Viax","20054879");
                assertEquals(true,docente.getIndirizzo().equals("Viax")); 	
}
        
        
        @Test
	public void testSetandGetInsegnamento() {
		Insegnamento insegnamenti = new Insegnamento (802, 12, "asma", "Description");
		insegnamentos.add(insegnamenti);
		docente.setInsegnamento(insegnamentos);
		expectedResult1= insegnamentos;
		List<Insegnamento> result = docente.getInsegnamento();
		assertEquals(this.expectedResult1, result);
		
}
        @Test
	public void testSetandGetPrenotazioni(){
		Prenotazione Pren = new Prenotazione (1, 12, 123, "12", "InCorso");
		Prenotazioni.add(Pren);
		docente.setListPrenotazione(Prenotazioni);
		expectedResult2= Prenotazioni;
		List<Prenotazione> result = docente.getListPrenotazione();
		assertEquals(this.expectedResult2, result);

}
        @Test
	public void testSetandGetCorsoDiStudio(){
		CorsoDiStudio CS = new CorsoDiStudio(1,"SoftwareEngineering");
		CorsoDistudi.add(CS);
		docente.setCorsoDistudi(CorsoDistudi); 
		expectedResult3= CorsoDistudi;
		List<CorsoDiStudio> result = docente.getCorsoDistudi();
		assertEquals(this.expectedResult3, result);

}
 }

