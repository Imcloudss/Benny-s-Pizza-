package it.unibo.model.impl.IngredientsImpl;

import it.unibo.model.impl.IngredientImpl;

/**
 * Class that emulates a cherry tomatoe.
 */
public class CherryTomatoe extends IngredientImpl {
    private static final int QUANTITY_TO_REDUCE = 8;
    private static final double PRICE = 0.9;
    private static final String IMAGE_NAME = "CherryTomatoes.png";

    /**
     * The constructor of the class CherryTomatoe.
     */
    public CherryTomatoe() {
        super(PRICE, IMAGE_NAME);
    }

    @Override
    public void reduce() {
        super.reduceIngredient(QUANTITY_TO_REDUCE);
    }
}
