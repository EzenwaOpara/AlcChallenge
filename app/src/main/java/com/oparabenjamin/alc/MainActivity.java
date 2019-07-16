package com.oparabenjamin.alc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("ALC 4 Phase 1");
    }

    public void moveToProfile(View view) {
        startActivity(new Intent(this, ProfileActivity.class));
    }

    public void moveToAbout(View view) {
        startActivity(new Intent(this, AlcAboutActivity.class));

    }
}
