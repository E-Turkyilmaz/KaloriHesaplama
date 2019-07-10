package com.courses.egemen.kalorihesapla;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.courses.egemen.kalorihesapla.KaloriUyari;

public class YemekSec extends AppCompatActivity {

    private static final String TAG = "YemekSec";

    VeriTabaninaKaydet veriTabaninaKaydet;
    public double toplamKalori = 0.0;
    public double sinirDeğeri = 0.0;
    public KaloriUyari uyarici = new KaloriUyari();
    public static String kayitStr;

    static int kilo;
    static int boy;
    static int yas;
    static String isim;
    static String cinsiyet;
    public void Value(String vIsim, int vKilo,int vBoy,int vYas,String vCinsiyet)
    {
        kilo=vKilo;
        boy=vBoy;
        yas=vYas;
        isim = vIsim;
        cinsiyet=vCinsiyet;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yemek_sec);

        veriTabaninaKaydet = new VeriTabaninaKaydet(this);

        ImageButton salataButton = (ImageButton) findViewById(R.id.salataButton);
        ImageButton corbaButton = (ImageButton) findViewById(R.id.corbaButton);
        ImageButton anayemekButton = (ImageButton) findViewById(R.id.anayemekButton);
        ImageButton icecekButton = (ImageButton) findViewById(R.id.icecekButton);
        ImageButton ekleButton = (ImageButton) findViewById(R.id.ekleButton);

        final Button kaydetButton = (Button) findViewById(R.id.kaydetButton);

        final TextView listeleTextView = (TextView) findViewById(R.id.listeleTextView);
        final EditText porsiyonEditText = (EditText) findViewById(R.id.porsiyonEditText);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final ArrayList<String> yemekListesi = new ArrayList<>();
        final ArrayList<String> yemekTurleri = new ArrayList<>();
        final ArrayList<String> sonListe = new ArrayList<>();

        yemekListesi.add(0,"Yemek Türü Seçiniz");

        final ArrayAdapter<String> yemekAdapter = new ArrayAdapter<String>(this ,
                android.R.layout.simple_spinner_dropdown_item, yemekListesi);
        spinner.setAdapter(yemekAdapter);

        salataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yemekTurleri.clear();
                yemekTurleri.add(0,"Salata");

                yemekListesi.clear();
                yemekListesi.add(0,"Sezar Salata");
                yemekListesi.add(1,"Roka Salatası");
                yemekListesi.add(2,"Çoban Salata");
                yemekListesi.add(3,"Pancar Salatası");

                spinner.setAdapter(yemekAdapter);
            }
        });

        corbaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yemekTurleri.clear();
                yemekTurleri.add(0, "Çorba");

                yemekListesi.clear();
                yemekListesi.add(0,"Mercimek Çorbası");
                yemekListesi.add(1,"Yayla Çorbası");
                yemekListesi.add(2,"Domates Çorbası");

                spinner.setAdapter(yemekAdapter);
            }
        });

        anayemekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yemekTurleri.clear();
                yemekTurleri.add(0, "Ana Yemek");

                yemekListesi.clear();
                yemekListesi.add(0,"Adana Kebap");
                yemekListesi.add(1,"Dana Külbası");
                yemekListesi.add(2,"Beyti Sarma");
                yemekListesi.add(3,"Izgara Köfte");
                yemekListesi.add(4,"Kuzu Şiş");

                spinner.setAdapter(yemekAdapter);
            }
        });

        icecekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yemekTurleri.clear();
                yemekTurleri.add(0, "İçecek");

                yemekListesi.clear();
                yemekListesi.add(0,"Ayran");
                yemekListesi.add(1,"Şalgam Suyu");
                yemekListesi.add(2,"Meyve Suyu");
                yemekListesi.add(3,"Gazlı İçecek");

                spinner.setAdapter(yemekAdapter);
            }
        });
        ekleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str =  porsiyonEditText.getText().toString();
                String yemekAdi = spinner.getSelectedItem().toString();
                String yemekTuru = yemekTurleri.get(0).toString();
                String kaloriStr;
                float porsiyon = Float.parseFloat(str);
                double kalori = 0.0;

                switch (yemekTuru){
                    case "Salata":
                        switch (yemekAdi){
                            case "Sezar Salata":
                                kalori = porsiyon*466.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                            case "Roka Salatası":
                                kalori = porsiyon*65.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                            case "Çoban Salata":
                                kalori = porsiyon*115.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                            case "Pancar Salatası":
                                kalori = porsiyon*195.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                        }
                        break;
                    case "Çorba":
                        switch (yemekAdi){
                            case "Mercimek Çorbası":
                                kalori = porsiyon*135.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                            case "Yayla Çorbası":
                                kalori = porsiyon*98.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                            case "Domates Çorbası":
                                kalori = porsiyon*66.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                        }
                        break;
                    case "Ana Yemek":
                        switch (yemekAdi){
                            case "Adana Kebap":
                                kalori = porsiyon*361.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                            case "Dana Külbastı":
                                kalori = porsiyon*105;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                            case "Beyti Sarma":
                                kalori = porsiyon*489.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                            case "Izgara Köfte":
                                kalori = porsiyon*200.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                            case "Kuzu Şiş":
                                kalori = porsiyon*342.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                        }
                        break;
                    case "İçecek":
                        switch (yemekAdi){
                            case "Ayran":
                                kalori = porsiyon*67.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                            case "Şalgam Suyu":
                                kalori = porsiyon*10.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                            case "Meyve Suyu":
                                kalori = porsiyon*64.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                            case "Gazlı İçecek":
                                kalori = porsiyon*145.0;
                                kaloriStr = String.valueOf(kalori);
                                sonListe.add("\n" + yemekAdi + " " + kaloriStr);
                                toplamKalori = toplamKalori+kalori;
                                break;
                        }
                        break;
                }
                str = String.valueOf(toplamKalori);
                Toast.makeText(YemekSec.this, str, Toast.LENGTH_SHORT).show();

                sinirDeğeri = uyarici.uyari(toplamKalori, boy, kilo,yas,cinsiyet);
                if(sinirDeğeri < toplamKalori)
                {
                    builder.setMessage("Günlük ihtiyacınızın " +
                            String.valueOf(toplamKalori - sinirDeğeri) +
                            " kcal üzerindesiniz!!!").setPositiveButton("TAMAM",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                }
                listeleTextView.setText(sonListe.toString());
            }
        });

        kaydetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kayitStr = android.text.format.DateFormat.format("yyyy-MM-dd hh:mm:ss a ", new java.util.Date())
                        +  isim + " " + String.valueOf(toplamKalori);
                AddData(kayitStr);

                sonListe.clear();

                Intent intent = new Intent(YemekSec.this, KayitGoster.class);
                startActivity(intent);
            }
        });
    }

    public void AddData(String kayitBilgisi){
        boolean veriEkle = veriTabaninaKaydet.addData(kayitBilgisi);
        if(veriEkle){
            Toast.makeText(YemekSec.this, "Kayıt Başarılı!",
                    Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(YemekSec.this, "Kayıt Gerçekleşmedi!",
                    Toast.LENGTH_SHORT).show();
        }
    }

}
