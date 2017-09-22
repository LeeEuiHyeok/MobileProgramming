package com.example.leeeh.phtogallery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mainImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainImage = (ImageView) findViewById(R.id.imageView);

    }

    public void imageClick(View view){
        switch (view.getId()){
            case R.id.imageView2:
                mainImage.setImageResource(R.drawable.apple);
                break;
            case R.id.imageView3:
                mainImage.setImageResource(R.drawable.grape);
                break;
            case R.id.imageView4:
                mainImage.setImageResource(R.drawable.banana);
                break;
            case R.id.imageView5:
                mainImage.setImageResource(R.drawable.strawberry);
                break;
        }

    }
}
