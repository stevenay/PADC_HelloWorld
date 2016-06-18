package com.passion.padc_helloworld;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class RegisterFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        final Spinner spinner = (Spinner) view.findViewById(R.id.spn_country);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                                                R.array.countries_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // auto-select Myanmar Country value
        int spinnerPosition = adapter.getPosition("Myanmar");
        spinner.setSelection(spinnerPosition);

//        AutoCompleteTextView actvCountry = (AutoCompleteTextView) view.findViewById(R.id.actv_country);
//
//        String[] countries = getResources().getStringArray(R.array.countries_array);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, countries);
//        actvCountry.setAdapter(adapter);

        final EditText etUsername = (EditText) view.findViewById(R.id.et_username);
        final EditText etPassword = (EditText) view.findViewById(R.id.et_password);
        final EditText etEmail = (EditText) view.findViewById(R.id.et_email);
        final EditText etPhoneNumber = (EditText) view.findViewById(R.id.et_phonenumber);
        final RadioGroup rdgGender = (RadioGroup) view.findViewById(R.id.rdg_gender);

        // to add try_catch block
        Button btnSubmit = (Button) view.findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectGenderId = rdgGender.getCheckedRadioButtonId();
                RadioButton rdbGender = (RadioButton) rdgGender.findViewById(selectGenderId);
                String gender = (rdbGender != null) ? rdbGender.getText().toString() : "others";

                UserParcel userParcel = new UserParcel(
                    etUsername.getText().toString(),
                    etPassword.getText().toString(),
                    etEmail.getText().toString(),
                    etPhoneNumber.getText().toString(),
                    spinner.getSelectedItem().toString(),
                    gender
                );

                Intent intent = RegistrationSummaryActivity.newIntent(userParcel);
                startActivity(intent);
            }
        });

        return view;
    }
}
