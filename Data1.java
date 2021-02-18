/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gabriele
 */
public class Data1 implements Cloneable{
    
    private String name;
    private Category category;
    private int likes;
    
    public Data1(String name){      //constructor of a new data
        if(name==null) throw new IllegalArgumentException("Null name not accepted!");
        if(name.isEmpty()) throw new IllegalArgumentException("Name is empty!");
        this.name = name;
        this.likes = 0;
    }
    
    @Override
    public Data1 clone() throws CloneNotSupportedException{
        return (Data1) super.clone();
    }
    
    public void setCategory(Category cat){
        this.category = cat;
    }
    
    public String getName(){
        String nome;
        nome = this.name;
        return nome;
    }
    
    public Category getCategory(){
        Category cat;
        cat = this.category;
        return cat;
    }
    
    public int getLikes(){
        int like;
        like = this.likes;
        return like;
    }
    
    public void addLike(){
        this.likes = this.likes + 1;
    }
    
    public String Display(){
        String display;
        display = "Data name: "+this.getName()+", category: "+this.getCategory().getName()+", likes number: "+this.getLikes()+".";
        return display;
    }
    
}
