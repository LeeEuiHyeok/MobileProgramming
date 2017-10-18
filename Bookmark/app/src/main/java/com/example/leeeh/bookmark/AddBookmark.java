package com.example.leeeh.bookmark;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by LeeEH on 2017-10-18.
 */

public class AddBookmark extends AppCompatActivity{
    EditText title = null;
    EditText url = null;
    TextFileManager tfm = new TextFileManager(this);

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bookmark);
        title = (EditText)findViewById(R.id.editText);
        url = (EditText)findViewById(R.id.editText2);
    }
    public void addClick(View v){
        String getTitle = title.getText().toString();
        String getUrl = url.getText().toString();
        tfm.save(getTitle, getUrl);

        title.setText("");
        url.setText("");

        Toast.makeText(this, "추가 완료", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AddBookmark.this, MainActivity.class);
        startActivity(intent);
    }
}
