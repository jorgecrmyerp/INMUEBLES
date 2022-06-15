package com.jgr.inmuebles.utilidad;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class CreaBackupBBDD {

    /**
     * Instantiates a new crea backup BBDD.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public CreaBackupBBDD() throws IOException{
	/** constructor por defecto */
    }
    
    /**
     * Crea fichero backup.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void creaFicheroBackup() throws IOException {
	// define backup file
	 Calendar cal = Calendar.getInstance();
    //DateFormat hourdateFormat = new SimpleDateFormat("HH.mm.ssdd-MM-yyyy");
    DateFormat hourdateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    String historial = hourdateFormat.format(cal.getTime());
    Path currentRelativePath = Paths.get("");
    String s = currentRelativePath.toAbsolutePath().toString();
    String ruta = "\\"+"log"+"\\";
   		 
    String salida = s+ruta;
    salida= salida+historial+".sql";     
    
    //log.debug("creo fichero backup "+ salida);
   File fbackup = new File(salida);
   // execute mysqldump command
   //String[] command = new String[] {"cmd.exe", "/c", "mysqldump.exe --quick --lock-tables --user=root --password=root  practicafinal"};
   String[] command = new String[] {"cmd.exe", "/c", "mysqldump.exe -u --lock-tables --user=root --password=root  practicafinal"};
   final Process process = Runtime.getRuntime().exec(command);
   // write process output line by line to file
   if(process!=null) {
       new Thread(new Runnable() {
           @Override
           public void run() {
               try{
                   try(BufferedReader reader = new BufferedReader(new InputStreamReader(new DataInputStream(process.getInputStream()))); 
                       BufferedWriter writer = new BufferedWriter(new FileWriter(fbackup))) {
                       String line;
                       while((line=reader.readLine())!=null)   {
                           writer.write(line);
                           writer.newLine();
                       }
                   }
               } catch(Exception ex){
                  
                   // handle or log exception ...
               }
           }
       }).start();
   }
   
}

    /**
     * Restore.
     */
    private static void restore() {
	   try {
	      Process p = Runtime
	            .getRuntime()
	            .exec("C:/Aplicaciones/wamp/bin/mysql/mysql5.1.36/bin/mysql -u root -ppassword database");

	      FileOutputStream os = (FileOutputStream) p.getOutputStream();
	      FileInputStream fis = new FileInputStream("backup_pruebas.sql");
	      byte[] buffer = new byte[1000];

	      int leido = fis.read(buffer);
	      while (leido > 0) {
	         os.write(buffer, 0, leido);
	         leido = fis.read(buffer);
	      }

	      os.flush();
	      os.close();
	      fis.close();

	   } catch (Exception e) {
	      e.printStackTrace();
	      
	   }

	
    }

}
