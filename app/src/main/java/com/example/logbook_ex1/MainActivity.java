package com.example.logbook_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ImageView imageView;
Button preButton, nextButton;
ArrayList<String> listImageUrl;
int imageIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        preButton = findViewById(R.id.button_prev);
        nextButton = findViewById(R.id.button_next);

        //add image to array
        listImageUrl = new ArrayList<>();
        listImageUrl.add("https://www.apple.com/v/iphone-14-pro/a/images/meta/iphone-14-pro_overview__e2a7u9jy63ma_og.png?202209282359");
        listImageUrl.add("https://media.techz.vn/media2019/upload2019/2022/08/28/cuando-sale-el-iphone-14.jpeg");
        listImageUrl.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9kruEJ7cqNS_qIYgIrAloVCv5iu1ut_JhiIQnqnSH-qq6S0jVgKf2U_YOdXzVHTttOI0&usqp=CAU");

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
    }
    void displayImages(){
        Picasso.get().load(listImageUrl.get(imageIndex)).resize(900, 700).into(imageView);
    }
}