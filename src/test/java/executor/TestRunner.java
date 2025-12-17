package executor;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import businesscomponents.AdacitinJUnit;
import businesscomponents.SMJunitMainpg;

@RunWith(Suite.class)
@SuiteClasses({SMJunitMainpg.class, AdacitinJUnit.class})

public class TestRunner {

}
