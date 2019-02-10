package ca.nbcc.shoppinglist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    Model shoppingCart = new Model();
    String myCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Save items for shopping cart from the Main Activity
        Intent intent = getIntent();
        myCart = intent.getStringExtra("cart");
        if(myCart != null){
            shoppingCart.getShoppingCart(myCart);
        }
    }

    public void addProduct(View view) {
        //Save tag of the clicked button as a product Name
        String product_name = (String)view.getTag();
        shoppingCart.addItem(product_name);

        //Send Intent with updated shopping cart to the Main activity
        Intent replyIntent = new Intent(this, MainActivity.class);
        replyIntent.putExtra("cart", shoppingCart.sendShoppingCart());
        setResult(Activity.RESULT_OK, replyIntent);
        finish();
    }

    public void launchMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        finish();
    }
}
