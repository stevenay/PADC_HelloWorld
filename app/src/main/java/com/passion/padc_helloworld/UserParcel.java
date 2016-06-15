package com.passion.padc_helloworld;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Dell on 6/15/2016.
 */
public class UserParcel implements Parcelable {

    private String mUsername;
    private String mPassword;
    private String mEmail;
    private String mPhoneNumber;
    private String mCountry;
    private String mGender;

    public String getUsername() {
        return mUsername;
    }

    public String getPassword() {
        return mPassword;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public String getCountry() {
        return mCountry;
    }

    public String getGender() {
        return mGender;
    }

    public UserParcel(String username, String password, String email, String phoneNumber, String country, String gender) {
        mUsername = username;
        mPassword = password;
        mEmail = email;
        mPhoneNumber = phoneNumber;
        mCountry = country;
        mGender = gender;
    }

    private UserParcel(Parcel in){
        mUsername = in.readString();
        mPassword = in.readString();
        mEmail = in.readString();
        mPhoneNumber = in.readString();
        mCountry = in.readString();
        mGender = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUsername);
        dest.writeString(mPassword);
        dest.writeString(mEmail);
        dest.writeString(mPhoneNumber);
        dest.writeString(mCountry);
        dest.writeString(mGender);
    }

    public static final Parcelable.Creator<UserParcel> CREATOR
            = new Parcelable.Creator<UserParcel>() {
        public UserParcel createFromParcel(Parcel in) {
            return new UserParcel(in);
        }

        public UserParcel[] newArray(int size) {
            return new UserParcel[size];
        }
    };
}
