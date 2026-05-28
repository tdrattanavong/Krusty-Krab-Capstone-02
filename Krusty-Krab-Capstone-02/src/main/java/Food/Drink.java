package Food;

public class Drink extends OtherProducts {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        super("Drink");
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() { return size; }
    public String getFlavor() { return flavor; }

    @Override
    public double getPrice() {
        if (size.equalsIgnoreCase("small"))  return 2.00;
        if (size.equalsIgnoreCase("medium")) return 2.50;
        if (size.equalsIgnoreCase("large"))  return 3.00;
        return 0;
    }

    @Override
    public String toString() {
        return String.format("%s %s - $%.2f", size, flavor, getPrice());
    }
}
