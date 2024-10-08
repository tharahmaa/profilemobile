package com.example.profileatha;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class ContactActivity extends AppCompatActivity {
    private MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the osmdroid configuration
        Configuration.getInstance().setUserAgentValue(getPackageName());

        setContentView(R.layout.activity_contact);

        // Set up the back button to finish the current activity
        Button backButton = findViewById(R.id.backToHomeButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close the current activity
            }
        });

        // Set up click listeners for the various TextViews
        setUpLink(R.id.instagram, "https://www.instagram.com/tharahmaa/");
        setUpLink(R.id.linkedin, "https://www.linkedin.com/in/atharahmaarianti");
        setUpLink(R.id.github, "https://github.com/tharahmaa");
        setUpPhoneCall(R.id.phone, "082115595576");
        setUpLink(R.id.alamat, "https://www.google.com/maps/search/?api=1&query=Tower 2 ITS");

        // Initialize and set up the map
        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setMultiTouchControls(true);

        GeoPoint startPoint = new GeoPoint(-7.2819705, 112.795323);
        map.getController().setZoom(18.5);
        map.getController().setCenter(startPoint);

        Marker marker = new Marker(map);
        marker.setPosition(startPoint);
        marker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker.setTitle("Tower 2 ITS");
        map.getOverlays().add(marker);
    }

    @Override
    public void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        map.onPause();
    }

    // Helper method to set up link click listeners
    private void setUpLink(int textViewId, String url) {
        TextView textView = findViewById(textViewId);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUrl(url);
            }
        });
    }

    private void setUpPhoneCall(int textViewId, String phoneNumber) {
        TextView textView = findViewById(textViewId);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(phoneNumber);
            }
        });
    }

    // Method to open a URL in the browser
    private void openUrl(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

    private void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        startActivity(intent);
    }
}