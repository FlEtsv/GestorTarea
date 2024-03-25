package org.BasesDatos;

import org.mindrot.jbcrypt.BCrypt;

public class HashPassword {
    
    // Genera el hash de una contraseña
    public static String hashPassword(String password_plaintext) {
        int workload = 12;
        String salt = BCrypt.gensalt(workload);
        return BCrypt.hashpw(password_plaintext, salt);
    }

    // Verifica una contraseña con un hash dado
    public static boolean verifyPassword(String password_plaintext, String stored_hash) {
    boolean password_verified = false;

    if (null == stored_hash || !stored_hash.startsWith("$2a$")) {
        throw new java.lang.IllegalArgumentException("Hash inválido proporcionado para comparación");
    } else {
        System.out.println("contraseña no nula y formato correcto contraseña texto plano:"+ password_plaintext + " y la contraseña hash almacenada:" + stored_hash);
        password_verified = BCrypt.checkpw(password_plaintext, stored_hash);
        if(password_verified) {
            System.out.println("verificacion hecha");
        }
    }
    return password_verified;
}


}
/*
 * public class TestPasswordHashing {
    public static void main(String[] args) {
        String originalPassword = "miSuperSecretaContraseña!";
        String generatedSecuredPasswordHash = HashPassword.hashPassword(originalPassword);
        System.out.println("Hash de la contraseña: " + generatedSecuredPasswordHash);
        
        boolean matched = HashPassword.verifyPassword("miSuperSecretaContraseña!", generatedSecuredPasswordHash);
        System.out.println("Contraseña verificada: " + matched);
        
        matched = HashPassword.verifyPassword("Ejempo_contraseña_Erronea", generatedSecuredPasswordHash);
        System.out.println("Contraseña verificada: " + matched);
    }
}

 * */
 