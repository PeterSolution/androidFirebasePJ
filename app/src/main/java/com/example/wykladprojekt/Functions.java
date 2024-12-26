package com.example.wykladprojekt;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Functions {
    //"creategame" to kod wygenerowany w większości przez AI
    public void creategame3x3(Context ctx, String gamer1,String gamer2, String key) {

            FirebaseFirestore db = FirebaseFirestore.getInstance();
            Map<String, Object> gameData = new HashMap<>();

            // Inicjalizacja danych gry zgodnie z modelem
            gameData.put("gracz1", gamer1);  // pierwszy gracz to twórca gry
            gameData.put("gracz2", gamer2);    // drugi gracz - początkowo pusty
            // Inicjalizacja wszystkich pól gry jako puste
            gameData.put("tura","0");
            gameData.put("pole1", "0");
            gameData.put("pole2", "0");
            gameData.put("pole3", "0");
            gameData.put("pole4", "0");
            gameData.put("pole5", "0");
            gameData.put("pole6", "0");
            gameData.put("pole7", "0");
            gameData.put("pole8", "0");
            gameData.put("pole9", "0");

        try {
            // Zapis do bazy danych
            db.collection("game").document(key).set(gameData).addOnSuccessListener(documentReference -> {

                        Toast.makeText(ctx,"Game created",Toast.LENGTH_LONG).show();
                    })
                    .addOnFailureListener(e -> {

                        Toast.makeText(ctx,"server error",Toast.LENGTH_LONG).show();
                    });;



        }
        catch (Exception ex) {
            Toast.makeText(ctx,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
    public void creategame5x5(Context ctx, String gamer1,String gamer2, String key) {

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> gameData = new HashMap<>();

        gameData.put("gracz1", gamer1);
        gameData.put("gracz2", gamer2);
        gameData.put("tura","0");
        gameData.put("pole1", "0");
        gameData.put("pole2", "0");
        gameData.put("pole3", "0");
        gameData.put("pole4", "0");
        gameData.put("pole5", "0");
        gameData.put("pole6", "0");
        gameData.put("pole7", "0");
        gameData.put("pole8", "0");
        gameData.put("pole9", "0");
        gameData.put("pole10", "0");
        gameData.put("pole11", "0");
        gameData.put("pole12", "0");
        gameData.put("pole13", "0");
        gameData.put("pole14", "0");
        gameData.put("pole15", "0");
        gameData.put("pole16", "0");
        gameData.put("pole17", "0");
        gameData.put("pole18", "0");
        gameData.put("pole19", "0");
        gameData.put("pole20", "0");
        gameData.put("pole21", "0");
        gameData.put("pole22", "0");
        gameData.put("pole23", "0");
        gameData.put("pole24", "0");
        gameData.put("pole25", "0");
        try {
            // Zapis do bazy danych
            db.collection("game").document(key).set(gameData).addOnSuccessListener(documentReference -> {

                        Toast.makeText(ctx,"Game created",Toast.LENGTH_LONG).show();
                    })
                    .addOnFailureListener(e -> {

                        Toast.makeText(ctx,"server error",Toast.LENGTH_LONG).show();
                    });;



        }
        catch (Exception ex) {
            Toast.makeText(ctx,ex.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public void getGameData3x3(String nameofgame,OnDataLoadedListener listener) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("game")
                .document(nameofgame)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        DataModel3x3 model = task.getResult().toObject(DataModel3x3.class);
                        if (model != null) {
                            listener.onDataLoaded(model);
                        }
                    }
                    else{
                        listener.onDataLoaded(null);
                    }
                });
    }
    public interface OnDataLoadedListener {
        void onDataLoaded(DataModel3x3 data);
    }

    public void getGameData5x5(String nameofgame,OnDataLoadedListener5x5 listener) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("game")
                .document(nameofgame)
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        DataModel5x5 model = task.getResult().toObject(DataModel5x5.class);
                        if (model != null) {
                            listener.onDataLoaded(model);
                        }
                    }
                }).addOnFailureListener(fail->{
                    listener.onDataLoaded(null);
                });
    }
    public interface OnDataLoadedListener5x5 {
        void onDataLoaded(DataModel5x5 data);
    }

    public void deletegame(String gamename) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Usuń pojedynczy dokument
        db.collection("game")           // nazwa kolekcji
                .document(gamename)     // nazwa dokumentu do usunięcia
                .delete()
                .addOnSuccessListener(aVoid -> {
                    System.out.println("Document successfully deleted");
                })
                .addOnFailureListener(e -> {
                    System.out.println("Error deleting document: " + e.getMessage());
                });
    }

    public boolean isendofgame3x3(String namegame){
        int[] tab=new int[9];

        getGameData3x3(namegame,data -> {
            tab[0]=Integer.parseInt(data.pole1);
            tab[1]=Integer.parseInt(data.pole2);
            tab[2]=Integer.parseInt(data.pole3);
            tab[3]=Integer.parseInt(data.pole4);
            tab[4]=Integer.parseInt(data.pole5);
            tab[5]=Integer.parseInt(data.pole6);
            tab[6]=Integer.parseInt(data.pole7);
            tab[7]=Integer.parseInt(data.pole8);
            tab[8]=Integer.parseInt(data.pole9);
    });
        for (int i=0;i<9;i++){
            if (tab[i]!=0||
            tab[0]==tab[1]&&tab[1]==tab[2]&tab[0]!=0||
            tab[3]==tab[4] && tab[4]==tab[5] && tab[3]!=0||
            tab[6]==tab[7] && tab[7]==tab[8] && tab[6]!=0||
            tab[0]==tab[3] && tab[3]==tab[6] && tab[0]!=0||
            tab[1]==tab[4] && tab[4]==tab[7] && tab[1]!=0||
            tab[2]==tab[5] && tab[5]==tab[8] && tab[2]!=0||
            tab[0]==tab[4] && tab[4]==tab[8] && tab[0]!=0||
            tab[2]==tab[4] && tab[4]==tab[6] && tab[2]!=0
            ){
                return true;
            }
        }
        return false;


    }
    public boolean isendofgame5x5(String namegame){
        int[] tab=new int[25];

        getGameData5x5(namegame,data -> {
            tab[0]=Integer.parseInt(data.pole1);
            tab[1]=Integer.parseInt(data.pole2);
            tab[2]=Integer.parseInt(data.pole3);
            tab[3]=Integer.parseInt(data.pole4);
            tab[4]=Integer.parseInt(data.pole5);
            tab[5]=Integer.parseInt(data.pole6);
            tab[6]=Integer.parseInt(data.pole7);
            tab[7]=Integer.parseInt(data.pole8);
            tab[8]=Integer.parseInt(data.pole9);
            tab[0]=Integer.parseInt(data.pole10);
            tab[0]=Integer.parseInt(data.pole11);
            tab[1]=Integer.parseInt(data.pole12);
            tab[2]=Integer.parseInt(data.pole13);
            tab[3]=Integer.parseInt(data.pole14);
            tab[4]=Integer.parseInt(data.pole15);
            tab[5]=Integer.parseInt(data.pole16);
            tab[6]=Integer.parseInt(data.pole17);
            tab[7]=Integer.parseInt(data.pole18);
            tab[8]=Integer.parseInt(data.pole19);
            tab[0]=Integer.parseInt(data.pole20);
            tab[1]=Integer.parseInt(data.pole21);
            tab[2]=Integer.parseInt(data.pole22);
            tab[3]=Integer.parseInt(data.pole23);
            tab[4]=Integer.parseInt(data.pole24);
            tab[5]=Integer.parseInt(data.pole25);
        });
        for (int i=0;i<9;i++){
            if (tab[i]!=0||
                    tab[0]==tab[1]&&tab[1]==tab[2]&tab[0]!=0||
                    tab[3]==tab[4] && tab[4]==tab[5] && tab[3]!=0||
                    tab[6]==tab[7] && tab[7]==tab[8] && tab[6]!=0||
                    tab[0]==tab[3] && tab[3]==tab[6] && tab[0]!=0||
                    tab[1]==tab[4] && tab[4]==tab[7] && tab[1]!=0||
                    tab[2]==tab[5] && tab[5]==tab[8] && tab[2]!=0||
                    tab[0]==tab[4] && tab[4]==tab[8] && tab[0]!=0||
                    tab[2]==tab[4] && tab[4]==tab[6] && tab[2]!=0){
                return true;
            }
        }
        return false;

    }

    public void getadminlogin(OnAdminLoadedListener listener) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("login")
                .document("admin")
                .get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful() && task.getResult() != null) {
                        AdminModel model = task.getResult().toObject(AdminModel.class);
                        if (model != null) {
                            listener.onDataLoaded(model);
                        }
                    }
                });
    }
    public interface OnAdminLoadedListener {
        void onDataLoaded(AdminModel data);
    }
    public String generatecode3x3() {
        String code = "";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            code += (char) (random.nextInt(26) + 'A');
        }
        return code;
    }
    public String generatecode5x5(){
        String code = "";
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            code += (char) (random.nextInt(26) + 'A');
        }
        return code;
    }
    public void updateGameData5x5(Context ctx, String nameofgame, DataModel5x5 newData ) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("game")
                .document(nameofgame)
                .set(newData)
                .addOnFailureListener(e -> {
                    Toast.makeText(ctx,"Error",Toast.LENGTH_LONG).show();
                });
    }

    public interface OnUpdateListener {
        void onUpdateSuccess();
    }

    public void updateGameData3x3(Context ctx, String nameofgame, DataModel3x3 newData) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("game")
                .document(nameofgame)
                .set(newData);
    }


}
