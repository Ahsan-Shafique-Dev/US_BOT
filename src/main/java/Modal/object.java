package Modal;

import java.util.ArrayList;

public class object {
    private String name;
    private String state;
    private String imgUrl;

    public object(String profile_name, String profile_state, String profile_imgurl) {
        this.name = profile_name;
        this.state = profile_state;
        this.imgUrl = profile_imgurl;
    }
    public void setProfileName(String name) {
        this.name = name;
    }
    public void setStateName(String state) {
        this.state = state;
    }
    public void setImageUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getProfileName() {
        return name;
    }
    public String getStateName() {
        return state;
    }
    public String getImgUrl() {
        return imgUrl;
    }

    @Override
    public String toString() {
        return ("PROFILE_NAME:"+ " " +this.getProfileName()+ "From" +
                " STATE: "+this.getStateName() + "   =>" +
                " IMAGE_URL: "+" " + this.getImgUrl());
    }

}
