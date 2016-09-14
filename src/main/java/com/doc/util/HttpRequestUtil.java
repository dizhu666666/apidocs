package com.doc.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by zhoumengkang on 19/1/16.
 */
public class HttpRequestUtil {

    public static String postData(String url, String data, Header[] headers) {
        HttpClient httpClient = getClient();
        String responseText = "";
        HttpResponse httpResponse = null;

        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().
                    setSocketTimeout(5000).
                    setConnectTimeout(5000).
                    build();
            httpPost.setConfig(requestConfig);

            httpPost.setHeaders(headers);

            httpPost.setEntity(new StringEntity(data, "UTF-8"));

            httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                responseText = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseText;
    }
    public static String post(String url, String data, Header[] headers, boolean ssl) {
        HttpClient httpClient = getClient();
        String responseText = "";
        HttpResponse httpResponse = null;

        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().
                    setSocketTimeout(5000).
                    setConnectTimeout(5000).
                    build();
            httpPost.setConfig(requestConfig);

            httpPost.setHeaders(headers);

            httpPost.setEntity(new StringEntity(data, "UTF-8"));

            httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                responseText = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseText;
    }

    public static String post(String url, List<NameValuePair> params,Map<String,String> headers) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse httpResponse = null;

        try {
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
            httpPost.setConfig(requestConfig);
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            if (headers != null && !headers.isEmpty()) {  
                for (Map.Entry<String, String> entry : headers.entrySet()) {  
                	httpPost.addHeader(entry.getKey(),entry.getValue());
                }  
            }
            	
            httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                responseText = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return responseText;
    }

