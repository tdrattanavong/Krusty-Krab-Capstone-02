package Food;

public class Chips extends OtherProducts {
    private String type;

    public Chips(String type) {
        super("Chips");
        this.type = type;
    }

    public String getType() { return type; }

    @Override
    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return String.format("%s chips - $%.2f", type, getPrice());
    }
}
