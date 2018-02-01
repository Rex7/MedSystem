package com.example.regis.medsystem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView nav;
    Snackbar snackbar;
    ImageView coverImage, fav, bookmark, share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nav = (NavigationView) findViewById(R.id.nav);
        nav.setNavigationItemSelectedListener(this);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        coverImage = (ImageView) findViewById(R.id.medCover);
        fav = (ImageView) findViewById(R.id.fav);
        bookmark = (ImageView) findViewById(R.id.bookmark);
        share = (ImageView) findViewById(R.id.share_art);
        fav.setOnClickListener(this);
        bookmark.setOnClickListener(this);
        share.setOnClickListener(this);
        Glide.with(this).load(R.drawable.medimage)
                .into(coverImage);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.open_navigation, R.string.close_navigation);


        drawerLayout.addDrawerListener(actionBarDrawerToggle);


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.Med)
            startActivity(new Intent(this, Medicine.class));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.search:
                snackbar = Snackbar.make(getCurrentFocus(), "Search", Snackbar.LENGTH_SHORT)
                        .setActionTextColor(Color.BLUE)
                        .setAction("Hey am in search", null);
                snackbar.show();
                break;
            case R.id.share:
                snackbar = Snackbar.make(getCurrentFocus(), "Share", Snackbar.LENGTH_SHORT)
                        .setActionTextColor(Color.BLUE)
                        .setAction("Share", null);
                snackbar.show();

        }
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fav:
                snackbar = Snackbar.make(v, "favorite", Snackbar.LENGTH_SHORT)
                        .setAction("Fav", null)
                        .setActionTextColor(Color.RED);
                snackbar.show();
                break;
            case R.id.share_art:
                snackbar = Snackbar.make(v, "share", Snackbar.LENGTH_SHORT)
                        .setAction("bookmark", null)
                        .setActionTextColor(Color.RED);
                snackbar.show();
                break;
            case R.id.bookmark:
                snackbar = Snackbar.make(v, "bookmark", Snackbar.LENGTH_SHORT)
                        .setAction("bookmark", null)
                        .setActionTextColor(Color.RED);
                snackbar.show();
                break;

        }
    }
}
