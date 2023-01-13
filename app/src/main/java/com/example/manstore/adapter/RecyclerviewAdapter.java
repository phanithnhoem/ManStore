package com.example.manstore.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.manstore.R;
import com.example.manstore.SearchFragment;
import com.example.manstore.model.Product;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.RecyclerviewHolder> {

    Context context;
    List<Product> productList;
    List<Product> filteredProductList;

    public void setFilteredList(List<Product> filteredList){
        this.productList = filteredList;
        notifyDataSetChanged();
    }

    public RecyclerviewAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
        this.filteredProductList = filteredProductList;
    }

    @NonNull
    @Override
    public RecyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycleview_row_item, parent, false);
        return new RecyclerviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerviewHolder holder, int position) {
        holder.productName.setText(productList.get(position).getProductName());
        holder.categoryName.setText(productList.get(position).getCategoryName());
        holder.price.setText(productList.get(position).getPrice());
        holder.productImage.setImageResource(productList.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static final class RecyclerviewHolder extends RecyclerView.ViewHolder {

        ImageView productImage;
        TextView productName, categoryName, price;
        public RecyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            productImage = itemView.findViewById(R.id.imgProduct);
            productName = itemView.findViewById(R.id.txtProductName);
            categoryName = itemView.findViewById(R.id.txtProductCategory);
            price = itemView.findViewById(R.id.txtPrice);
        }
    }

    public Filter getFiltered(){
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String key = charSequence.toString();
                if (key.isEmpty()){
                    filteredProductList = productList;
                }else{
                    List<Product> lstFiltered = new ArrayList<>();
                    for (Product row: productList){
                        if(row.getProductName().toLowerCase().contains(key.toLowerCase())){
                            lstFiltered.add(row);
                        }
                    }
                    filteredProductList = lstFiltered;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredProductList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                filteredProductList = (List<Product>)filterResults.values;
                notifyDataSetChanged();
            }
        };

    }
}
