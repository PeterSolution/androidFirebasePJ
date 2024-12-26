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

public class gra5x5 extends AppCompatActivity {
    String gamecode;
    DataModel5x5 data = null;
    Functions functions;
    String nazwagracza2, you;
    TextView firstgamer, secondgamer, kodwyswietlacz,Endmessage;
    private Handler handler = new Handler();
    private Runnable runnable;
    private ImageView[] pola = new ImageView[25];
    ImageView pole1,pole2,pole3,pole4,pole5,pole6,pole7,pole8,pole9,pole10,
            pole11,pole12,pole13,pole14,pole15,pole16,pole17,pole18,pole19,pole20,
            pole21,pole22,pole23,pole24,pole25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gra5x5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Endmessage=(TextView)findViewById(R.id.MessageEnd);
        /*initializeViews();
        gamecode = getIntent().getStringExtra("key");
        setupClickListeners();*/
        pole1 = (ImageView) findViewById(R.id.imageView1);
        pole2 = (ImageView) findViewById(R.id.imageView2);
        pole3 = (ImageView) findViewById(R.id.imageView3);
        pole4 = (ImageView) findViewById(R.id.imageView4);
        pole5 = (ImageView) findViewById(R.id.imageView5);
        pole6 = (ImageView) findViewById(R.id.imageView6);
        pole7 = (ImageView) findViewById(R.id.imageView7);
        pole8 = (ImageView) findViewById(R.id.imageView8);
        pole9 = (ImageView) findViewById(R.id.imageView9);
        pole10 = (ImageView) findViewById(R.id.imageView10);
        pole11 = (ImageView) findViewById(R.id.imageView11);
        pole12 = (ImageView) findViewById(R.id.imageView12);
        pole13 = (ImageView) findViewById(R.id.imageView13);
        pole14 = (ImageView) findViewById(R.id.imageView14);
        pole15 = (ImageView) findViewById(R.id.imageView15);
        pole16 = (ImageView) findViewById(R.id.imageView16);
        pole17 = (ImageView) findViewById(R.id.imageView17);
        pole18 = (ImageView) findViewById(R.id.imageView18);
        pole19 = (ImageView) findViewById(R.id.imageView19);
        pole20 = (ImageView) findViewById(R.id.imageView20);
        pole21 = (ImageView) findViewById(R.id.imageView21);
        pole22 = (ImageView) findViewById(R.id.imageView22);
        pole23 = (ImageView) findViewById(R.id.imageView23);
        pole24 = (ImageView) findViewById(R.id.imageView24);
        pole25 = (ImageView) findViewById(R.id.imageView25);

        kodwyswietlacz = (TextView) findViewById(R.id.kodwyswietlacz);
        gamecode = getIntent().getStringExtra("key");
        kodwyswietlacz.setText(gamecode);
        functions=new Functions();
        firstgamer=(TextView) findViewById(R.id.gracz1textView);
        secondgamer=(TextView) findViewById(R.id.gracz2textView);
        you=getIntent().getStringExtra("you");

        functions.getGameData5x5(gamecode,firedata->{
            data=firedata;
            data.gracz2="";
            firstgamer.setText("gracz1: "+data.gracz1);
        });

        if(getIntent().hasExtra("gamer2")) {
            nazwagracza2 = getIntent().getStringExtra("gamer2");
            DataModel5x5 model = new DataModel5x5();
            data.gracz2 = nazwagracza2;
            functions.updateGameData5x5(getApplicationContext(), gamecode, data);
            secondgamer.setText("gracz2: " + data.gracz2);
            data.tura="0";
        }

