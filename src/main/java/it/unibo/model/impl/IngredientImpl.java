package it.unibo.model.impl;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.regex.Pattern;

import it.unibo.model.api.Ingredient;

/**
 * Abstract implementation of the 'Ingredient' interface.
 */
public abstract class IngredientImpl implements Ingredient {

    private static final String SEP = File.separator;
    private static final String PATH_TO_THE_ROOT = FileSystems.getDefault().getPath(new String()).toAbsolutePath().toString();
    private static final String PATH_TO_RESOURCES = SEP + "src" + SEP + "main" + SEP 
        + "resources" + SEP + "ingredientsImages" + SEP;
    /**
     * The max quantity for each ingredient.
     */
    public static final int MAX_QUANTITY = 100;
    private int quantity;
    private double price;
    private String imagePath;

    /**
     * Protected constructor of IngredientImpl, called by its subclasses.
     * @param price the price of the specific ingredient.
     * @param imageName the image name of the specific ingredient.
     */
    protected IngredientImpl(final double price, final String imageName) {
        this.quantity = MAX_QUANTITY;
        this.price = price;
        this.imagePath = PATH_TO_THE_ROOT + PATH_TO_RESOURCES + imageName;
    }

    /**
     * It returns the ingredient's current quantity.
     */
    @Override
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * It returns the ingredient's price.
     */
    @Override
    public double getPrice() {
        return this.price;
    }

    /**
     * It returns the path of the ingredient's image.
     */
    @Override
    public String getImagePath() {
        return this.imagePath;
    }

    @Override
    public final void supply() {
        this.quantity = MAX_QUANTITY;
    }

    @Override
    public abstract void reduce();

    /**
     * Method in common among all the classes that inherit from 'IngredientImpl'.
     * It is used in the method 'reduce()' of these classes.
     * @param toReduce the quantity of the ingredient to reduce.
     */
    protected void reduceIngredient(final int toReduce) {
        this.quantity = this.quantity - toReduce;
    }

    /**
     * It returns true if two 'ingredient' object are equal.
     */
    @Override
    public boolean equals(final Object o) {
        return this.imagePath.equals(((Ingredient) o).getImagePath());
    }

    /**
     * It returns the hash code.
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * It returns the name of the specific ingredient.
     */
    @Override
    public String toString() {
        String[] strings = this.imagePath.split(Pattern.quote(SEP));
        return strings[strings.length - 1].split(Pattern.quote("."))[0];
    }

}
