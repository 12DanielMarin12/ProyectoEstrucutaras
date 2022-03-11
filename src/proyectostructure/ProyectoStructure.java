 

package proyectostructure;
 
public class ProyectoStructure {

    
    public static void main(String[] args) {
        ListaDoble n = new ListaDoble("piedad");
        ListaSimple m = new ListaSimple("podo");
        m.add(1);
        m.add(3);
        m.add(2);
        m.add(4);
        Node ñ = new Node(5);
        n.add(1);
        n.add(2);
        n.add(3);
        n.add(4);
        n.add(5);
        n.add(6);
        
        n.add(n.nodeOf(6), 99);
        n.add(33);
        n.addFirst(0);
        n.addLast(100); 
        
        System.out.println(n.size());
        System.out.println(n);  
        
        System.out.println(n.sort());
        
        System.out.println(n.size());
        System.out.println(n);  
        
        
        
        
    }
    
}
