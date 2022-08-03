package enums.EVENTS;

public enum E_EVENTS_INFO {


    DATABASE_MYEVENT_INFO("id", "address_id", "owner_id", "title", "date", "fee", "duration", "description", "attendee_limit", "schedule", "tac", "status", "created", "is_active", "is_refundable", "updated", "refundable_up_to_day"),
    DATABASE_EVENTS_ATTENDANCE_INFO("id","attendee_id","event_id","number_of_attendees","status","created","updated","transaction_id"),
    DATABASE_EVENTS_CHECKOUT_INFO("id","owner_id","event_attendance_id","token","payment_state","session_id","created_at","updated_at","amount","deleted_at"),
    UI_EVENTBAR_CONTAINER_INFO("Title","Date","Time","Available Seat","Fee","Location");

    //    DATABASE_MYEVENT_INFO("id", "address_id", "owner_id", "title", "date", "fee", "duration", "description", "attendee_limit", "schedule", "tac", "status", "created", "is_active", "is_refundable", "updated", "refundable_up_to_day","id","owner_id","event_attendance_id","token","payment_state","session_id","created_at","updated_at","amount","deleted_at","id","attendee_id","event_id","number_of_attendees","status","created","updated","transaction_id"),
//        DATABASE_EVENTS_ATTENDANCE_INFO("id", "address_id", "owner_id", "title", "date", "fee", "duration", "description", "attendee_limit", "schedule", "tac", "status", "created", "is_active", "is_refundable", "updated", "refundable_up_to_day","id","owner_id","event_attendance_id","token","payment_state","session_id","created_at","updated_at","amount","deleted_at","id","attendee_id","event_id","number_of_attendees","status","created","updated","transaction_id"),
//        DATABASE_EVENTS_CHECKOUT_INFO("id", "address_id", "owner_id", "title", "date", "fee", "duration", "description", "attendee_limit", "schedule", "tac", "status", "created", "is_active", "is_refundable", "updated", "refundable_up_to_day","id","owner_id","event_attendance_id","token","payment_state","session_id","created_at","updated_at","amount","deleted_at","id","attendee_id","event_id","number_of_attendees","status","created","updated","transaction_id");
    private  Object title;
    private  Object date;
    private  Object time;

