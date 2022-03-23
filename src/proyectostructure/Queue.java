
package proyectostructure;
import Interfaces.*;
public class Queue implements QueueInterface {
    public Node first;
    public Node tail;
    private int size;
    
    public Queue(){
        first = null;
        tail = null;
        size = 0;
    }
    
    public Queue(Object object){
        first = new Node(object);
        tail = first;
        size = 1;
    }
    
    @Override
    public void clear() {
        first = null;
        tail = null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Object extract() {
        if(!isEmpty()){
            Node current = first;
            if(size==1){
                first = null;
                tail = null;
                size--;
            }else{
                first = first.getNext();
                size--;
            }
            return current;
        }
        return null;
    }

    @Override
    public boolean insert(Object object)  {
        try {
            if(isEmpty()){
                first = new Node(object);
                tail = first;
                size = 1;
                return true;
            }else{
                Node current = new Node(object);
                tail.setNext(current);
                current.setPrevius(tail);
                tail = current;
                size++;
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean search(Object object) {
        Node current = first;
        for (int i = 0; i < size; i++) {
            if(current.getObject()==object){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void sort() {
        
        Node current = first;
        int sis = size+1; 
        for (int i = 1; i < sis; i++) {
            if(i%2==0){
                insert(current.getObject());
            } 
            current = current.getNext();
        } 

        current = first;
        for (int i = 1; i < sis; i++) {
            if(i%2!=0){
                insert(current.getObject());   
            }
            current = current.getNext();
        } 

        for (int i = 1; i < sis; i++) { 
            extract();
        } 

    }

    @Override
    public void reverse() {
        try {
            Node current = tail;   
            int sis = size;
            for (int i = 0; i < sis-1; i++) {

                current = current.getPrevius();
                insert(current.getObject());
            }
            for (int i = 0; i < sis-1; i++) {
                extract();
            }
        } catch (Exception e) {
            System.out.println("vacia");
        }
    }

    @Override
    public String toString() {
        String M = "";
        if(!isEmpty()){
            Node current = first;
            for (int i = 0; i < size; i++) {
                M += current.toString();
                current = current.getNext();
            } 
        }
        return M;
    }
    
    public String reverses(){
        String M = "";
        if(!isEmpty()){
            Node current = tail;
            for (int i = 0; i < size; i++) {
                M += current.toString()+"  ";
                current = current.getPrevius();
            } 
        }
        return M;
    }
    
}
