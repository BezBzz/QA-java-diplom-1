import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;


public class TestBurger {
    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;


    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        when(bun.getPrice()).thenReturn(Float.valueOf(100));
        when(ingredient1.getPrice()).thenReturn(Float.valueOf(200));
        when(ingredient2.getPrice()).thenReturn(Float.valueOf(150));
    }


    @Test
    public void setBunForBurger() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertEquals(100, bun.getPrice(), 0.1);
    }

    @Test
    public void addIngredient() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(550, burger.getPrice(), 0.1);
    }

    @Test
    public void removeIngredient() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(1);
        assertEquals(400, burger.getPrice(), 0.1);
    }

    @Test
    public void moveIngredient() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(1, 0);
        assertEquals(550, burger.getPrice(), 0.1);
    }

    @Test
    public void getPriceSuccess() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        assertEquals(550, burger.getPrice(), 0.1);
    }

    @Test
    public void getReceiptSuccess() {
        Burger burger = new Burger();
        when(bun.getName()).thenReturn("black bun");
        when(ingredient1.getName()).thenReturn("sour cream");
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("cutlet");
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expectedReceipt = "(==== black bun ====)\n" +
                "= filling sour cream =\n" +
                "= sauce cutlet =\n" +
                "(==== black bun ====)\n" +
                "\n" +
                "Price: 550,000000\n";
        String actualReceipt = burger.getReceipt().replace("\r\n", "\n");
        assertEquals(expectedReceipt, actualReceipt);

    }
}
