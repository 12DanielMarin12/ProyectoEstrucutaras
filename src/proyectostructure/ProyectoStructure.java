 

package proyectostructure;
 
public class ProyectoStructure {

    
    public static void main(String[] args) {
         LinkedList n = new Pila();
         
         n.add(1);
         n.add(2);
         n.add(3);
         n.add(4);
         n.add(4);
         n.add(8);
         
         
         
         System.out.println(n.peek());
         System.out.println(n.pop());
         LinkedList m = n.clone();
         System.out.println(m);
         System.out.println(n);
         
        
        
        
        
    }
    
}
