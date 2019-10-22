/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agrawal_completo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author waly_
 */
public class Agrawal {

    public int[] getQuorum(No arvore, int comprimento, int largura) {

        int vazio[] = new int[0];//vetor vazio representa o conjunto de quorum vazio
        int quorumFilhos[] = new int[0];//quorum dos filhos inicializado como um conjunto vazio
        ArrayList<Integer> tempQuorum;//quorum temporario

        int h = 3;//altura da arvore

        if (comprimento > h) {//se o comprimento do quorum for maior que a altura da arvore, o algoritmo nao roda
            System.out.println("ERRO! COMPRIMENTO ULTRAPASSOU A ALTURA DA ÁRVORE");
        } else if (comprimento == 0) {//condicao de parada da recursao
            return vazio;
        } else if (arvore.isVivo()) {//se o no atual nao falhou

            int no[] = new int[1];//cria um vetor de uma posicao (necessario pra poder concatenar na funcao concatenar)
            no[0] = arvore.getId();//pega o id do no atual e joga nesse vetor

            tempQuorum = geraTempQuorum(arvore, largura);//gera quorum temporario

            for (int i = 0; i < tempQuorum.size(); i++) {//joga o quorum temporario na recursao para verificar os filhos deles e formar o quorum dos filhos
                quorumFilhos = uniao(quorumFilhos, getQuorum(arvore.getFilho()[tempQuorum.get(i)], comprimento - 1, largura));
            }

            int quorum[] = uniao(no, quorumFilhos);//gera o quorum com o id do no atual concatenado com o dos filhos dele
            return quorum;//retorna o vetor de quorum
        } else {

            //nessa parte aqui faz a mesma coisa da de cima, so que sem decrementar o comprimento
            //isso é pra descer um nível na arvore e ir verificar os filhos, caso a raiz falhe
            tempQuorum = geraTempQuorum(arvore, largura);//gera quorum temporario

            for (int i = 0; i < tempQuorum.size(); i++) {//joga o quorum temporario na recursao para verificar os filhos deles e formar o quorum dos filhos
                quorumFilhos = uniao(quorumFilhos, getQuorum(arvore.getFilho()[tempQuorum.get(i)], comprimento, largura));
            }
            return quorumFilhos;
        }
        return null;
    }

    private int[] uniao(int a[], int b[]) {//concatena dois vetores
        int c[] = new int[a.length + b.length];//cria um vetor com o tamanho dos dois vetores somados
        int k = 0;//cria um indice k pra controlar o vetor maior

        for (int i = 0; i < a.length; i++) {//preenche o vetor com os elementos do primeiro
            c[k] = a[i];
            k++;
        }
        for (int i = 0; i < b.length; i++) {//termina de preeencher com os elementos do segundo
            c[k] = b[i];
            k++;
        }
        return c;//retorna o vetor concatenado || Uniao completa
    }

    private ArrayList geraTempQuorum(No arvore, int largura) {
        ArrayList<Integer> tempQuorum = new ArrayList();//quorum temporario
        ArrayList<Integer> falhou = new ArrayList();//conjunto dos filhos que falharam
        Random gerador = new Random();
        for (int i = 0; i < arvore.getFilho().length; i++) {//cria quorum temporario
            if (tempQuorum.size() != largura) {
                if (arvore.getFilho()[i] == null) {//se chegou na base da arvore, entao o filho sera nulo, logo o quorum temporario pode ser montado com valores arbitrarios
                    //pois so servira para não travar o algoritmo, porque o mesmo tentara formar um quorum mas retornara um conjunto vazio
                    tempQuorum.add(i);//pode ser adicionado qualquer valor
                } else if (arvore.getFilho()[i].isVivo()) {//se o filho da posicao i nao tiver falhado
                    tempQuorum.add(i);//adiciona a posicao i no quorum temporario
                } else {
                    falhou.add(i);//se falhou, add a posicao no conjunto de filhos falhados
                }
            }
        }

        if (tempQuorum.size() != largura) {//caso a maioria dos filhos tenha falhado,o vetor tempquorum nao sera preenchido ate a largura, ai add os falhos no tempquorum pra pegar os filhos dele na proxima recursao
            while (tempQuorum.size() != largura) {
                int posicao = gerador.nextInt(falhou.size());//pega uma numero aleatoria no intervalo do tamanho do vetor falhou
                if (!tempQuorum.contains(falhou.get(posicao))) {//se um dos filhos falhados selecionados aleatoriamente já não estiver dentro do tempquorum, adiciona ele
                    tempQuorum.add(falhou.get(posicao));
                }
            }
        }

        return tempQuorum;
    }
    
    public Arvore geraArvore(){ //gera uma arvore com 21 nós
        Arvore a = new Arvore();
        No no2 = new No(2);
        No no3 = new No(3);
        No no4 = new No(4);
        no2.setVivo(false);
        no4.setVivo(false);
        No no5 = new No(5);
        //no5.setVivo(false);
        No no6 = new No(6);
        No no7 = new No(7);
        No no8 = new No(8);
        No no9 = new No(9);
        No no10 = new No(10);
        No no11 = new No(11);
        No no12 = new No(12);
        No no13 = new No(13);
        No no14 = new No(14);
        No no15 = new No(15);
        No no16 = new No(16);
        No no17 = new No(17);
        No no18 = new No(18);
        No no19 = new No(19);
        No no20 = new No(20);
        No no21 = new No(21);
        //no14.setVivo(false);
        //no3.setVivo(false);
        No f2[] = {no6, no7,no8,no9};
        no2.setFilho(f2);
        No f3[] = {no10,no11,no12,no13};
        no3.setFilho(f3);
        No f4[] = {no14,no15,no16,no17};
        no4.setFilho(f4);
        No f5[] = {no18,no19,no20,no21};
        no5.setFilho(f5);
        No fr[] = {no2,no3,no4,no5};
        
        a.getRaiz().setFilho(fr); //monta a arvore
        
        return a;
    }

}
