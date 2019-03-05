package com.example.tim.Presenter;

import com.example.tim.Model.MenuModel;
import com.example.tim.R;
import com.example.tim.View.MainView;

import java.util.ArrayList;

public class MenuPresenter {
    private MainView mainview;
    private String[] title = {"Sushi Gunkan", "Sushi Roll", "Sushi Nigiri", "Sushi Salmon", "Onigiri", "Sashimi Shrimp",
            "Tamago Sushi", "Ramen", "Tempura"};


    private  int[] thumbnail ={R.drawable.gunkan,R.drawable.sroll,R.drawable.nigiri,R.drawable.salmon,
            R.drawable.oni,R.drawable.sashimi,R.drawable.tamago,R.drawable.ramen,R.drawable.tempuraa};

    public MenuPresenter(MainView mainview) {
        this.mainview = mainview;
    }
    public void load(){
        mainview.succes(getListData());
    }
    public ArrayList<MenuModel> getListData(){
        MenuModel menuModel = null;
        ArrayList<MenuModel> list = new ArrayList<>();
        for (int i = 0; i<title.length; i++){
            menuModel = new MenuModel();
            menuModel.setImage(thumbnail[i]);
            menuModel.setName(title[i]);
            list.add(menuModel);
        }
        return list;
    }
}
