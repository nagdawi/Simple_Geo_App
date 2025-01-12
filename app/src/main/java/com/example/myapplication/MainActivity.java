package com.example.myapplication;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if Geocoder is present
        if (Geocoder.isPresent()) {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
    
            try {
                // Example: Get a list of addresses for a location (latitude, longitude)
                double latitude = 37.7749;
                double longitude = -122.4194;
                List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);

                if (addresses != null && !addresses.isEmpty()) {
                    Address address = addresses.get(0);
                    String addressLine = address.getAddressLine(0);
                    Toast.makeText(this, "Address: " + addressLine, Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "No address found", Toast.LENGTH_LONG).show();
                }

            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(this, "Geocoder service not available", Toast.LENGTH_LONG).show();
            }
        } else {
            // Geocoder implementation is not available
            Toast.makeText(this, "Geocoder not supported on this device", Toast.LENGTH_LONG).show();
        }
    }
}
