package ua.netronic.testwork.vm;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;
import ua.netronic.testwork.models.OurResult;
import ua.netronic.testwork.repository.UserRepository;

@HiltViewModel
public class UserViewModel extends ViewModel {
    private final UserRepository userRepository;
    @NonNull Disposable subscription;

    private final MutableLiveData<ArrayList<OurResult>> _response = new MutableLiveData<>();
    public LiveData<ArrayList<OurResult>> response = _response;

    @Inject
    public  UserViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
        getUsers();
    }

    private void  getUsers() {
        subscription = userRepository.updateData()
                .subscribe(
                        _response::postValue,
                        Throwable::printStackTrace,
                        () -> Log.d(UserViewModel.this.getClass().getName(), "UserLoaded"));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        subscription.dispose();
    }
}
