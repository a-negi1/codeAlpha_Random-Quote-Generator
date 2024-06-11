package com.example.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private Button newQuoteButton;
    private Button shareButton;

    private String[] quotes = {
            "The greatest glory in living lies not in never falling, but in rising every time we fall. - Nelson Mandela",
            "The way to get started is to quit talking and begin doing. - Walt Disney",
            "Your time is limited, don't waste it living someone else's life. - Steve Jobs",
            "If life were predictable it would cease to be life, and be without flavor. - Eleanor Roosevelt",
            "If you look at what you have in life, you'll always have more. - Oprah Winfrey"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        newQuoteButton = findViewById(R.id.newQuoteButton);
        shareButton = findViewById(R.id.shareButton);

        newQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateNewQuote();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareQuote();
            }
        });
    }

    private void generateNewQuote() {
        Random random = new Random();
        int index = random.nextInt(quotes.length);
        quoteTextView.setText(quotes[index]);
    }

    private void shareQuote() {
        String quote = quoteTextView.getText().toString();
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, quote);
        startActivity(Intent.createChooser(shareIntent, "Share via"));
    }
}
