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
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Agrawal agrawal = new Agrawal();
        Arvore arvore = agrawal.geraArvore();
        arvore.getRaiz().setVivo(false);
        int quorum[] = agrawal.getQuorum(arvore.getRaiz(), 1, 3);
        for (int i = 0; i < quorum.length; i++) {
            System.out.println(quorum[i]);
        }
    }
    
}
