package it.unibo.model.impl.IngredientsImpl;

import it.unibo.model.impl.IngredientImpl;

/**
 * Class that emulates a french fry.
 */
public class FrenchFry extends IngredientImpl {
    private static final int QUANTITY_TO_REDUCE = 17;
    private static final double PRICE = 1.5;
    private static final String IMAGE_NAME = "FrenchFries.png";

    /**
     * The constructor of the class FrenchFry.
     */
    public FrenchFry() {
        super(PRICE, IMAGE_NAME);
    }

    @Override
    public void reduce() {
        super.reduceIngredient(QUANTITY_TO_REDUCE);
    }
}
