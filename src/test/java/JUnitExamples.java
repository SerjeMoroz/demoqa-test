import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitExamples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before Each");
    }

    @Test
    void test() {
        System.out.println("here is second test");
    }

    @Test
    void anotherTest() {
        System.out.println("here is another test");
    }
}
