package controlador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/primos")
public class servlets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // obtener parametros del formulario

        int inicio = Integer.parseInt(request.getParameter("inicio"));
        int fin = Integer.parseInt(request.getParameter("final"));

        // lista para almacenar numeros primos

        List<Integer> primos = new ArrayList<>();   // Crea una lista vacía de enteros para almacenar los números primos.
        for (int i = inicio; i <= fin; i++) {       // Itera desde el valor 'inicio' hasta el valor 'fin', ambos incluidos.
            if (esPrimo(i)) {                       // Verifica si el número actual 'i' es primo utilizando el método 'esPrimo'.
                primos.add(i);                      // Si 'i' es primo, lo añade a la lista 'primos'.
            }
        }

        // pasar datos a resultado.jsp

        request.setAttribute("primos", primos);
        request.setAttribute("cantidad", primos.size());
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
      // calculamos numeros primos

    private boolean esPrimo(int num) {                 // Metodo privado que determina si un número entero es primo.
        if (num <= 1) return false;                   // Si el número es menor o igual a 1, no es primo, retorna false.
        for (int i = 2; i <= Math.sqrt(num); i++) {   // Itera desde 2 hasta la raíz cuadrada del número.
            if (num % i == 0) return false;           // Si 'num' es divisible por 'i', no es primo, retorna false.
        }
        return true;                                   // Si no se encontró ningún divisor, retorna true, indicando que el número es primo.
    }


}

