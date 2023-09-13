package com.dev.financeApp.util;

public class CriptografiaUtil {

    public static String criptografar(String senha) {
        int deslocamento = 3;
        StringBuilder senhaCriptografada = new StringBuilder();
        for (int i = 0; i < senha.length(); i++) {
            char caractere = senha.charAt(i);
            if (Character.isLetter(caractere)) {
                char novoCaractere = (char) (((caractere - 'a' + deslocamento) % 26) + 'a');
                senhaCriptografada.append(novoCaractere);
            } else {
                senhaCriptografada.append(caractere);
            }
        }
        return senhaCriptografada.toString();
    }

    public static String descriptografar(String senhaCriptografada) {
        int deslocamento = 3;
        StringBuilder senhaDescriptografada = new StringBuilder();
        for (int i = 0; i < senhaCriptografada.length(); i++) {
            char caractere = senhaCriptografada.charAt(i);
            if (Character.isLetter(caractere)) {
                char novoCaractere = (char) (((caractere - 'a' - deslocamento + 26) % 26) + 'a');
                senhaDescriptografada.append(novoCaractere);
            } else {
                senhaDescriptografada.append(caractere);
            }
        }
        return senhaDescriptografada.toString();
    }

}
