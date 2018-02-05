package daos;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;
import entities.Permisos;
import entities.Personal;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class PersonalDAOTest {
    
    @Autowired
    private PersonalDAO personalDao;
    
    @Autowired
    private PermisosDAO permisosDAO;
    
    @Test
    public void testFindAll(){
        assertEquals(9, personalDao.findAll().size());
    }
    
    @Test
    public void testFindMaestro(){
        assertEquals(3, personalDao.findMaestroLaboratorio().size());
    }
    @Test
    public void testSearchByUsername(){
        assertEquals("admin", personalDao.searchByUsername("admin").getPass());
    }
    
    @Test
    public void testAddPersonal(){
    	Permisos permisos = permisosDAO.findAll().get(1);
    	Personal profesor = new  Personal(permisos, "Lola", "Martinez", "lmartinez", "1234");
        assertEquals(profesor, personalDao.save(profesor));
    }

}
