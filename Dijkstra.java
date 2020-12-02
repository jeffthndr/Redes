/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
import java.util.*;
public class Dijkstra
{
 public  int distancia[] = new int[10];
 public  int matriz[][] = new int[10][10];
 
 public void calc(int n,int origen)
 {
  int fila[] = new int[n+1];
  int i,minpos=1,k,c,minimum;
  
  for(i=1;i<=n;i++)
  {  
      fila[i]=0; 
      this.distancia[i]=this.matriz[origen][i]; 
  }
  c=2;
  while(c<=n)
  {
   minimum=99;
   for(k=1;k<=n;k++)
   { 
          if(this.distancia[k]<minimum && fila[k]!=1)
       {
        minimum=this.distancia[i];
        minpos=k;
       }
      } 
            fila[minpos]=1;
      c++;
      for(k=1;k<=n;k++){
       if(this.distancia[minpos]+this.matriz[minpos][k] <  this.distancia[k] && fila[k]!=1 )
       this.distancia[k]=this.distancia[minpos]+this.matriz[minpos][k];
   }   
  } 
  
 }
 public static void main(String args[])
 {
  int nodes,source,i,j;
  Scanner in = new Scanner(System.in);
  System.out.println("Ingresa el numero de nodos \n");
  nodes = in.nextInt();
  Dijkstra d = new Dijkstra();
  System.out.println("Ingresa el peso de las distancias: \n");
        for(i=1;i<=nodes;i++)
          for(j=1;j<=nodes;j++)
          {
            d.matriz[i][j]=in.nextInt();
            if(d.matriz[i][j]==0)
              d.matriz[i][j]=999;
          }
  System.out.println("Ingrese el nodo origen :\n");
  source=in.nextInt();
  
  d.calc(nodes,source);
  System.out.println("El camino mas corto de \t"+source+"\t hacia los otros nodos es : \n");
        for(i=1;i<=nodes;i++)
          if(i!=source)
  System.out.println("origen :"+source+"\t destino :"+i+"\t Peso minimo :"+d.distancia[i]+"\t");
        
  
 } 
}