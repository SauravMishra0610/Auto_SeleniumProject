package hooks;

import org.junit.After;
import org.junit.Before;

public class HooksClass {
    @Before
    public void beforeHooks(){
        System.out.println("Before Test Execution..");
    }

    @After
    public void afterHooks(){
        System.out.println("After Test Execution..");
    }
}