    E_EVENTS_INFO(Object title, Object date, Object time, Object availableSeat, Object fee, Object location) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.availableSeat = availableSeat;
        this.fee = fee;
        this.location=location;
    }

    private  Object availableSeat;
    private  Object fee;
    private  Object location;


    private  Object MYEVENT_id;
        private  Object MYEVENT_address_id;
        private  Object MYEVENT_owner_id;
        private  Object MYEVENT_title;
        private  Object MYEVENT_date;
        private  Object MYEVENT_fee;
        private  Object MYEVENT_duration;
        private  Object MYEVENT_description;
        private  Object MYEVENT_attendee_limit;
        private  Object MYEVENT_schedule;
        private  Object MYEVENT_tac;
        private  Object MYEVENT_status;
        private  Object MYEVENT_created;
        private  Object MYEVENT_is_active;
        private  Object MYEVENT_is_refundable;
        private  Object MYEVENT_updated;
        private  Object MYEVENT_refundable_up_to_day;

    E_EVENTS_INFO(Object MYEVENT_id, Object MYEVENT_address_id, Object MYEVENT_owner_id, Object MYEVENT_title, Object MYEVENT_date, Object MYEVENT_fee, Object MYEVENT_duration, Object MYEVENT_description, Object MYEVENT_attendee_limit, Object MYEVENT_schedule, Object MYEVENT_tac, Object MYEVENT_status, Object MYEVENT_created, Object MYEVENT_is_active, Object MYEVENT_is_refundable, Object MYEVENT_updated, Object MYEVENT_refundable_up_to_day) {
        this.MYEVENT_id = MYEVENT_id;
        this.MYEVENT_address_id = MYEVENT_address_id;
        this.MYEVENT_owner_id = MYEVENT_owner_id;
        this.MYEVENT_title = MYEVENT_title;
        this.MYEVENT_date = MYEVENT_date;
        this.MYEVENT_fee = MYEVENT_fee;
        this.MYEVENT_duration = MYEVENT_duration;
        this.MYEVENT_description = MYEVENT_description;
        this.MYEVENT_attendee_limit = MYEVENT_attendee_limit;
        this.MYEVENT_schedule = MYEVENT_schedule;
        this.MYEVENT_tac = MYEVENT_tac;
        this.MYEVENT_status = MYEVENT_status;
        this.MYEVENT_created = MYEVENT_created;
        this.MYEVENT_is_active = MYEVENT_is_active;
        this.MYEVENT_is_refundable = MYEVENT_is_refundable;
        this.MYEVENT_updated = MYEVENT_updated;
        this.MYEVENT_refundable_up_to_day = MYEVENT_refundable_up_to_day;
    }

        private  Object CHECKOUT_id;
        private  Object CHECKOUT_owner_id;
        private  Object CHECKOUT_event_attendance_id;
        private  Object CHECKOUT_token;
        private  Object CHECKOUT_payment_state;
        private  Object CHECKOUT_session_id;
        private  Object CHECKOUT_created_at;
        private  Object CHECKOUT_updated_at;
        private  Object CHECKOUT_amount;
        private  Object CHECKOUT_deleted_at;

    E_EVENTS_INFO(Object CHECKOUT_id, Object CHECKOUT_owner_id, Object CHECKOUT_event_attendance_id, Object CHECKOUT_token, Object CHECKOUT_payment_state, Object CHECKOUT_session_id, Object CHECKOUT_created_at, Object CHECKOUT_updated_at, Object CHECKOUT_amount, Object CHECKOUT_deleted_at) {
        this.CHECKOUT_id = CHECKOUT_id;
        this.CHECKOUT_owner_id = CHECKOUT_owner_id;
        this.CHECKOUT_event_attendance_id = CHECKOUT_event_attendance_id;
        this.CHECKOUT_token = CHECKOUT_token;
        this.CHECKOUT_payment_state = CHECKOUT_payment_state;
        this.CHECKOUT_session_id = CHECKOUT_session_id;
        this.CHECKOUT_created_at = CHECKOUT_created_at;
        this.CHECKOUT_updated_at = CHECKOUT_updated_at;
        this.CHECKOUT_amount = CHECKOUT_amount;
        this.CHECKOUT_deleted_at = CHECKOUT_deleted_at;
    }



        private Object ATTENDANCE_id;
        private  Object ATTENDANCE_attendee_id;
        private  Object ATTENDANCE_event_id;
        private  Object ATTENDANCE_number_of_attendees;
        private  Object ATTENDANCE_status;
        private  Object ATTENDANCE_created;
        private  Object ATTENDANCE_updated;
        private  Object ATTENDANCE_transaction_id;

    E_EVENTS_INFO(Object ATTENDANCE_id, Object ATTENDANCE_attendee_id, Object ATTENDANCE_event_id, Object ATTENDANCE_number_of_attendees, Object ATTENDANCE_status, Object ATTENDANCE_created, Object ATTENDANCE_updated, Object ATTENDANCE_transaction_id) {
        this.ATTENDANCE_id = ATTENDANCE_id;
        this.ATTENDANCE_attendee_id = ATTENDANCE_attendee_id;
        this.ATTENDANCE_event_id = ATTENDANCE_event_id;
        this.ATTENDANCE_number_of_attendees = ATTENDANCE_number_of_attendees;
        this.ATTENDANCE_status = ATTENDANCE_status;
        this.ATTENDANCE_created = ATTENDANCE_created;
        this.ATTENDANCE_updated = ATTENDANCE_updated;
        this.ATTENDANCE_transaction_id = ATTENDANCE_transaction_id;
    }


    public Object getMYEVENT_id() {
        return MYEVENT_id;
    }

    public Object getMYEVENT_address_id() {
        return MYEVENT_address_id;
    }

    public Object getMYEVENT_owner_id() {
        return MYEVENT_owner_id;
    }

    public Object getMYEVENT_title() {
        return MYEVENT_title;
    }

    public Object getMYEVENT_date() {
        return MYEVENT_date;
    }

    public Object getMYEVENT_fee() {
        return MYEVENT_fee;
    }

    public Object getMYEVENT_duration() {
        return MYEVENT_duration;
    }

    public Object getMYEVENT_description() {
        return MYEVENT_description;
    }

    public Object getMYEVENT_attendee_limit() {
        return MYEVENT_attendee_limit;
    }

    public Object getMYEVENT_schedule() {
        return MYEVENT_schedule;
    }

    public Object getMYEVENT_tac() {
        return MYEVENT_tac;
    }

    public Object getMYEVENT_status() {
        return MYEVENT_status;
    }

    public Object getMYEVENT_created() {
        return MYEVENT_created;
    }

    public Object getMYEVENT_is_active() {
        return MYEVENT_is_active;
    }

    public Object getMYEVENT_is_refundable() {
        return MYEVENT_is_refundable;
    }

    public Object getMYEVENT_updated() {
        return MYEVENT_updated;
    }

    public Object getMYEVENT_refundable_up_to_day() {
        return MYEVENT_refundable_up_to_day;
    }

    public Object getCHECKOUT_id() {
        return CHECKOUT_id;
    }

    public Object getCHECKOUT_owner_id() {
        return CHECKOUT_owner_id;
    }

    public Object getCHECKOUT_event_attendance_id() {
        return CHECKOUT_event_attendance_id;
    }

    public Object getCHECKOUT_token() {
        return CHECKOUT_token;
    }

    public Object getCHECKOUT_payment_state() {
        return CHECKOUT_payment_state;
    }

    public Object getCHECKOUT_session_id() {
        return CHECKOUT_session_id;
    }

    public Object getCHECKOUT_created_at() {
        return CHECKOUT_created_at;
    }

    public Object getCHECKOUT_updated_at() {
        return CHECKOUT_updated_at;
    }

    public Object getCHECKOUT_amount() {
        return CHECKOUT_amount;
    }

    public Object getCHECKOUT_deleted_at() {
        return CHECKOUT_deleted_at;
    }

    public Object getATTENDANCE_id() {
        return ATTENDANCE_id;
    }

    public Object getATTENDANCE_attendee_id() {
        return ATTENDANCE_attendee_id;
    }

    public Object getATTENDANCE_event_id() {
        return ATTENDANCE_event_id;
    }

    public Object getATTENDANCE_number_of_attendees() {
        return ATTENDANCE_number_of_attendees;
    }

    public Object getATTENDANCE_status() {
        return ATTENDANCE_status;
    }

    public Object getATTENDANCE_created() {
        return ATTENDANCE_created;
    }

    public Object getATTENDANCE_updated() {
        return ATTENDANCE_updated;
    }

    public Object getATTENDANCE_transaction_id() {
        return ATTENDANCE_transaction_id;
    }

    public Object getTitle() {
        return title;
    }

    public Object getDate() {
        return date;
    }

    public Object getTime() {
        return time;
    }

    public Object getAvailableSeat() {
        return availableSeat;
    }

    public String getFee() {
        return (String) fee;
    }

    public Object getLocation() {
        return location;
    }
}