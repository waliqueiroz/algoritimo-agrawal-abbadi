/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrawal_completo;

/**
 *
 * @author waly_
 */
public class No {
    private boolean vivo = true;
    private int id;
    private No filhos [] = new No[4];

    public No(int id) {
        this.id = id;
            
        
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        
    }

    public No[] getFilho() {
        return filhos;
    }

    public void setFilho(No[] filhos) {
        this.filhos = filhos;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }
    
    
}
