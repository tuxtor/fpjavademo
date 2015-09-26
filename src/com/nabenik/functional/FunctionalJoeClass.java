package com.nabenik.functional;

/**
 *
 * @author tuxtor
 */
public class FunctionalJoeClass {
    
    /**
     * Static Joe behavior method
     * @param letext 
     */
    static void joeDoSomething(String letext){
        System.out.println("joe static prints: "+letext);
    }
    
    /**
     * Regular instance method
     * @param letext 
     */
    void instanceOfJoeDoSomething(String letext){
        System.out.println("joe regular prints: "+letext);
    }
}
