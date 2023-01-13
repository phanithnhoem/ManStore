package com.example.manstore;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.Random;

public class HomeFragment extends Fragment implements View.OnClickListener {

    ImageSlider imageSlider;
    LinearLayout layoutBelt, layoutWatch, layoutCap, layoutGlasses, layoutWallet, layoutShoe, layoutSock, layoutPerfume;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        layoutBelt = view.findViewById(R.id.layoutBelt);
        layoutWatch = view.findViewById(R.id.layoutWatch);
        layoutCap = view.findViewById(R.id.layoutCap);
        layoutGlasses = view.findViewById(R.id.layoutGlasses);
        layoutWallet = view.findViewById(R.id.layoutWallet);
        layoutShoe = view.findViewById(R.id.layoutShoe);
        layoutSock = view.findViewById(R.id.layoutSock);
        layoutPerfume = view.findViewById(R.id.layoutPerfume);

        imageSlider = view.findViewById(R.id.imageSlider);

        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://img.freepik.com/free-vector/super-sale-horizontal-banner_52683-59532.jpg?w=2000", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://img.freepik.com/free-vector/gradient-colored-sale-background_52683-68460.jpg?w=2000", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.creativefabrica.com/wp-content/uploads/2020/09/12/Special-offer-mega-sale-banner-promotion-Graphics-5443532-1.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.creativefabrica.com/wp-content/uploads/2020/12/09/Big-sale-banner-promotion-background-Graphics-7082393-1.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://img.freepik.com/vector-premium/promocion-banner-super-venta_131000-345.jpg?w=2000", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://www.crushpixel.com/big-static14/preview4/mega-sale-banner-poster-50-1565699.jpg", ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        layoutBelt.setOnClickListener(this);
        layoutWatch.setOnClickListener(this);
        layoutCap.setOnClickListener(this);
        layoutGlasses.setOnClickListener(this);
        layoutWallet.setOnClickListener(this);
        layoutShoe.setOnClickListener(this);
        layoutSock.setOnClickListener(this);
        layoutPerfume.setOnClickListener(this);

        //Control color changing on Banner Title
        TextView lblBannerTitle = view.findViewById(R.id.lblBannerTitle);
        Thread thread = new Thread()
        {
            public void run()
            {
                while (true){
                    Random myColor = new Random();
                    lblBannerTitle.setTextColor(Color.rgb(myColor.nextInt(255), myColor.nextInt(255), myColor.nextInt(255)));
                    try
                    {
                        Thread.sleep(1000); // 1 second
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.layoutBelt:
                Intent intentBelt = new Intent(getActivity(), CategoryActivity.class);
                intentBelt.putExtra("CategoryName", "Belt Category");
                startActivity(intentBelt);
                break;
            case R.id.layoutWatch:
                Intent intentWatch = new Intent(getActivity(), CategoryActivity.class);
                intentWatch.putExtra("CategoryName", "Watch Category");
                startActivity(intentWatch);
                break;
            case R.id.layoutCap:
                Intent intentCap = new Intent(getActivity(), CategoryActivity.class);
                intentCap.putExtra("CategoryName", "Cap Category");
                startActivity(intentCap);
                break;
            case R.id.layoutGlasses:
                Intent intentGlasses = new Intent(getActivity(), CategoryActivity.class);
                intentGlasses.putExtra("CategoryName", "Classes Category");
                startActivity(intentGlasses);
            case R.id.layoutWallet:
                Intent intentWallet = new Intent(getActivity(), CategoryActivity.class);
                intentWallet.putExtra("CategoryName", "Wallet Category");
                startActivity(intentWallet);
                break;
            case R.id.layoutShoe:
                Intent intentShoe = new Intent(getActivity(), CategoryActivity.class);
                intentShoe.putExtra("CategoryName", "Shoe Category");
                startActivity(intentShoe);
                break;
            case R.id.layoutSock:
                Intent intentSock = new Intent(getActivity(), CategoryActivity.class);
                intentSock.putExtra("CategoryName", "Sock Category");
                startActivity(intentSock);
                break;
            case R.id.layoutPerfume:
                Intent intentPerfume = new Intent(getActivity(), CategoryActivity.class);
                intentPerfume.putExtra("CategoryName", "Perfume Category");
                startActivity(intentPerfume);
                break;
        }
    }
}