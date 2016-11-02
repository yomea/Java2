package junit_001.youth.hong;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TaskTest.class, TaskTest2.class, TaskTest3.class})
public class SuiteTest {

}
