package com.beshoykamal.resturantfragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.beshoykamal.resturantfragment.model.Menu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.beshoykamal.resturantfragment.ui.main.SectionsPagerAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AsyncCallback<Menu>  {

    List<Menu> menus;
    MyAdapter adapter;
    ListView listscreen;
    ViewGroup vp;
//    RecyclerView recycle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        final FloatingActionButton fab = findViewById(R.id.fab);
        listscreen = findViewById(R.id.listscreen);
        vp = findViewById(R.id.view_pager);


        Backendless.initApp(this, "75ECCCAC-84F0-BCF1-FF67-268BE2B26600",
                "BD61E607-34DF-4794-85BA-966FB015E17C");

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Snackbar.make(view, "Drinks ..  ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        DataQueryBuilder Builder = DataQueryBuilder.create();
        Builder.setSortBy("Created desc");


        Backendless.Data.of(Menu.class).find(Builder, new AsyncCallback<List<Menu>>() {


            @Override
            public void handleResponse(List<Menu> response) {
                Toast.makeText(MainActivity.this, "data  list", Toast.LENGTH_SHORT).show();
                menus = response;
                adapter = new MyAdapter(MainActivity.this);
                listscreen.setAdapter(adapter);
//                recycle.setAdapter(new MyAdapter(adapter));

            }

            @Override
            public void handleFault(BackendlessFault fault) {

                Toast.makeText(MainActivity.this, "no Database Error LOAD " + fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        listscreen.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent in=new Intent(MainActivity.this,Orderbuy.class);

//                YoYo.with(Techniques.Flash)
//                        .duration(700)
//                        .repeat(5)
//                        .playOn(findViewById(R.id.textlay);

                //int pos=position;

                in.putExtra("items",menus.get(position).getItems());
                in.putExtra("URL",menus.get(position).getURL());
                in.putExtra("nameplate",menus.get(position).getName());
                in.putExtra("price",menus.get(position).getPrice());
                in.putExtra("num",position);
                startActivity(in);
            }
        });

//////////////////////view pager
//
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Integer[] colors = {getResources().getColor(R.color.colorPrimary),
//                        getResources().getColor(R.color.colorAccent),
//                        getResources().getColor(R.color.colorPrimaryDark)};
//                ArgbEvaluator argb = new ArgbEvaluator();
//
////                if (position <(adapter.getCount()-1)&&position<(colors.length-1)){
////                    viewPager.setBackgroundColor(
////                            (Integer) argb.evaluate(positionOffset,
////                                    colors[position],
////                                    colors[position+1])
////                    );
////                }else
//
//                    viewPager.setBackgroundColor(colors[colors.length-1]);
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });

    }

    @Override
    public void handleResponse(Menu response) {
        Toast.makeText(this, "first", Toast.LENGTH_SHORT).show();
    }
        class MyAdapter extends ArrayAdapter<Menu> {
        public MyAdapter(@NonNull Context context) {
            super(context, 0);
        }

        @Override
        public int getCount() {
            return menus.size();
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.layoutnew, parent, false);


        TextView custtextlay = convertView.findViewById(R.id.nameview);
        TextView aboutlay = convertView.findViewById(R.id.itemsview);
        TextView custcostlay = convertView.findViewById(R.id.costview);
        ImageView custimaglay = convertView.findViewById(R.id.imageView);

        custtextlay.setText(menus.get(position).getName());
        custcostlay.append(menus.get(position).getPrice());
        aboutlay.append(menus.get(position).getItems());
        Picasso.get().load(menus.get(position).getURL()).into(custimaglay);


        return convertView;
        }
    }



     @Override
       public void handleFault(BackendlessFault fault) {

         Toast.makeText(this, ""+fault.getMessage(), Toast.LENGTH_SHORT).show();
      }
}