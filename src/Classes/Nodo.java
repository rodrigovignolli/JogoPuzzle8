/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Rodrigo Vignolli
 */
public class Nodo {
    public Nodo pai;
    public String saida;
    public double valHeuristica;
    public int nivel;
    public int[][] dadosJogo;

    public Nodo(Nodo pai, double valHeuristica, int nivel, int[][] dadosJogo) {
        this.pai = pai;
        this.valHeuristica = valHeuristica;
        this.nivel = nivel;
        this.dadosJogo = dadosJogo;
    }

    
    public int hashCode() {
        return (int) this.valHeuristica + this.nivel;
    }
    
  
    public boolean equals(Nodo obj) {
       for(int i = 0; i < this.dadosJogo.length; i++){
         for(int j = 0; j < this.dadosJogo[i].length; j++){
             if(this.dadosJogo[i][j] != obj.dadosJogo[i][j]){
                 return false;
             }
         }  
       }
       return true;
    }
}
