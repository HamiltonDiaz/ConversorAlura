import java.math.BigDecimal;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        String monedaOrigen="";
        String monedaFinal="";
        double cantidad= 1;

        String menu = """
        ***********************************************
        Sea bienvenido/a al conversor de moneda =
        
        1) Dólar =>> Peso argentino
        2) Peso argentino =>> Dólar
        3) Dólar =>> Real brasileño
        4) Real brasileño =>> Dólar
        5) Dólar =>> Peso colombiano
        6) Peso colombiano =>> Dólar
        7) Salir
        ***********************************************
        """;

        while (true){
            System.out.println(menu);
            System.out.println("Escribe una opción:");
            var busqueda = lectura.nextInt();

            if (busqueda==7){
                System.out.println("¡Hasta pronto!");
                break;
            }

            System.out.println("Escribe el monto");
            cantidad = lectura.nextDouble();

            ConsultaMoneda consultaMoneda = new ConsultaMoneda();
            Moneda moneda = consultaMoneda.convertirMoneda(busqueda, cantidad);
            monedaOrigen= moneda.base_code();
            monedaFinal=moneda.target_code();

            System.out.println("El valor de "+ cantidad + " [" +  monedaOrigen + "] corresponde al valor final de ==> " +
                    BigDecimal.valueOf(moneda.conversion_result()) + "[" + monedaFinal +"]");
        }




    }
}
