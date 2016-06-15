package com.passion.padc_helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RegistrationSummaryActivity extends AppCompatActivity {

    public static final String IE_USERPARCEL = "userparcel_key";

    public static Intent newIntent(UserParcel userParcel) {
        Intent intentToRegistrationSummary = new Intent(HelloWorldApp.getContext(), RegistrationSummaryActivity.class);
        intentToRegistrationSummary.putExtra(IE_USERPARCEL, userParcel);
        return intentToRegistrationSummary;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_summary);

        Intent intentFromHomeActivity = getIntent();
        UserParcel userParcel = intentFromHomeActivity.getParcelableExtra(IE_USERPARCEL);
        TextView tvRegistrationSummary = (TextView) this.findViewById(R.id.tv_summary);

        String summary = "Username: " + userParcel.getUsername() + "\n";
        summary += "Password: " + userParcel.getPassword() + "\n";
        summary += "Email: " + userParcel.getEmail() + "\n";
        summary += "Phone: " + userParcel.getPhoneNumber() + "\n";
        summary += "Country: " + userParcel.getCountry() + "\n";
        summary += "Gender: " + userParcel.getGender() + "\n";

        if (tvRegistrationSummary != null)
            tvRegistrationSummary.setText(summary);
    }
}
