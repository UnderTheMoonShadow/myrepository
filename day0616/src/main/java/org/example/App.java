package org.example;

import com.google.gson.Gson;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Gson gson = new Gson();
        System.out.println( gson.toJson(new Date()) );
    }
}
