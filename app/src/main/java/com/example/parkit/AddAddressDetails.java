package com.example.parkit;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AddAddressDetails extends AppCompatActivity {

    Button add = null;
    EditText address = null;
    EditText pinCode = null;
    EditText city = null;
    EditText state = null;
    EditText country = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_details);

        add = findViewById(R.id.add_button);
        address = findViewById(R.id.addressEditText);
        city = findViewById(R.id.cityEditText);
        country = findViewById(R.id.countryEditText);
        pinCode = findViewById(R.id.pinEditText);
        state = findViewById(R.id.stateEditText);

        add.setOnClickListener(view -> {
            String e_address = address.getText().toString();
            String e_pinCode = pinCode.getText().toString();
            String e_city = city.getText().toString();
            String e_state = state.getText().toString();
            String e_country = country.getText().toString();

            if(
                    e_address.isEmpty() && e_pinCode.isEmpty() && e_city.isEmpty() && e_state.isEmpty() && e_country.isEmpty()
            ) {
                setResult(RESULT_CANCELED);
            }
            else {
                int pin = 0;
                if(!e_pinCode.isEmpty())
                {
                    pin = Integer.parseInt(e_pinCode);
                }

                Intent intent = new Intent();
                AddressDetails data = new AddressDetails(e_address, pin, e_city, e_state, e_country);
                intent.putExtra(
                        "object",
                        data
                );
                setResult(RESULT_OK, intent);
            }
            finish();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity2_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.go_back) {
            setResult(RESULT_CANCELED);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
