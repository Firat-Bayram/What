package com.androidproject.what;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Firat on 31.1.2015.
 */
public class profil extends Activity {

    EditText eTxtName, eTxtSurname, eTxtBirthdate, eTxtAdress, eTxtEmail, eTxtPhonenumber, eTxtGender, eTxtMaritalstatus;
    Helper helper;
    // Progress Dialog
    private ProgressDialog pDialog;

    //testing on Emulator:
    private static final String PROFIL_URL = "http://192.168.1.101:80/webservis/android_what/profil.php";

    //JSON element ids from repsonse of php script:
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    private static final String TAG_NAME = "name";
    private static final String TAG_SURNAME = "surname";
    private static final String TAG_BIRTHDATE = "birthdate";
    private static final String TAG_ADRESS = "adress";
    private static final String TAG_EMAIL = "email";
    private static final String TAG_PHONENUMBER = "phonenumber";
    private static final String TAG_GENDER = "gender";
    private static final String TAG_MARITALSTATUS = "maritalstatus";

    String username;
    int userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);
        helper = Helper.INSTANCE;
        eTxtName = helper.getirView(this, R.id.eTxtName, EditText.class);
        eTxtSurname = helper.getirView(this, R.id.eTxtSurname, EditText.class);
        eTxtBirthdate = helper.getirView(this, R.id.eTxtBirthdate, EditText.class);
        eTxtAdress = helper.getirView(this, R.id.eTxtAdress, EditText.class);
        eTxtEmail = helper.getirView(this, R.id.eTxtAdress, EditText.class);
        eTxtPhonenumber = helper.getirView(this, R.id.eTxtPhonenumber, EditText.class);
        eTxtGender = helper.getirView(this, R.id.eTxtGender, EditText.class);
        eTxtMaritalstatus = helper.getirView(this, R.id.eTxtMaritalstatus, EditText.class);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(profil.this);
        username = sp.getString("username", "a");
        userid = sp.getInt("user_id", 0);
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        //loading the comments via AsyncTask
        new ProfilBilgi().execute();
    }

    class ProfilBilgi extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         */
        boolean failure = false;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = helper.showLoadingDialogBox(profil.this, AlertDialog.THEME_HOLO_LIGHT, "Profil Bilgileri Okunuyor...", true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
            // Check for success tag
            int success;
            // Building Parameters
            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("userid",String.valueOf(userid)));

            helper.yazLog(Helper.logTypes.debug, "HttpRequest", "start " + PROFIL_URL);
            // getting product details by making HTTP request
            String json = JSONParser.INSTANCE.makeHttpRequestReturnJSONString(PROFIL_URL, JSONParser.requestMethod.Post, params);

            helper.yazLog(Helper.logTypes.debug, "HttpRequest", "finish " + PROFIL_URL);

            return json;
        }

        /**
         * After completing background task Dismiss the progress dialog
         *
         * @param file_url
         */
        protected void onPostExecute(String file_url) {
            helper.yazLog(Helper.logTypes.debug, file_url);
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            JSONObject jObj = JSONParser.INSTANCE.convertJSONStringToJSONObject(file_url);
            if (jObj == null) {
                helper.gosterBilgiMesaji(profil.this, "Profil bilgisi okunamadı...");
                return;
            }

            int success = 0;
            String message = null;
            try {
                success = jObj.getInt(TAG_SUCCESS);
                message = jObj.getString(TAG_MESSAGE);
            } catch (JSONException e) {
                e.printStackTrace();
                helper.yazLog(Helper.logTypes.error, e.toString());
                helper.gosterBilgiMesaji(profil.this, "Profil okuma denemesi başarısız...");
            }

            if (success == 1) {
                String name = null;
                String surname = null;
                String birthdate = null;
                String adress = null;
                String email = null;
                String phonenumber = null;
                String gender = null;
                String maritalstatus = null;
                try {
                    name = jObj.getString(TAG_NAME);
                    surname = jObj.getString(TAG_SURNAME);
                    birthdate = jObj.getString(TAG_BIRTHDATE);
                    adress = jObj.getString(TAG_ADRESS);
                    email = jObj.getString(TAG_EMAIL);
                    phonenumber = jObj.getString(TAG_PHONENUMBER);
                    gender = jObj.getString(TAG_GENDER);
                    maritalstatus = jObj.getString(TAG_MARITALSTATUS);

                } catch (JSONException e) {
                    e.printStackTrace();
                    helper.yazLog(Helper.logTypes.error, e.toString());
                    helper.gosterBilgiMesaji(profil.this, "Profil bilgisi okunamadı...");
                    return;
                }
                eTxtName.setText(name);
                eTxtSurname.setText(surname);
                eTxtBirthdate.setText(birthdate);
                eTxtAdress.setText(adress);
                eTxtEmail.setText(email);
                eTxtPhonenumber.setText(phonenumber);
                eTxtGender.setText(gender);
                eTxtMaritalstatus.setText(maritalstatus);
            }
            helper.gosterBilgiMesaji(profil.this, message);
        }
    }
}
