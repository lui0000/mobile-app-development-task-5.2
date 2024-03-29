package com.example.myapplication;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class NavFragment1 extends Fragment implements ProductAdapter.OnProductClickListener {

    public NavFragment1() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nav1, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.nav_host_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        String[] productNames = getResources().getStringArray(R.array.userName);
        List<Product> productList = new ArrayList<>();

        int[] productImages = {R.drawable.product1, R.drawable.product2, R.drawable.product3};

        for (int i = 0; i < productNames.length; i++) {
            Product product = new Product(productNames[i], productImages[i]);
            productList.add(product);
        }


        ProductAdapter productAdapter = new ProductAdapter(productList, this);
        recyclerView.setAdapter(productAdapter);

        return view;
    }

    @Override
    public void onProductClick(Product product) {
        Toast.makeText(getActivity(), "Clicked on " + product.getName(), Toast.LENGTH_SHORT).show();
        switch (product.getName()) {
            case "Apple":
                Navigation.findNavController(getView()).navigate(R.id.action_navFragment1_to_navFragment2);
                break;
            case "Broccoli":
                Navigation.findNavController(getView()).navigate(R.id.action_navFragment1_to_navFragment3);
                break;
            case "Milk":
                Navigation.findNavController(getView()).navigate(R.id.action_navFragment1_to_navFragment4);
                break;
        }

    }
}

