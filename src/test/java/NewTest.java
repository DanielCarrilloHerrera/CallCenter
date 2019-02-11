import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
    private static ThreadLocal<Long> val = new ThreadLocal<>();

    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        val.set(id);
        printer("beforeMethod");
    }
    
    @AfterMethod
    public void afterMethod() {
        printer("afterMethod");
        //usage of thread locale done. Lets reset it.
        val.set(null);
    }

    /*@BeforeTest
    public void beforeTest() {
        long id = Thread.currentThread().getId();
        val.set(id);
        printer("beforeTest");
    }*/
    
    /*@AfterTest
    public void afterTest() {
        long id = Thread.currentThread().getId();
        val.set(id);
        printer("afterTest");
    }*/
    
    @BeforeClass
    public void beforeClass() {
        long id = Thread.currentThread().getId();
        val.set(id);
        printer("beforeClass");
    }
    
    @AfterClass
    public void afterClass() {
        printer("afterClass");
        //usage of thread locale done. Lets reset it.
        val.set(null);
    }

    @Test (threadPoolSize = 5, invocationCount = 5, timeOut = 1000)
    public void methodOne() {
        printer("methodOne");
    }
    
    @Test (threadPoolSize = 5, invocationCount = 5, timeOut = 1000)
    public void methodTwo() {
        printer("methodTwo");
    }

    private static void printer(String prefix) {
        System.err.println("Thread ID in the method " + prefix + "() is " + val.get());
    }
}