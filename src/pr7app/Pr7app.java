/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pr7app;

import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;

/**
 *
 * @author ivan
 */
public class Pr7app {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws it.sauronsoftware.ftp4j.FTPIllegalReplyException
     * @throws it.sauronsoftware.ftp4j.FTPException
     * @throws java.io.FileNotFoundException
     * @throws it.sauronsoftware.ftp4j.FTPDataTransferException
     * @throws it.sauronsoftware.ftp4j.FTPAbortedException
     */
    public static void main(String[] args) throws IOException, IllegalStateException, FTPIllegalReplyException, FTPException, FileNotFoundException, FTPDataTransferException, FTPAbortedException {
        // TODO code application logic here
       

        URL url = new URL("http://192.168.122.200/docs/ic10-m04-WindowsServer.pdf"); //Nos conectamos a la URL
        url.openConnection(); //Abrimos la conexion
        InputStream reader = url.openStream(); //Selecionamos el lector con el que abre
        FileOutputStream writer = new FileOutputStream("C:\\Users\\Adria\\Desktop\\adria.pdf");
        byte[] buffer = new byte[153600];
        int bytesRead = 0;
        while ((bytesRead = reader.read(buffer)) > 0) {
            writer.write(buffer, 0, bytesRead);
            //buffer = new byte[153600];
        }
        writer.close();
        reader.close();
        
        FTPClient client = new FTPClient();
        client.connect("srv.toca.cat");
        client.login("fulano", "Platano123");
        client.upload(new java.io.File("C:\\Users\\Adria\\Desktop\\adria.pdf"));
        client.disconnect(true);
    }

}
