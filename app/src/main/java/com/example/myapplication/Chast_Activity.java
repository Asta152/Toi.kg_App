    package com.example.myapplication;

    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.EditText;

    import androidx.activity.EdgeToEdge;
    import androidx.appcompat.widget.SearchView;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.core.content.ContextCompat;
    import androidx.core.graphics.Insets;
    import androidx.core.view.ViewCompat;
    import androidx.core.view.WindowInsetsCompat;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import java.util.ArrayList;
    import java.util.List;

    public class Chast_Activity extends AppCompatActivity {

        protected RecyclerView recyclerView;
        protected List<CardItem> cardList;
        protected CardAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_chast);
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            SearchView searchView = findViewById(R.id.searchView);
            EditText editText = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
            editText.setHintTextColor(ContextCompat.getColor(this, R.color.gray));

            // Инициализируем список
            cardList = new ArrayList<>();
            fillCardList(); // Вызываем метод для заполнения карточек

            // Устанавливаем адаптер
            adapter = new CardAdapter(cardList);
            recyclerView.setAdapter(adapter);

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    filterList(newText);
                    return false;
                }
            });
        }

        // Новый метод для заполнения списка карточек
        protected void fillCardList() {
            cardList.add(new CardItem(R.drawable.first_card, "UNO|Banquet Hall", "Выпускные", 4.8f, 150, "1 500 000 сом", R.drawable.uno_logo));
            cardList.add(new CardItem(R.drawable.second_image, "Bellagio|Banquet Hall", "Выпускные", 4.5f, 100, "800 000 сом", R.drawable.bellagio_logo));
            cardList.add(new CardItem(R.drawable.third_image, "Navat", "Той", 5.0f, 200, "500 000 сом", R.drawable.navat_logo));
            cardList.add(new CardItem(R.drawable.fourth_image, "Altyn-Arashan", "Выпускные/Тои", 4.9f, 250, "2 000 000", R.drawable.altyn_arashan));
            cardList.add(new CardItem(R.drawable.arzu, "Arzu Grand", "Выпускные/Тои", 4.3f, 150, "1 000 000", R.drawable.arzu_logo));
        }

        protected void filterList(String newText) {
            ArrayList<CardItem> filteredList = new ArrayList<>();
            for (CardItem item : cardList) {
                if (item.getTitle().toLowerCase().contains(newText.toLowerCase()) ||
                        item.getCategory().toLowerCase().contains(newText.toLowerCase())) {
                    filteredList.add(item);
                }
            }
            adapter.filterList(filteredList);
        }

        public void startMainMenuActivity(View v) {
            Intent intent = new Intent(this, MainMenu.class);
            startActivity(intent);
        }
    }
