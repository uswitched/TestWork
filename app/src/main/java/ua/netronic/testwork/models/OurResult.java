package ua.netronic.testwork.models;

import java.util.ArrayList;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;

public class OurResult {
    private String name;
    private String email;
    private String phone;
    private String img;
    private String bigImg;
    private String gender;

    public OurResult(String name, String email, String phone, String img, String bigImg, String gender) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.img = img;
        this.bigImg = bigImg;
        this.gender = gender;
    }

    public static @NonNull Observable<ArrayList<OurResult>> convertToOurResult(Response response) {
        ArrayList<OurResult> list = new ArrayList<>();
        for(Result result1 : response.getResults())
            list.add(new OurResult(
                    result1.getName().getFirst(),
                    result1.getEmail(),
                    result1.getPhone(),
                    result1.getPicture().getMedium(),
                    result1.getPicture().getLarge(),
                    result1.getGender()
            ));

        return io.reactivex.rxjava3.core.Observable.just(list);
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getImg() {
        return img;
    }

    public String getBigImg() {
        return bigImg;
    }

    public String getGender() {
        return gender;
    }
}
