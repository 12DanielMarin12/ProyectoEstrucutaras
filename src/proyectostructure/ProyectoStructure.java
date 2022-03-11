 

package proyectostructure;
 
public class ProyectoStructure {

    
    public static void main(String[] args) {
        ListaSimple m = new ListaSimple("piedad");
        Node x = new Node(4114);
        Node u = new Node(4444);
        m.add(1);
        m.add(2);
        m.add(4);
        m.add(6);
        m.addFirst(2);
        m.addLast(12);
        System.out.println(m.size() );
        System.out.println(m);
        
        System.out.println(m.subList(m.nodeOf(2),m.nodeOf(2)));
        
    }
    
}
