package controler;

import dtos.ArticuloDTO;
import exception.ServiceException;
import services.ArticuloService;
import services.impl.ArticuloServiceImpl;

import java.io.*;
import java.net.HttpRetryException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.xml.ws.http.HTTPException;

public class ArticuloControler extends HttpServlet {

    ArticuloService articuloService = new ArticuloServiceImpl();



    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {



        articuloService.consultarArticulo((Integer.parseInt(req.getParameter("id"))));

        // Obtenemos un objeto Print Writer para enviar respuesta
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Metodo GET</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Llamar al recurso Articulo</p>");
        pw.println("</body>");
        pw.close();

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        ArticuloDTO articuloDTO = new ArticuloDTO();
        ArticuloService articuloService = new ArticuloServiceImpl();


        articuloDTO.setDescripcion(req.getParameter("descripcion"));


        try {
            articuloService.ingresarArticulo(articuloDTO);
        } catch (ServiceException e) {

            e.printStackTrace();
        }
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Método Post</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Llamar al recurso Articulo</p>");
        pw.println(req.getParameter("descripcion"));
        pw.println(req.getParameter("precio"));
        pw.println("</body>");
        pw.close();



    }


    public void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


    }


    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}