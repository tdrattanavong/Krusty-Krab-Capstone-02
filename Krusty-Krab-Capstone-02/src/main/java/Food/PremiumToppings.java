package Food;

public abstract class PremiumToppings extends Toppings {

    public PremiumToppings(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public abstract double getPrice(int sandwichSize);
}
