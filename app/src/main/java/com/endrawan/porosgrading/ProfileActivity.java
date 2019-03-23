package com.endrawan.porosgrading;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import Components.AppCompatActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    public static final int RESULT_LOGOUT = 1;
    public static final int RESULT_DELETE = 2;
    public static final int RESULT_EDIT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView mName, mEmail, mNim, mDivision, mDelete, mLogout, mEdit;
        Toolbar mToolbar;
        CircleImageView mImage;

        user = getUserFromSP();

        mName = findViewById(R.id.name);
        mEmail = findViewById(R.id.email);
        mNim = findViewById(R.id.nim);
        mDivision = findViewById(R.id.division);
        mDelete = findViewById(R.id.delete);
        mLogout = findViewById(R.id.logout);
        mImage = findViewById(R.id.image);
        mEdit = findViewById(R.id.edit);
        mToolbar = findViewById(R.id.toolbar);

        mName.setText(user.getName());
        mEmail.setText(user.getEmail());
        mNim.setText(user.getNim());
        mDivision.setText(Config.DIVISIONS[user.getDivision()].getName());

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (user.getPhoto_url() != null)
            Glide.with(this).load(user.getPhoto_url()).into(mImage);

        mDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_DELETE);
                finish();
            }
        });

        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_LOGOUT);
                finish();
            }
        });

        mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_EDIT);
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
