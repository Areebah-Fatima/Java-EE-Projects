/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

// Imports
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author areebah
 */

// For servlet
@WebServlet(name = "BookForm", urlPatterns = {"/BookForm"})
public class BookForm extends HttpServlet {
    
    private static final String CONTENT_TYPE = "text/html";
    // Use a prepared statement to store a student into the database
    private PreparedStatement pstmt;
    Connection connection;

    /** Initialize variables */
    public void init() throws ServletException {
      initializeJdbc();
    }
    
     /** Initialize database connection */
    private void initializeJdbc() {

        try {

            String connectionString = "jdbc:derby://localhost:1527/PersonDB";

            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/BookDB", "areebah", "fatima");
            
            // Create a Statement for title, page, author using isbn
            pstmt = connection.prepareStatement("select Book.title, Author.author, Book.pages from Author, Book, WrittenBy " +
            "where Book.isbn = ? and Author.id = WrittenBy.id and Book.isbn = WrittenBy.isbn");
        }
        catch (Exception ex) {
          ex.printStackTrace();
        }
  }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BookForm</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BookForm at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // Do get for input page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // response will be in html
        response.setContentType(CONTENT_TYPE);
        
        // make a print writer
        PrintWriter out = response.getWriter();

        // format website in html
        out.println("<head><title>Find Books</title></head>");
        out.println("<h4>Please Enter a ISBN</h4>");
    
        // form method is a post (cause we're doing http); action will be projectname/servlet name (specifies whats being post)
        out.println("<form method=\"post\" action=" +
            "/BooksWebApp/BookForm>");
        
        // Text box to input isbn
        out.println("<p><input type=\"text\" id=\"isbn\" name=\"isbn\"></p>");
        
        // input type (button) 
        out.println("<p><input type=\"submit\" value=\"Submit\" >");
        out.println("<input type=\"reset\" value=\"Reset\"></p>");
        out.println("</form>");

        out.close(); // Close stream
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    // Do post for output page
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
      
        // User inputted isbn
        String isbn = request.getParameter("isbn");
        //String isbn = "1-43-024692-8";
     
        try {
            
            // Set ? in query string to user input
            pstmt.setString(1, isbn);
            ResultSet rset = pstmt.executeQuery();
            int count = 1;

            // If true it means our search returned results
            if(rset.next())
            {

                do{
                    
                    // Retrieve title, author, and pages
                    String title = rset.getString(1);
                    String author = rset.getString(2);
                    int pages = rset.getInt(3);

                    if(count<2){
                        
                        // print response
                        out.println("<html>");
                        out.println("<head><title>Find Books</title></head>");
                        out.println("<body>");
                        out.println("Title: " +
                        title + "<br>"  + "Number of Pages: " + pages + "<br>"+  "By: " + author);
                        out.println("</body></html>");
                        
                        System.out.println(title + " " + author + " " + pages);
                        count++;
                        
                    }
                    else{
                        
                        // For when more than one author
                        out.println("<html>");
                        out.println(" and " + author);
                        out.println("</html></p>");
                       
                    }

                }while(rset.next()); 
            }

            else{

                // If true it means we weren't able to recover any books (notify user)
                out.println("The previously provided isbn didn't return back any results");
                System.out.println("The previously provided isbn didn't return back any results");
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(BookForm.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        out.close(); // Close stream
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
