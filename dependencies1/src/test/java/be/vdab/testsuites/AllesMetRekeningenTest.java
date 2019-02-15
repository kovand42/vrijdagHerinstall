package be.vdab.testsuites;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import be.vdab.entities.Rekening1Test;
import be.vdab.entities.RekeningnummerTest;
@RunWith(Suite.class)
@SuiteClasses({RekeningnummerTest.class,
	Rekening1Test.class})
public class AllesMetRekeningenTest {

}
