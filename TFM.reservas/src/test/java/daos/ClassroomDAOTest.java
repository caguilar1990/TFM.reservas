package daos;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.PersistenceConfig;
import config.TestsPersistenceConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class, TestsPersistenceConfig.class})
public class ClassroomDAOTest {
    
    @Autowired
    private ClassroomDAO classroom;
    
    @Test
    public void testFindAll(){
        assertEquals(9, classroom.findAll().size());
    }
    
    @Test
    public void testSearchByReferencia(){
    	
    	Assert.assertEquals(0, Double.compare(classroom.searchByReferencia(1001).getSuperficie(), 1.1));
    	Assert.assertEquals(0, Double.compare(classroom.searchByReferencia(1002).getSuperficie(), 1.2));
    	Assert.assertEquals(0, Double.compare(classroom.searchByReferencia(1003).getSuperficie(), 1.3));
    	Assert.assertEquals(0, Double.compare(classroom.searchByReferencia(1004).getSuperficie(), 1.4));
    	Assert.assertEquals(0, Double.compare(classroom.searchByReferencia(1005).getSuperficie(), 1.5));
    	Assert.assertEquals(0, Double.compare(classroom.searchByReferencia(1006).getSuperficie(), 1.6));

     
     
    }
}
