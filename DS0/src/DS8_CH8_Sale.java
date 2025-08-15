import java.util.ArrayList;

public class DS8_CH8_Sale {

    public static void sale(ArrayList<DS8_CH8_Item> inventory){
        for (int x=inventory.size()-1; x>=0; x--){
            if (inventory.get(x).getStatus()==0)
            {
                inventory.get(x).setStatus(1);
                inventory.get(x).setPrice(inventory.get(x).getPrice()-(inventory.get(x).getPrice()*0.30));
            }
            else if(inventory.get(x).getStatus()==1){
                inventory.get(x).setStatus(2);
                inventory.get(x).setPrice(inventory.get(x).getPrice()-(inventory.get(x).getPrice()*0.50));
            }
            else  inventory.remove(x);
        }
    }
}
