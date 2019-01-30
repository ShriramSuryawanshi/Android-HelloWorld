package com.example.helloworld;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.Snackbar;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    boolean first = true;
    boolean endApp = false;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        final EditText textbox = findViewById(R.id.editText_name);

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                if(endApp){

                    finishAndRemoveTask();
                    System.exit(0);
                }

                if (first) {

                    name = textbox.getText().toString();
                    textbox.setText("");

                    if (name.length() == 0)
                        Snackbar.make(view, "Ohh, that can't be your name!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    else {
                        String msg = "Hello " + name + "! Welcome! Now, let's Hi5!!";
                        Snackbar.make(view, (String) msg, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        first = false;

                        TextView label1 = findViewById(R.id.text_hello);
                        TextView label2 = findViewById(R.id.text_name);

                        textbox.setVisibility(View.GONE);
                        label1.setVisibility(View.GONE);
                        label2.setVisibility(View.GONE);
                    }
                }

                if(!first) {

                    Button button = findViewById(R.id.button);
                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) button.getLayoutParams();

                    Random rand = new Random();
                    float x = rand.nextFloat();
                    float y = rand.nextFloat();

                    params.height = params.height - 25;
                    params.width = params.width - 25;

                    if (params.height < 40 || params.width < 40){

                        String msg = "Bye " + name + "!";
                        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).setAction("Action", null).show();

                        endApp = true;
                    }
                    else {

                        params.horizontalBias = x;
                        params.verticalBias = y;

                        button.setLayoutParams(params);
                    }
                }
            }
        });
    }
}


