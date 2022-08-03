package enums.USER;

public enum USERINFO {


    BUYER("buyer", "-8.4256", "115.2009", "buyer@mailsac.com", "buyer_password", "buyer_token"),
    SELLER("seller", "-8.4256", "115.3009", "seller@mailsac.com", "AQ4LPPAASQVuCLf", "seller_token"),



    ;


    private String lat;
    private String lng;
    private String email;
    private String password;
    private String userName;
    private String token;

    USERINFO(String userName, String lat, String lng, String email, String password, String token) {
        this.token = token;
        this.lat = lat;
        this.lng = lng;
        this.email = email;
        this.password = password;
        this.userName = userName;
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

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }



    public static class methods {


    }

}


