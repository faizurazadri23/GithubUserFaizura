package com.faizurazadri.githubuser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterUser extends BaseAdapter {

    private final Context context;
    private ArrayList<User> users = new ArrayList<>();

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public AdapterUser(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        }

        ViewHolderUser viewHolder = new ViewHolderUser(itemView);
        User user = (User) getItem(position);
        viewHolder.bindUser(user);
        return itemView;
    }

    public class ViewHolderUser{
        private TextView nama,username;
        private CircleImageView avatar;

        ViewHolderUser(View view){
            nama = view.findViewById(R.id.txt_name);
            username = view.findViewById(R.id.txt_user);
            avatar = view.findViewById(R.id.img_photo);
        }

        void bindUser (User user){
            nama.setText(user.getNama());
            username.setText(user.getUsername());
            avatar.setImageResource(user.getAvatar());
        }
    }
}
