package com.example.pharasayo;

import static com.facebook.FacebookSdk.getApplicationContext;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Notification_setting extends AppCompatActivity {
    ListView listView;
    String sTitle[] = {"Promotions", "Social Updates", "Activities"};
    String sSubTitle[] = {"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."};
    int images[] = {R.drawable.promo, R.drawable.update,R.drawable.activities};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_setting);

        listView = findViewById(R.id.ListView);
        classAdapter adapter = new classAdapter(this, sTitle, sSubTitle, images);
        listView.setAdapter(adapter);

    }
}

class classAdapter extends ArrayAdapter<String>{
    Context context;
    String cTitle[];
    String cSubtitle[];
    int cImgs[];

    classAdapter (Context c, String title[], String subtitle[], int imgs[]){
        super(c,R.layout.listitem, R.id.titleTxt,title);
        this.context = c;
        this.cTitle = title;
        this.cSubtitle = subtitle;
        this.cImgs = imgs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listitem = layoutInflater.inflate(R.layout.listitem, parent, false);
        ImageView imgView = listitem.findViewById(R.id.imgView);
        TextView titleTxt = listitem.findViewById(R.id.titleTxt);
        TextView subTitletxt = listitem.findViewById(R.id.subTitleTxt);

        imgView.setImageResource(cImgs[position]);
        titleTxt.setText(cTitle[position]);
        subTitletxt.setText(cSubtitle[position]);

        return listitem;
    }
}


