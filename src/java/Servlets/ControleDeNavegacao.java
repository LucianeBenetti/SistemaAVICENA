
package Servlets;

import controller.Usuario.UsuarioController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.vo.Usuario.UsuarioVO;

/**
 *
 * @author 80119050
 */
public class ControleDeNavegacao extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String var1 = request.getParameter("sair");
        String var2 = request.getParameter("sairdocadastro");
        String var3 = request.getParameter("avicena");
        
        ArrayList<String> variaveis = new ArrayList<>();
        variaveis.add(var1);
        variaveis.add(var2);
        variaveis.add(var3);
        
        System.out.println(var3);
        for (int i = 0; i < variaveis.size(); i++) {
            String variavelDeControle = variaveis.get(i);

            if (variavelDeControle != null) {
                switch (variavelDeControle) {
                    case "sair":
                       
                        request.getSession().invalidate();        
                        request.getRequestDispatcher("Index.jsp").forward(request, response);
                        break;

                    case "sairdocadastro":
                        request.getRequestDispatcher("Index.jsp").forward(request, response);
                        break;
                        
                    case "avicena":
                       //  System.out.println("A variável é: " + variaveis.get(i));
                        request.getRequestDispatcher("WEB-INF/PaginaInicial.jsp").forward(request, response);
                        break;

                    default:
                        request.getRequestDispatcher("Index.jsp").forward(request, response);
                        break;

                }
            }
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
