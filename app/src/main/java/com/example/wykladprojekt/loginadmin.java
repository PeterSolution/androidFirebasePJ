package com.example.wykladprojekt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class loginadmin extends AppCompatActivity {
    Button buttonlogin;
    TextView loginview,hasloview;
    Functions functions;
    String adminlogin,adminpassword;
    ListView listaplansz;
    String selectedItem=null;
    TextView message;
    Button wrocbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_loginadmin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        wrocbtn=(Button) findViewById(R.id.wrocbtn);
        loginview=(TextView) findViewById(R.id.adminbox);
        hasloview=(TextView) findViewById(R.id.HasloBox);
        functions=new Functions();
        functions.getadminlogin(dane->{
            adminlogin=dane.login;
            adminpassword= dane.password;
        });
        wrocbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(loginadmin.this, MainActivity.class);
                startActivity(intent);
            }
        });
        listaplansz=(ListView) findViewById(R.id.listaPlanszy);
        ArrayList<String> items = new ArrayList<>();
        items.add("3x3");
        items.add("5x5");

        // Tworzenie adaptera
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                items
        );
        message=findViewById(R.id.Gramessage);
//        listvie1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                // Tutaj position to indeks klikniętego elementu w ListView
//                // Możesz użyć 'items.get(position)' do uzyskania konkretnego elementu na podstawie pozycji
//                fetchExchangeRates(link + items.get(position));
//            }
//        });

        listaplansz.setAdapter(adapter);
        listaplansz.setOnItemClickListener((parent, view, position, id) -> {
            selectedItem = items.get(position);
            message.setText("Wybrano gre: "+selectedItem);
        });
        buttonlogin=(Button) findViewById(R.id.creategameButton2);
        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((loginview.getText().toString().equals(adminlogin))&&(hasloview.getText().toString().equals(adminpassword))){
                    try {
                        if (selectedItem.equals("3x3")) {

                            String code=functions.generatecode3x3();
                            functions.creategame3x3(getApplicationContext(),"admin","",code);

                            Intent intent2=new Intent(loginadmin.this, Gra.class);
                            intent2.putExtra("key", code);
                            intent2.putExtra("you", "0");
                            startActivity(intent2);
                        } else {
                            if (selectedItem.equals("5x5")) {
//                                Toast.makeText(getApplicationContext(), "bbb", Toast.LENGTH_LONG).show();
                                String code=functions.generatecode5x5();
                                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_LONG).show();
                                functions.creategame5x5(getApplicationContext(),"admin","",code);
                                Intent intent=new Intent(loginadmin.this, gra5x5.class);
                                intent.putExtra("key", code);
                                intent.putExtra("you", "0");
                                startActivity(intent);
                            }
                        }
                    }
                    catch (Exception ex){
                        Toast.makeText(getApplicationContext(),"Wybierz plansze",Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Wprowadz poprawne dane",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}