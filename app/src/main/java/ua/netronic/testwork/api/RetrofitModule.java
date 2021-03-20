package ua.netronic.testwork.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class RetrofitModule {
    private static final String baseURL = "https://randomuser.me/api/";

    @Provides
    public static OkHttpClient okHttpClient() {
        return new OkHttpClient
                .Builder()
                .build();
    }

    @Provides
    @Singleton
    public static UsersAPI provideAPI(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient())
                .build()
                .create(UsersAPI.class);
    }
}
