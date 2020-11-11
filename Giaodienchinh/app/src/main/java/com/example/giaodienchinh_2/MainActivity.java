package com.example.giaodienchinh_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;

    ViewFlipper flipper;
    private ViewPager2 viewPager2;
    Button btndangchieu;
    Button btnsapchieu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        viewPager2=(ViewPager2)findViewById(R.id.viewPagerImageSlider);

        final List<dangchieu_AT> dangchieu_ats =new ArrayList<>();
        dangchieu_ats.add(new dangchieu_AT(R.drawable.matbet,"Mắt biếc","Tình cảm"));
        dangchieu_ats.add(new dangchieu_AT(R.drawable.rom,"Ròm","Tâm lý"));
        dangchieu_ats.add(new dangchieu_AT(R.drawable.trangmau,"Tiệc trăng máu","Tâm lý,Tình cảm, Hài"));
        dangchieu_ats.add(new dangchieu_AT(R.drawable.venom,"Venom","Khoa học viễn tưởng"));
        dangchieu_ats.add(new dangchieu_AT(R.drawable.trangquynh,"Trạng Quỳnh","Cổ tích, Hài"));

        final List<dangchieu_AT> dangchieu_ats2 =new ArrayList<>();
        dangchieu_ats2.add(new dangchieu_AT(R.drawable.rom,"Ròm","Tâm lý"));
        dangchieu_ats2.add(new dangchieu_AT(R.drawable.rom,"Ròm","Tâm lý"));
        dangchieu_ats2.add(new dangchieu_AT(R.drawable.rom,"Ròm","Tâm lý"));
        dangchieu_ats2.add(new dangchieu_AT(R.drawable.rom,"Ròm","Tâm lý"));
        dangchieu_ats2.add(new dangchieu_AT(R.drawable.trangquynh,"Ròm","Tâm lý"));

        initslider1(dangchieu_ats);
        btndangchieu = (Button) findViewById(R.id.dangchieu);
        btnsapchieu = (Button) findViewById(R.id.sapchieu);

        btndangchieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initslider1(dangchieu_ats);
            }
        });
        btnsapchieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initslider1(dangchieu_ats2);
            }
        });

    int[] igmarray ={R.drawable.slide1,R.drawable.slide2,R.drawable.slide3,R.drawable.slide4};
    flipper=(ViewFlipper)findViewById(R.id.flipper);
        for(int i=0;i<igmarray.length;i++)
    {
        showimg(igmarray[i]);
    }
}
    public void showimg(int img)
    {
        ImageView imageview=new ImageView(this);
        imageview.setBackgroundResource(img);
        flipper.addView(imageview);
        flipper.setFlipInterval(2700);
        flipper.setAutoStart(true);

        flipper.setInAnimation(this,android.R.anim.slide_in_left);
        flipper.setOutAnimation(this,android.R.anim.slide_out_right);

    }
    public  void initslider1(List<dangchieu_AT> dangchieus)
    {
        viewPager2=(ViewPager2)findViewById(R.id.viewPagerImageSlider);
        viewPager2.setAdapter(new Adapterdangchieu(dangchieus,viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(5);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(50));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r=1-Math.abs(position);
                page.setScaleY(0.87f + r * 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId() == R.id.menuTab){
            Toast.makeText(this, "Btn is clicked.", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}