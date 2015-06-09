import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class HttpServer {
	
	
	public static void main(String[]args) throws Exception{
		
		System.out.println("Sup bitches, server is up and running");
		BlockingQueue<Socket> a = new ArrayBlockingQueue<Socket>(10);
		ServerSocket soc = new ServerSocket(2001);
		for(int i = 0; i<4; i++){
			HttpServletWorkerThread slave = new HttpServletWorkerThread(a);
			slave.start();
		}
		while (true) {
		      Socket s = soc.accept();
		      a.put(s);
		    }
	}
}
