package com.example.justdoit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class newstab extends AppCompatActivity {

    ViewPager simpleViewPager;
    TabLayout tabLayout;
    TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newstab);
// get the reference of ViewPager and TabLayout
        simpleViewPager = (ViewPager) findViewById(R.id.simpleViewPager);
        tabLayout = (TabLayout) findViewById(R.id.simpleTabLayout);
// Create a new Tab named "First"
        TabLayout.Tab firstTab = tabLayout.newTab();
        firstTab.setText("BBC"); // set the Text for the first Tab
        firstTab.setIcon(R.drawable.logo2); // set an icon for the
// first tab
        tabLayout.addTab(firstTab); // add  the tab at in the TabLayout
// Create a new Tab named "Second"
        TabLayout.Tab secondTab = tabLayout.newTab();
        secondTab.setText("Fox"); // set the Text for the second Tab
        secondTab.setIcon(R.drawable.logo2); // set an icon for the second tab
        tabLayout.addTab(secondTab); // add  the tab  in the TabLayout
// Create a new Tab named "Third"
        TabLayout.Tab thirdTab = tabLayout.newTab();
        thirdTab.setText("NYC"); // set the Text for the first Tab
        thirdTab.setIcon(R.drawable.logo3); // set an icon for the first tab
        tabLayout.addTab(thirdTab); // add  the tab at in the TabLayout






        com.example.justdoit.PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        simpleViewPager.setAdapter(adapter);
// addOnPageChangeListener event change the tab on slide
        simpleViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}