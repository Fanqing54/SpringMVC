package fan.util;

import java.util.HashMap;
import java.util.Map;

public class EhcacheTest {

	/**
	 * @param args
	 */
	static EhCache ehCache = new EhCache(); 
	public static void main(String[] args) throws Exception {
		Map cacheMap=new HashMap();
		cacheMap.put("name", "Faith");
		ehCache.addToCache("cache_map",cacheMap); 
		HashMap<String,String> map=(HashMap)ehCache.getCacheElement("cache_map");
	    for(Map.Entry<String, String> entry:map.entrySet()){
	        System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
	    //for (String key : map.keySet()) {
	    	   //System.out.println("key= "+ key + " and value= " + map.get(key));
	    }
	}

}
