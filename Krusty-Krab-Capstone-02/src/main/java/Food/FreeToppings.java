package Food;

public class FreeToppings extends Toppings {

    public FreeToppings(String name) {
        super(name, false);
    }

    @Override
    public double getPrice(int sandwichSize) {
        return 0.0;
    }
}
