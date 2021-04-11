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
    }
}