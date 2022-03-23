
package proyectostructure;

import Interfaces.LinkedListNode;
import Interfaces.LinkedList;

public class ListaDobleCircular implements LinkedList{
     private Node head;
    private Node tail;
    private int size;
    
    public ListaDobleCircular(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public ListaDobleCircular(Object object){
        this.head = new Node(object) ;
        this.tail = head;
        this.size = 1;
    }
    
    public ListaDobleCircular(Node node){
        this.head = node;
        this.tail = head;
        this.size = 1;
    }
    
    
    @Override
    public boolean add(Object object) {
        Node n =  new Node(object) ;
        if(isEmpty()){
            this.head = n;
            this.tail = head;
            this.size = 1;
            return true;
        }else{
            tail.setNext(n);
            n.setPrevius(tail);
            tail = n;
            tail.setNext(head);
            head.setPrevius(tail);
            size++;
            return true;
        }
    }

    @Override
    public boolean add(LinkedListNode node, Object object) {
        try {
            if(isEmpty()){
               return false;
            }else{
                Node n = new Node(object);
                Node current = head;
                if(current.getObject()==node.getObject()){
                    n.setNext(current.getNext());
                    n.setPrevius(current);
                     current.getNext().setPrevius(n);
                     current.setNext(n);
                    head.setPrevius(tail);
                    tail.setNext(head);
                    size++;
                    return true;
                }else{
                    for(int i=0 ; i<getSize() ; i++){
                        current = current.getNext();
                        if(current.getObject()==node.getObject()){
                            if(current==tail){
                                tail.setNext(n);
                                n.setPrevius(tail);
                                tail = n;
                                tail.setNext(head);
                                head.setPrevius(tail);
                                size++;
                                return true;
                            }else{
                                n.setNext(current.getNext());
                                n.setPrevius(current); 
                                current.getNext().setPrevius(n);
                                current.setNext(n); 
                                size++;
                                return true;
                            }
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
        Node n = new Node(object);
        n.setNext(head);
        head.setPrevius(n);
        head = n;
        size++;
        return true;
    }

    @Override
    public boolean addLast(Object object)  {
        Node n = new Node(object);
        tail.setNext(n);
        n.setPrevius(tail);
        tail = n;
        size++;
        return true;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public LinkedList clone() {
        LinkedList n = new ListaDobleCircular();
        n.setHead(head);
        n.setTail(tail);
        n.setSize(size);
        return n;
    }

    @Override
    public boolean contains(Object object) {
        if(isEmpty()){
            return false;
        }else{
            Node current = head;
            for(int i=0 ; i<getSize() ; i++){
                if(current.getObject()==object){
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
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
            for(int i=0 ; i<getSize() ; i++){
                if(current.getObject()==object){
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
        if(isEmpty()){
            return false;
        }else{
            Node current = head;
            for(int i=0 ; i<getSize() ; i++){
                if(current.getObject().getClass()==object.getClass()){
                    return true;
                }
                current = current.getNext();
            }
        }
        return false;
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
    public Object getPrevious(LinkedListNode node)  {
        try {
            if(isEmpty()){
            return false;
        }else{
            Node current = head;
            for(int i=0 ; i<getSize() ; i++){
                if(current.getObject()==node.getObject()){
                    return current.getPrevius();
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
    public Object getNext(LinkedListNode node) {
        try {
            if(isEmpty()){
            return false;
        }else{
            Node current = head; 
            for(int i=0 ; i<getSize() ; i++){
                if(current.getObject()==node.getObject()){
                    return current.getNext();
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
                head.setPrevius(tail);
                tail.setNext(head);
                size--;
                return true;
            }
            for(int i=0 ; i<getSize() ; i++){
                current = current.getNext();
                if(current.getObject()==object){
                    if(current==tail){
                        
                        tail = current.getPrevius();
                        tail.setNext(head); 
                        size--;
                        return true;
                    }else{
                        current.getPrevius().setNext(current.getNext()); 
                        current.getNext().setPrevius(current.getPrevius());
                        size--;
                        return true;
                    }
                } 
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
                head.setPrevius(tail);
                tail.setNext(head);
                size--;
                return true;
            }
            for(int i=0 ; i<getSize()-1 ; i++){
                current = current.getNext(); 
                if(current.getObject()==node.getObject()){ 
                    if(current==tail){
                        tail = current.getPrevius();
                        tail.setNext(head); 
                        size--;
                        return true;
                    }else{
                        current.getPrevius().setNext(current.getNext()); 
                        current.getNext().setPrevius(current.getPrevius());
                        size--;
                        return true;
                    }
                } 
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
                int c = getSize();
                for(int i=0 ; i<c ; i++){ 
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
                int c = getSize();
                for(int i=0 ; i<c ; i++){ 
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
        try {
            if(isEmpty()){
            return false;
        }else{
            Node current = head;
            while(current!=null){
                if(current.getObject()==node.getObject()){
                    current.setObject(object);
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
    public int size() {
        return size;
    }

    @Override
    public LinkedList subList(LinkedListNode from, LinkedListNode to) {
        try {
            if(isEmpty()){
            return null;
            } 
            if(contains(from.getObject()) && contains(to.getObject())){ 
                Node current = head; 
                for(int i=0 ; i<getSize() ; i++){ 
                    if(current.getObject()==from.getObject()){ 
                        LinkedList n = new ListaDobleCircular();
                        while(current!=to){
                            System.out.println("...");
                            n.add(current.getObject());
                            current = current.getNext();
                        }
                        n.add(current.getObject());
                        return n;
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
        LinkedList n = new ListaDobleCircular(); 
        Node current = tail;
        for(int i=0 ; i<getSize() ; i++){
            n.add(current.getObject());
            current = current.getPrevius();
        }
        return n;
    }
    
    public String toString(){
        Node current = head;
        String lista = "";
        
        for(int i=0 ; i<getSize() ; i++){
            lista += current.toString();
            current = current.getNext();
        }
        return lista;
    }

    public String toStringReverse(){
        Node current = tail;
        String lista = "";
        
        for(int i=0 ; i<getSize() ; i++){
            lista += current.toString();
            current = current.getPrevius();
        }
        return lista;
    }
  
    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Node peek() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Node pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