        pole1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.tura.equals("0")&&you.equals("0")) {
                    pole1.setImageResource(R.drawable.krzyzyk);
                    data.tura="1";
                    data.pole1="1";
                    functions.updateGameData5x5(getApplicationContext(),gamecode,data);
                }
                else{
                    if(data.tura.equals("1")&&you.equals("1")) {
                        pole1.setImageResource(R.drawable.kolo);
                        data.tura = "0";
                        data.pole1="2";
                        functions.updateGameData5x5(getApplicationContext(), gamecode, data);
                    }
                }
            }
        });

        // Similar onClick listeners for poles 2-25
        pole2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.tura.equals("0")&&you.equals("0")) {
                    pole2.setImageResource(R.drawable.krzyzyk);
                    data.tura="1";
                    data.pole2="1";
                    functions.updateGameData5x5(getApplicationContext(),gamecode,data);
                }
                else{
                    if(data.tura.equals("1")&&you.equals("1")) {
                        pole2.setImageResource(R.drawable.kolo);
                        data.tura = "0";
                        data.pole2="2";
                        functions.updateGameData5x5(getApplicationContext(), gamecode, data);
                    }
                }
            }
        });

        // Continue with similar listeners for poles 3-25...

        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);

                functions.getGameData5x5(gamecode,dane->{
                    data=dane;
                    runOnUiThread(() -> {
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
                        if(data.pole10.equals("1")){
                            pole10.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole10.equals("2")){
                            pole10.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole11.equals("1")){
                            pole11.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole11.equals("2")){
                            pole11.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole12.equals("1")){
                            pole12.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole12.equals("2")){
                            pole12.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole13.equals("1")){
                            pole13.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole13.equals("2")){
                            pole13.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole14.equals("1")){
                            pole14.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole14.equals("2")){
                            pole14.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole15.equals("1")){
                            pole15.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole15.equals("2")){
                            pole15.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole16.equals("1")){
                            pole16.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole16.equals("2")){
                            pole16.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole17.equals("1")){
                            pole17.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole17.equals("2")){
                            pole17.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole18.equals("1")){
                            pole18.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole18.equals("2")){
                            pole18.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole19.equals("1")){
                            pole19.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole19.equals("2")){
                            pole19.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole20.equals("1")){
                            pole20.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole20.equals("2")){
                            pole20.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole21.equals("1")){
                            pole21.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole21.equals("2")){
                            pole21.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole22.equals("1")){
                            pole22.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole22.equals("2")){
                            pole22.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole23.equals("1")){
                            pole23.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole23.equals("2")){
                            pole23.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole24.equals("1")){
                            pole24.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole24.equals("2")){
                            pole24.setImageResource(R.drawable.kolo);
                        }
                        if(data.pole25.equals("1")){
                            pole25.setImageResource(R.drawable.krzyzyk);
                        }
                        if(data.pole25.equals("2")){
                            pole25.setImageResource(R.drawable.kolo);
                        }
                    });
                });
            }
        };
        handler.post(runnable);
    }
//
//    private void initializeViews() {
//        for(int i = 0; i < 25; i++) {
//            int id = getResources().getIdentifier("imageView" + (i + 1), "id", getPackageName());
//            pola[i] = findViewById(id);
//        }
//        kodwyswietlacz = findViewById(R.id.kodwyswietlacz);
//        firstgamer = findViewById(R.id.gracz1textView);
//        secondgamer = findViewById(R.id.gracz2textView);
//        setupGameUpdates();
//    }
//
//    private void setupGame() {
//        gamecode = getIntent().getStringExtra("key");
//        kodwyswietlacz.setText(gamecode);
//        functions = new Functions();
//
//        functions.getGameData5x5(gamecode, firedata -> {
//            data = firedata;
//            data.gracz2 = "";
//            firstgamer.setText("gracz1: " + data.gracz1);
//        });
//
//        if(getIntent().hasExtra("gamer2")) {
//            nazwagracza2 = getIntent().getStringExtra("gamer2");
//            data.gracz2 = nazwagracza2;
//            functions.updateGameData5x5(getApplicationContext(), gamecode, data);
//            secondgamer.setText("gracz2: " + data.gracz2);
//            data.tura = "0";
//        }
//    }
//
//    private void setupClickListeners() {
//        for(int i = 0; i < 25; i++) {
//            final int index = i;
//            pola[i].setOnClickListener(view -> handleClick(index));
//        }
//    }
//
//    private void handleClick(int index) {
//        if(data.tura.equals("0") && you.equals("0")) {
//            pola[index].setImageResource(R.drawable.krzyzyk);
//            data.tura = "1";
//            setFieldValue(index, "1");
//            functions.updateGameData5x5(getApplicationContext(), gamecode, data);
//        } else if(data.tura.equals("1") && you.equals("1")) {
//            pola[index].setImageResource(R.drawable.kolo);
//            data.tura = "0";
//            setFieldValue(index, "2");
//            functions.updateGameData5x5(getApplicationContext(), gamecode, data);
//        }
//    }
//
//    private void setFieldValue(int index, String value) {
//        try {
//            java.lang.reflect.Field field = data.getClass().getDeclaredField("pole" + (index + 1));
//            field.setAccessible(true);
//            field.set(data, value);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void setupGameUpdates() {
//        runnable = new Runnable() {
//            @Override
//            public void run() {
//                handler.postDelayed(this, 1000);
//
//                functions.getGameData5x5(gamecode, dane -> {
//                    data = dane;
//                    runOnUiThread(() -> updateBoard());
//                });
//            }
//        };
//        handler.post(runnable);
//    }
//
//    private void updateBoard() {
//        for(int i = 0; i < 25; i++) {
//            try {
//                java.lang.reflect.Field field = data.getClass().getDeclaredField("pole" + (i + 1));
//                field.setAccessible(true);
//                String value = (String) field.get(data);
//
//                if("1".equals(value)) {
//                    pola[i].setImageResource(R.drawable.krzyzyk);
//                } else if("2".equals(value)) {
//                    pola[i].setImageResource(R.drawable.kolo);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private void setupWindowInsets() {
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
}