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
import ua.netronic.testwork.databinding.UserDetailsFragmentBinding;
import ua.netronic.testwork.databinding.UsersFragmentBinding;
import ua.netronic.testwork.models.OurResult;
import ua.netronic.testwork.vm.UserViewModel;

@AndroidEntryPoint
public class UserDetailsFragment extends Fragment {
    private UserViewModel userViewModel;
    private UserDetailsFragmentBinding binding;
    private String email;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userViewModel = new ViewModelProvider(requireActivity()).get(UserViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = UserDetailsFragmentBinding.inflate(inflater,container,false);
        email = getArguments().getString("email");
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userViewModel.response.observe(this.getViewLifecycleOwner(), response -> {
            for(OurResult ourResult : response) {
                if(ourResult.getEmail().equals(email)) {
                    binding.setResult(ourResult);
                    return;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        binding = null;
        super.onDestroyView();
    }
}
