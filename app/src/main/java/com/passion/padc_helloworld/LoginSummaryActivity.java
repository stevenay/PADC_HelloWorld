package com.passion.padc_helloworld;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class LoginSummaryActivity extends AppCompatActivity {

    // Naming Convention AllCAPS to public static variable
    public static final String IE_USERNAME = "username_key";

    // Static Factory Pattern
    public static Intent newIntent(String username)
    {
        Context context = HelloWorldApp.getContext();
        Intent intentToLoginSummary = new Intent(context, LoginSummaryActivity.class);
        intentToLoginSummary.putExtra(IE_USERNAME, username);
        return intentToLoginSummary;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_summary);

        Intent intentFromHomeActivity = getIntent();
        String username = intentFromHomeActivity.getStringExtra(IE_USERNAME);

        TextView tvUsername = (TextView) this.findViewById(R.id.tv_username);
        if (tvUsername != null)
            tvUsername.setText("Welcome " + username);

        // Toast.makeText(getApplicationContext(), "Username: " + username, Toast.LENGTH_SHORT).show();
    }
}
