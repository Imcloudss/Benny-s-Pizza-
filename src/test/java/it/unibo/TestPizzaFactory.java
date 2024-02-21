package it.unibo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.unibo.model.api.PizzaFactory;
import it.unibo.model.impl.PizzaFactoryImpl;
import it.unibo.model.impl.PreparationZoneImpl;
import it.unibo.model.impl.ingredientsImpl.Dough;
import it.unibo.model.impl.ingredientsImpl.FrenchFry;
import it.unibo.model.impl.ingredientsImpl.Ham;
import it.unibo.model.impl.ingredientsImpl.Mozzarella;
import it.unibo.model.impl.ingredientsImpl.Mushroom;
import it.unibo.model.impl.ingredientsImpl.Olive;
import it.unibo.model.impl.ingredientsImpl.TomatoSauce;
import it.unibo.model.impl.management.SubtractorManager;

/**
 * Test for the PizzaFactoryImpl class.
 */
public class TestPizzaFactory {
    private PreparationZoneImpl p;

    /**
     * Initialing for the test.
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     * @throws NoSuchMethodException
     * @throws SecurityException
     */
    @BeforeEach
    public void initialize() throws ClassNotFoundException, 
                                    InstantiationException, 
                                    IllegalAccessException, 
                                    IllegalArgumentException, 
                                    InvocationTargetException, 
                                    NoSuchMethodException, 
                                    SecurityException {
        this.p = new PreparationZoneImpl(new SubtractorManager());
    }

    /**
     * Test the method addIngredient of PizzaFactory.
     */
    @Test
    public void testAddingIngredients() {
        final PizzaFactory pizza = new PizzaFactoryImpl();
        pizza.addIngredient(p, new Dough());
        assertEquals(Collections.unmodifiableList(List.of(new Dough())), pizza.getAddedIngredients());
        pizza.addIngredient(p, new TomatoSauce());
        pizza.addIngredient(p, new Mozzarella());
        assertNotEquals(Collections.unmodifiableList(List.of(new TomatoSauce(), new Mozzarella())), pizza.getAddedIngredients());
        pizza.addIngredient(p, new FrenchFry());
        pizza.addIngredient(p, new FrenchFry());
        assertEquals(Collections.unmodifiableList(List.of(new Dough(), new TomatoSauce(), new Mozzarella(), new FrenchFry())), 
            pizza.getAddedIngredients());
    }

    /**
     * Test the method equal of PizzaFactory.
     */
    @Test
    public void testPreparedPizzaEqualToTheRequestedOne() {
        final var ingredientsRequested = new ArrayList<>(List.of(new Dough().toString(), new TomatoSauce().toString(), 
            new Mozzarella().toString(), new Ham().toString(), new Mushroom().toString()));
        final PizzaFactory pizza = new PizzaFactoryImpl();
        pizza.addIngredient(p, new Dough());
        pizza.addIngredient(p, new TomatoSauce());
        pizza.addIngredient(p, new Mozzarella());
        assertFalse(pizza.equals(ingredientsRequested));
        pizza.addIngredient(p, new Mushroom());
        pizza.addIngredient(p, new Ham());
        assertTrue(pizza.equals(ingredientsRequested));
        pizza.addIngredient(p, new Mushroom());
        assertTrue(pizza.equals(ingredientsRequested));
        pizza.addIngredient(p, new Olive());
        assertFalse(pizza.equals(ingredientsRequested));
    }
}
