package ca.nbcc.shoppinglist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    Model shoppingCart = new Model();
    String myCart;
    private TextView textCart;
    public static final int TEXT_REQUEST = 1;
    public static final String EXTRA_MESSAGE =
            "ca.nbcc.shoppinglist.extra.MESSAGE";

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                myCart = "";
                myCart = data.getStringExtra("cart");
                textCart.setText(myCart);
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(textCart != null){
            outState.putString("rotate_cart", textCart.getText().toString());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textCart = (TextView)findViewById(R.id.text_cart);

        if (savedInstanceState != null) {
            textCart.setText(savedInstanceState.getString("rotate_cart"));
        }
    }

    public void makeOrder(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("cart", myCart);
        startActivityForResult(intent, TEXT_REQUEST);
    }
}