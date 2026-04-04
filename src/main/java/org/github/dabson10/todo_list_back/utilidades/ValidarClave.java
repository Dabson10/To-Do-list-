package org.github.dabson10.todo_list_back.utilidades;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;

@Controller
public class ValidarClave {

    public boolean validarClave(String clave, String claveHash){
        boolean estado = false;
        try{
            if(BCrypt.checkpw(clave, claveHash)){
                estado = true;
            }
        }catch(IllegalArgumentException ilegal){
            System.out.println("clave incorrecta.");
        }
        return estado;
    }
}
