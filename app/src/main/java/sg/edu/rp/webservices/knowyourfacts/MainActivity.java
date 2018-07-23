package sg.edu.rp.webservices.knowyourfacts;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager vPager;
    Button read,read1;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_search:
                int a =vPager.getCurrentItem()-1;
                vPager.setCurrentItem(a);
                return true;
            case R.id.action_compose:
                int max = vPager.getChildCount();
                Random r = new Random();
                int i1 = r.nextInt(max - 0)+ 0;
                vPager.setCurrentItem(i1);
                return true;
            case R.id.action_compose1:
                int b =vPager.getCurrentItem()+1;

                vPager.setCurrentItem(b);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vPager = (ViewPager)findViewById(R.id.viewpager1);
        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<Fragment>();
        al.add(new frag1());
        al.add(new Frag3());

        adapter = new MyFragmentPagerAdapter(fm,al);

        vPager.setAdapter(adapter);





    }

}
