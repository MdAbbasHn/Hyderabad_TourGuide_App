package com.examples.tourguideapp;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Attraction extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.attraction);
        Intent mIntent = getIntent();
        Category current = (Category) mIntent.getParcelableExtra("UniqueKey");
        TextView title = (TextView) findViewById(R.id.title_att);
        title.setText(current.getName());
        TextView textView = (TextView) findViewById(R.id.description);
        textView.setText(current.getDescr());
        ImageView img = (ImageView) findViewById(R.id.att_image);
        img.setImageResource(current.getImageId());
        String cur = current.getLoc();
        if(cur==null){
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.icons);
            linearLayout.setVisibility(View.GONE);

        }
        else{
            ImageView phone = (ImageView) findViewById(R.id.call);

            phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+ current.getNumber()));
                    startActivity(intent);
                }
            });
            ImageView website = (ImageView) findViewById(R.id.web);
            website.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(current.getLink()));
                    startActivity(i);
                }
            });
            ImageView location = (ImageView) findViewById(R.id.map);
            location.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("geo:"+current.getLoc()));
                    startActivity(i);
                }
            });
        }
        if(current.getTiming()!=null){
            TextView time = (TextView) findViewById(R.id.timing);
            time.setText(current.getTiming());
        }

    }
}
