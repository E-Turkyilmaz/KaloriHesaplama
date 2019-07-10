package com.courses.egemen.kalorihesapla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Pattern;

public class KayitEkrani extends AppCompatActivity  {
    private EditText Name;
    private EditText Weight;
    private EditText Height;
    private EditText Yas;
    private RadioGroup Sex;
    private Button SignUp;
    private RadioButton Female;
    private  RadioButton Male;
    public YemekSec gonder = new YemekSec();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit_ekrani);

        Name=(EditText)findViewById(R.id.SignUpName);
        Weight=(EditText)findViewById(R.id.SignUpWeight);
        Height=(EditText)findViewById(R.id.SignUpHeight);
        Yas=(EditText)findViewById(R.id.SignUpYas);
        Sex=(RadioGroup)findViewById(R.id.SignUpSex);
        Female=(RadioButton)findViewById(R.id.Female);
        Male=(RadioButton)findViewById(R.id.Male);
        SignUp=(Button)findViewById(R.id.SignUp);

        final Intent intent=new Intent(this,YemekSec.class);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Name.getText().toString().isEmpty() ||  Weight.getText().toString().isEmpty()
                        || Height.getText().toString().isEmpty() ||
                        Yas.getText().toString().isEmpty() ||  (Sex.getCheckedRadioButtonId() == -1))
                {
                    Toast.makeText(KayitEkrani.this, "Lütfen boşlukları doldurun.",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int op=Sex.getCheckedRadioButtonId();
                    String SexRadiovalue;
                    if (op==R.id.Female)
                    {
                        SexRadiovalue="Kadın";
                    }
                    else
                    {
                        SexRadiovalue="Erkek";
                    }
                    gonder.Value(Name.getText().toString(),
                            Integer.parseInt(Weight.getText().toString()),
                            Integer.parseInt(Height.getText().toString()),
                            Integer.parseInt(Yas.getText().toString()), SexRadiovalue);
                    startActivity(intent);
                }

            }

        });
    }
}