package IceCreamShop;

import java.util.ArrayList;

public class IceCream {
    private String flavor;
    private int container;
    private int scoops;

    public IceCream(String flavor, int container,int scoops, ArrayList<String> toppings, double total){
        this.flavor = flavor;
        this.container=container;
        this.scoops=scoops;
        this.toppings=toppings;
        this.total=total;
    }    private ArrayList<String> toppings;
    double total;

    public String getFlavor(){
        return flavor;
    }

    public int getContainer() {
        return container;
    }

    public int getScoops() {
        return scoops;
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setContainer(int container) {
        this.container = container;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setScoops(int scoops) {
        this.scoops = scoops;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }
}
