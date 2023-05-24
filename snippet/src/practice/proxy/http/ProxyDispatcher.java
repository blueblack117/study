package practice.proxy.http;

import com.google.gson.Gson;
import logger.TestLogger;
import practice.message.vo.RequestBody;
import practice.message.vo.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProxyDispatcher extends HttpServlet {

	ProxyServlet servlet = new ProxyServlet();

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res);
	}

	protected void process(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
		TestLogger.print("Request uri : "+ req.getRequestURL());
//		TestLogger.print("Request method : "+ req.getMethod());
//		TestLogger.print("Request path : "+ req.getPathInfo());

//		String[] path = req.getPathInfo().substring(1).split("/");
//
		RequestBody reqBody = null;
		if ("POST".equals(req.getMethod())) {
			String body = getBody(req);
//			reqBody = fromJson(body);
			TestLogger.print("Request body : " + body);
		}

		resp.setStatus(200);
//		resp.getWriter().write(toJson(result));
		resp.getWriter().write("OK -- " + req.getRequestURL());
    }

    public static String getBody(HttpServletRequest request) throws IOException {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();
        return body;
    }

	private String toJson(ResponseBody result) {
		Gson gson = new Gson();
		String json = gson.toJson(result);
		return json;
	}

	private RequestBody fromJson(String body) {
		Gson gson = new Gson();
		RequestBody reqBody = gson.fromJson(body, RequestBody.class);
		return reqBody;
	}
}