package enums.EVENTS;

public enum ENDPOINTS {
     //abdullah abi
        EVENT_CREATE("https://test.urbanicfarm.com/api/account/event/create"),
        GET_MY_EVENT("https://test.urbanicfarm.com/api/account/event/getMyEvents"),
        GET_ALL_EVENT("https://test.urbanicfarm.com/api/public/getAllEvents"),
        REGISTER_EVENT("https://test.urbanicfarm.com/api/public/getAllEvents"),
        DELETE_EVENT("https://test.urbanicfarm.com/api/account/event/delete"),



    ADDRESS_CHANGELOCATION("https://test.urbanicfarm.com/api/account/change/location"),
    GET_ALL_ADDRESS("https://test.urbanicfarm.com/api/account/address/getAddress"),
    GET_ALL_ADDRESS_CANLI("https://urbanicfarm.com/api/account/address/getAddress"),
    UPDATE_ADDRESS("https://test.urbanicfarm.com/api/account/address/update"),
    ADD_ADDRESS("https://test.urbanicfarm.com/api/account/address/addAddress"),
    DELETE_ADDRESS("https://test.urbanicfarm.com/api/account/address/delete"),
    ADDRESS_DETAILS("https://test.urbanicfarm.com/api/account/address/details"),



    BASKET_getTotal("https://test.urbanicfarm.com/api/public/basket/getTotal"),
    GET_CART_DETAILS("https://test.urbanicfarm.com/api/cart/getCartDetails"),
    //Abdullah: GET_CART_DETAILS calismayinca ekledim.
    GET_BASKET_DETAILS("https://test.urbanicfarm.com/api/public/basket/getBasketDetails"),
    REMOVE_PRODUCT_FROM_BASKET("https://test.urbanicfarm.com/api/public/basket/product/remove/{productId}"),
    DELETE_PRODUCT_FROM_BASKET("https://test.urbanicfarm.com/api/public/basket/product/delete/{productId}"),
    ADD_PRODUCT_TO_BASKET("https://test.urbanicfarm.com/api/public/basket/product/add/58262"),



    GET_UNREAD_MESSAGES_COUNT("https://test.urbanicfarm.com/api/chat/getUnreadMessagesCount"),
    SEND_MESAJ("https://test.urbanicfarm.com/api/chat/sendMsg"),
    CHANGE_CONVERSATION_STATUS("https://test.urbanicfarm.com/api/chat/changeConversationStatus"),
    GET_CONVERSATION_STATUS("https://test.urbanicfarm.com/api/chat/getConversations"),


    HUB_ALL("https://test.urbanicfarm.com/api/account/hub/getMyHubs"),
    HUBS_CREATE ("https://test.urbanicfarm.com/api/account/hub/create"),
    HUB_VEGETABLES_AND_FRUITS_HUB("https://test.urbanicfarm.com/api/account/hub/getHubDetails/VEGETABLES_AND_FRUITS_HUB"),
    HUB_DAIRY_HUB("https://test.urbanicfarm.com/api/account/hub/getHubDetails/DAIRY_HUB"),
    HUB_GARDENING_TOOLS_HUB("https://test.urbanicfarm.com/api/account/hub/getHubDetails/GARDENING_TOOLS_HUB"),
    HUB_GARDENING_SERVICES_HUB("https://test.urbanicfarm.com/api/account/hub/getHubDetails/GARDENING_SERVICES_HUB"),
    HUB_SEED_HUB("https://test.urbanicfarm.com/api/account/hub/getHubDetails/SEED_HUB"),
    HUB_SEEDLING_AND_SAPLING_HUB("https://test.urbanicfarm.com/api/account/hub/getHubDetails/SEEDLING_AND_SAPLING_HUB"),
    HUB_COMPOST_HUB("https://test.urbanicfarm.com/api/account/hub/getHubDetails/COMPOST_HUB"),
    HUB_WORM_HUB("https://test.urbanicfarm.com/api/account/hub/getHubDetails/WORM_HUB"),
    HUB_FERTILIZER_HUB("https://test.urbanicfarm.com/api/account/hub/getHubDetails/FERTILIZER_HUB"),
    HUB_TREES_HUB("https://test.urbanicfarm.com/api/account/hub/getHubDetails/TREES_HUB"),
    HUB_HERBS_AND_FLOWERS_HUB("https://test.urbanicfarm.com/api/account/hub/getHubDetails/HERBS_AND_FLOWERS_HUB"),

    GET_HUB_DETAILS("https://test.urbanicfarm.com/api/account/hub/getHubDetails/"),
    GET_MY_HUBS("https://test.urbanicfarm.com/api/account/hub/getMyHubs"),
    PRODUCT_UPDATE_IN_HUB("https://test.urbanicfarm.com/api/account/hub/product/update"),
    PRODUCT_DELETE_IN_HUB("https://test.urbanicfarm.com/api/account/hub/product/delete"),


    PRODUCT_update("https://test.urbanicfarm.com/api/account/hub/product/update"),
    PRODUCT_delete("https://test.urbanicfarm.com/api/public/basket/product/delete/"),
    PRODUCT_add("https://test.urbanicfarm.com/api/public/basket/product/add/"),


    APPLY_PROMOCODE("https://test.urbanicfarm.com/api/account/promoCode/applyPromoCode"),
    CHECK_PROMOCODE_WITH_PRICE("https://test.urbanicfarm.com/api/account/promoCode/checkPromoCode"),
    CHECK_PROMOCODE_WITHOUT_PRICE("https://test.urbanicfarm.com/api/account/promoCode/checkPromoCode"),


    MY_BUYS("https://test.urbanicfarm.com/api/account/order/get/myBuys"),
    MY_SELLS("https://test.urbanicfarm.com/api/account/order/get/mySells"),


    GET_INFO("https://test.urbanicfarm.com/api/account/getUserInfo"),
    REGISTER("https://test.urbanicfarm.com/api/public/register"),
    LOGIN("https://test.urbanicfarm.com/api/public/login"),


    WEEKLY_reActivateWeeklyOrder("https://test.urbanicfarm.com/api/account/weeklyorder/reActivateWeeklyOrder"),
    WEEKLY_createWeeklyOrder("https://test.urbanicfarm.com/api/account/weeklyorder/createWeeklyOrder"),
    WEEKLY_getWeeklyOrderList("https://test.urbanicfarm.com/api/account/weeklyorder/getWeeklyOrderList"),
    WEEKLY_getWeeklyOrderPastIterations("https://test.urbanicfarm.com/api/account/weeklyorder/getWeeklyOrderPastIterations"),
    WEEKLY_getWeeklyOrderIterations("https://test.urbanicfarm.com/api/account/weeklyorder/getWeeklyOrderIterations"),


    ALL_ZIPCODE("https://test.urbanicfarm.com/api/public/zipcode/allZipCodes"),
    SIPARIS_ALINAN_ZIPCODE("https://test.urbanicfarm.com/api/public/zipcode/woZipCodes"),



    ;
        private final String endPoint;

        ENDPOINTS(String endPoint) {

            this.endPoint = endPoint;
        }

        public String getEndPoint() {
            return endPoint;
        }

}
