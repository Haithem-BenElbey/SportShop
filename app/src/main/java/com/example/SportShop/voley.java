package com.example.SportShop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class voley extends AppCompatActivity {

    private GridView gridView;
    private GridAdaptervoley gridAdapter;
    private ArrayList<String> imageDescriptions = new ArrayList<>();
    private int[] imageResources = {
            R.drawable.ballonv,
            R.drawable.pompe,
            R.drawable.protegev,
            R.drawable.filet2,
            R.drawable.filetb7ar,
            R.drawable.filet_piscine,
            R.drawable.sabat,
            R.drawable.eau,

    };
    private DatabaseHelperVoley dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voley);

        gridView = findViewById(R.id.gridView);

        dbHelper = new DatabaseHelperVoley(this);

        // Récupérer les descriptions d'images depuis la base de données
        for (int i = 1; i <= imageResources.length; i++) {
            String description = dbHelper.getImageDescription(i);
            imageDescriptions.add(description);
        }
        gridAdapter = new GridAdaptervoley(this, imageDescriptions, imageResources);
        gridView.setAdapter(gridAdapter);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            // Rafraîchir votre GridView ici
            // Par exemple, si vous avez une méthode appelée refreshGridView(), vous pouvez l'appeler ici
            // Récupérer les descriptions d'images depuis la base de données
            imageDescriptions = new ArrayList<>();
            for (int i = 1; i <= imageResources.length; i++) {
                String description = dbHelper.getImageDescription(i);
                imageDescriptions.add(description);
            }
            gridAdapter.setImageDescriptions(imageDescriptions);
            gridAdapter.notifyDataSetChanged();
        }
    }
}
