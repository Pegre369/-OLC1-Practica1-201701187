
package Practica_1;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;



public class Tabla_Follow {
    
         public void tokensHtml(ArrayList<Lista_Follow> Acepatacion,String nombre) {

        String Contenido;
        Contenido = "<html>"
                + "<body>"
                + "<h1 align='center'>TABLA DE FOLLOW</h1></br>"
                + "<table cellpadding='10' border = '1' align='center'>"
                + "<tr>"
                + "<td><strong>Hoja"
                + "</strong></td>"
                + "<td><strong>Numero de hoja"
                + "</strong></td>"
                + "<td><strong>Follow"
                + "</strong></td>"
                + "</tr>";

        String CadTokens = "";
        String tempotk;

        for (int i = 0; i < Acepatacion.size(); i++) {

            tempotk = "";
            tempotk = "<tr>"
                    + "<td>" + Acepatacion.get(i).getHoja()
                    + "</td>"
                    + "<td>"
                    + String.valueOf(Acepatacion.get(i).getNumero())
                    + "</td>"
                    + "<td>" + Acepatacion.get(i).getFollow()
                    + "</td>"
                    + "</tr>";
            CadTokens = CadTokens + tempotk;

        }

        Contenido = Contenido + CadTokens
                + "</table>"
                + "</body>"
                + "</html>";


        /*creando archivo html*/
        File file = new File(nombre+".html");

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
