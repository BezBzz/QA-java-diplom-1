import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestIngredientType {

    @Parameterized.Parameter(0)
    public IngredientType ingredientType;

    @Parameterized.Parameter(1)
    public String expectedName;

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    @Test
    public void testIngredientTypeValue(){
        assertEquals(expectedName, ingredientType.name());
            }
}
