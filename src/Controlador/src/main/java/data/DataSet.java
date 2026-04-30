package data;

import model.Login;

import java.io.*;
import java.util.Optional;

public class DataSet {
    public Login getLogin (String login, String pass){
        File file = new File("src/main/java/files/Login.txt");
        BufferedReader reader = null;
        String linea;
        try{
            reader = new BufferedReader(new FileReader(file));
            while ((linea = reader.readLine())!=null){
                String[] partes = linea.split(",");
                if (partes.length>=3){
                    String loginArchivo = partes[0].trim();
                    String passArchivo = partes[1].trim();
                    String tipoArchivo = partes[2].trim();
                    if(loginArchivo.equals(login) && passArchivo.equals(pass)){
                        reader.close();
                        return Login.valueOf(tipoArchivo);
                    }
                }
            }
            reader.close();
            return null;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
