package com.myapplicationdev.android.mydatabook;

        import androidx.appcompat.app.ActionBar;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.drawerlayout.widget.DrawerLayout;
        import androidx.fragment.app.Fragment;
        import androidx.fragment.app.FragmentManager;
        import androidx.fragment.app.FragmentTransaction;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import com.google.android.material.floatingactionbutton.FloatingActionButton;

        import java.lang.reflect.Array;
        import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> drawerItems = new ArrayList<String>();
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    SomeAdapter aa;
    String currentTitle;
    ActionBar ab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList = findViewById(R.id.left_drawer);

        drawerItems = new ArrayList<String>();
        drawerItems.add("Bio");
        drawerItems.add("Vaccination");
        drawerItems.add("Anniversary");
        drawerItems.add("About Us");
        ab = getSupportActionBar();

        aa = new SomeAdapter(this,
                R.layout.row, drawerItems);
        drawerList.setAdapter(aa);

        // Set the list's click listener
        drawerList.setOnItemClickListener(new
                                                  AdapterView.OnItemClickListener(){
                                                      @Override
                                                      public void onItemClick(AdapterView<?> arg0, View arg1, int
                                                              position, long arg3) {
                                                          Intent i = new Intent(MainActivity.this,
                                                                  AboutUsActivity.class);
                                                          Fragment fragment = null;
                                                          if (position == 0)
                                                              fragment = new BioFragment();
                                                          else if (position == 1)
                                                              fragment = new VaccinationFragment();
                                                          else if (position == 2)
                                                              fragment = new AnniversaryFragment();
                                                          else if (position == 3)
                                                          startActivity(i);

                                                          FragmentManager fm = getSupportFragmentManager();
                                                          FragmentTransaction trans = fm.beginTransaction();
                                                          trans.replace(R.id.content_frame, fragment);
                                                          trans.commit();

                                                          // Highlight the selected item,
                                                          //  update the title, and close the drawer
                                                          drawerList.setItemChecked(position, true);
                                                          currentTitle = drawerItems.get(position);
                                                          ab.setTitle(currentTitle);
                                                          drawerLayout.closeDrawer(drawerList);
                                                      }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(drawerList);
            }
        });

    }
}
