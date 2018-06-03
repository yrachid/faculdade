package s1801.lab02.m12.arvores;

/**
Classe que representa o nodo de uma arvore binaria de pesquisa
**/

public class BSTNode {

    //Chave do nodo
    protected int key;
    
    //Referencias aos filhos esquerdo e direito do nodo
    protected BSTNode left, right;
    
    
    public BSTNode() {
        left = right = null;
    }
    public BSTNode(int num) {
        this(num,null,null);
    }
    public BSTNode(int num, BSTNode lt, BSTNode rt) {
        this.key = num; left = lt; right = rt;
    }    
 
}
