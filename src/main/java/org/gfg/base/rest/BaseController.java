package org.gfg.base.rest;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class BaseController {
	
	// http://localhost:8080/
    @RequestMapping(value = "", method = RequestMethod.GET)
    public <T> T listUsers() {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("india", "delhi");
        map.put("korea", "seoul");
        map.put("afghanistan", "kabul");
        map.put("canada", "ottawa");
        
        return (T) map;
    }
    
    // http://localhost:8080/reverse
    @RequestMapping(value = "/reverse", method = RequestMethod.GET)
    public <T> T reverseString(@RequestParam("name") String name) {
    	String reverse = "";
    	
    	for(int i = name.length() - 1; i >= 0; i--)
        {
            reverse = reverse + name.charAt(i);
        }
    	
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("name", name);
        map.put("reverse_name", reverse);
        
        return (T) map;
    }
    
    // http://localhost:8080/friendship-meter
    @RequestMapping(value = "/friendship-meter", method = RequestMethod.GET)
    public <T> T getFriendshipMeter(@RequestParam(value = "name1", defaultValue = "Gautam Karthik") String name1, @RequestParam(value = "name2", defaultValue = "Deepika Padukone") String name2) {
    	int fMeter = (int)(Math.random() * 50 + 1);
    	
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("name1", name1);
        map.put("name2", name2);
        map.put("friendship_meter", fMeter);
        
        return (T) map;
    }
}
