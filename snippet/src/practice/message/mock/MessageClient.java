package practice.message.mock;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;

public class MessageClient {

    public static void main(String[] args) throws Exception {
//		create("PLAY", 15);
//		create("LOG", 10);
//		create("PLAY", 5);
//		send("PLAY", "test");
//		receive("PLAY");

		create("TEST");
		receive("TEST");
		Thread.sleep(2000);
//		send("TEST", "test");
		receive("TEST");
		Thread.sleep(2000);
//		send("TEST", "test");
		receive("TEST");
	}


	public static void create(String queue, int size) throws Exception {
		String body = "{ \"QueueSize\" : "+size+"}";
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		Request request = httpClient.newRequest("http://127.0.0.1:8080/CREATE/"+queue).method(HttpMethod.POST);
		request.header(HttpHeader.CONTENT_TYPE, "application/json");
		request.content(new StringContentProvider(body,"utf-8"));
		ContentResponse contentRes = request.send();
		System.out.println(contentRes.getContentAsString());
		httpClient.stop();
	}

	public static void create(String queue) throws Exception {
		String body = "{ \"QueueSize\" : 10, \"ProcessTimeout\" : 10, \"MaxFailCount\" : 3, \"WaitTime\" : 3 }";
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		Request request = httpClient.newRequest("http://127.0.0.1:8080/CREATE/"+queue).method(HttpMethod.POST);
		request.header(HttpHeader.CONTENT_TYPE, "application/json");
		request.content(new StringContentProvider(body,"utf-8"));
		ContentResponse contentRes = request.send();
		System.out.println(contentRes.getContentAsString());
		httpClient.stop();
	}

	public static void send(String queue, String msg) throws Exception {
		String body = "{ \"Message\" : \"test\" }";
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		Request request = httpClient.newRequest("http://127.0.0.1:8080/SEND/"+queue).method(HttpMethod.POST);
		request.header(HttpHeader.CONTENT_TYPE, "application/json");
		request.content(new StringContentProvider(body,"utf-8"));
		ContentResponse contentRes = request.send();
		System.out.println(contentRes.getContentAsString());
		httpClient.stop();
	}

	public static void receive(String queue) throws Exception {
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		ContentResponse contentRes = httpClient.newRequest("http://127.0.0.1:8080/RECEIVE/"+queue).method(HttpMethod.GET)
				.send();
		System.out.println(contentRes.getContentAsString());
		httpClient.stop();
	}
}
