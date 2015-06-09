import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;



public class Client {

	public static void main(String[] args) throws Exception{
	    InetAddress inet = InetAddress.getLocalHost();

	    Socket soc = new Socket(inet, 2001);
	    InputStream in = soc.getInputStream();
	    Scanner r = new Scanner(in);
	    OutputStream out = soc.getOutputStream();
	    PrintWriter printer = new PrintWriter(out);

	    printer.println("GET data/test.txt");
	    printer.flush();

	    String line;
	    while (r.hasNextLine()) {
	      line = r.nextLine();
	      System.out.println(line);
	    }
	}
}
