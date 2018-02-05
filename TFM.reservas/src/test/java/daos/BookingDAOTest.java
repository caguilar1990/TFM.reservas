package daos;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import entities.Aula;
import entities.Horario;
import entities.Personal;
import entities.Reservas;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class BookingDAOTest {

	@Autowired
    private BookingDAO bookingDAO;
	
	@Autowired
    private PersonalDAO personalDAO;
	
	@Autowired
    private ClassroomDAO classroomDAO;
	
	@Autowired
    private TimeDAO timeDAO;

	@Test
	public void testFindAll() {

		assertEquals(81, bookingDAO.findAll().size());
		    
	}
	
	@Test
	public void testFindByPersonal() {
		assertEquals(9, bookingDAO.findByPersonal(personalDAO.findAll().get(1).getId()).size());
		    
	}
	
	@Test
	public void testGetByMaster() {
		assertEquals(27, bookingDAO.getByMaster(personalDAO.findMaestroLaboratorio().get(2).getId()).size());
		    
	}
	
	@Test
	public void testFindClassroomsBookingByDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		String dateInString = "2018-01-29";
		java.util.Date date = null;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		assertEquals(81,bookingDAO.findClassroomsBookingByDate(sqlDate).size());

	}


	@Test
	public void testfindByID(){
		List<Aula> classList = classroomDAO.findAll();
		List<Horario> horarioList = timeDAO.findAll();
		List<Personal> personalList = personalDAO.findAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		String dateInString = "2018-01-29";
		java.util.Date date = null;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		Reservas reserva = bookingDAO.findByID(personalList.get(1).getId(), classList.get(1).getId(), sqlDate, horarioList.get(1).getId());
		assertEquals("Population", reserva.getDescripcion());
//		assertEquals(81,bookingDAO.findByID(idPersonal, idAula, fechaReserva, idHorario));

	}
	
	@Test
	public void testFindClassroomsBookingByDateMaster(){

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		String dateInString = "2018-01-29";
		java.util.Date date = null;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		assertEquals(27,bookingDAO.findClassroomsBookingByDateMaster(sqlDate,personalDAO.findMaestroLaboratorio().get(1).getId()).size());
	}
	
	@Test
	public void testFindClassroomsBookingByDateAndStateMaster(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		String dateInString = "2018-01-29";
		java.util.Date date = null;
		try {
			date = sdf.parse(dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
		assertEquals(27,bookingDAO.findClassroomsBookingByDateAndStateMaster(sqlDate,true,personalDAO.findMaestroLaboratorio().get(1).getId()).size());

	}
	
	
	
	
	
	

}
