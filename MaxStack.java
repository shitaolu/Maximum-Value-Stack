package A1Q3;

import java.util.*;

/**
 * Specializes the stack data structure for comparable elements, and provides
 * a method for determining the maximum element on the stack in O(1) time.
 * @author jameselder
 */
public class MaxStack<E extends Comparable> extends Stack<E> {

    private Stack<E> maxStack;
    private Stack<E> maxStackHelper;
    
     

    public MaxStack() {
        maxStack = new Stack<>();
        maxStackHelper = new Stack<>();
    }

    
    
    
    /* must run in O(1) time */
    //为什么没有override字样？
    public E push(E element) {
    	if(maxStack.isEmpty()){
    		maxStack.addElement(element);
    		maxStackHelper.addElement(element);
    	}
    	
    	else if((int) maxStackHelper.peek() > (int) element){
    		maxStack.addElement(element);
    		maxStackHelper.addElement(maxStackHelper.peek());
    	}
    	else{
    		maxStack.addElement(element);
    		maxStackHelper.addElement(element);
    	}
  
        return element; //Dummy return to satisfy compiler.  Remove once coded.
    }

    
    
    
    
    /* @exception  EmptyStackException  if this stack is empty. */
    /* must run in O(1) time */
   public synchronized E pop() {
        if(maxStack.size() ==0){
        	throw new EmptyStackException();
        }
        E temp = maxStack.pop();
        maxStackHelper.pop();
	   return temp; //Dummy return to satisfy compiler.  Remove once coded.
    }

   
   
   
    /* Returns the maximum value currenctly on the stack. */
    /* @exception  EmptyStackException  if this stack is empty. */
    /* must run in O(1) time */
   public synchronized E max() {
    	
        return maxStackHelper.peek(); //Dummy return to satisfy compiler.  Remove once coded.
    }
}