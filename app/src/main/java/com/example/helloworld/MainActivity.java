package com.example.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.Snackbar;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        final EditText textbox = findViewById(R.id.editText_name);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = textbox.getText().toString();
                name = "Hello "+ name +"!";

                textbox.setText("");

                if (name.length() == 7)
                    Snackbar.make(view, "Ohh, that's not a valid name!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                else
                    Snackbar.make(view, (String)name, Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });


    }
}
