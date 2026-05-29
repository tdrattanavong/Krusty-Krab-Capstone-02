package Food;

public abstract class Toppings {
    private String name;
    private boolean isExtra;

    public Toppings(String name, boolean isExtra) {
        this.name = name;
        this.isExtra = isExtra;
    }

    public String getName() { return name; }
    public boolean isExtra() { return isExtra; }

    public abstract double getPrice(int sandwichSize);

    @Override
    public String toString() {
        return name + (isExtra ? " (extra)" : "");
    }
}
