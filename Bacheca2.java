/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author gabriele
 * @param <E>
 */
public class Bacheca2 <E extends Data2> implements DataBoard2<E> {
    
    private String password;
    private HashMap<String, Vector<E>> datas;
    private HashMap<String, Vector<String>> friends;
    
    public Bacheca2(String password){
        if(password==null) throw new IllegalArgumentException("Null password not accepted!");
        if(password.isEmpty()) throw new IllegalArgumentException("Password is empty!");
        this.password = password;
        this.datas = new HashMap<>();
        this.friends = new HashMap<>();
    }
    
    private E getData(E dato){
        if(dato == null) return null;
        Collection<Vector<E>> list = datas.values();
        for(Vector<E> aux : list){
            Iterator<E> iter = aux.iterator();
            E corr;
            while(iter.hasNext()){
                corr = iter.next();
                if(corr.getName().equals(dato.getName())) return corr;
            }
        }
        return null;
    }
    
    @Override
    public void createCategory(String Category, String passw) throws AccessDeniedException, ExistingCategoryException, IllegalArgumentException {
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");
        if(Category==null) throw new IllegalArgumentException("Null category name not accepted!");
        if(Category.isEmpty()) throw new IllegalArgumentException("Category name is empty!");
        if(datas.containsKey(Category)) throw new ExistingCategoryException("Existing category!");
        datas.put(Category, new Vector<>());
        friends.put(Category, new Vector<>());
    }

    @Override
    public void removeCategory(String Category, String passw) throws AccessDeniedException, NotExistingCategoryException, UnsupportedOperationException {
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");
        if(!datas.containsKey(Category)) throw new NotExistingCategoryException("Not existing category!");
        if(!datas.get(Category).isEmpty()) throw new UnsupportedOperationException("Category is associated to datas in board! Please remove datas before removing category.");
        datas.remove(Category);
        friends.remove(Category);
    }

    @Override
    public void addFriend(String Category, String passw, String friend) throws AccessDeniedException, IllegalArgumentException, NotExistingCategoryException {
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");
        if(friend == null) throw new IllegalArgumentException("Null friend name not accepted!");
        if(friend.isEmpty()) throw new IllegalArgumentException("Friend name is empty!");
        if(!datas.containsKey(Category)) throw new NotExistingCategoryException("Not existing category!");
        if(friends.get(Category).contains(friend)) throw new IllegalArgumentException("Friend name already exists!");
        friends.get(Category).add(friend);
    }

    @Override
    public void removeFriend(String Category, String passw, String friend) throws AccessDeniedException, NotExistingCategoryException, NotExistingFriendException {
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");
        if(!datas.containsKey(Category)) throw new NotExistingCategoryException("Not existing category!");
        if(!friends.get(Category).contains(friend)) throw new NotExistingFriendException("Friend wanted to be removed doesn't exist!");
        friends.get(Category).remove(friend);
    }

    @Override  //datas with the same are not permitted even here
    public boolean put(String passw, E dato, String categoria) throws AccessDeniedException, ExistingDataException, NotExistingCategoryException, IllegalArgumentException, CloneNotSupportedException {
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");
        if(dato == null) throw new IllegalArgumentException("Null data not accepted!");
        if(!datas.containsKey(categoria)) throw new NotExistingCategoryException("Not existing category!");
        E el = getData(dato);
        if(el != null) throw new ExistingDataException("Data name already exists!");
        dato.setCategory(categoria);
        E elem = (E) dato.clone();
        boolean add = datas.get(categoria).add(elem);
        return add;
    }

    @Override
    public E get(String passw, E dato) throws AccessDeniedException, NotExistingDataException, CloneNotSupportedException {
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");
        E res = getData(dato);
        if(res == null) throw new NotExistingDataException("Data doesn't exist!");
        E newData = (E) res.clone();
        return newData;
    }

    @Override
    public E remove(String passw, E dato) throws AccessDeniedException, NotExistingDataException {
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");
        E res = getData(dato);
        if(res == null) throw new NotExistingDataException("Data doesn't exist!");
        String cat = res.getCategory();
        int index = datas.get(cat).indexOf(res);
        E remove = datas.get(cat).remove(index);
        return remove;
    }

    @Override
    public List<E> getDataCategory(String passw, String Category) throws AccessDeniedException, NotExistingCategoryException {
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");
        if(!datas.containsKey(Category)) throw new NotExistingCategoryException("Not existing category! List would be empty!");
        List<E> list;
        list = new LinkedList<>();
        for(E aux : datas.get(Category)){
                list.add(aux);
            }
        return Collections.unmodifiableList(list);
        }

    @Override
    public Iterator<E> getIterator(String passw) throws AccessDeniedException, UnsupportedOperationException {
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");
        ArrayList<E> list;
        list = new ArrayList<>();
        for(Vector<E> aux : datas.values()){
            for(E dato : aux){
             list.add(dato);   
            }
        }
        list.sort(new Order2());
        Collection<E> immutablelist = Collections.unmodifiableCollection(list);
        return immutablelist.iterator();
    }

    @Override
    public void insertLike(String friend, E data) throws NotExistingFriendException, NotExistingDataException {
        E search = getData(data);
        if(search == null) throw new NotExistingDataException("Data doesn't exist!");
        String cat = search.getCategory();
        if(!friends.get(cat).contains(friend)) throw new NotExistingFriendException("Operation not permitted!");
        search.addLike();
    }

    @Override
    public Iterator<E> getFriendIterator(String friend) throws NotExistingFriendException {
        Set<String> categories;
        categories = friends.keySet();
        ArrayList<String> list = new ArrayList<>();
        for(String cat : categories){
            if(friends.get(cat).contains(friend)) list.add(cat);
        }
        if(list.isEmpty()) throw new NotExistingFriendException("No friend found!");
        ArrayList<E> dati = new ArrayList<>();
        for(String cat : list){
            for(E dat : datas.get(cat)){
                dati.add(dat);
            }
        }
        Collection<E> immutablelist = Collections.unmodifiableCollection(dati);
        return immutablelist.iterator();
    }
        
    //method to verify the correct status of the board
    public void status(String passw) throws AccessDeniedException{
        if(!passw.equals(this.password)) throw new AccessDeniedException("Wrong password!");   //check password
        System.out.println("CURRENT STATUS OF BOARD'S CATEGORIES, DATAS AND FRIENDS:");
        System.out.print("DATAS IN BOARD: ");
        Collection<Vector<E>> list = datas.values();
        for(Vector<E> aux : list){
            Iterator<E> iter = aux.iterator();
            E corr;
            while(iter.hasNext()){
                corr = iter.next();
                 System.out.print(corr.Display()+" ");
            }
        }
        System.out.println();
        System.out.print("FRIENDS IN BOARD: ");System.out.println(friends);
        System.out.println();
    }
        
}
    

