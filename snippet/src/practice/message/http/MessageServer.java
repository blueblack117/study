package practice.message.http;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletHandler;
import practice.message.queue.ProcessTimeoutChecker;

public class MessageServer {

    public static void main(String[] args) throws Exception {
		Thread serverThread = new Thread(new ProcessTimeoutChecker());
		serverThread.start();

		new MessageServer().start();
	}

	public void start() throws Exception {
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost("127.0.0.1");
		http.setPort(8080);
		server.addConnector(http);

		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(Dispatcher.class, "/*");
		server.setHandler(servletHandler);

		server.start();
		server.join();
	}
}
