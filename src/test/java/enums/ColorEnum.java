package enums;

public enum ColorEnum {
    RED("rgba(231, 76, 60, 1)", "rgb(231, 76, 60)","",""),
    BLUE("rgb(52, 152, 219)", "rgba(52, 152, 219, 1)","",""),
    GREEN("rgba(7, 188, 12, 1)", "rgba(25, 135, 84, 1)","rgba(144, 238, 144, 1)","rgb(7, 188, 12)"),

    ;



    private final String action;
    private final String action2;
    private final String action3;
    private final String action4;

    public String getAction() {
        return this.action;
    }

    public String getAction2() {
        return this.action2;
    }

    public String getAction3() {
        return action3;
    }

    public String getAction4() {
        return action4;
    }

    private ColorEnum(String action, String action2, String action3, String action4) {

        this.action = action;
        this.action2 = action2;
        this.action3 = action3;
        this.action4 = action4;
    }
}
