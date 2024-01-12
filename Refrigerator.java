import java.util.HashMap;
import java.util.Map;

public class Refrigerator extends Devices {
    int temperature;
    String mode;

    public Refrigerator(String device_name) {
        super(device_name, "refrigerator");
        this.temperature = 0;
        this.mode = "AUTO";
    }

    public Map<String, String> get_details() {
        Map<String, String> values = new HashMap<>();
        values.put("temperature", String.valueOf(this.temperature));
        values.put("mode", this.mode);
        return values;
    }

    public int update_parameters(Map<String, String> values) {
        if (values.containsKey("temperature")) {
            try {
                this.temperature = Integer.parseInt(values.get("temperature"));
            }
            catch (java.lang.NumberFormatException ex) {
                System.out.println("Error : Temperature should be a number" + ex);
            }
        }
        if (values.containsKey("mode")) {
            this.mode = values.get("mode");
        }
        return 1;
    }
}
