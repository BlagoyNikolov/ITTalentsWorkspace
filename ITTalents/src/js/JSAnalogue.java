package js;

import java.util.ArrayList;
import java.util.List;

public class JSAnalogue {
	public static void main(String[] args) {
		looping();
	}


//var catsKeyValuePairs = [];
//var catNames = [];
//var catValues = [];
//$.each(cats.split(","), function(i,e){
//	catsKeyValuePairs.push(e);
//	//alert(catsKeyValuePairs);
//	for (var i = 0; i < catsKeyValuePairs.length; i++) {
//		var kv = catsKeyValuePairs[i].split("=");
//		catValues.push(kv[0]);
//		catNames.push(kv[1]);
//	}
//});

	private static void looping() {
		List<String> amount = new ArrayList<>();
		List<String> name = new ArrayList<>();
		String input = new String("6000=HealthCare, 1250=Car, 600=ALS, 7500=SDW");
		String[] entries = input.split(",");
		for (String kv : entries) {
			String[] keyvalues = kv.split("=");
			amount.add(keyvalues[0]);
			name.add(keyvalues[1]);
		}
		System.out.println(amount);
		System.out.println(name);
	}
}