package Practica_1;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;

public class Tabla_Transicion_Graficar {

    public void Tabla(String S, LinkedList<String> encabezado, String nombre) {

        String Contenido;
        Contenido = "<html>"
                + "<body>"
                + "<h1 align='center'>TABLA DE TRANSICIONES</h1></br>"
                + "<table cellpadding='10' border = '1' align='center'>"
                + "<tr>"
                + "<td><strong>Estado"
                + "</strong></td>"
                + "<td><strong>Terminales"
                + "</strong></td>"
                + "</tr>";

        String CadTokens = "";
        String tempotk;
        
        tempotk = "";
        tempotk = "<tr>";
        for (int i = 0; i < encabezado.size(); i++) {

            tempotk = tempotk + "<td>" + ""
                    + "</td>"
                    + "<td>"
                    + encabezado.get(i)
                    + "</td>";

            CadTokens = CadTokens + tempotk;

        }

        CadTokens = CadTokens + "</tr>";
        
        tempotk = "<tr>";
        CadTokens =CadTokens +tempotk + "<td>" + S
                + "</td>"
                + "</tr>";;

        Contenido = Contenido + CadTokens
                + "</table>"
                + "</body>"
                + "</html>";


        /*creando archivo html*/
        File file = new File(nombre + ".html");

        try {

            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(Contenido);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Desktop.getDesktop().open(file);
            //archivo.delete();

        } catch (Exception ex) {

        }
        /*File.WriteAllText("Reporte de Tokens.html", Contenido);
            System.Diagnostics.Process.Start("Reporte de Tokens.html");*/

    }

}
