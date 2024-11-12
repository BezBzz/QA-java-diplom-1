import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class TestBun {

    @Test
    public void testBunName() {
        Bun bun = new Bun("black bun", 100);
        assertEquals("black bun", bun.getName());
    }

    @Test
    public void testBunPrice() {
        Bun bun = new Bun("red bun", 300);
        assertEquals(300, bun.getPrice(), 0.1);
    }
}
