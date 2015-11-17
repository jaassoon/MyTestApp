package com.example.htc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class MyHttpClient {
	public static void connect(String sURL)
	{

		BufferedReader in = null;  
        try {  
            HttpClient client = new DefaultHttpClient();  
//            HttpPost request = new HttpPost("https://service9.nsdhealth.com/Services/");  
            HttpPost request = new HttpPost("https://service9.nsdhealth.com/");
             
            List<NameValuePair> postParameters = new ArrayList<NameValuePair>();  
             
            postParameters.add(new BasicNameValuePair("id", "12345"));  
            postParameters.add(new BasicNameValuePair("username", "dave"));  
             
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(  
                    postParameters);  
 
             
            //request.setEntity(formEntity);  
            HttpResponse response = client.execute(request);  
            in = new BufferedReader(  
                    new InputStreamReader(  
                            response.getEntity().getContent()));  
 
            StringBuffer string = new StringBuffer("");  
            String lineStr = "";  
            while ((lineStr = in.readLine()) != null) {  
                string.append(lineStr + "\n");  
            }  
            in.close();  
 
            String resultStr = string.toString();  
            System.out.println(resultStr);  
        } catch(Exception e) {  
             e.printStackTrace();
        } finally {  
            if (in != null) {  
                try {  
                    in.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
	}

	    private static String convertStreamToString(InputStream is) {
	    /*
	     * To convert the InputStream to String we use the BufferedReader.readLine()
	     * method. We iterate until the BufferedReader return null which means
	     * there's no more data to read. Each line will appended to a StringBuilder
	     * and returned as String.
	     */
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();

	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return sb.toString();
	}
}
