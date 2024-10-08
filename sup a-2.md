
// Pizza interface representing a basic pizza
interface Pizza {
    String getDescription();
    double getCost();
}

// BasicPizza class implementing Pizza interface
class BasicPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Basic Pizza (Dough, Sauce, Cheese)";
    }

    @Override
    public double getCost() {
        return 5.00; // Base price for a simple pizza
    }
}

// PizzaDecorator class, implementing the Pizza interface and allowing dynamic additions to Pizza
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription();
    }

    public double getCost() {
        return pizza.getCost();
    }
}

// Adding Pepperoni to the pizza
class Pepperoni extends PizzaDecorator {

    public Pepperoni(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.50; // Adding extra cost for pepperoni
    }
}

// Adding Mushrooms to the pizza
class Mushrooms extends PizzaDecorator {

    public Mushrooms(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushrooms";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.00; // Adding extra cost for mushrooms
    }
}

// Main class to demonstrate the Decorator Pattern in action
public class PizzaOrder {
    public static void main(String[] args) {
        // Basic Pizza
        Pizza pizza = new BasicPizza();
        System.out.println(pizza.getDescription() + " Cost: $" + pizza.getCost());

        // Adding Pepperoni
        pizza = new Pepperoni(pizza);
        System.out.println(pizza.getDescription() + " Cost: $" + pizza.getCost());

        // Adding Mushrooms
        pizza = new Mushrooms(pizza);
        System.out.println(pizza.getDescription() + " Cost: $" + pizza.getCost());
    }
}
