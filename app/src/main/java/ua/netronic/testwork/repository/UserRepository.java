package ua.netronic.testwork.repository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import ua.netronic.testwork.api.UsersAPI;
import ua.netronic.testwork.models.OurResult;

public class UserRepository {
    private final UsersAPI api;
    private  static final  int COUNT =20;

    @Inject
    public UserRepository(UsersAPI apiService) {
        this.api = apiService;
    }

    public @NonNull Observable<ArrayList<OurResult>> updateData() {
        //TODO First load from db after server
        return api
                .getResponse(COUNT)
                .observeOn(Schedulers.newThread())
                .flatMap(OurResult::convertToOurResult)
                .subscribeOn(Schedulers.io());
    }
}
