public class Event {

    private final String name;  //Name of the event
    private final String date;  //Date
    private final String time;  //Time
    private final String booth; //Location
    private final String cost;  //Cost
    private final String type;  //Type of event

    /**
     * Builder class
     */
    public static class Builder{

        //Required parameters
        private String name;

        //Optional parameters
        private String date = "";
        private String time = "";
        private String booth = "";
        private String cost = "";
        private String type = "";

        public Builder(String name){
            this.name = name;
        }

        public Builder date(String value){
            date = value;
            return this;
        }

        public Builder time(String value){
            time = value;
            return this;
        }

        public Builder booth(String value){
            booth = value;
            return this;
        }

        public Builder cost(String value){
            cost = value;
            return this;
        }

        public Builder type(String value){
            type = value;
            return this;
        }

        public Event build(){
            return new Event(this);
        }
    }

    private Event(Builder builder){
        name = builder.name;
        date = builder.date;
        time = builder.time;
        booth = builder.booth;
        cost = builder.cost;
        type = builder.type;
    }

    /**
     * toString method
     * @return A string showing the name, date, time, location, and cost of the event
     */
    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20s%-20s$%-20s",type, name, date, time, booth, cost);
    }
}
