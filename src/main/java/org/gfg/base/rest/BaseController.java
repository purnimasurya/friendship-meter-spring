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
        map.put("india1", "delhi");
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
}
