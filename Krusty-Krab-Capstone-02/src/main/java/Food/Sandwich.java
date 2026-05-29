package Food;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sandwich {
    private int size;
    private String bread;
    private List<Toppings> toppings;
    private boolean toasted;

    public Sandwich(int size, String bread) {
        this.size = size;
        this.bread = bread;
        this.toasted = false;
        this.toppings = new ArrayList<>();
    }

    public int getSize() { return size; }
    public String getBread() { return bread; }
    public boolean isToasted() { return toasted; }
    public void setToasted(boolean toasted) { this.toasted = toasted; }
    public List<Toppings> getToppings() { return toppings; }

    public void addTopping(Toppings topping) {
        toppings.add(topping);
    }

    public double getPrice() {
        double price;
        if (size == 4)       price = 5.50;
        else if (size == 8)  price = 7.00;
        else if (size == 12) price = 8.50;
        else                 price = 0;
        for (Toppings t : toppings) {
            price += t.getPrice(size);
        }
        return price;
    }

    @Override
    public String toString() {
        String header = size + "\" " + bread + " bread" + (toasted ? " (toasted)" : "");
        String toppingLines = toppings.stream()
                .map(t -> "\n   - " + t)
                .collect(Collectors.joining());
        String footer = String.format("%n   Subtotal: $%.2f", getPrice());
        return header + toppingLines + footer;
    }
}
