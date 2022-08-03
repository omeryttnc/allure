package enums.USER;

public class USER_MANAGER {
    private String lat;
    private String lng;
    private String email;
    private String password;
    private String userName;
    private String token;

    public USER_MANAGER(USERINFO userInfoCart) {
        switch (userInfoCart) {
            case SELLER:
                this.lat = USERINFO.SELLER.getLat();
                this.lng = USERINFO.SELLER.getLng();
                this.email = USERINFO.SELLER.getEmail();
                this.password = USERINFO.SELLER.getPassword();
                this.userName = USERINFO.SELLER.getUserName();
                this.token = USERINFO.SELLER.getToken();
                break;
            case BUYER:
                this.lat = USERINFO.BUYER.getLat();
                this.lng = USERINFO.BUYER.getLng();
                this.email = USERINFO.BUYER.getEmail();
                this.password = USERINFO.BUYER.getPassword();
                this.userName = USERINFO.BUYER.getUserName();
                this.token = USERINFO.BUYER.getToken();
                break;

        }
    }


    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getToken() {
        return token;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
