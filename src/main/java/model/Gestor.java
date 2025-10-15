
package model;

import java.io.Serializable;


public class Gestor implements Serializable {
    private int id;
    private String nome;
    private String bi;
    private int contacto;
    private String email;
    private String senha;

    public Gestor(int id, String nome, String bi,int contacto, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.bi = bi;
        this.contacto = contacto;
        this.email = email;
        this.senha = senha;
    }

    public Gestor(int id, String senha) {
        this.id = id;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
     
    
    
    
            
}
