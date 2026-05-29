src/
├── UI/
│   ├── OrderScreen.java       # Main ordering interface (add items, view order, checkout)
│   ├── SandwichScreen.java    # Sandwich builder
│   └── CheckoutScreen.java    # Order summary and receipt
└── Food/
├── Order.java             # Holds all items and calculates totals
├── Sandwich.java          # Sandwich model (size, bread, toppings)
├── Drink.java             # Drink model (size, flavor)
└── Chips.java             # Chips model (flavor)