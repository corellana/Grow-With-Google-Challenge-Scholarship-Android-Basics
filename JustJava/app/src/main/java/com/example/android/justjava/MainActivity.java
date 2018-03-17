package com.example.android.justjava;


import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.jar.Attributes;

import static android.widget.Toast.*;

/**
 * This app displays an order form to order coffee.
 * <p>
 * *********
 * extends AppCompatActivity means that the main activity is an extension of the funcionality in
 * the AppCompatActivity class.
 * <p>
 * The AppCompatActivity is part of the Android support library.
 * It allows us to use the latest UI features on Android while still working on older Android Devices.
 * <p>
 * By extending the AppCompayActivity class, we're getting all the funcionality all the state and
 * the methods from here within the MainActivity for free.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     * <p>
     * 33: I've calculate the price
     * 34: Now I have to pass it into the createOrderSummary method. So I'm going to do that right
     * here, createOrderSummary with the price variable.
     * The return value of this method is going to get stored in the priceMessage variable.
     * And then to update the screen all I have to do is call displayMessage with the priceMessage
     * variable like before.
     * <p>
     * Instead of creating the order summary and storing it in a variable and then using it right
     * after, I could have just called createOrderSummary and then call displayMessage on that.
     * <p>
     * --Replace this --
     * String priceMessage = createOrderSummary(price);
     * displayMessage(priceMessage);
     * <p>
     * -- For this --
     * displayMessage(createOrderSummary(price));
     */
    public void submitOrder(View view) {
        EditText nameCustomer = this.findViewById(R.id.name_text_input);
        String name = nameCustomer.getText().toString();
//        Log.v("MainActivity", "Name: " + name);

        CheckBox checkBox = findViewById(R.id.checkbox_toppings);
        boolean hasWhippedCream = checkBox.isChecked();

        CheckBox checkbox2 = findViewById(R.id.checkbox_topping_2);
        boolean hasChocolate = checkbox2.isChecked();

        int price = calculatePrice(hasWhippedCream,hasChocolate);

        String priceMessage = createOrderSummary(price,hasWhippedCream,hasChocolate,name);
//        displayMessage(priceMessage);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "orders@coffeeshop.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava Order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        //        Button button = findViewById(R.id.button_order);
        //        button.setText("botoncito");
    }

    /**
     * Calculates the price of the order.
     *
     * @param addWhippedCream is wether or not the user wants whipped cream topping
     * @param addChocolate    is wether or not the user wants chocolate topping
     * @param hasWhippedCream
     * @param hasChocolate    @return is the final price to the order
     */

    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        // Price of 1 cup of coffee
        int basePrice = 5;

        // Add $1 if the user wants whipped cream
        if (addWhippedCream) {
            basePrice = basePrice + 1;
        }

        // Add $2 if the user wants chocolate
        if (addChocolate) {
            basePrice = basePrice + 2;
        }

        // Calculate the total order price by multiplying by quantity
        return quantity * basePrice;
    }

    /**
     * Create the summary of the order.
     *
     * @param price           of the order
     * @param hasWhippedCream is wheter or not to add whipped cream to the coffee
     * @param hasChocolate    is for Chocolate topping
     * @param name            of the customer
     * @return text summary
     */
    private String createOrderSummary(int price, boolean hasWhippedCream, boolean hasChocolate, String name) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nAdd whipped cream? " + hasWhippedCream;
        priceMessage += "\nAdd chocolate? " + hasChocolate;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank you!";
        return priceMessage;
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {
            Toast.makeText(this, "you cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);

    }


    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity < 1) {
            Toast.makeText(this, "you cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

//    /**
//     * This method displays the given quantity value on the screen.
//     */
//    private void display(int number) {
//        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
//        quantityTextView.setText("" + number);
//    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }


//    /**
//     * This method displays the given price on the screen.
//     */
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    /**
     * This method displays the given text on the screen.
     * <p>
     * <p>
     * Class displayMessage Method
     * -> We are creating a variable orderSummaryTextView
     * The data type of this variable was TextView.
     * <p>
     * -> We call a method on the TextView object OrderSummary.
     * We use the same variable name as declared up here (orderSummaryTextView).
     * <p>
     * -> Then we pass a string as an input to the method. This string message originally came
     * as an input parameter (String message) to the display message method.
     * <p>
     * -> It looks like findViewByld is a method call because its preceding parenthesis with what
     * looks like an input argument. But this method isn't defined anywhere in this class.
     * Where is this method defined?
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}