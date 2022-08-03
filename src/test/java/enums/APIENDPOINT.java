package enums;

public enum APIENDPOINT {
    ;

    APIENDPOINT() {
    }

    public enum CAT_1 {
        ENDPOINT("first endpoint");
        private String endPoint;

        CAT_1(String endPoint) {
            this.endPoint = endPoint;
        }

        public String getEndPoint() {
            return endPoint;
        }
    }

    public enum CAT_2 {
        ENDPOINT("first endpoint");
        private String endPoint;

        CAT_2(String endPoint) {
            this.endPoint = endPoint;
        }

        public String getEndPoint() {
            return endPoint;
        }
    }

    public enum CAT_3 {
        ENDPOINT("first endpoint");
        private String endPoint;

        CAT_3(String endPoint) {
            this.endPoint = endPoint;
        }

        public String getEndPoint() {
            return endPoint;
        }
    }
    }
