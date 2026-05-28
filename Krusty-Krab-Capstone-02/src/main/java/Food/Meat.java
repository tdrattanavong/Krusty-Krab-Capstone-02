package Food;

public class Meat extends PremiumToppings {

    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int sandwichSize) {
        if (isExtra()) {
            if (sandwichSize == 4)  return 0.50;
            if (sandwichSize == 8)  return 1.00;
            if (sandwichSize == 12) return 1.50;
        } else {
            if (sandwichSize == 4)  return 1.00;
            if (sandwichSize == 8)  return 2.00;
            if (sandwichSize == 12) return 3.00;
        }
        return 0;
    }
}
