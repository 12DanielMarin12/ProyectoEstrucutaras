 

package proyectostructure;
 
public class ProyectoStructure {

    
    public static void main(String[] args) {
         LinkedList n = new ListaDobleCircular();
          
         n.add(1);
         n.add(2);
         n.add(3);
         n.add(4);
         n.add(5);
         n.add(6); 
            
         LinkedList m = n.sort();
         System.out.println(m);
         System.out.println(m.toStringReverse());
         
         System.out.println(n); 
         System.out.println(n.toStringReverse()); 
          
         /*
         
         System.out.println(n.getSize());
         
         System.out.println(n);
         System.out.println(n.toStringReverse());
         System.out.println(n.nodeOf(2));
         */
         
        
        
        
        
    }
    
}
