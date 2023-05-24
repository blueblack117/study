package practice.proxy.http;

import logger.TestLogger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class ProxyServer implements Runnable {

	private String name;
	private Server server;

	private String host;
	private int port;

	private boolean bStop = true;
	public ProxyServer(int port) {
		this.port = port;
	}

	public ProxyServer(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Server getServer() {
		return server;
	}

	public boolean isbStop() {
		return bStop;
	}

	public void setbStop(boolean bStop) {
		this.bStop = bStop;
	}

	public void start() {
        TestLogger.print("ProxyServer[" + name + "] Starting. port = " + port);

		server = new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost(this.host);
		http.setPort(this.port);
		server.addConnector(http);

		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(ProxyDispatcher.class, "/*");
		server.setHandler(servletHandler);

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
        TestLogger.print("ProxyServer[" + name + "] Started.");
	}

	public void stop() {
        TestLogger.print("ProxyServer[" + name + "] stopped.");
		try {
			server.stop();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void run() {
		start();

		while (bStop) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		stop();
	}
}
