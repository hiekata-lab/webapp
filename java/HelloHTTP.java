// Based on BalusC example from:
// http://stackoverflow.com/questions/3732109/simple-http-server-in-java-using-only-java-se-api
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class HelloHTTP {
    private static Map<String, String> env;

    public static void main(String[] args) throws Exception {
	env = System.getenv();
	int port = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
	    // Logging IP address of request to stdout
	    System.out.println("Request received from: " + t.getRemoteAddress().toString());

	    // Displaying Hello message
	    String hello = "Hello Criteo !!";
	    String lang = env.get("HELLO_LANG");
	    if (lang != null && lang.equals("FR")) {
		hello = "Bonjour Criteo !!";
	    }
            String response = "<html><body><h1>" + hello + "</h1>\n";

	    // Displaying environment variables
	    response += "<h2>Environment variables:</h2><ul>\n";
	    for (String envName : env.keySet()) {
		response += "<li>" + envName + '=' + env.get(envName) + "</li>\n";
	    }
	    response += "</ul></body></html>\n";

	    // Sending response
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}