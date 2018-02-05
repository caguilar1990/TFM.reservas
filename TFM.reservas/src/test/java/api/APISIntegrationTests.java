package api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({BookingRestTest.class,ClassroomRestTest.class,LoginRestTest.class,PermissionRestTest.class,PersonalRestTest.class,ResourcesClassroomRestTest.class,ResourcesRestTest.class,TimeRestTest.class})
public class APISIntegrationTests {

}
