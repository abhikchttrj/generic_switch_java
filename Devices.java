import java.io.*;
import java.util.HashMap;
import java.util.Map;


public abstract class Devices{
    int state = 0;
    String device_name;
    String device_type;

    public Devices(String dev_name, String dev_type){
        this.state = 0;
        this.device_name = dev_name;
        this.device_type = dev_type;
    }

    public int update_state(int state){
        if (this.state == state) {
            System.out.println(device_name + ", Already at state : " + state);
            return 0;
        }
        this.state = state;
        return 1;
    }

    public int get_state() {
        return this.state;
    }

    public abstract Map<String, String> get_details();

    public abstract int update_parameters(Map<String, String> values);
}
