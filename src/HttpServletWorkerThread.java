import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class HttpServletWorkerThread extends Thread {
	BlockingQueue<Socket> a;

	public HttpServletWorkerThread(BlockingQueue<Socket> a) {
		this.a = a;
	}

	public void run() {
		while (true) {

			try {
				Socket s = a.take();
				
				InputStream in = s.getInputStream();
				Scanner r = new Scanner(in);
				
				OutputStream out = s.getOutputStream();
				PrintWriter printer = new PrintWriter(out);
				
				
				
				String request;
				request = r.nextLine();
				
				System.out.println("Sup bitches i am going to handle this "+ request);
				
				if(request.startsWith("GET")){
					String fileName = request.substring(4);
					System.out.println(fileName);
					FileInputStream fin = new FileInputStream(fileName);
					Scanner f = new Scanner(fin);
					
					String line;
					while(f.hasNextLine()){
						line = f.nextLine();
						printer.println(line);
					}
					System.out.println("Sup bitches! I have finished handling "+fileName);
				} else if (request.startsWith("POST")) {
			          String params = r.nextLine();
			          HttpServletRequest servletRequest = new HttpServletRequest(params) ;
			          HttpServletResponse response =new HttpServletResponse(printer);
			          HttpServlet servlet = new MyServlet();
			          servlet.doPost(servletRequest, response);
				}
				printer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//String str = (String) Class.forName("java.lang.String").newInstance();
			
		}

	}
}
