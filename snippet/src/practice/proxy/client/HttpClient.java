package practice.proxy.client;

import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;

import java.util.Date;

public class HttpClient {

    public static void main(String[] args) throws Exception {
//		doPost(9091);
//		doPost(9092);
//		doPost(9092);

		doGet(8085, "/proxy/abc.html");

		doGet(9091, "/test/abc.html");
	}

	public static void doPost(int port) throws Exception {
		String body = "{ \"Date\" : " + new Date() + "}";
		org.eclipse.jetty.client.HttpClient httpClient = new org.eclipse.jetty.client.HttpClient();
		httpClient.start();
		Request request = httpClient.newRequest("http://127.0.0.1:"+port+"/").method(HttpMethod.POST);
		request.header(HttpHeader.CONTENT_TYPE, "application/json");
		request.content(new StringContentProvider(body,"utf-8"));
		ContentResponse contentRes = request.send();
		System.out.println(contentRes.getContentAsString());
		httpClient.stop();
	}


	public static void doGet(int port, String url) throws Exception {
		org.eclipse.jetty.client.HttpClient httpClient = new org.eclipse.jetty.client.HttpClient();
		httpClient.start();
		Request request = httpClient.newRequest("http://127.0.0.1:"+port+url).method(HttpMethod.GET);
		request.header(HttpHeader.CONTENT_TYPE, "application/json");
		ContentResponse contentRes = request.send();
		System.out.println(contentRes.getContentAsString());
		System.out.println(contentRes.getHeaders().get("x-requestId"));
		httpClient.stop();
	}
}
