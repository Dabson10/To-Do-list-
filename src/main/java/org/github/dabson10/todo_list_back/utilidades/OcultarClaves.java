package org.github.dabson10.todo_list_back.utilidades;

import org.mindrot.jbcrypt.BCrypt;

public class OcultarClaves {

    public String ocultarContrasI(String clave){
        return BCrypt.hashpw(clave, BCrypt.gensalt());
    }


}
