package com.example.logbook_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
Button preButton, nextButton, addImage;
ArrayList<String> listImageUrl;
    EditText urlImage;
int imageIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        preButton = findViewById(R.id.button_prev);
        nextButton = findViewById(R.id.button_next);
        urlImage = findViewById(R.id.urlImage);


        //add image to array
        listImageUrl = new ArrayList<>();

        //set image index first
        imageIndex = 1;
        displayImages();

        //button previous
        preButton = findViewById(R.id.button_prev);
        preButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(imageIndex == 0)
                {
                    imageIndex = listImageUrl.size() -1;
                }
                else{
                    imageIndex -= 1;
                }
                displayImages();
            }
        });
        //button next
        nextButton = findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int lastIndex = listImageUrl.size() -1;
                if(imageIndex == lastIndex)
                {
                    imageIndex = 0;
                }
                else{
                    imageIndex += 1;
                }
                displayImages();
            }
        });
        addImage = findViewById(R.id.buttonAdd);
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String img = urlImage.getText().toString().trim();
                if (img.length() != 0) {
                    if (URLUtil.isValidUrl(img)) {
                        listImageUrl.add(img);
                        imageIndex = listImageUrl.size() - 1;
                        urlImage.setText("");
                        displayImages();
                    } else {
                        Toast.makeText(
                                MainActivity.this,
                                "Url is incorrect!", Toast.LENGTH_LONG
                        ).show();
                    }
                } else {
                    Toast.makeText(
                            MainActivity.this,
                            "Url is null. Please check valid input!",
                            Toast.LENGTH_LONG
                    ).show();
                }
            }
        });
    }
    void displayImages(){
        Toast.makeText(this, "Loading...", Toast.LENGTH_LONG).show();
        Picasso.get().load(listImageUrl.get(imageIndex)).resize(900, 700).into(imageView);
    }
}