package org.howard.edu.lsp.finalExam;
import java.util.*;

public class MapUtilities {

	public static int commonKeyValuePairs(HashMap<String, String> map1,
			HashMap<String, String> map2)throws NullMapException{
			//implementation
		
			if(map1.size()==0 || map2.size()==0) {
				return 0;
			}
			if(map1.containsValue(null)||map2.containsValue(null)) {
				throw new NullMapException("One or both maps are null!");
			}
			int numCommon = 0;
			
			//for each entry while iterating through map1, compare to see if both values appear in map2
			for(Map.Entry<String, String> mapEntry: map1.entrySet()) {
				String key = mapEntry.getKey(); 
				String val = mapEntry.getValue();
				String val2; //will be the value we use for comparison
				if(map2.containsKey(key)) {
					
					val2 = map2.get(key); //get, unlike getValue or getKey, finds the value/key that matches the parameter it takes
					if(val == val2) {
						numCommon++; //common pair found, increment the number of common pairs
					}
				
				}
				
			}
		return numCommon;
		}

			

}


