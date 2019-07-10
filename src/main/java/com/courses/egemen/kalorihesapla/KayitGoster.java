package com.courses.egemen.kalorihesapla;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class KayitGoster extends AppCompatActivity {

    private static final String TAG = "KayitlariGoster";

    VeriTabaninaKaydet veriTabaninaKaydet;

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_goster);
        mListView = (ListView) findViewById(R.id.listView);
        veriTabaninaKaydet = new VeriTabaninaKaydet(this);
        populateListView();
    }

    private void populateListView() {
        Cursor data = veriTabaninaKaydet.getData();
        ArrayList<String> veriListesi = new ArrayList<>();
        while (data.moveToNext()){
            veriListesi.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, veriListesi);
        mListView.setAdapter(adapter);
    }
}
