package it.unibo.model.impl.IngredientsImpl;

import it.unibo.model.impl.IngredientImpl;

/**
 * Class that emulates an onion.
 */
public class Onion extends IngredientImpl {
    private static final int QUANTITY_TO_REDUCE = 8;
    private static final double PRICE = 1;
    private static final String IMAGE_NAME = "Onions.png";

    /**
     * The constructor of the class Onion.
     */
    public Onion() {
        super(PRICE, IMAGE_NAME);
    }

    @Override
    public void reduce() {
        super.reduceIngredient(QUANTITY_TO_REDUCE);
    }
}
