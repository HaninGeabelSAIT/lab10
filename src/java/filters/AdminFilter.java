
package filters;

import dataaccess.UserDB;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hanin
 */
public class AdminFilter implements Filter {
    
  
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        //code executed before the servlet
        HttpServletRequest httpRequest = (HttpServletRequest)request; 
        HttpSession session = httpRequest.getSession(); 
        String email = (String)session.getAttribute("email"); 
        
            UserDB user = new UserDB();
         int roleID = user.get(email).getRole().getRoleId();
            
            if (roleID != 1) {
              HttpServletResponse HttpResponse = (HttpServletResponse)response; 
            HttpResponse.sendRedirect("notes");
                return;
            }
     
        
            chain.doFilter(request, response);//execute the servlet
       //code executed after the servlet
        
     
    }

  

 
    @Override
    public void destroy() {        
    }

   
    @Override
    public void init(FilterConfig filterConfig) {        
       
    }

   
    
  
    
}
