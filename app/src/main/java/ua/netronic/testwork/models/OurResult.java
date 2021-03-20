package ua.netronic.testwork.models;

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
