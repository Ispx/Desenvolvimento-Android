package com.example.appchat.controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appchat.R;
import com.example.appchat.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


import java.io.IOException;
import java.util.UUID;

public class act_register extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText password;
    private Button btSelectImage;
    private ImageView ImagePhoto;

    private String fileNameRandom;
    private Uri wayImage;
    private User user = null;

    //Database Cloud Firestore
    private FirebaseFirestore firebaseFirestore = null;

    //Database RealTime
    private DatabaseReference databaseReference = null;

    //Database Mídia Storage
    private StorageReference storageReference = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_register);
        name = findViewById(R.id.edt_rgt_name);
        email = findViewById(R.id.edt_rgt_email);
        password = findViewById(R.id.act_rgt_password);
        btSelectImage = findViewById(R.id.bt_rgt_image);
        ImagePhoto = findViewById(R.id.image_rgt_image);

        //Geting reference Database midía Storage
        storageReference = FirebaseStorage.getInstance().getReference();

        //Geting instance Database Cloud
        firebaseFirestore = FirebaseFirestore.getInstance();

        //Geting instance and reference Database real time
        databaseReference = FirebaseDatabase.getInstance().getReference();


    }


    public void onRegister(View view){
        final String _name = this.name.getText().toString();
        final String _email = this.email.getText().toString();
        final String _password = this.password.getText().toString();

        if(_name == null || _name.isEmpty() || _email == null || _email.isEmpty() || _password == null || _password.isEmpty()){

        Toast.makeText(act_register.this, "Todos os campos devem ser preenchidos!",Toast.LENGTH_SHORT).show();
        return;
    }
        saveImage();

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(_email,_password).
                addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            user = new User(task.getResult().getUser().getUid(),_name,_email,_password,fileNameRandom);

                            //Add data real time database
                            databaseReference.child("users").setValue(user);

                            //Add date real time cloud firestore
                            firebaseFirestore.collection("users").add(user);
                        }
                    }
                }
        ).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("FireAuthN",e.getMessage());
            }
        });


        startActivity(new Intent(act_register.this,act_login.class));

        finish();
    }

    public void setBtSelectImage(View view){

        Intent captureImage = new Intent(Intent.ACTION_PICK);
        captureImage.setType("image/*");
        startActivityForResult(captureImage,0);

    }

    public void saveImage() {
        this.fileNameRandom = UUID.randomUUID().toString();
        StorageReference imageRef = storageReference.child("imagens/" + this.fileNameRandom);

        if (this.wayImage != null) {
            imageRef.putFile(this.wayImage);
        }
        else{
            Toast.makeText(getApplicationContext(),"Nenhuma imagem adicionada",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0) {

            this.wayImage = data.getData();
            Bitmap bitmap = null;

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),this.wayImage);
                this.ImagePhoto.setImageBitmap(bitmap);
                this.btSelectImage.setAlpha(0);
            } catch (IOException e) {
                e.getMessage();
                e.printStackTrace();
            }
        }
    }
}


