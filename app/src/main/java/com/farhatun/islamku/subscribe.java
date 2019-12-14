package com.farhatun.islamku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class subscribe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subscribe);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public void submitOrder(View view) {
        // Get user's name
        EditText nameField = findViewById(R.id.nama_field);
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        EditText nomorField = findViewById(R.id.nomor_field);
        Editable nomorEditable = nomorField.getText();
        String nomor = nomorEditable.toString();

        EditText komentarField = findViewById(R.id.komentar_field);
        Editable komentarEditable = komentarField.getText();
        String komentar = komentarEditable.toString();


        // Display the order summary on the screen
        String message = createOrderSummary(name, nomor, komentar);

        // Use an intent to launch an email app.
        // Send the order summary in the email body.
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT,
                getString(R.string.order_summary_email_subject, name));
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String createOrderSummary(String name, String nomor, String komentar) {
        String priceMessage = getString(R.string.order_summary_name, name);
        priceMessage += "\n" + getString(R.string.order_summary_nomor, nomor);
        priceMessage += "\n" + getString(R.string.order_summary_komentar, komentar);
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;
    }
}

