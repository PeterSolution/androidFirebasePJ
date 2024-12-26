package com.example.wykladprojekt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    Button loginbutton,nowagra;
    Functions fun;
    EditText nazwagraczabox,kodbox;
    Functions functions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        functions=new Functions();
        nazwagraczabox=(EditText)findViewById(R.id.Loginbox);
        kodbox=(EditText)findViewById(R.id.KodBox);
        loginbutton=(Button) findViewById(R.id.loginButton);
        nowagra=(Button) findViewById(R.id.newgameButton);
        nowagra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, loginadmin.class);
                startActivity(intent);

            }
        });
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nazwagraczabox.length()>0){
                    if(kodbox.length()>0){
                        if(kodbox.length()==5){


                            functions.getGameData3x3( kodbox.getText().toString(), new Functions.OnDataLoadedListener() {
                                public void onDataLoaded(DataModel3x3 data) {
                                    if (data != null) {
                                        Intent intent = new Intent(MainActivity.this, Gra.class);
                                        intent.putExtra("key", kodbox.getText().toString());
                                        intent.putExtra("gamer2",nazwagraczabox.getText().toString());
                                        intent.putExtra("you", "1");
                                        startActivity(intent);
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(),"Gra nie istnieje",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                        }
                        else{
                            if(kodbox.length()==6){
                                functions.getGameData5x5( kodbox.getText().toString(), new Functions.OnDataLoadedListener5x5() {
                                    public void onDataLoaded(DataModel5x5 data) {
                                        if (data != null) {
                                            Intent intent = new Intent(MainActivity.this, Gra.class);
                                            intent.putExtra("key", kodbox.getText().toString());
                                            intent.putExtra("gamer2",nazwagraczabox.getText().toString());
                                            intent.putExtra("you", "1");
                                            startActivity(intent);
                                        }
                                        else{
                                            Toast.makeText(getApplicationContext(),"Gra nie istnieje",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                                Intent intent=new Intent(MainActivity.this, gra5x5.class);
                                intent.putExtra("key", kodbox.getText());
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),"Gra nie istnieje",Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"wprowadz kod do gry",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wprowadz jakas swoja nazwe",Toast.LENGTH_LONG).show();
                }
            }
        });

        fun=new Functions();
        fun.creategame3x3(getApplication(),"a","b","abc");
       // fun.deletegame("gra");
    }
}