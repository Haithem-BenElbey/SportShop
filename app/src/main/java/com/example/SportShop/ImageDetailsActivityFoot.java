package com.example.SportShop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ImageDetailsActivityFoot extends AppCompatActivity {

    private int imageId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_details);

        // Get the image ID from the intent
        imageId = getIntent().getIntExtra("imageId", -1);

        // Get reference to views
        EditText editTextDescription = findViewById(R.id.editTextDescription);
        Button buttonSaveDescription = findViewById(R.id.buttonSaveDescription);
        TextView textView = findViewById(R.id.imageDetailsTextView);

        // Get image data from database and display
        DatabaseHelperFoot dbHelper = new DatabaseHelperFoot(this);
        String imageData = dbHelper.getImageData(imageId);
        editTextDescription.setText(imageData);

        // Set OnClickListener for the Save Description button
        buttonSaveDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the new description from the EditText
                String newDescription = editTextDescription.getText().toString();

                // Update the description in the database
                dbHelper.updateImageDescription(imageId, newDescription);

                // Show a toast message to indicate successful update
                Toast.makeText(ImageDetailsActivityFoot.this, "Description updated successfully", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                finish();
            }
        });
    }
}
