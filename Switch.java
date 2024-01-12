import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


public class Switch{
	ArrayList<Devices> device_list;
	
	public Switch() {
		this.device_list = new ArrayList<Devices>();
	}
	
	public void add_device(Devices device) {
		this.device_list.add(device);
	}
	
	public void get_devices() {
		for(Devices dev : this.device_list) {
			System.out.println(dev.device_name);
		}
	}
	
	public int update_device_state(String device_name, int state) {
		for(Devices dev : this.device_list) {
			if (dev.device_name.equals(device_name)) {
				return dev.update_state(state);
			}
		}
		System.out.println("No device found with name : " + device_name);
		return 0;
	}
	
	public int get_device_state(String device_name) {
		for(Devices dev : this.device_list) {
			if(dev.device_name.equals(device_name)) {
				return dev.get_state();
			}
		}
		System.out.println("No device found with name : " + device_name);
		return 0;
	}

	public Map<String, String> get_device_details(String device_name) {
		for(Devices dev : this.device_list) {
			if(dev.device_name.equals(device_name)) {
				return dev.get_details();
			}
		}
		System.out.println("No device found with name : " + device_name);
		return null;
	}

	public int update_device_parameters(String device_name, Map<String, String> values) {
		for(Devices dev : this.device_list) {
			if (dev.device_name.equals(device_name)) {
				return dev.update_parameters(values);
			}
		}
		System.out.println("No device found with name : " + device_name);
		return 0;
	}
	
	public static void main(String[] args) {
		Switch sw = new Switch();
		String television_name = "television_1";
		Television tv = new Television(television_name);
		sw.add_device(tv);
		
		sw.get_devices();
		System.out.println("State of " + television_name + " = " + sw.get_device_state(television_name));
		
		int ret_val = sw.update_device_state(television_name, 1);
		if (ret_val == 0) {
			System.out.println("Error in updating state for : " + television_name);
		}
		
		System.out.println("State of " + television_name + " = " + sw.get_device_state(television_name));

		String refrigerator_name = "refrigerator_1";
		sw.add_device(new Refrigerator(refrigerator_name));

		sw.get_devices();

		System.out.println("State of " + refrigerator_name + " = " + sw.get_device_state(refrigerator_name));
		if (sw.update_device_state(refrigerator_name, 1) == 0) {
			System.out.println("Error in updating state for : " + refrigerator_name);
		}

		System.out.println("State of " + refrigerator_name + " = " + sw.get_device_state(refrigerator_name));

		System.out.println("State of " + refrigerator_name + " = " + sw.get_device_state(refrigerator_name));
		if (sw.update_device_state(refrigerator_name, 0) == 0) {
			System.out.println("Error in updating state for : " + refrigerator_name);
		}

		System.out.println("State of " + refrigerator_name + " = " + sw.get_device_state(refrigerator_name));

		sw.get_devices();

		// Get Refrigerator details
		Map<String, String> ref_values = sw.get_device_details(refrigerator_name);
		System.out.println("Refrigerator details : \t" + ref_values);

		// Get Television details
		Map<String, String> tv_values = sw.get_device_details(television_name);
		System.out.println("Television details : \t" + tv_values);

		// Update Refrigerator temperature
		ref_values.put("temperature", "5");
		ref_values.put("mode", "COOL");
//		System.out.println("Refrigerator details : \t" + ref_values);
		if (sw.update_device_parameters(refrigerator_name, ref_values) == 0) {
			System.out.println("Error in updating parameters of : " + refrigerator_name);
		}

		// Get Refrigerator details
		ref_values = sw.get_device_details(refrigerator_name);
		System.out.println("Updated Refrigerator details : \t" + ref_values);

		// Update Television channel
		tv_values.put("channel", "100");
		tv_values.put("mode", "AV");
//		System.out.println("Television details : \t" + tv_values);
		if (sw.update_device_parameters(television_name, tv_values) == 0) {
			System.out.println("Error in updating parameters of : " + television_name);
		}

		// Get Television details
		tv_values = sw.get_device_details(television_name);
		System.out.println("Updated Television details : \t" + tv_values);

	}
	
}