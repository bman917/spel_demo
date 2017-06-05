package com.datalex;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DyamicSearchVariables
{
    public static String ONE_WEEK = "1 week";
    
    public static Map<String, String> searchParams = new HashMap<String, String>();
    
    static {
        searchParams.put("origin", "JFK");
    }
    
    
    public String getCurrentDate()
    {
        return new Date().toString();
    }
    
    public static long days(java.lang.Integer days)
    {
        return days;
    }
    
    
}
