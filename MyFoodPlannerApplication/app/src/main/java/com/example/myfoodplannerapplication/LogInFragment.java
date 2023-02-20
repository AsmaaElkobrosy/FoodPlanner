package com.example.myfoodplannerapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.room.Update;

import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInFragment extends Fragment {
    private FirebaseAuth auth;
    private EditText loginEmail,loginPass;
    private TextView signupRedirectTeXT;
    private Button loginpbutton;

    private FirebaseAuth firebaseAuth;
    private Button guest;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_log_in, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        guest= view.findViewById(R.id.guestBtn);
        auth = FirebaseAuth.getInstance();
        loginEmail = view.findViewById(R.id.login_email);
        loginPass = view.findViewById(R.id.login_pw);
        loginpbutton = view.findViewById(R.id.Loginbtn);
        signupRedirectTeXT = view.findViewById(R.id.signupredirecttext);

        //anonymous
        firebaseAuth = FirebaseAuth.getInstance();
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                anonymousAuth();
            }

            private void anonymousAuth() {
                firebaseAuth.signInAnonymously().addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user= firebaseAuth.getCurrentUser();
                            startActivity(new Intent(getActivity(),MainActivity.class));
                        }else {
                            Toast.makeText(getContext(),"Can not complete", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        loginpbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginEmail.getText().toString();
                String pass = loginPass.getText().toString();

                if (!email.isEmpty()&& Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                if (!pass.isEmpty()){
                   auth.signInWithEmailAndPassword(email,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                       @Override
                       public void onSuccess(AuthResult authResult) {
                           Toast.makeText(getContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getActivity(),MainActivity.class));
                          //getActivity().finish();
                       }
                   }).addOnFailureListener(new OnFailureListener() {
                       @Override
                       public void onFailure(@NonNull Exception e) {
                           Toast.makeText(getContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                       }
                   });
                }else if (pass.isEmpty()){
                   loginPass.setError("Password can not be empty");
                }else if (email.isEmpty()){
                        loginEmail.setError("Email can not be empty");
                    }else{
                        loginEmail.setError("Please enter a valid email");
                    }
            }
        }
        });
        signupRedirectTeXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_logInFragment_to_signUpFragment);
            }
        });

    }
}