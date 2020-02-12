package Practica_1;

import static Practica_1.Interfaz.Acepatacion;
import static Practica_1.Interfaz.ErrorLista;
import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Reportes_HTML {
    
         public void tokensHtml(ArrayList<Tokens> Acepatacion) {

        String Contenido;
        Contenido = "<html>"
                + "<body>"
                + "<h1 align='center'>TABLA DE TOKENS</h1></br>"
                + "<table cellpadding='10' border = '1' align='center'>"
                + "<tr>"
                + "<td><strong>No."
                + "</strong></td>"
                + "<td><strong>Tipo"
                + "</strong></td>"
                + "<td><strong>Lexema"
                + "</strong></td>"
                + "<td><strong>Id"
                + "</strong></td>"
                + "<td><strong>Fila"
                + "</strong></td>"
                + "<td><strong>Columna"
                + "</strong></td>"
                + "</tr>";

        String CadTokens = "";
        String tempotk;

        for (int i = 0; i < Acepatacion.size(); i++) {

            tempotk = "";
            tempotk = "<tr>"
                    + "<td><strong>" + Integer.toString(i + 1)
                    + "</strong></td>"
                    + "<td>" + Acepatacion.get(i).getDescripcion()
                    + "</td>"
                    + "<td>"
                    + Acepatacion.get(i).getLexema()
                    + "</td>"
                    + "<td>" + Acepatacion.get(i).getId()
                    + "</td>"
                    + "<td>" + Acepatacion.get(i).getFila()
                    + "</td>"
                    + "<td>" + Acepatacion.get(i).getColumna()
                    + "</td>"
                    + "</tr>";
            CadTokens = CadTokens + tempotk;

        }

        Contenido = Contenido + CadTokens
                + "</table>"
                + "</body>"
                + "</html>";


        /*creando archivo html*/
        File file = new File("ReporteTokens.html");

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

    
     public void ErrorLexicoHtml(ArrayList<Tokens> ErrorLista) {
            String Contenido;
            Contenido = "<html>" +
            "<body>" +
            "<h1 align='center'>TABLA DE ERRORES</h1></br>" +
            "<table cellpadding='10' border = '1' align='center'>" +
            "<tr>" +
            "<td><strong>No." +
            "</strong></td>" +

            "<td><strong>Tipo" +
            "</strong></td>" +
            "<td><strong>Lexema" +
            "</strong></td>" +

           "<td><strong>Fila" +
            "</strong></td>" +

            "<td><strong>Columna" +
            "</strong></td>" +


            "</tr>";

            String CadError = "";
            String tempoError="";

            for (int i = 0; i < ErrorLista.size(); i++)
            {



                
                tempoError = "<tr>" +
                "<td><strong>" + Integer.toString(i + 1) +
                "</strong></td>" +
                "<td>" + ErrorLista.get(i).getDescripcion() +
                "</td>" +
                "<td>"
                + ErrorLista.get(i).getLexema() +
                "</td>" +


                "<td>" + ErrorLista.get(i).getFila() +
                "</td>" +

                "<td>" + ErrorLista.get(i).getColumna() +
                "</td>" +



                "</tr>";
                CadError = CadError + tempoError;

            }

            Contenido = Contenido + CadError +
            "</table>" +
            "</body>" +
            "</html>";


            
            
            /*creando archivo html*/
             File file = new File("Error.html");

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
           /* File.WriteAllText("Reporte de Errores.html", Contenido);
            System.Diagnostics.Process.Start("Reporte de Errores.html");*/
        }
    




}