    public static String get(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse httpResponse = null;

        try {
            HttpGet httpGet = new HttpGet(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
            httpGet.setConfig(requestConfig);

            httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                responseText = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (httpResponse != null) {
                    httpResponse.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return responseText;
    }

    public static HttpClient getClient() {

        HttpClient httpClient = new DefaultHttpClient();

        return httpClient;
    }

    public static String doGet(String url){
    	//创建一个Request
    	final Request request = new Request.Builder()
    			.url(url)
    			.build();
    	return  execute(request);
    }
    public static String doPost(String url,String reqbody,Map<String,Object> map){
    	
    	FormEncodingBuilder builder=addParamToBuilder(reqbody, map);
	     RequestBody body = builder.build();
	      Request request = new Request.Builder()
	      .url(url)
	      .post(body)
	      .build();
		return execute(request);
    }
    
    public static String doPut(String url,String reqbody,Map<String,Object> map){
    	FormEncodingBuilder builder=addParamToBuilder(reqbody, map);
	     RequestBody body = builder.build();
	      Request request = new Request.Builder()
	      .url(url)
	      .put(body)
	      .build();
		return execute(request);
    }
    public static String doDelete(String url,String reqbody,Map<String,Object> map){
    	FormEncodingBuilder builder=addParamToBuilder(reqbody, map);
    	RequestBody body = builder.build();
    	Request request = new Request.Builder()
    			.url(url)
    			.delete(body)
    			.build();
    	return execute(request);
    }
    
    
    
    public static FormEncodingBuilder  addParamToBuilder(String reqbody,Map<String,Object> map){
    	FormEncodingBuilder builder=new FormEncodingBuilder();
    	if(!StringUtils.isEmpty(reqbody)){
	    	if(reqbody.startsWith("?")){
	    		reqbody=reqbody.substring(1);
	    	}
	    	String[] params=reqbody.split("&");
	    	for(int i=0;i<params.length;i++){
	    		if(params[i].equals("")){
	    			continue;
	    		}
	    		String [] kv=params[i].split("=");
	    		builder.add(kv[0], kv[1]);
	    	}
    	}
    	if(map!=null){
    		Iterator<Entry<String,Object>> ite= map.entrySet().iterator();
    		for(;ite.hasNext();){
    			Entry<String,Object> kv=ite.next();
    			builder.add(kv.getKey(), kv.getValue().toString());
    		}
    	}
    	return builder;
    }
    
    public static void asynPost(String url,String reqbody,Map<String,Object> map){
    	FormEncodingBuilder builder=addParamToBuilder(reqbody, map);
	     RequestBody body = builder.build();
	      Request request = new Request.Builder()
	      .url(url)
	      .post(body)
	      .build();
    	executeAsyn(request);
    }
    public static void asynGet(String url){
        Request request = new Request.Builder()
                .url(url)
                .build();
        executeAsyn(request);
    }
    public static String executeAsyn(Request request){
    	System.out.println("start");
    	try {
    		OkHttpClient client = new OkHttpClient();
    		client.newCall(request).enqueue(new Callback() {
				
				@Override
				public void onResponse(Response response) throws IOException {
					 System.out.println(response.body().contentType().toString());
					System.out.println(response.body().string());
				}
				
				@Override
				public void onFailure(Request response, IOException e) {
					 e.printStackTrace();
				}
			});
    		
    		System.out.println("end");
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return "{\"error\":\"fail\"}";
    }
     public static String execute(Request request){
    	 try {
    		 OkHttpClient client = new OkHttpClient();
    		 Response response = client.newCall(request).execute();
 			if (response.isSuccessful()) {
 				return response.body().string();
 			} 
 		} catch (IOException e) {
 			e.printStackTrace();
 		}
 		return "{\"error\":\"fail\"}";
     }
    
    
    public static void main(String[] args) throws MalformedURLException, IOException {
		//System.out.println(getResultFromUrl("http://show.pvgo.com:16162/live/announcement", "GET", "a=b"));
		//System.out.println(getResultFromUrl("http://show.pvgo.com:16162/message/to/fans", "POST",""));
		//System.out.println(doGet("http://show.pvgo.com:16162/live/announcement"));
		//System.out.println(doPost("http://show.pvgo.com:16162/message/to/fans", null,null));
		//System.out.println(doGet("http://localhost:8080/api/texas/open?a=b&uid=2&apiName=get"));
    	//System.out.println(doPost("http://localhost:8080/api/texas/finish", "liveid=5533&uid=523",null));
		//System.out.println(doPut("http://localhost:8080/project-docs/api/list", "a=b&c=1&apiName=puts",null));
		//System.out.println(doDelete("http://localhost:8080/project-docs/api/lists", "a=b&c=1&apiName=delete",null));
		//System.out.println(getResultFromUrl("http://localhost:8080/project-docs/api/list", "DELETE",""));
		//System.out.println(get("http://show.pvgo.com:16162/live/announcement"));
		//System.out.println(post("http://show.pvgo.com:16162/message/to/fans", null, null));
	//-------
    //System.out.println(doPost("http://211.155.84.134:16161/game/info", "p={\"liveid\":1999}",null));
//    	System.out.println(doPost("http://localhost:8080/api/texas/robSeat", "liveGameId=19&location=1&uidd=1",null));
//    	System.out.println(doPost("http://localhost:8080/api/texas/robSeat", "liveGameId=19&location=2&uidd=2",null));
//    	System.out.println(doPost("http://localhost:8080/api/texas/robSeat", "liveGameId=19&location=3&uidd=3",null));
//    	System.out.println(doPost("http://localhost:8080/api/texas/robSeat", "liveGameId=19&location=4&uidd=4",null));
//    	System.out.println(doPost("http://localhost:8080/api/texas/call", "liveGameId=19&location=4",null));
//    	System.out.println(doPost("http://localhost:8080/api/texas/call", "liveGameId=19&location=1",null));
//    	System.out.println(doPost("http://localhost:8080/api/texas/fold", "liveGameId=19&location=2",null));
    	//System.out.println(doPost("http://localhost:8080/api/texas/fold", "liveGameId=19&location=3&amount=20",null));
    	//asynPost("http://www.baidu.com", null, null);
    	System.out.println(TimeManager.StringToTime("2016-08-22 11:24", "yyyy-MM-dd HH:mm"));
//    	Thread thread=new Thread(new Atorun());
//    	thread.start();
	}
    
    private AtomicInteger atoint=new AtomicInteger(0);
    
    public void modifyato(){
    	
    	if(atoint.intValue()==0){
    		System.out.println(atoint.getAndIncrement());
    		System.out.println(atoint.incrementAndGet());
    	}
    	System.out.println(atoint.intValue());
    }
}
class Atorun implements Runnable{

	@Override
	public void run() {
		
		new HttpRequestUtil().modifyato();
		
	}
	
}

