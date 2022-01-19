package com.example.pharasayo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.pharasayo.ui.home.HomeFragment;

public class ProductAdapter extends BaseAdapter {

    FragmentActivity context;
    String[] productName;
    String[] productPrice;
    int[] image;

    LayoutInflater inflater;

    public ProductAdapter(FragmentActivity context, String[] productName, String[] productPrice, int[] image) {
        this.context = context;
        this.productName = productName;
        this.productPrice = productPrice;
        this.image = image;
    }


    @Override
    public int getCount() {
        return productName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null) {
            inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){

            convertView = inflater.inflate(R.layout.products_item, null);

        }

        ImageView imageView = convertView.findViewById(R.id.product_pic);
        TextView textView1 = convertView.findViewById(R.id.product_name);
        TextView textView2 = convertView.findViewById(R.id.product_price);

        imageView.setImageResource(image[position]);
        textView1.setText(productName[position]);
        textView2.setText(productPrice[position]);

        }


        return convertView;
    }
}
