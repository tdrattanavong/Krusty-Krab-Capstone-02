package Food;

public abstract class OtherProducts {
    private String name;

    public OtherProducts(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public abstract double getPrice();

    @Override
    public abstract String toString();
}
