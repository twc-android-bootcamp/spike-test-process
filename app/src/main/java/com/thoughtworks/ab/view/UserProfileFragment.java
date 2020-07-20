package com.thoughtworks.ab.view;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.thoughtworks.ab.R;
import com.thoughtworks.ab.repository.entity.User;
import com.thoughtworks.ab.viewmodel.UserProfileViewModel;
import com.thoughtworks.ab.viewmodel.UserVO;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.SingleScheduler;
import io.reactivex.schedulers.Schedulers;

public class UserProfileFragment extends Fragment {
    private UserProfileViewModel userProfileViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_profile, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userProfileViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(Objects.requireNonNull(getActivity()).getApplication())).get(UserProfileViewModel.class);

        view.findViewById(R.id.button_loading).setOnClickListener(v -> userProfileViewModel.findUser("123456789")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(
                result -> Toast.makeText(getContext(), result.toString(), Toast.LENGTH_SHORT).show()
        ));

        view.findViewById(R.id.button_save).setOnClickListener(view1 -> {
            UserVO userVO = new UserVO();
            userVO.setName(new Random().nextInt() + "");
            userVO.setLastName("Yuan");
            userVO.setId("123456789");
            userProfileViewModel.save(userVO).subscribeOn(Schedulers.io()).subscribe();
        });
    }
}