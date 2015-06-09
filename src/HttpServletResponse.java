import java.io.PrintWriter;

public class HttpServletResponse {
  PrintWriter p;

  public HttpServletResponse(PrintWriter p) {
    this.p = p;
  }

  public PrintWriter getWriter() {
    return p;
  }
}