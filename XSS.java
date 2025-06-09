import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class XSSVulnerableServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🚨 This is vulnerable to XSS
        String userInput = request.getParameter("name");

        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Welcome " + userInput + "</h1>");
        response.getWriter().println("</body></html>");
    }
}
