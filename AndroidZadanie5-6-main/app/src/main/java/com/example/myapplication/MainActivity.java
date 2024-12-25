package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int likeCount = 0;
    private String lastRegisteredEmail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView likeCounter = findViewById(R.id.likeCounter);
        Button polub = findViewById(R.id.polub);
        Button niepolub = findViewById(R.id.niepolub);
        Button zapisz = findViewById(R.id.zapisz);
        Button zobaczuczestnika = findViewById(R.id.zobaczuczestnika);
        EditText emailInput = findViewById(R.id.emailInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        EditText confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        TextView powiadomienia = findViewById(R.id.powiadomienia);

        polub.setOnClickListener(v -> {
            likeCount++;
            likeCounter.setText(likeCount + " polubień");
        });

        niepolub.setOnClickListener(v -> {
            if (likeCount > 0) likeCount--;
            likeCounter.setText(likeCount + " polubień");
        });


        zapisz.setOnClickListener(v -> {
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();
            String confirmPassword = confirmPasswordInput.getText().toString();

            if (!email.contains("@")) {
                powiadomienia.setText("Nieprawidłowy adres e-mail");
            } else if (!password.equals(confirmPassword)) {
                powiadomienia.setText("Hasła się różnią");
            } else {
                lastRegisteredEmail = email;
                powiadomienia.setText("Zarejestrowano: " + email);
            }
        });

        zobaczuczestnika.setOnClickListener(v -> {
            if (!lastRegisteredEmail.isEmpty()) {
                powiadomienia.setText("Zarejestrowany uczestnik: " + lastRegisteredEmail);
            } else {
                powiadomienia.setText("Brak zarejestrowanych uczestników");
            }
        });
    }
}