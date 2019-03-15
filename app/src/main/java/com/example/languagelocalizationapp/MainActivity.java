package com.example.languagelocalizationapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListPopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.languagelocalizationapp.adapter.PopupWindowAdapter;
import com.example.languagelocalizationapp.helper.LocalHelper;
import com.example.languagelocalizationapp.model.CountryModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListPopupWindow popupWindow;
    TextView txtSelectLanguage;
    Button btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSelectLanguage=findViewById(R.id.txtSelectLanguage);
        btnNext=findViewById(R.id.btnNext);
        this.setTitle(getString(R.string.title));

        txtSelectLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopup(view);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showPopup(View view) {
        //final ListPopupWindow popupWindow=new ListPopupWindow(this);
        popupWindow=new ListPopupWindow(this);
        final List<CountryModel> itemList=new ArrayList<>();
        CountryModel item=new CountryModel(getString(R.string.English),"en");
        CountryModel item1=new CountryModel(getString(R.string.Hindi),"hi");
        CountryModel item2=new CountryModel(getString(R.string.vietnamese),"vi");
        CountryModel item3=new CountryModel(getString(R.string.chinese),"zh");
        itemList.add(item);
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);

        final ListAdapter listAdapter=new PopupWindowAdapter(this,itemList);
        popupWindow.setAnchorView(view);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.popup_bg));
        popupWindow.setAdapter(listAdapter);
        popupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(!alsoSelected(itemList.get(i).getLanguageCode())){
                    LocalHelper.setLocale(MainActivity.this,itemList.get(i).getLanguageCode());
                    LocalHelper.persist(MainActivity.this,itemList.get(i).getLanguageCode());
                    popupWindow.dismiss();
                    recreate();
                }else {
                    Toast.makeText(MainActivity.this, "language also selected", Toast.LENGTH_SHORT).show();
                    popupWindow.dismiss();
                }
            }
        });
        popupWindow.show();
    }
    private boolean alsoSelected(String lan){
        if(LocalHelper.getPersistedData(MainActivity.this,null).equals(lan)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocalHelper.onAttach(newBase));
    }
}
