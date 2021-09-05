package com.recycler.agendacontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.recycler.agendacontactos.adapters.PagerAdapterTabsInicial;

public class MainActivity extends AppCompatActivity {

    private PagerTabStrip tabStrip;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PagerAdapterTabsInicial tabsInicial = new PagerAdapterTabsInicial(getSupportFragmentManager());
        pager = findViewById(R.id.pager);
        pager.setAdapter(tabsInicial);
        tabStrip = findViewById(R.id.tab_strip);
        tabStrip.setTextColor(Color.WHITE);
        tabStrip.setTabIndicatorColor(Color.WHITE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add, menu);
        return true;
    }
}