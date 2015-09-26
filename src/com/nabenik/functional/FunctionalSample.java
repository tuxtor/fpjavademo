package com.nabenik.functional;

/**
 *
 * @author tuxtor
 */
public class FunctionalSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FunctionalSample leSample = new FunctionalSample();
        
        //The old way
        leSample.doItWithOldFashion();
        
        //The new Way
        leSample.doItWithLambda();
    }
    
    
    public void doItWithOldFashion(){
        MyFunctionalInterface myFunctionalObject = new  MyFunctionalInterface() {

            //Behaviour definition into anon inner class 
            @Override
            public void doSomethingFunctional(String leText) {
                System.out.println(leText);
            }
        };
        myFunctionalObject.doSomethingFunctional("Invoking in the traditional way");
    }
    
    public void doItWithLambda(){
        //Behaviour - lambda as anonymus function
        MyFunctionalInterface myFunctionalObject = (x) -> System.out.println(x);
        myFunctionalObject.doSomethingFunctional("I'm a basic lambda behaviour");
        
        //Using lambda as a parameter in high order functions
        MyFunctionalInterface behaviourAsParameter = (x) -> System.out.println("Simple behaviour ".concat(x));
        MyFunctionalInterface anotherBehaviourAsParameter = (x) -> {
            System.out.println("Complex behavior");    
            System.out.println("A very complex behaviour".concat(x));};
        
        lambdaAsParameter(behaviourAsParameter);
        lambdaAsParameter(anotherBehaviourAsParameter);
        
        //Method references
        //Static
        MyFunctionalInterface staticMethodReference = System.out::println;
        staticMethodReference.doSomethingFunctional("Print using references");
        MyFunctionalInterface joeStaticMethodReference = FunctionalJoeClass::joeDoSomething;
        joeStaticMethodReference.doSomethingFunctional("Joe static reference");
        
        //Instance
        FunctionalJoeClass joe = new FunctionalJoeClass();
        MyFunctionalInterface instanceOfJoeMethodReference = joe::instanceOfJoeDoSomething;
        instanceOfJoeMethodReference.doSomethingFunctional("Text printed by joe instance");
        
    }
    
    //High order function - Takes another function as a parameter
    public void lambdaAsParameter(MyFunctionalInterface leParameter){
        leParameter.doSomethingFunctional(" awesome while using high-order functions");
    }
    
}
