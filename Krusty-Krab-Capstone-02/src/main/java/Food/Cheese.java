package Food;

public class Cheese extends PremiumToppings {

    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int sandwichSize) {
        if (isExtra()) {
            if (sandwichSize == 4)  return 0.30;
            if (sandwichSize == 8)  return 0.60;
            if (sandwichSize == 12) return 0.90;
        } else {
            if (sandwichSize == 4)  return 0.75;
            if (sandwichSize == 8)  return 1.50;
            if (sandwichSize == 12) return 2.25;
        }
        return 0;
    }
}
