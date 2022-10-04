package services;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipFile {

private final int BUFFER_SIZE = 4096; //numero di byte scritti

	//Map coppia di elementi estratti da file json
	//Metodo che prende in input il file zip e restituisce una struttura Map
   	public Map<String, String> unzip(String zipPath) {
   		File fileZip = new File(zipPath);
   		Map<String, String> mapFiles = new HashMap<>();
   		// qualche controllo
   		if (!fileZip.exists()) // se il file zip non esiste
   			throw new IllegalArgumentException("UnzipFile: file o directory di origine inestistente: " + fileZip);

   		ZipInputStream zis = null;

   		try {
   			FileInputStream fis = new FileInputStream(zipPath);
   			zis = new ZipInputStream(new BufferedInputStream(fis));
   			ZipEntry entry;

         //scorre la lista dei file nell'archivio zip
   			while((entry = zis.getNextEntry()) != null) {       

   				ByteArrayOutputStream baos = new ByteArrayOutputStream();
   				//legge il file da estrarre
   				int cont;
   				byte data[] = new byte[BUFFER_SIZE];
   				while((cont = zis.read(data, 0, BUFFER_SIZE)) != -1) {
   					baos.write(data, 0, cont); 
   				}
            String file = baos.toString();
            mapFiles.put(entry.getName(), file);
          
         }

         return mapFiles;

      } catch (FileNotFoundException fnfe) {
         fnfe.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } finally {
         try {
            if(zis != null)
               zis.close(); // chiude l'archivio zip in lettura
         } catch (IOException ioe) {
            ioe.printStackTrace();
         }
      }

      // qualora ci fosse qualche malfunzionamento
      return null;
    }
}


