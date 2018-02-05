package daos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({Population.class,ClassroomDAOTest.class,ResourcesDAOTest.class,PersonalDAOTest.class})
public class AllDaosIntegrationTests {

}
