package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EnjoyActivity extends Chast_Activity {

    private RecyclerView recyclerView;
    private CardAdapter adapter; // <-- Добавляем адаптер
    private ArrayList<CardItem> cardList = new ArrayList<>(); // <-- Инициализируем список

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enjoy);

        // Находим RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Создаём адаптер и устанавливаем его
        adapter = new CardAdapter(cardList);
        recyclerView.setAdapter(adapter);

        // Заполняем список карточек
        fillCardList();
        adapter.notifyDataSetChanged(); // <-- Теперь адаптер обновится
    }

    @Override
    protected void fillCardList() {
        cardList.add(new CardItem(R.drawable.gunfun, "Gun Fun", "Страйкболл", 4.2f, 20, "1500сом на каждого", R.drawable.ihub_logo));
        cardList.add(new CardItem(R.drawable.ololo, "ololo Creative Hubs", "Бизнес-встречи", 4.7f, 50, "12 000сом", R.drawable.ololo_logo));
        cardList.add(new CardItem(R.drawable.sabi, "Coworking Space Sabi", "Презентации/Конференции", 5.0f, 200, "3 000 сом", R.drawable.sabi_logo));
        cardList.add(new CardItem(R.drawable.collab_hub, "Collab Hub", "Конференции", 4.5f, 300, "50 000сом", R.drawable.collab_logo));
    }

    public void startMainMenuActivity(View v) {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }
}
