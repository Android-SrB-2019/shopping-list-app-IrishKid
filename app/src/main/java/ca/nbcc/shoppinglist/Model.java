package ca.nbcc.shoppinglist;

import java.util.HashMap;

public class Model {
    HashMap<String, Integer> shoppingCart = new HashMap<String, Integer>();

    public void addItem(String itemAdd){
        if(!shoppingCart.containsKey(itemAdd)){
            shoppingCart.put(itemAdd, 1);
        }else{
            Integer oldNum = shoppingCart.get(itemAdd);
            shoppingCart.replace(itemAdd, oldNum, oldNum + 1);
        }
    }

    public String sendShoppingCart(){
        String cart = "";

        for (String key : shoppingCart.keySet()) {
            Integer x = shoppingCart.get(key);
            cart += key + " " + Integer.toString(x) + "\n";
        }
        return  cart;
    }

    public void getShoppingCart(String cart){
        for(String keyValue : cart.split("\n")) {
            String[] pairs = keyValue.split(" ", 5);
            shoppingCart.put(pairs[0], 1);

        }
    }
}
