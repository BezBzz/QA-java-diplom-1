import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class TestIngredient {


    @Test
    public void getIngredientPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 100);
        assertEquals(100, ingredient.getPrice(),0.1);
    }

    @Test
    public void getIngredientName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        assertEquals("hot sauce", ingredient.getName());
    }

    @Test
    public void getIngredientType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "dinosaur", 200);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
