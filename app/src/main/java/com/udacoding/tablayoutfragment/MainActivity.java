package com.udacoding.tablayoutfragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.udacoding.tablayoutfragment.fragment.FirstFragment;
import com.udacoding.tablayoutfragment.fragment.SecondFragment;
import com.udacoding.tablayoutfragment.fragment.ThirdFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        PagerAdapterCustom adapterCustom = new PagerAdapterCustom(getSupportFragmentManager());
        TabLayout tabLayout = findViewById(R.id.tablayout);
        ViewPager pager = findViewById(R.id.pager);

        pager.setAdapter(adapterCustom);

        tabLayout.setupWithViewPager(pager);
    }



    class PagerAdapterCustom extends FragmentPagerAdapter{

        public PagerAdapterCustom(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            if(position == 0){
                return new FirstFragment();
            }
            else if (position == 1){
                return  new SecondFragment();
            }
            else{
                return new ThirdFragment();
            }

        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0){
                return "Tab 1";
            }
            else if(position == 1){
                return  "Tab 2";
            }
            else {
                return  "tab 3";
            }

        }
    }
}