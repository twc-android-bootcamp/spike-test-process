package com.thoughtworks.ab.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.thoughtworks.ab.R;
import com.thoughtworks.ab.MainApplication;
import com.thoughtworks.ab.viewmodel.UserProfileViewModel;
import com.thoughtworks.ab.viewmodel.UserVO;

public class UserProfileFragment extends Fragment {
    private UserProfileViewModel userProfileViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_profile, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userProfileViewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);

        view.findViewById(R.id.button_loading).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfileFragment.this.userProfileViewModel.findUser("123").observe(UserProfileFragment.this, new Observer<UserVO>() {
                    @Override
                    public void onChanged(UserVO user) {
                        Toast.makeText(getContext(), user.toString(), Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        view.findViewById(R.id.button_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserProfileFragment.this.userProfileViewModel.save("sjyuan", "Yuan");
            }
        });
    }
}