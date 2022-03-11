 

package proyectostructure;
 
public class ProyectoStructure {

    
    public static void main(String[] args) {
         LinkedList n = new ListaDoble();
         n.add(5);
         n.add(4);
         n.add(3);
         n.add(2);
         n.add(2);
         n.add(2);
         System.out.println(n);
         System.out.println(n.toStringReverse());
         n.retainAll(2);
         System.out.println(n);
         System.out.println(n.toStringReverse());
        
        
        
        
    }
    
}
