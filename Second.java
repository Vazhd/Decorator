import java.util.ArrayList;
import java.util.List;

//2)
public class Second {
    public static void main(String[] args) {
        IPizza Dpizza = new MakePizza();
        System.out.printf("Ingredients: %s %nCost: %.2f Tenge", Dpizza.getIngredients(), Dpizza.getCost());
        IPizza pizzaM = new PizzaWithMushroom(new MakePizza());
        System.out.printf("%nIngredients: %s %nCost: %.2f Tenge", pizzaM.getIngredients(), pizzaM.getCost());
        IPizza pizzaA = new PizzaWithChicken(new PizzaWithMushroom(new MakePizza()));
        System.out.printf("%nIngredients: %s %nCost: %.2f Tenge", pizzaA.getIngredients(), pizzaA.getCost());
    }


}
interface IPizza{
    double getCost();
    String getIngredients();
}
class MakePizza implements IPizza{
    @Override
    public double getCost() {
        return 1500.0;
    }

    @Override
    public String getIngredients() {
        return "Pizza";
    }
}

class PizzaDecorator implements IPizza{
    private IPizza pizza;

    public PizzaDecorator(IPizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }

    @Override
    public String getIngredients() {
        return pizza.getIngredients();
    }
}

class PizzaWithChicken extends PizzaDecorator{
    public PizzaWithChicken(IPizza pizza){
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 300.0;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " + Chicken ";
    }
}
class PizzaWithMushroom extends PizzaDecorator{
    public PizzaWithMushroom(IPizza pizza){
        super(pizza);
    }

    @Override
    public double getCost() {
        return super.getCost() + 500.0;
    }

    @Override
    public String getIngredients() {
        return super.getIngredients() + " +Mushroom";
    }
}