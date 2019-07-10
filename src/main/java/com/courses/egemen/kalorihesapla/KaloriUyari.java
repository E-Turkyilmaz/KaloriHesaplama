package com.courses.egemen.kalorihesapla;

import android.widget.Toast;

/**
 * Created by Egemen on 20.12.2017.
 */

public class KaloriUyari {
    public double uyari(double kaloriToplam, int boy, int kilo, int yas, String cinsiyet){
        double sinirDeğer = 0.0;
        if(cinsiyet == "Erkek")
        {
            sinirDeğer = 66 + (13.75*kilo) + (5*boy) - (6.8*yas);
        }
        else if(cinsiyet == "Kadın")
        {
            sinirDeğer = 665 + (9.6*kilo) + (1.7*boy) - (4.7*yas);
        }
        return sinirDeğer;
    }
}
