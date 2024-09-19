package com.reyaan.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private EditText editTextNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView2);
        editTextNumber = findViewById(R.id.editTextNumber);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the input value from the EditText
                String input = editTextNumber.getText().toString();

                // Check if input is not empty
                if (!input.isEmpty()) {
                    try {
                        // Convert the input value to a double
                        double cmValue = Double.parseDouble(input);

                        // Convert centimeters to meters
                        double meterValue = cmValue / 100;

                        // Display the result in the TextView
                        textView.setText("Result: " + meterValue + " meters");
                    } catch (NumberFormatException e) {
                        // Show an error message if the input is invalid
                        Toast.makeText(MainActivity.this, "Please enter a valid number", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Show a toast message if no input is given
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;