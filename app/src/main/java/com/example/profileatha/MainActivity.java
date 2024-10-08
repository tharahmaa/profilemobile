package com.example.profileatha;

import android.graphics.Typeface;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi TextView untuk "Profil Saya"
        TextView textViewProfile = findViewById(R.id.textView);

        // Inisialisasi TextView untuk nama dan deskripsi
        TextView textViewName = findViewById(R.id.profileName);

        TextView textViewDescription = findViewById(R.id.profileDescription);

        // Inisialisasi tombol
        Button cvButton = findViewById(R.id.cvButton);
        Button portfolioButton = findViewById(R.id.portfolioButton);
        Button contactButton = findViewById(R.id.contactButton);

        // Set OnClickListener untuk setiap tombol
        cvButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CVActivity.class);
                startActivity(intent);
            }
        });

        portfolioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PortfolioActivity.class);
                startActivity(intent);
            }
        });

        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });
    }
}
