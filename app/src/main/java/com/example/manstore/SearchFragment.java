package com.example.manstore;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.manstore.adapter.RecyclerviewAdapter;
import com.example.manstore.model.Product;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {
    RecyclerView productRecycler;
    RecyclerviewAdapter recyclerviewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        productRecycler = view.findViewById(R.id.productRecyclerFragment);

        //Declaration obj
        List<Product> productList = new ArrayList<>();

        //Assign values to obj
        productList.add(new Product("Ratchet Belt", "Belt", "$125.12", R.drawable.belt_one));
        productList.add(new Product("Chronograph Analog Quartz", "Watch", "$125.12", R.drawable.watch_one));
        productList.add(new Product("Leather Dress Belt", "Belt", "$125.12", R.drawable.belt_two));

        productList.add(new Product("Snapback Hats for Men", "Hat", "$125.12", R.drawable.hat_three));

        productList.add(new Product("Classic Dress Belt", "Belt", "$125.12", R.drawable.belt_three));
        productList.add(new Product("Ratchet Belt Dress", "Belt", "$125.12", R.drawable.belt_four));

        productList.add(new Product("Fusion of Technology", "Watch", "$125.12", R.drawable.watch_three));
        productList.add(new Product("Ted Baker 38 mm Poppiey", "Watch", "$125.12", R.drawable.watch_four));

        productList.add(new Product("LANGZHEN Unisex Baseball Cap", "Hat", "$125.12", R.drawable.hat_one));
        productList.add(new Product("TSSGBL Classic 100% Cotton", "Hat", "$125.12", R.drawable.hat_two));

        productList.add(new Product("Ted Baker 43 mm Phylipa", "Watch", "$125.12", R.drawable.watch_two));
        productList.add(new Product("CACUSS Mens Baseball Cap", "Hat", "$125.12", R.drawable.hat_four));


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        productRecycler.setLayoutManager(layoutManager);
        recyclerviewAdapter = new RecyclerviewAdapter(getContext(), productList);
        productRecycler.setAdapter(recyclerviewAdapter);

        return view;
    }

}