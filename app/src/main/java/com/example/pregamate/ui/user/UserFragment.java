package com.example.pregamate.ui.user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pregamate.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserFragment extends Fragment {

<<<<<<< HEAD
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        UserViewModel userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        View root = inflater.inflate(R.layout.fragment_user, container, false);
        final TextView textView = root.findViewById(R.id.text_user);
        userViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });



        return root;
=======
//    Firebase
    private FirebaseAuth auth;
    private FirebaseUser user;
    private FirebaseDatabase db;
    private DatabaseReference ref;


//    Views from xml
    private ImageView userProfileIv;
    private TextView nameTv, emailTv, trimesterTv;

    public UserFragment(){
//       Required public constructor
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

//        init firebase
        auth =FirebaseAuth.getInstance();
        user= auth.getCurrentUser();
        db= FirebaseDatabase.getInstance();
        ref= db.getReference();


        return inflater.inflate(R.layout.fragment_user, container, false);
>>>>>>> d5e42b74b6cc509d4fc23533efa3318b66a8d91f
    }
}