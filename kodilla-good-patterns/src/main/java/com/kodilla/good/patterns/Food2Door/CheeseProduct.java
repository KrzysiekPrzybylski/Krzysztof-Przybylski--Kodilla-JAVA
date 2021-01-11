package com.kodilla.good.patterns.Food2Door;

public class CheeseProduct extends Product{

    private String mainIngredient;

    public CheeseProduct(String productName, String mainIngredient) {
        super(productName);
        this.mainIngredient = mainIngredient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CheeseProduct that = (CheeseProduct) o;

        return mainIngredient.equals(that.mainIngredient);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + mainIngredient.hashCode();
        return result;
    }
}
