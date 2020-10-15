package com.faizurazadri.githubuser;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdapterUser adapterUser;
    private ListView listViewUser;
    private String[] dataname;
    private String[] datauser;
    private TypedArray dataavatar;
    private String[] datafollowers;
    private String [] datafollowing;
    private String[] location;
    private String[] repositories;
    private String[] company;
    private ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewUser = findViewById(R.id.list_user);
        adapterUser = new AdapterUser(this);
        listViewUser.setAdapter(adapterUser);
        prepare();
        datauser();

        listViewUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User datauser = new User();
                datauser.setNama(userList.get(position).getNama());
                datauser.setUsername(userList.get(position).getUsername());
                datauser.setAvatar(userList.get(position).getAvatar());
                datauser.setFollowers(userList.get(position).getFollowers());
                datauser.setFollowing(userList.get(position).getFollowing());
                datauser.setLocation(userList.get(position).getLocation());
                datauser.setCompany(userList.get(position).getCompany());
                datauser.setRepository(userList.get(position).getRepository());
                Intent detail = new Intent(MainActivity.this, DetailUserActivity.class);
                detail.putExtra(DetailUserActivity.EXTRA_USER, datauser);
                startActivity(detail);
            }
        });

    }

    private void prepare(){
        dataname = getResources().getStringArray(R.array.data_name);
        datauser = getResources().getStringArray(R.array.data_username);
        dataavatar = getResources().obtainTypedArray(R.array.data_avatar);
        datafollowers = getResources().getStringArray(R.array.data_follower);
        datafollowing = getResources().getStringArray(R.array.data_following);
        company = getResources().getStringArray(R.array.data_company);
        location = getResources().getStringArray(R.array.data_location);
        repositories = getResources().getStringArray(R.array.data_repositories);
    }

    private void datauser() {
        userList = new ArrayList<>();

        for (int i = 0; i < dataname.length; i++){
            User user = new User();
            user.setNama(dataname[i]);
            user.setUsername(datauser[i]);
            user.setAvatar(dataavatar.getResourceId(i, -1));
            user.setFollowing(datafollowing[i]);
            user.setFollowers(datafollowers[i]);
            user.setCompany(company[i]);
            user.setLocation(location[i]);
            user.setRepository(repositories[i]);
            userList.add(user);
        }

        adapterUser.setUsers(userList);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }
}