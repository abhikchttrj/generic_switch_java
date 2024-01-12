import java.util.Map;
import java.util.HashMap;

public class Television extends Devices{
    int channel;
    String mode;

    public Television(String dev_name) {
        super(dev_name, "television");
        this.channel = 0;
        this.mode = "TV";
    }

    public Map<String, String> get_details() {
        Map<String, String> values = new HashMap<>();
        values.put("channel", String.valueOf(this.channel));
        values.put("mode", this.mode);
        return values;
    }

    public int update_parameters(Map<String, String> values) {
        if (values.containsKey("channel")) {
            try {
                this.channel = Integer.parseInt(values.get("channel"));
            }
            catch (java.lang.NumberFormatException ex) {
                System.out.println("Error : Channel should be a number" + ex);
            }
        }
        if (values.containsKey("mode")) {
            this.mode = values.get("mode");
        }
        return 1;
    }
}