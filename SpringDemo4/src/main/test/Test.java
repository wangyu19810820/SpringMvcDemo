import config.DatabaseConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

/**
 * Created by admin on 2017/7/6.
 */

public class Test {

    @org.junit.Test
    public void test() {
//        GiveRaiseJava.giveRaise(new Executor());
        Executor executor = new Executor();
        executor.raise(new BigDecimal("11"));
    }
}

class Employee {
    public void raise(Number amount) {
        System.out.println("Employee got raise");
    }
}

class Executor extends Employee {
    public void raise(Number amount) {
        System.out.println("Executor got raise");
    }

    public void raise(BigDecimal amount) {
        System.out.println("Executor got outlandish raise");
    }
}

class GiveRaiseJava {
    public static void giveRaise(Employee e) {
        e.raise(new BigDecimal(100.00));
    }
}
