
package com.example.litesql;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button b1, b2;
    TextView t1;
    DatabaseHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.e1);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        t1 = findViewById(R.id.t1);

        // Initialize the database helper
        dbhelper = new DatabaseHelper(this);
    }

    public void addme(View view) {

        String name = e1.getText().toString().trim();

        if (name.isEmpty()) {
            e1.setError("Please enter a name");
            return;
        }

        if (dbhelper.addName(name)) {
            Toast.makeText(
                    this, "Name added",
                    Toast.LENGTH_SHORT
            ).show();

            e1.setText("");
        } else {
            Toast.makeText(
                    this, "Failed to add name",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    public void show(View view) {
        String names = dbhelper.getAllNames();
        t1.setText(names);
    }
}
