package com.example.parkit;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int ADD_DETAILS = 1;
    RecyclerView rView = null;
    List<AddressDetails> addressList = new ArrayList<>();
    AddressListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addressList.add(
                new AddressDetails(
                        "Sector 16 C",
                        110078,
                        "Dwarka",
                        "Delhi",
                        "India"));
        addressList.add(
                new AddressDetails(
                        "Opposite TV Tower",
                        110034,
                        "Pitam Pura",
                        "New Delhi",
                        "India"));

        rView = findViewById(R.id.recyclerView);
        adapter = new AddressListAdapter(this, addressList);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        rView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add_yours) {
            Intent intent = new Intent(this, AddAddressDetails.class);
            startActivityForResult(intent, ADD_DETAILS);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            addressList.add(0, (AddressDetails) data.getSerializableExtra("object"));
            adapter.notifyItemInserted(0);
        }
    }
}