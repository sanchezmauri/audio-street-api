package com.adst.api;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.Objects;

public class User {

    public User() {}

    @Id
    public ObjectId _id;

    public String username;

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(_id, user._id) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_id, username);
    }

    @Override
    public String
    toString() {
        return "User{" +
                "_id=" + _id +
                ", username='" + username + '\'' +
                '}';
    }
}
