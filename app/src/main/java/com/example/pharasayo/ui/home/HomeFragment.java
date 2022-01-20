package com.example.pharasayo.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.pharasayo.ProductAdapter;
import com.example.pharasayo.ProductInfo;
import com.example.pharasayo.R;
import com.example.pharasayo.databinding.ActivityMainBinding;
import com.example.pharasayo.databinding.FragmentHomeBinding;

import org.xmlpull.v1.XmlPullParser;

public class HomeFragment extends Fragment {

    private View view;
    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;


    @NonNull FragmentHomeBinding bindingProduct;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        bindingProduct = FragmentHomeBinding.inflate(getLayoutInflater());
        View root1 = bindingProduct.getRoot();

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        //button
        Button btn1 = (Button) root.findViewById(R.id.addToCart);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProductInfo.class);
                getActivity().startActivity(intent);
            }
        });


        /*final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/

        String[] productName = {"Medicine Name", "Medicine Name", "Medicine Name", "Medicine Name", "Medicine Name", "Medicine Name"};
        String[] productPrice = {"PHP 100.00", "PHP 100.00", "PHP 100.00", "PHP 100.00", "PHP 100.00", "PHP 100.00",};
        int[] productImages = {R.drawable.biogesic, R.drawable.biogesic, R.drawable.biogesic, R.drawable.biogesic, R.drawable.biogesic, R.drawable.biogesic,};

        ProductAdapter gridAdapter = new ProductAdapter(getActivity(),productName,productPrice,productImages);
        //GridView prodgrid = (GridView) root1.findViewById(R.id.product_categories);
        //prodgrid.setAdapter(gridAdapter);
        //prodgrid.setAdapter(new ProductAdapter(getActivity(),productName,productPrice,productImages));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}