/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nabenik.functional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 *
 * @author tuxtor
 */
public class StreamsSample {
    public static void main(String args[]){
        StreamsSample sample = new StreamsSample();
        sample.oldSort();
        sample.lambdaSort();
        
        sample.oldFilter();
        sample.lambdaFilter();
    }
    
    /**
     * Returns a set random numbers
     * @return 
     */
    public List<Integer> createRandomList(){
        List<Integer> numberList = new ArrayList<>();
        Random rand = new Random();
        for(int i=0;i<24;i++){
            numberList.add(rand.nextInt(255));
        }
        return numberList;
    }
    
    public void oldSort(){
        List<Integer> unsortedList = createRandomList();
        Collections.sort(unsortedList, new Comparator<Integer>(){
            public int compare(Integer n1, Integer n2){
                return n1.compareTo(n2);
            }
        });
        //The list has been sorted in the traditional way
        System.out.println(unsortedList);
    }
    
    public void lambdaSort(){
        List<Integer> unsortedList = createRandomList();
        unsortedList.sort((Integer n1, Integer n2) -> n1.compareTo(n2));
        //The list has been sorted in lambda way
        System.out.println(unsortedList);
    }
    
    
    public void oldFilter(){
        List<Integer> unfilteredList = createRandomList();
        List<Integer> filteredList = new ArrayList<>();
        for(Integer number:unfilteredList){
            if(number > 50){
                filteredList.add(number);
                System.out.println(number);
            }
        }
        //The list has been filtered in the traditional way
        System.out.println(filteredList);
    }
    
    public void lambdaFilter(){
        List<Integer> unfilteredList = createRandomList();
        List<Integer> filteredList = unfilteredList.stream() //Stream
                .filter(x -> x > 50) //Intermeadiate operator
                .peek(System.out::println) //Intermediate operator - debugger
                .collect(Collectors.toList()); //Terminal operator
        //The list has been filtered in the lambda way   
        System.out.println(filteredList);
    }
}
