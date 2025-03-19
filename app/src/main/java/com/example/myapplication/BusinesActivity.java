package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BusinesActivity extends Chast_Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void fillCardList() {
        cardList.add(new CardItem(R.drawable.ihub, "iHub Coworking", "Конференции", 4.8f, 100, "15 000сом", R.drawable.ihub_logo));
        cardList.add(new CardItem(R.drawable.ololo, "ololo Creative Hubs", "Бизнес-встречи", 4.7f, 50, "12 000сом", R.drawable.ololo_logo));
        cardList.add(new CardItem(R.drawable.sabi, "Coworking Space Sabi", "Презентации/Конференции", 5.0f, 200, "3 000 сом", R.drawable.sabi_logo));
        cardList.add(new CardItem(R.drawable.collab_hub, "Collab Hub", "Конференции", 4.5f, 300, "50 000сом", R.drawable.collab_logo));
    }
    public void startMainMenuActivity(View v){
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}
