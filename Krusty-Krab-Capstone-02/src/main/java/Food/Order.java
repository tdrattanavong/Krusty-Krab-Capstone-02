package Food;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order() {
        sandwiches = new ArrayList<>();
        drinks = new ArrayList<>();
        chips = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) { sandwiches.add(sandwich); }
    public void addDrink(Drink drink) { drinks.add(drink); }
    public void addChips(Chips c) {
        boolean add = chips.add(c);
    }

    public List<Sandwich> getSandwiches() { return sandwiches; }
    public List<Drink> getDrinks() { return drinks; }
    public List<Chips> getChips() { return chips; }

    public double getTotalPrice() {
        double total = 0;
        for (Sandwich s : sandwiches) total += s.getPrice();
        for (Drink d : drinks) total += d.getPrice();
        for (Chips c : chips) total += c.getPrice();
        return total;
    }
}
