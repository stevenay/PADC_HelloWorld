package com.passion.padc_helloworld;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginFragment extends Fragment {

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        final EditText etUsername  = (EditText) view.findViewById(R.id.et_username);
        final EditText etPassword  = (EditText) view.findViewById(R.id.et_password);

        Button btnLogin = (Button) view.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // Toast.makeText(getContext(), "Hello Login Form : " + username + " - " + password, Toast.LENGTH_SHORT).show();

                Intent intentToLoginSummary = LoginSummaryActivity.newIntent(username);
                startActivity(intentToLoginSummary);
            }
        });

        return view;
    }
}
