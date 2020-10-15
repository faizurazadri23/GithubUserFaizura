package com.faizurazadri.githubuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailUserActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "user";
    private TextView nama,username,followers,following,company,location,repositories;
    private CircleImageView img_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);

        nama = findViewById(R.id.detail_nama);
        username = findViewById(R.id.detail_username);
        followers = findViewById(R.id.detail_followers);
        following = findViewById(R.id.detail_following);
        company = findViewById(R.id.detail_company);
        location = findViewById(R.id.detail_location);
        repositories = findViewById(R.id.detail_repositories);
        img_user = findViewById(R.id.detail_foto);

        String a,b,c,d,e,f,g,h;

        User user = getIntent().getParcelableExtra(EXTRA_USER);
        a = user.getNama();
        b = user.getUsername();
        c = user.getFollowers();
        d = user.getFollowing();
        e = user.getLocation();
        f = user.getRepository();
        g = user.getCompany();

        nama.setText(a);
        username.setText(b);
        img_user.setImageResource(user.getAvatar());
        followers.setText(c);
        following.setText(d);
        location.setText(e);
        repositories.setText(f);
        company.setText(g);

    }
}