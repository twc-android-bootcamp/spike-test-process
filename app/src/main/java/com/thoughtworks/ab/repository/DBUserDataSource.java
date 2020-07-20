package com.thoughtworks.ab.repository;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.thoughtworks.ab.repository.entity.User;

import io.reactivex.Completable;
import io.reactivex.Maybe;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface DBUserDataSource extends DataSource {

    @Query("SELECT * FROM user WHERE id = :userId")
    Maybe<User> find(String userId);

    @Insert(onConflict = REPLACE)
    Completable save(User user);
}
