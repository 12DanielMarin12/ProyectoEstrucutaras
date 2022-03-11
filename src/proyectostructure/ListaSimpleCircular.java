 
package proyectostructure;

 
public class ListaSimpleCircular implements LinkedList {
    private Node head;
    private Node tail;
    private int size;
    
    public ListaSimpleCircular(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public ListaSimpleCircular(Object object){
        this.head = new Node(object) ;
        this.tail = head;
        this.size = 1;
    }
    
    public ListaSimpleCircular(Node node){
        this.head = node;
        this.tail = head;
        this.size = 1;
    }
    
    
    @Override
    public boolean add(Object object) {
        try {
            Node n =  new Node(object) ;
        if(isEmpty()){
            this.head = n;
            this.tail = head;
            this.size = 1;
            return true;
        }else{
            tail.setNext(n);
            tail = n;
            tail.setNext(head); 
            size++;
            return true;
        }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean add(LinkedListNode node, Object object) {
        try {
                Node current = head;
                if(current.getObject()==node.getObject()){
                    current.setNext(new Node(object, current.getNext()));
                    size++;
                    return true;
                }else{
                    while(current!=null){
                        current = current.getNext();
                        if(current.getObject()==node.getObject()){
                            if(current==tail){
                                current.setNext(new Node(object));
                                tail = current.getNext();
                                tail.setNext(head);
                                size++;
                                return true;
                            }else{
                                current.setNext(new Node(object, current.getNext()));
                                size++;
                                return true;
                            }
                        }
                    }
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override//!?!?!?!?
    public boolean addAll(Object objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override//?!?!?!
    public boolean addAll(LinkedListNode node, Object objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addFirst(Object object) {
        try {
            Node n = new Node(object);
            if(isEmpty()){
                head = n;
                tail = head;
                size = 1;
            }else{
                n.setNext(head);
                head = n;
                tail.setNext(head);
            }
            size++;
        return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addLast(Object object)  {
        try {
            Node n = new Node(object);
            tail.setNext(n);
            tail = n;
            tail.setNext(head);
            size++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public LinkedList clone() {
        ListaSimpleCircular n = new ListaSimpleCircular();
        n.setHead(head);
        n.setTail(tail);
        n.setSize(size);
        return n;
    }

    @Override
    public boolean contains(Object object) {
        try {
            if(isEmpty()){
            return false;
        }else{
            Node current = head;
            for(int i = 0 ; i<getSize() ; i++){ 
                if(current.getObject().equals(object)){
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override//!??!?!
    public boolean containsAll(Object objects) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LinkedListNode nodeOf(Object object) {
        try {
            if(isEmpty()){
            return null;
        }else{
            LinkedListNode current = head;
            for(int i = 0 ; i<getSize() ; i++){ 
                System.out.println(getSize());
                if(current.getObject().equals(object)){
                    return current;
                }
                current = current.getNext();
            }
        }
        return null;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean isEquals(Object object) {
        try {
             if(isEmpty()){
            return false;
        }else{
            Node current = head;
            for(int i = 0 ; i<getSize() ; i++){ 
                if(current.getObject().getClass().equals(object.getClass())){
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isEmpty() {
        return head==null;
    }

    @Override
    public Object get() {
        return tail;
    }

    @Override
    public Object get(LinkedListNode node) {
        try {
        int c = 0;
        if(isEmpty()){
            return false;
        }else{
            Node current = head;
            for(int i=0 ; i<getSize() ; i++){ 
                if(node.getObject()==current.getObject()){
                    return c;
            }
                c++; 
                current = current.getNext();
            }
        }
        return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Object getPrevious(LinkedListNode node) {
        try {
            if(isEmpty()){
            return null;
        }else{
            Node current = head;
            if(node.getObject()==current.getObject()){
                return null;
            }else{
                for(int i=0 ; i<getSize() ; i++){
                    if(current.getNext().getObject()==node.getObject()){
                        return current;
                    }
                    current = current.getNext();
                }
            }
        }
        return null;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Object getNext(LinkedListNode node) {
        try {
             if(isEmpty()){
            return null;
        }else{
            Node current = head;
            if(node.getObject()==current.getObject()){
                return current.getNext();
            }else{
                for(int i=0 ; i<getSize() ; i++){
                    if(current.getObject()==node.getObject()){
                        return current.getNext();
                    }
                    System.out.println(current.getObject());
                    current = current.getNext();
                }
            }
        }
        return null;
        } catch (Exception e) {
            
            return false;
        }
    }

    @Override
    public Object getFirst() {
        return head;
    }

    @Override
    public Object getLast() {
        return tail;
    }

    @Override
    public boolean remove(Object object) {
        try {
             if(isEmpty()){
            return false;
        }else{
            Node current = head;
            if(current.getObject()==object){
                head = head.getNext();
                size--;
                return true;
            }
            for(int i=0 ; i<getSize() ; i++){
                if(current.getNext().getObject()==object){
                    current.setNext(current.getNext().getNext());
                    size--;
                    return true;
                }
                current = current.getNext();
                
            }
        }
        return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean remove(LinkedListNode node) {
        try {
             if(isEmpty()){
            return false;
        }else{
            Node current = head;
            if(current.getObject()==node.getObject()){
                head = head.getNext();
                tail.setNext(head);
                size--;
                return true;
            }
            for(int i=0 ; i<getSize() ; i++){
                if(current.getNext().getObject()==node.getObject()){
                    if(current.getNext()==tail){
                        tail = current;
                        tail.setNext(head);
                        size--;
                    }else{
                        current.setNext(current.getNext().getNext());
                        size--;
                    } 
                    return true;
                }
                current = current.getNext();
                
            }
        }
        return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean removeAll(Object objects) {
        try {
            if(isEmpty()){
               return false;
            }else{
                Node current = head;
                for(int i=0 ; i<getSize() ; i++){ 
                    
                    if(current.getObject()==objects){
                        remove(current);
                    }
                    current = current.getNext();
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override 
    public boolean retainAll(Object objects) {
         try {
            if(isEmpty()){
               return false;
            }else{
                Node current = head;
                int contador = getSize();
                for(int i=0 ; i<contador ; i++){  
                    if(current.getObject()!=objects){ 
                        remove(current); 
                    }
                    current = current.getNext();
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean set(LinkedListNode node, Object object) {
        if(isEmpty()){
            return false;
        }else{
            Node current = head;
            for(int i=0 ; i<getSize() ; i++){
                if(current==node){
                    current.setObject(object);
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public LinkedList subList(LinkedListNode from, LinkedListNode to) {
        
                System.out.println(to);
        if(isEmpty()){
            return null;
        } 
        Node current = head; 
        for(int i=0 ; i<getSize() ; i++){ 
            if(current==from){ 
                LinkedList n = new ListaSimpleCircular();
                System.out.println(current);
                System.out.println(to);
                while(current!=to){ 
                    n.add(current.getObject());
                    current = current.getNext();
                }
                n.add(current.getObject());
                return n;
            }
            current = current.getNext();
            
        }
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] a = new Object[size];
        Node current = head;
        
        for(int i = 0 ; i < size ; i++){
            a[i]=current.getObject();
            current = current.getNext();
        }
        
        return a;
    }

    @Override
    public LinkedList sort() {
        Object[] k = toArray(); 
        LinkedList n = new ListaSimpleCircular();
        
        for(int i=size-1 ; i>0 ; i--){
            n.add(k[i]);
        }
        return n;
    }
    
    @Override
    public String toString(){
        Node current = head;
        String lista = "";
        lista += current.toString();
        current = current.getNext();
        while(current!=head){
            lista += current.toString();
            current = current.getNext();
        }
        return lista;
    }
    
    @Override
    public Node getHead() {
        return head;
    }

    @Override
    public void setHead(Node head) {
        this.head = head;
    }

    @Override
    public Node getTail() {
        return tail;
    }

    @Override
    public void setTail(Node tail) {
        this.tail = tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override//no es para esta lista
    public String toStringReverse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
