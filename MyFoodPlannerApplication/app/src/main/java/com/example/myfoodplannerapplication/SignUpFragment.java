package com.example.myfoodplannerapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import static android.provider.ContactsContract.Intents.Insert.EMAIL;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.developer.gbuttons.GoogleSignInButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import javax.xml.transform.Result;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;


public class SignUpFragment extends Fragment {

    CallbackManager callbackManager;
    private FirebaseAuth mAuth;

    LoginButton fb_Btn;

    private static final int RC_SIGN_IN = 100;
    private FirebaseAuth auth;
    private EditText signupEmail,signupPass;
    private Button signupbutton;
    private TextView loginRedirectTeXT;
    GoogleSignInButton googleSignInButton;
    GoogleSignInOptions googlesignInOptions;
    GoogleSignInClient googlesignInClient;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);


    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //google
        googlesignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        googlesignInClient = GoogleSignIn.getClient(getActivity(),googlesignInOptions);

        auth = FirebaseAuth.getInstance();
        signupEmail = view.findViewById(R.id.signup_email);
        signupPass = view.findViewById(R.id.signup_pw);
        signupbutton = view.findViewById(R.id.signupbtn);
        loginRedirectTeXT = view.findViewById(R.id.loginredirecttext);
        googleSignInButton = view.findViewById(R.id.googlebtn);
        fb_Btn= view.findViewById(R.id.facebookBtn);



        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = signupEmail.getText().toString().trim();
                String pass = signupPass.getText().toString().trim();

                if (email.isEmpty()){
                    signupEmail.setError("Email can not be empty");
                }
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    signupEmail.setError("Enter a valid Email");
                }
                if (pass.isEmpty()){
                    signupPass.setError("password can't be empty");
                }else{
                    auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getContext(),"Sign up successful",Toast.LENGTH_SHORT).show();
                                Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_logInFragment);

                            }else{
                                Toast.makeText(getContext(),"Signup failed"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

            }
        });
        loginRedirectTeXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_signUpFragment_to_logInFragment);
            }
        });


        googleSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinIntent = googlesignInClient.getSignInIntent();
                startActivityForResult(signinIntent,1000);
            }
        });





        //Facebook
        callbackManager = CallbackManager.Factory.create();

        //LoginManager.getInstance().registerCallback(callbackManager,
        fb_Btn.setReadPermissions("email", "public_profile");
        fb_Btn.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        handleFacebookAccessToken(loginResult.getAccessToken());

                    }

                    @Override
                    public void onCancel() {
                        Log.d("TAG", "facebook:onCancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Log.d("TAG", "facebook:onError", exception);
                    }
                });
        /*fb_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logInWithPublishPermissions(getActivity(), Arrays.asList("email","public_profile"));
            }
        });*/

    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Facebook
        callbackManager.onActivityResult(requestCode, resultCode, data);

        //google
        if (requestCode==1000){
            Task<GoogleSignInAccount> task= GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                getActivity().finish();
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);

            }catch (ApiException e){
                Toast.makeText(getContext(),"Something went wrong",Toast.LENGTH_LONG).show();
            }
        }

        //Facebook
        //callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    /*@Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }*/

    private void handleFacebookAccessToken(AccessToken token) {

        mAuth = FirebaseAuth.getInstance();

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "signInWithCredential:failure", task.getException());
                            Toast.makeText(getActivity(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });


    }

    private void updateUI(FirebaseUser user) {
        startActivity(new Intent(getActivity(), MainActivity.class));
    }
}