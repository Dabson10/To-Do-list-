package org.github.dabson10.todo_list_back.utilidades;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;

@Controller
public class OcultarClaves {

    public String ocultarContrasI(String clave){
        return BCrypt.hashpw(clave, BCrypt.gensalt());
    }


}
