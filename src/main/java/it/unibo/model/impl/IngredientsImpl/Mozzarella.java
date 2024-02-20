package it.unibo.model.impl.IngredientsImpl;

import it.unibo.model.impl.IngredientImpl;

/**
 * Class that emulates the mozzarella cheese.
 */
public class Mozzarella extends IngredientImpl {
    private static final int QUANTITY_TO_REDUCE = 10;
    private static final double PRICE = 0.6;
    private static final String IMAGE_NAME = "Mozzarella.png";

    /**
     * The constructor of the class Mozzarella.
     */
    public Mozzarella() {
        super(PRICE, IMAGE_NAME);
    }

    @Override
    public void reduce() {
        super.reduceIngredient(QUANTITY_TO_REDUCE);
    }
}
