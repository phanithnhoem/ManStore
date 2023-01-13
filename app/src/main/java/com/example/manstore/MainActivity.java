package com.example.manstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;


public class MainActivity extends AppCompatActivity {

    //Initialize variable
    MeowBottomNavigation bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNav = (MeowBottomNavigation) findViewById(R.id.bottomNav);
        MeowBottomNavigation.Model model1 = new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24);
        bottomNav.add(model1);
        bottomNav.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_search_24));
        bottomNav.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_shopping_cart_24));
        bottomNav.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_notifications_24));
        bottomNav.add(new MeowBottomNavigation.Model(5, R.drawable.ic_baseline_settings_24));
        bottomNav.setCount(4, "8");
        replace(new HomeFragment());

       bottomNav.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
           @Override
           public Unit invoke(MeowBottomNavigation.Model model) {
               switch(model.getId()){
                   case 1:
                       replace(new HomeFragment());
                       break;
                   case 2:
//                       startActivity(new Intent(MainActivity.this, SearchActivity.class));
                       replace(new SearchFragment());
                       break;
                   case 3:
                       replace(new CartFragment());
                       break;
                   case 4:
                       replace(new NotificationFragment());
                       break;
                   case 5:
                       replace(new SettingFragment());
                       break;
               }
               return null;
           }
       });
        bottomNav.show(1, true);
    }

    private void replace(Fragment fragment) {
       FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
       transaction.replace(R.id.nav_host_fragment_container, fragment);
       transaction.commit();
    }
}