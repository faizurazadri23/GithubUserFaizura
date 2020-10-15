package com.faizurazadri.githubuser;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private String nama;
    private String username;
    private int avatar;
    private String followers;
    private String following;
    private String company;
    private String location;
    private String repository;

    public User(){

    }

    protected User(Parcel in) {
        nama = in.readString();
        username = in.readString();
        avatar = in.readInt();
        followers = in.readString();
        following = in.readString();
        company = in.readString();
        location = in.readString();
        repository = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(username);
        dest.writeInt(avatar);
        dest.writeString(followers);
        dest.writeString(following);
        dest.writeString(company);
        dest.writeString(location);
        dest.writeString(repository);
    }
}
