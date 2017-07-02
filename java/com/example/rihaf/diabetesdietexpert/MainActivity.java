package com.example.rihaf.diabetesdietexpert;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        FrameLayout buttondb = (FrameLayout) findViewById(R.id.buttondb);//DELETE THIS LATER!!!//
        Button yourButton = (Button) findViewById(R.id.buttonhome);



//******
//******
//******
//---------------------------------------START OF : MAIN BUTTON METHOD-----------------------------------------------//
        yourButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

                Cursor res = myDb.getAllData();

                if(res.getCount()==0)
                startActivity(new Intent(MainActivity.this, FirstSetupActivity.class));
                    else
                        startActivity(new Intent(MainActivity.this, DataListActivityGol.class));

            }
        });
//---------------------------------------END OF : MAIN BUTTON METHOD-----------------------------------------------//
//******
//******
//******
//--------------------------------------------TEMPORARY BUTTON. DELETE THIS LATER---------------------//
        buttondb.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
            startActivity(new Intent (MainActivity.this, DbControl.class));
                }
        });

//--------------------------------------------TEMPORARY BUTTON. DELETE THIS LATER---------------------//


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

//-----------------Device Back Button Pressed Actions ------------------------------//
    @Override
    public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
      if (drawer.isDrawerOpen(GravityCompat.START)) {
          drawer.closeDrawer(GravityCompat.START);
       } else {
           super.onBackPressed();
          Intent intent = new Intent(Intent.ACTION_MAIN);
          intent.addCategory(Intent.CATEGORY_HOME);
          intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          startActivity(intent);
      }
   }
//-----------------End of Device Back Button Pressed Actions ------------------------------//

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_home:

                Cursor res = myDb.getAllData();

                if(res.getCount()==0){
                    startActivity(new Intent(MainActivity.this, FirstSetupActivity.class));}
                else{
                    startActivity(new Intent(MainActivity.this, DataListActivity.class));}
              //  Intent a = new Intent(MainActivity.this, DataListActivity.class);
               // startActivity(a);
                break;

            case R.id.nav_dietplan:
                Cursor res1 = myDb.getAllData();
                if(res1.getCount()==0){
                    startActivity(new Intent(MainActivity.this, FirstSetupActivity.class));}
                else{
                    startActivity(new Intent(MainActivity.this, DataListActivityGol.class));}
              //  Intent b = new Intent(MainActivity.this, DataListActivityGol.class);
               // startActivity(b);
                break;

            case R.id.nav_journal:
                Cursor res2 = myDb.getAllData();
                if(res2.getCount()==0){
                    startActivity(new Intent(MainActivity.this, FirstSetupActivity.class));}
                else{
                    startActivity(new Intent(MainActivity.this, dietplan2Activity.class));}
                break;

            case R.id.nav_foodlist:
                Cursor res3 = myDb.getAllData();
                if(res3.getCount()==0){
                    startActivity(new Intent(MainActivity.this, FirstSetupActivity.class));}
                else{
                    startActivity(new Intent(MainActivity.this, DataListActivityFoodlist.class));}
                //Do some thing here
                // add navigation drawer item onclick method here
                break;
            case R.id.nav_history:
                Cursor res4 = myDb.getAllData();
                if(res4.getCount()==0){
                    startActivity(new Intent(MainActivity.this, FirstSetupActivity.class));}
                else{
                    startActivity(new Intent(MainActivity.this, HistoryActivity.class));}
                break;
            case R.id.nav_reminder:
                Cursor res5 = myDb.getAllData();
                if(res5.getCount()==0){
                    startActivity(new Intent(MainActivity.this, FirstSetupActivity.class));}
                else{
                    startActivity(new Intent(MainActivity.this, ReminderActivity.class));}
                break;
            case R.id.nav_settings:
                Intent g = new Intent(MainActivity.this, InfoDiabetes.class);
                startActivity(g);
                break;
            case R.id.nav_about:
                Intent h = new Intent(MainActivity.this, aboutActivity.class);
                startActivity(h);
                break;
        }
        return false;


    }



}
