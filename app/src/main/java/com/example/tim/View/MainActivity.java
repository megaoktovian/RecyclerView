package com.example.tim.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tim.R;

import java.util.ArrayList;
import java.util.List;

import com.example.tim.Adapter.MenuAdapter;
import com.example.tim.Model.MenuModel;
import com.example.tim.Presenter.MenuPresenter;

public class MainActivity extends AppCompatActivity implements MainView {
    private RecyclerView rv;
    private ArrayList<MenuModel> listmenu = new ArrayList<>();
    private MenuPresenter presenter;


    MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.recycler_view);
        presenter = new MenuPresenter(this);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        presenter.load();

    }

    @Override
    public void succes(List<MenuModel> list) {

        adapter = new MenuAdapter(getApplicationContext(), list);
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
