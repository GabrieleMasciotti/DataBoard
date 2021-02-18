/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;

/**
 *
 * @author gabriele
 */
public class Category {
    
    private String name;
    ArrayList<String> friends;
    
    public Category(String category){
        this.name = category;
        friends = new ArrayList<>();
    }
    
    public String getName(){
        String returnName;
        returnName = this.name;
        return returnName;
    }
    
       
}
