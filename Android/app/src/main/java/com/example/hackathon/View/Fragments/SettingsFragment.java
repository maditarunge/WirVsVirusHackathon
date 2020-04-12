package com.example.hackathon.View.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import com.example.hackathon.Consts;
import com.example.hackathon.R;
import com.example.hackathon.View.Activity.ChangePasswordActivity;
import com.example.hackathon.View.Activity.ProfileActivity;


public class SettingsFragment extends Fragment {

    private View rootView = null;

    public SettingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        childFragTrans.replace(R.id.settings, new SettingsSubFragment()).commit();

        Log.i("CREATED!", "Fragment is created");
        return rootView;
    }

    public static class SettingsSubFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
            androidx.preference.Preference prefAccount = this.<androidx.preference.Preference>findPreference("profile_settings");
            androidx.preference.Preference prefPassword = this.<androidx.preference.Preference>findPreference("change_pass");
            androidx.preference.Preference prefKeepLoggedIn = this.<androidx.preference.SwitchPreference>findPreference("keep_logged_in");
            androidx.preference.Preference prefDataSecure = this.<androidx.preference.Preference>findPreference("data_secure");
            androidx.preference.Preference prefAbout = this.<androidx.preference.Preference>findPreference("about");


            prefAccount.setOnPreferenceClickListener(onPreferenceClickListenerAccount);
            prefPassword.setOnPreferenceClickListener(onPreferenceClickListenerPassword);
            prefKeepLoggedIn.setOnPreferenceChangeListener(onPreferenceClickListenerKeepLoggedIn);
            prefDataSecure.setOnPreferenceClickListener(onPreferenceClickListenerShowDataSecure);
            prefAbout.setOnPreferenceClickListener(onPreferenceClickListenerAbout);

            prefKeepLoggedIn.setDefaultValue(Consts.SharedPrefs.sharedPref.getBoolean(Consts.SharedPrefs.Values.STAY_LOGGED_IN, false));
        }

        private androidx.preference.Preference.OnPreferenceClickListener onPreferenceClickListenerAccount = new androidx.preference.Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(androidx.preference.Preference preference) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(),"Clicked",Toast.LENGTH_SHORT).show();
                return true;
            }
        };

        private androidx.preference.Preference.OnPreferenceClickListener onPreferenceClickListenerPassword = new androidx.preference.Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(androidx.preference.Preference preference) {
                Intent intent = new Intent(getActivity(), ChangePasswordActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(),"Clicked",Toast.LENGTH_SHORT).show();
                return true;
            }
        };

        private androidx.preference.SwitchPreference.OnPreferenceChangeListener onPreferenceClickListenerKeepLoggedIn = new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
//                (SwitchPreference)preference.
                Consts.SharedPrefs.editor.putBoolean(Consts.SharedPrefs.Values.STAY_LOGGED_IN, (boolean) newValue);
                Consts.SharedPrefs.editor.apply();
                Toast.makeText(getContext(),"Clicked",Toast.LENGTH_SHORT).show();
                return true;
            }
        };

        private androidx.preference.Preference.OnPreferenceClickListener onPreferenceClickListenerShowDataSecure = new androidx.preference.Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(androidx.preference.Preference preference) {
                doDialogAlert("Datenschutz", "Dies sind unsere Datenschutzinformationen ...");
                Toast.makeText(getContext(),"Clicked",Toast.LENGTH_SHORT).show();
                return true;
            }
        };

        private androidx.preference.Preference.OnPreferenceClickListener onPreferenceClickListenerAbout = new androidx.preference.Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(androidx.preference.Preference preference) {
                doDialogAlert("Über diese App", "Version: 1.0\nInformation ...");
                Toast.makeText(getContext(),"Clicked",Toast.LENGTH_SHORT).show();
                return true;
            }
        };

        public void doDialogAlert(String title, String message) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

            builder.setMessage(message)
                    .setTitle(title)
                    .setCancelable(true);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}
