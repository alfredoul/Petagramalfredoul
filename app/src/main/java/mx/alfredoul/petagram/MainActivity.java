package mx.alfredoul.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import mx.alfredoul.petagram.adapter.PageAdapter;
import mx.alfredoul.petagram.adapter.RVAdaptador;
import mx.alfredoul.petagram.fragment.MascotaFragment;
import mx.alfredoul.petagram.fragment.RecyclerviewFragment;
import mx.alfredoul.petagram.pojo.Pet;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)  findViewById(R.id.toolbar);
        tabLayout=(TabLayout)  findViewById(R.id.tabLayout);
        viewPager=(ViewPager)  findViewById(R.id.viewPager);
        setUpViewPager();

        if (toolbar!= null) {
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new RecyclerviewFragment());
        fragments.add(new MascotaFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("Home");
        tabLayout.getTabAt(1).setText("MyPet");
        //tabLayout.getTabAt(1).setIcon(R.drawable.ic_perm_identity_white);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFavoritos:
                Intent intent = new Intent(this, ActivityFavoritos.class);
                startActivity(intent);
                break;
            case R.id.mContact:
                Intent intent1 = new Intent (this, ContactActivity.class);
                startActivity(intent1);;
                break;
            case R.id.mAbout:
                Intent intent2=new Intent(this,AboutActivity.class);
                startActivity(intent2);
        }
        return super.onOptionsItemSelected(item);
    }

}