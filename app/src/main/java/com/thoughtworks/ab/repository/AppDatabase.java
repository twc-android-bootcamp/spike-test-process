package com.thoughtworks.ab.repository;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.thoughtworks.ab.repository.entity.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DBUserDataSource userDBDataSource();
}