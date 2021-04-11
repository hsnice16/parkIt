package com.example.parkit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AddressListAdapter extends RecyclerView.Adapter<AddressListAdapter.ViewHolder> {
    private final List<AddressDetails> addressList;
    private final Context context;

    public AddressListAdapter(Context context , List<AddressDetails> addressList){
        this.addressList = addressList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.address_list, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final AddressDetails data = addressList.get(position);
        holder.address.setText(data.getAddress());

        String pinCode;
        if(data.getPinCode() == 0) {
            pinCode="";
        } else {
            pinCode = String.valueOf(data.getPinCode());
        }

        holder.pinCode.setText(pinCode);
        holder.city.setText(data.getCity());
        holder.state.setText(data.getState());
        holder.country.setText(data.getCountry());

        holder.button.setOnClickListener(view -> {
            String st_co = holder.state.getText().toString().concat(holder.country.getText().toString());
            String pi_ci = holder.city.getText().toString().concat(holder.pinCode.getText().toString());

            String pi_ci_st_co = pi_ci.concat(st_co);
            String completeAddress = holder.address.getText().toString().concat(pi_ci_st_co);

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:0,0?q=" + Uri.encode(completeAddress)));
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder {
        public TextView address;
        public TextView pinCode;
        public TextView city;
        public TextView state;
        public TextView country;
        public Button button;

        public ViewHolder(View itemView){
            super(itemView);

            this.address = itemView.findViewById(R.id.address);
            this.pinCode = itemView.findViewById(R.id.pin_code);
            this.city = itemView.findViewById(R.id.city);
            this.state = itemView.findViewById(R.id.state);
            this.country = itemView.findViewById(R.id.country);
            this.button = itemView.findViewById(R.id.view_button);
        }
    }
}
