package ua.netronic.testwork.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import dagger.hilt.android.AndroidEntryPoint;
import ua.netronic.testwork.adapters.OurResultAdapter;
import ua.netronic.testwork.customuibinding.CustomHandlerInterface;
import ua.netronic.testwork.databinding.UsersFragmentBinding;
import ua.netronic.testwork.vm.UserViewModel;

@AndroidEntryPoint
public class UserListFragment extends Fragment implements CustomHandlerInterface {

    private UserViewModel userViewModel;
    private OurResultAdapter ourResultAdapter;
    private UsersFragmentBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        UsersFragmentBinding binding = UsersFragmentBinding.inflate(inflater,container,false);

        ourResultAdapter = new OurResultAdapter(this);
        binding.fragmentMainRecycler.setAdapter(ourResultAdapter);
        Log.d("TAG","TAG");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userViewModel.response.observe(this.getViewLifecycleOwner(), response -> ourResultAdapter.updateList((response)));
    }

    @Override
    public void onDestroyView() {
        binding = null;
        ourResultAdapter.setNullListUserFragment();
        super.onDestroyView();
    }

    @Override
    public void onClick(String email) {

    }
}
