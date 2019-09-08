package com.example.moviecatalogue;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_NAME= "EXTRA_NAME";
    TextView name,desc;
    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Res res = getIntent().getParcelableExtra(EXTRA_NAME);
        name = findViewById(R.id.txt_name);
        desc = findViewById(R.id.txt_description);
        photo =findViewById(R.id.img_movies);

        name.setText(res.getName());
        desc.setText(res.getDescription());
        photo.setImageResource(res.getPhoto());



    }


}
