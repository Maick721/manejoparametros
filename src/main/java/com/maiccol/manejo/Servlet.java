package com.maiccol.manejo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/* Siempre usamos una llave*/
@WebServlet("/manejoparametros/url-get")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Establecemos el tipo de contenido de la respuesta a HTML
        resp.setContentType("text/html");

        /* Creamos un objeto de PrintWriter para escribir la respuesta */
        PrintWriter out = resp.getWriter();

        // Capturamos los datos enviados desde index.html a través de parámetros GET
        String saludo = req.getParameter("saludo");
        String nombre = req.getParameter("nombre");

        // Generamos el contenido de la respuesta HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Manejo Parametros GET</title>");
        out.println("</head>");
        out.println("<body>");

        // Comprobamos si se han pasado los parámetros y generamos la respuesta correspondiente
        if (saludo != null && nombre != null) {
            out.println("<h2>El saludo enviado es: " + saludo + " " + nombre + "</h2>");
        } else if (saludo != null) {
            out.println("<h2>El saludo enviado es: " + saludo + "</h2>");
        } else if (nombre != null) {
            out.println("<h2>Hola, mi nombre es: " + nombre + "</h2>");
        } else {
            out.println("<h2>No se pasaron ni el saludo ni el nombre</h2>");
        }

        // Validación del parámetro "codigo" para asegurarnos de que es un número
        try {
            int codigo = Integer.parseInt(req.getParameter("codigo"));
            out.println("<h2>El código es: " + codigo + "</h2>");
        } catch (NumberFormatException e) {
            // Si ocurre una excepción, significa que el código no es un número válido
            out.println("<h3>El código es inválido</h3>");
        }

        // Enviamos el saludo nuevamente como parte de la respuesta
        out.println("El saludo enviado es: " + saludo);
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
