package com.example.wykladprojekt;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Handler;


public class Gra extends AppCompatActivity {
    String gamecode;
    DataModel3x3 data=null;
    Functions functions;
    String nazwagracza2;
    TextView firstgamer;
    String you;
    TextView secondgamer,kodwyswietlacz,Endmessage;
    ImageView pole1,pole2,pole3,pole4,pole5,pole6,pole7,pole8,pole9;
    private Handler handler = new Handler();
    private Runnable runnable;
    int delay=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gra);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Endmessage= (TextView) findViewById(R.id.MessageEnd);
        pole1 = (ImageView) findViewById(R.id.imageView1);
        pole2 = (ImageView) findViewById(R.id.imageView2);
        pole3 = (ImageView) findViewById(R.id.imageView3);
        pole4 = (ImageView) findViewById(R.id.imageView4);
        pole5 = (ImageView) findViewById(R.id.imageView5);
        pole6 = (ImageView) findViewById(R.id.imageView6);
        pole7 = (ImageView) findViewById(R.id.imageView7);
        pole8 = (ImageView) findViewById(R.id.imageView8);
        pole9 = (ImageView) findViewById(R.id.imageView9);
        kodwyswietlacz = (TextView) findViewById(R.id.kodwyswietlacz);
        gamecode = getIntent().getStringExtra("key");
        kodwyswietlacz.setText(gamecode);
        functions=new Functions();
        firstgamer=(TextView) findViewById(R.id.gracz1textView);
        secondgamer=(TextView) findViewById(R.id.gracz2textView);
        you=getIntent().getStringExtra("you");
        functions.getGameData3x3(gamecode,firedata->{
            data=firedata;
            data.gracz2="";
            firstgamer.setText("gracz1: "+data.gracz1);
            if(getIntent().hasExtra("gamer2")) {
                nazwagracza2 = getIntent().getStringExtra("gamer2").trim();
                DataModel3x3 model = new DataModel3x3();
                data.gracz2 = nazwagracza2;
                functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                secondgamer.setText("gracz2: " + data.gracz2);
                data.tura="0";
            }
        });



        pole1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.tura.equals("0")&&you.equals("0")) {
                    pole1.setImageResource(R.drawable.krzyzyk);
                    data.tura="1";
                    functions.updateGameData3x3(getApplicationContext(),gamecode,data);
                }
                else{
                    if(data.tura.equals("1")&&you.equals("1")) {
                        pole1.setImageResource(R.drawable.kolo);
                        data.tura = "0";
                        functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                    }
                }
            }
        });
        pole2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.tura.equals("0")&&you.equals("0") ) {
                    pole2.setImageResource(R.drawable.krzyzyk);
                    data.tura = "1";

                    functions.updateGameData3x3(getApplicationContext(), gamecode, data);

                } else {
                    if(data.tura.equals("1")&&you.equals("1")) {
                        pole2.setImageResource(R.drawable.kolo);
                        data.tura = "0";
                        functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                    }
                }
            }
        });

        pole3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.tura.equals("0")&&you.equals("0")) {
                    pole3.setImageResource(R.drawable.krzyzyk);
                    data.tura = "1";
                    functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                } else {
                    if(data.tura.equals("1")&&you.equals("1")) {
                        pole3.setImageResource(R.drawable.kolo);
                        data.tura = "0";
                        functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                    }
                }
            }
        });

        pole4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.tura.equals("0")&&you.equals("0")) {
                    pole4.setImageResource(R.drawable.krzyzyk);
                    data.tura = "1";
                    functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                } else {
                    if(data.tura.equals("1")&&you.equals("1")) {
                        pole4.setImageResource(R.drawable.kolo);
                        data.tura = "0";
                        functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                    }
                }
            }
        });

        pole5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.tura.equals("0")&&you.equals("0")) {
                    pole5.setImageResource(R.drawable.krzyzyk);
                    data.tura = "1";
                    functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                } else {
                    if(data.tura.equals("1")&&you.equals("1")) {
                        pole5.setImageResource(R.drawable.kolo);
                        data.tura = "0";
                        functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                    }
                }
            }
        });

        pole6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.tura.equals("0")&&you.equals("0")) {
                    pole6.setImageResource(R.drawable.krzyzyk);
                    data.tura = "1";
                    functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                } else {
                    if(data.tura.equals("1")&&you.equals("1")) {
                        pole6.setImageResource(R.drawable.kolo);
                        data.tura = "0";
                        functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                    }
                }
            }
        });

        pole7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.tura.equals("0")&&you.equals("0")) {
                    pole7.setImageResource(R.drawable.krzyzyk);
                    data.tura = "1";
                    functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                } else {
                    if(data.tura.equals("1")&&you.equals("1")) {
                        pole7.setImageResource(R.drawable.kolo);
                        data.tura = "0";
                        functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                    }
                }
            }
        });

        pole8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.tura.equals("0")&&you.equals("0")) {
                    pole8.setImageResource(R.drawable.krzyzyk);
                    data.tura = "1";
                    functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                } else {
                    if(data.tura.equals("1")&&you.equals("1")) {
                        pole8.setImageResource(R.drawable.kolo);
                        data.tura = "0";
                        functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                    }
                }
            }
        });

        pole9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (data.tura.equals("0")&&you.equals("0")) {
                    pole9.setImageResource(R.drawable.krzyzyk);
                    data.tura = "1";
                    functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                } else {
                    if(data.tura.equals("1")&&you.equals("1")) {
                        pole9.setImageResource(R.drawable.kolo);
                        data.tura = "0";
                        functions.updateGameData3x3(getApplicationContext(), gamecode, data);
                    }
                }
            }
        });
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);

                functions.getGameData3x3(gamecode,dane->{
                    data=dane;


                    if (data.tura == "100") {
                        Endmessage.setVisibility(View.VISIBLE);
                    }
                    if(data.pole1.equals("1")){
                        pole1.setImageResource(R.drawable.krzyzyk);
                    }
                    if(data.pole1.equals("2")){
                        pole1.setImageResource(R.drawable.kolo);
                    }
                    if(data.pole2.equals("1")){
                        pole2.setImageResource(R.drawable.krzyzyk);
                    }
                    if(data.pole2.equals("2")){
                        pole2.setImageResource(R.drawable.kolo);
                    }
                    if(data.pole3.equals("1")){
                        pole3.setImageResource(R.drawable.krzyzyk);
                    }
                    if(data.pole3.equals("2")){
                        pole3.setImageResource(R.drawable.kolo);
                    }
                    if(data.pole4.equals("1")){
                        pole4.setImageResource(R.drawable.krzyzyk);
                    }
                    if(data.pole4.equals("2")){
                        pole4.setImageResource(R.drawable.kolo);
                    }
                    if(data.pole5.equals("1")){
                        pole5.setImageResource(R.drawable.krzyzyk);
                    }
                    if(data.pole5.equals("2")){
                        pole5.setImageResource(R.drawable.kolo);
                    }
                    if(data.pole6.equals("1")){
                        pole6.setImageResource(R.drawable.krzyzyk);
                    }
                    if(data.pole6.equals("2")){
                        pole6.setImageResource(R.drawable.kolo);
                    }
                    if(data.pole7.equals("1")){
                        pole7.setImageResource(R.drawable.krzyzyk);
                    }
                    if(data.pole7.equals("2")){
                        pole7.setImageResource(R.drawable.kolo);
                    }
                    if(data.pole8.equals("1")){
                        pole8.setImageResource(R.drawable.krzyzyk);
                    }
                    if(data.pole8.equals("2")){
                        pole8.setImageResource(R.drawable.kolo);
                    }
                    if(data.pole9.equals("1")){
                        pole9.setImageResource(R.drawable.krzyzyk);
                    }
                    if(data.pole9.equals("2")){
                        pole9.setImageResource(R.drawable.kolo);
                    }
                });

            }
        };
        handler.post(runnable);


    }
}