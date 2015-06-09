import java.io.PrintWriter;

public class MyServlet extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
	    PrintWriter p = response.getWriter();
	    String name = request.getParameter("name");
	    String address = request.getParameter("address");
	    p.println("Hello " + name + " from " + address);
	  }
}
