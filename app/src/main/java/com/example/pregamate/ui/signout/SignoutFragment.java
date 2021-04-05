package com.example.pregamate.ui.signout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.pregamate.MainActivity;
import com.example.pregamate.R;
import com.google.firebase.auth.FirebaseAuth;

public class SignoutFragment extends Fragment {

    private FirebaseAuth auth;

    private SignoutViewModel signoutViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        signoutViewModel =
                new ViewModelProvider(this).get(SignoutViewModel.class);
        View root = inflater.inflate(R.layout.fragment_signout, container, false);
        final TextView textView = root.findViewById(R.id.text_signout);
        signoutViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        auth = FirebaseAuth.getInstance();
        signout(getView());
        return root;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        FirebaseUser user = auth.getCurrentUser();
//    }

    private void signout(View view) {
        auth.signOut();
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}