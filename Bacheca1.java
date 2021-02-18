/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gabriele
 * @param <E>
 */
public class Bacheca1<E extends Data1> implements DataBoard1<E>{
    
    private final String password;
    private ArrayList<E> datas;
    private ArrayList<Category> myCategories;
    
    public Bacheca1(String password){
        if(password==null) throw new IllegalArgumentException("Null password not accepted!");
        if(password.isEmpty()) throw new IllegalArgumentException("Password is empty!");
        this.password = password;
        this.myCategories = new ArrayList<>();
        this.datas = new ArrayList<>();
    }
    
    // private method to get the index of a category of the board named "Category"
    private int getIndex(String Category){
        int i = 0;
       for(Category aux : myCategories){
           if(aux.getName().equals(Category)) return i;
           else i++;
       }
       return -1;
    }
    
    // private method to get the index of a data of the board named "Data"
    private int getDataIndex(E Data){
        if(Data == null) return -1;
        int i = 0;
        String nome = Data.getName();
        for(E aux : datas){
           if(aux.getName().equals(nome)) return i;
           else i++;
       }
       return -1;
    }
    
    @Override
    public void createCategory(String Category, String passw) throws AccessDeniedException, ExistingCategoryException, IllegalArgumentException{
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");   //check password
        if(Category==null) throw new IllegalArgumentException("Null category name not accepted!");
        if(Category.isEmpty()) throw new IllegalArgumentException("Category name is empty!");
        if(getIndex(Category) != -1) throw new ExistingCategoryException("Existing category!");    //check if the category already exists
        Category newCategory = new Category(Category);    //create new category
        myCategories.add(newCategory);    //add category to the board
    }
    
    @Override
    public void removeCategory(String Category, String passw) throws AccessDeniedException, NotExistingCategoryException, UnsupportedOperationException{
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");   //check password
        int index = getIndex(Category);         //catches the index of the category wanted to be removed
        if(index == -1) throw new NotExistingCategoryException("Not existing category!");    //checks if the category exists
        for(E aux : datas){
           if(aux.getCategory().getName().equals(Category)) throw new UnsupportedOperationException("Category is associated to datas in board! Please remove datas before removing category.");
       }
        myCategories.remove(index);   //removes the category
    }
    
    @Override
    public void addFriend(String Category, String passw, String friend) throws AccessDeniedException, IllegalArgumentException, NotExistingCategoryException{
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");   //check password
        if(friend == null) throw new IllegalArgumentException("Null friend name not accepted!");
        if(friend.isEmpty()) throw new IllegalArgumentException("Friend name is empty!");
        int index = getIndex(Category);         //catches the index of the category in which friend has to be added
        if(index == -1) throw new NotExistingCategoryException("Not existing category!");    //checks if the category exists
        if(myCategories.get(index).friends.contains(friend)) throw new IllegalArgumentException("Friend name already exists!");
        myCategories.get(index).friends.add(friend);      //add the new friend
    }
    
    @Override
    public void removeFriend(String Category, String passw, String friend) throws AccessDeniedException, NotExistingCategoryException, NotExistingFriendException{
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");   //check password
        int index = getIndex(Category);
        if(index == -1) throw new NotExistingCategoryException("Not existing category!");    //checks if the category exists
        if(!myCategories.get(index).friends.contains(friend)) throw new NotExistingFriendException("Friend wanted to be removed doesn't exist!");
        myCategories.get(index).friends.remove(friend);
    }    
    
    @Override
    public boolean put(String passw, E dato, String categoria) throws AccessDeniedException, ExistingDataException, NotExistingCategoryException, IllegalArgumentException, CloneNotSupportedException{
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");   //check password
        if(dato == null) throw new IllegalArgumentException("Null data not accepted!");
        int ind = getDataIndex(dato);
        if(ind != -1) throw new ExistingDataException("Data name already exists!");
        int index = getIndex(categoria);
        if(index == -1) throw new NotExistingCategoryException("Not existing category!");    //check if the category exists
        dato.setCategory(myCategories.get(index));
        E newData = (E) dato.clone();
        boolean add = datas.add(newData);
        return add;
    }

    @Override
    public E get(String passw, E dato) throws AccessDeniedException, NotExistingDataException, CloneNotSupportedException{
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");   //check password
        int ind = getDataIndex(dato);
        if(ind == -1) throw new NotExistingDataException("Data doesn't exist!");
        E newData = (E) datas.get(ind).clone();
        return newData;
    }
    
    @Override
    public E remove(String passw, E dato) throws AccessDeniedException, NotExistingDataException{
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");   //check password
        int ind = getDataIndex(dato);
        if(ind == -1) throw new NotExistingDataException("Data doesn't exist!");
        E remove = datas.remove(ind);
        return remove;
    }
    
    @Override
    public List<E> getDataCategory(String passw, String Category) throws AccessDeniedException, NotExistingCategoryException{
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");   //check password
        if(getIndex(Category) == -1) throw new NotExistingCategoryException("Not existing category! List would be empty!");    //check if the category exists
        List<E> list;
        list = new LinkedList<>();
        for(E aux : datas){
            if(aux.getCategory().getName().equals(Category)){
                list.add(aux);
            }
        }
        return Collections.unmodifiableList(list);
    }
    
    @Override
    public Iterator<E> getIterator(String passw) throws AccessDeniedException, UnsupportedOperationException{
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");   //check password
        ArrayList<E> list;
        list = new ArrayList<>();
        for(E aux : datas){
            list.add(aux);
        }        
        list.sort(new Order1());
        Collection<E> immutablelist = Collections.unmodifiableCollection(list);
        return immutablelist.iterator();
    }
    
    @Override
    public void insertLike(String friend, E data) throws NotExistingFriendException, NotExistingDataException{
        int ind = getDataIndex(data);
        if(ind == -1) throw new NotExistingDataException("Data doesn't exist!");
        if(!datas.get(ind).getCategory().friends.contains(friend)) throw new NotExistingFriendException("Operation not permitted!");
        datas.get(ind).addLike();
    }
    
    @Override
    public Iterator<E> getFriendIterator(String friend) throws NotExistingFriendException{
        ArrayList<Category> categories;
        categories = new ArrayList<>();
        for(Category aux : myCategories){
            if(aux.friends.contains(friend)) categories.add(aux);
        }
        if(categories.isEmpty()) throw new NotExistingFriendException("No friend found!");
        ArrayList<E> list;
        list = new ArrayList<>();
        for(E corr : datas){
            if(categories.contains(corr.getCategory())){
                list.add(corr);
            }
        }
        Collection<E> immutablelist = Collections.unmodifiableCollection(list);
        return immutablelist.iterator();
    }
    
    
    //method to verify the correct status of the board
    public void status(String passw) throws AccessDeniedException{
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");   //check password
        int i = 1;
        System.out.println("CURRENT STATUS OF BOARD'S CATEGORIES AND FRIENDS:");
        for(Category aux : this.myCategories){
            System.out.print(i+ ")"+aux.getName()+", friends: ");
            if(aux.friends.isEmpty()) System.out.print("--none--");
            else{
            for(String friend : aux.friends){
                System.out.print(friend+" ");
            }}
            System.out.println();
            i++;
        }
        System.out.println("DATAS IN BOARD:");
        if(this.datas.isEmpty()) System.out.println("--none--");
        else{
            int j = 1;
            for(E aux : this.datas){
                System.out.println(j + ") "+aux.Display());
                j++;
            }
        }
        System.out.println();
    }
    
    
    
}
