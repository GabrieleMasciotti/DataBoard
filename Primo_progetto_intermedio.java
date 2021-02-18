/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriele
 */
public class Primo_progetto_intermedio {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
       Bacheca1 board = null;
       String psw = null;
       System.out.println();
       System.out.println("TESTING BACHECA1 METHODS:");
       System.out.println();
       try{
           System.out.println("1) Try to create a board with null password:");
           board = new Bacheca1(psw);
       }
       catch (IllegalArgumentException e){
           System.out.println("     IllegalArgumentException thrown: Null password not accepted!");
       }
       psw = new String();
       try{
           System.out.println("2) Try to create a board with empty password:");
           board = new Bacheca1(psw);
       }
       catch (IllegalArgumentException e){
           System.out.println("     IllegalArgumentException thrown: Password is empty!");
       }
       psw = "password";
       try{
           System.out.println("3) Creation of a board with correct password parameter.");
           board = new Bacheca1(psw);
       }
       catch (IllegalArgumentException e){
           System.out.println("     IllegalArgumentException thrown: Board not created!");   //This won't be printed..
       }
       
       System.out.println();
       
       try{
           System.out.println("4) Try to create category, passing wrong password:");
           board.createCategory("Post", "wrong");
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     AccessDeniedException thrown: Wrong password!");
       }
       try{
           System.out.println("5) Try to create category, with null name:");
           String name = null;
           board.createCategory(name, psw);
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     IllegalArgumentException thrown: Null category name not accepted!");
       }
       try{
           System.out.println("6) Try to create category, with empty name:");
           String name = new String();
           board.createCategory(name, psw);
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     IllegalArgumentException thrown: Category name is empty!");
       }
       try{
           System.out.println("7) Creation of a category (Post).");
           String name = new String("Post");
           board.createCategory(name, psw);
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     Category not created!");     //This won't be printed..
       }
       try{
           System.out.println("8) Try to create category, with the same name as previous:");
           String name = new String("Post");
           board.createCategory(name, psw);
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     ExistingCategoryException thrown: Existing category!");
       }
       try{
           System.out.println("9) Creation of a category (Video).");
           String name = new String("Video");
           board.createCategory(name, psw);
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     Category not created!");     //This won't be printed..
       }
       try{
           System.out.println("10) Creation of a category (Image).");
           String name = new String("Image");
           board.createCategory(name, psw);
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     Category not created!");     //This won't be printed..
       }
       try{
           System.out.println("11) Creation of a category (Gif).");
           String name = new String("Gif");
           board.createCategory(name, psw);
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     Category not created!");     //This won't be printed..
       }
       
       System.out.println();
       
       try{
           board.status(psw);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       // GOING TO OMIT TO RETEST AGAIN WRONG PASSWORD CONDITION
       
       try{
           System.out.println("12) Try to remove an inexistent category:");
           board.removeCategory("Picture", psw);
       }
       catch(AccessDeniedException | NotExistingCategoryException | UnsupportedOperationException e){
           System.out.println("     NotExistingCategoryException thrown: Not existing category!");
       }
       try{
           System.out.println("13) Try to remove a null named category:");
           String name = null;
           board.removeCategory(name, psw);
       }
       catch(AccessDeniedException | NotExistingCategoryException | UnsupportedOperationException e){
           System.out.println("     NotExistingCategoryException thrown: Not existing category!");
       }
       try{
           System.out.println("14) Removal of existing category, Video.");
           board.removeCategory("Video", psw);
       }
       catch(AccessDeniedException | NotExistingCategoryException | UnsupportedOperationException e){
           System.out.println("     Category not removed!");     //This won't be printed..
       }
       
       System.out.println();
       
       try{
           board.status(psw);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       try{
           System.out.println("15) Try to add a friend to an inexistent category:");
           board.addFriend("Text", psw, "Gabriele");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException e){
           System.out.println("     NotExistingCategoryException thrown: Not existing category!");
       }
       try{
           System.out.println("16) Try to add a friend with null name:");
           String name = null;
           board.addFriend("Text", psw, name);
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException e){
           System.out.println("     IllegalArgumentException thrown: Null friend name not accepted!");
       }
       try{
           System.out.println("17) Try to add a friend with empty name:");
           String name = null;
           name = new String();
           board.addFriend("Text", psw, name);
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException e){
           System.out.println("     IllegalArgumentException thrown: Friend name is empty!");
       }
       try{
           System.out.println("18) Adding a new friend (Gabriele).");
           board.addFriend("Post", psw, "Gabriele");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException e){
           System.out.println("     Friend not added!");        //This won't be printed
       }
       try{
           System.out.println("19) Adding a new friend (Martina).");
           board.addFriend("Image", psw, "Martina");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException e){
           System.out.println("     Friend not added!");        //This won't be printed
       }
       try{
           System.out.println("20) Adding a new friend (Emanuele).");
           board.addFriend("Gif", psw, "Emanuele");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException e){
           System.out.println("     Friend not added!");        //This won't be printed
       }
       try{
           System.out.println("21) Try to add a friend with the same name as previous:");
           board.addFriend("Post", psw, "Gabriele");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException e){
           System.out.println("     IllegalArgumentException thrown: Friend name already exists!");
       }
       try{
           System.out.println("22) Try to remove an inexistent friend:");
           board.removeFriend("Post", psw, "Giada");
       }
       catch(AccessDeniedException | NotExistingFriendException | NotExistingCategoryException e){
           System.out.println("     NotExistingFriendException thrown: Friend wanted to be removed doesn't exist!");
       }
       try{
           System.out.println("23) Try to remove a null named friend:");
           String name = null;
           board.removeFriend("Post", psw, name);
       }
       catch(AccessDeniedException | NotExistingFriendException | NotExistingCategoryException e){
           System.out.println("     NotExistingFriendException thrown: Friend wanted to be removed doesn't exist!");
       }
       try{
           System.out.println("24) Removal of friend Emanuele from category Gif.");
           board.removeFriend("Gif", psw, "Emanuele");
       }
       catch(AccessDeniedException | NotExistingFriendException | NotExistingCategoryException e){
           System.out.println("     Friend not removed!");        //This won't be printed
       }
       
       System.out.println();
       
       try{
           board.status(psw);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
        
       Primo_dato1 dato1;
       dato1 = new Primo_dato1("dato1");
        
       try{
          System.out.println("25) Adding a new data to the board (dato1).");
          boolean result = board.put(psw, dato1, "Post");
          System.out.println("     Put method returned: "+result+".");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException | ExistingDataException | CloneNotSupportedException e){
          System.out.println("     Data not created!");        //This won't be printed
       }
       
       Secondo_dato1 dato2;
       dato2 = new Secondo_dato1("dato2");
        
       try{
          System.out.println("26) Adding a new data to the board (dato2).");
          boolean result = board.put(psw, dato2, "Post");
          System.out.println("     Put method returned: "+result+".");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException | ExistingDataException | CloneNotSupportedException e){
          System.out.println("     Data not created!");        //This won't be printed
      }
       
       System.out.println();
       
       try{
           board.status(psw);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       Terzo_dato1 dato3 = null;
       
       try{
          System.out.println("27) Try to add a null data:");
          board.put(psw, dato3, "Post");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException | ExistingDataException | CloneNotSupportedException e){
          System.out.println("     IllegalArgumentException thrown: Null data not accepted!");
      }
       
       dato3 = new Terzo_dato1("dato2");
       
       try{
          System.out.println("28) Try to add a data with the same name as previous:");
          board.put(psw, dato3, "Post");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException | ExistingDataException | CloneNotSupportedException e){
          System.out.println("     ExistingDataException thrown: Data name already exists!");
      }
       
       dato3 = new Terzo_dato1("dato3");
       
       try{
          System.out.println("29) Try to add a correctly named data with an inexistent category:");
          board.put(psw, dato3, "Boomerang");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException | ExistingDataException | CloneNotSupportedException e){
          System.out.println("     NotExistingCategoryException thrown: Not existing category!");
      }
       try{
          System.out.println("30) Adding a new data to the board (dato3).");
          boolean result = board.put(psw, dato3, "Post");
          System.out.println("     Put method returned: "+result+".");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException | ExistingDataException | CloneNotSupportedException e){
          System.out.println("     Data not created!");        //This won't be printed
      }
       System.out.println();
       
       try{
           board.status(psw);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       Secondo_dato1 copy1 = null;
       Secondo_dato1 inexistent;
       inexistent = new Secondo_dato1("dato4");
       
       try{
          System.out.println("31) Try to get a copy of an inexistent data:");
          copy1 = (Secondo_dato1) board.get(psw, inexistent);
       }
       catch(AccessDeniedException | NotExistingDataException | CloneNotSupportedException e){
          System.out.println("     NotExistingDataException thrown: Data doesn't exist!");
      }
       
       Secondo_dato1 nullo = null;
       
       try{
          System.out.println("32) Try to get a copy of a null data:");
          copy1 = (Secondo_dato1) board.get(psw, nullo);
       }
       catch(AccessDeniedException | NotExistingDataException | CloneNotSupportedException e){
          System.out.println("     NotExistingDataException thrown: Data doesn't exist!");
      }
     try{
          System.out.println("33) Get a copy of a data (Dato2).");
          copy1 = (Secondo_dato1) board.get(psw, dato2);
          System.out.println("     "+copy1.Display());      //Complete display of the data copied
       }
       catch(AccessDeniedException | NotExistingDataException | CloneNotSupportedException e){
          System.out.println("     Data not copied!");        //This won't be printed
      }
       System.out.println();
       
       System.out.println("Modifying copied data into:");
       copy1.addLike();
       Category cat = new Category("N_D");
       copy1.setCategory(cat);
       System.out.println(copy1.Display());
       System.out.println();
       try{
           board.status(psw);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
       System.out.println("Although copy is modified the data into the board remains unchanged.");
       System.out.println();
       
       Secondo_dato1 two = null;
       
       try{
          System.out.println("34) Try to remove a null data:");
          board.remove(psw, two);
       }
       catch(AccessDeniedException | NotExistingDataException e){
          System.out.println("     NotExistingDataException thrown: Data doesn't exist!");
      }
       
       two = new Secondo_dato1("inexistent");
       
       try{
          System.out.println("35) Try to remove an inexistent data:");
          board.remove(psw, two);
       }
       catch(AccessDeniedException | NotExistingDataException e){
          System.out.println("     NotExistingDataException thrown: Data doesn't exist!");
      }
       
       Terzo_dato1 three = new Terzo_dato1("dato3");
       
       try{
          System.out.println("36) Removal of a data (dato3).");
          board.remove(psw, three);
       }
       catch(AccessDeniedException | NotExistingDataException e){
          System.out.println("     Data not removed!");        //This won't be printed
      }
       
       System.out.println();
       try{
           board.status(psw);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       List<Data1> lista = null;
       
       try{
          System.out.println("37) Try to get a list of datas with an inexistent category:");
          lista = board.getDataCategory(psw, "boomerang");
       }
       catch(AccessDeniedException | NotExistingCategoryException e){
          System.out.println("     NotExistingCategoryException thrown: Not existing category! List would be empty!");
      }
       try{
          System.out.println("38) Getting a list of datas of passed category (Post):");
          lista = board.getDataCategory(psw, "Post");
       }
       catch(AccessDeniedException | NotExistingCategoryException e){
          System.out.println("     List not created!");        //This won't be printed
      }
       
       //Print all the elements of the list
       System.out.print("     ");
       System.out.print("Elements of the created list:  ");
        for (Data1 el : lista) {
            System.out.print(el.Display()+" ;  ");
        }
        System.out.println();
        System.out.println();
        
       try{
          System.out.println("39) Try to add a like by an inexistent friend:");
          board.insertLike("Giada", dato1);
       }
       catch(NotExistingFriendException | NotExistingDataException e){
          System.out.println("     NotExistingFriendException thrown: Operation not permitted!");
      } 
        try{
          System.out.println("40) Try to add a like to an inexistent data:");
          board.insertLike("Gabriele", dato3);
       }
       catch(NotExistingFriendException | NotExistingDataException e){
          System.out.println("     NotExistingDataException thrown: Data doesn't exist!");
      } 
        try{
          System.out.println("41) Adding one like to a data (dato1).");
          board.insertLike("Gabriele", dato1);
       }
       catch(NotExistingFriendException | NotExistingDataException e){
          System.out.println("     Like not added!");        //This won't be printed
      } 
        try{
          System.out.println("42) Adding two likes to a data (dato2).");
          board.insertLike("Gabriele", dato2);
          board.insertLike("Gabriele", dato2);
       }
       catch(NotExistingFriendException | NotExistingDataException e){
          System.out.println("     Like not added!");        //This won't be printed
      } 
        
        System.out.println();
       try{
           board.status(psw);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
        Iterator<Data1> iter = null;
        
       try{
          System.out.println("43) Getting an iterator which generates all datas in board sorted considering number of likes (descending order) and trying to remove an element.");
          iter = board.getIterator(psw);
          iter.remove();
       }
       catch(AccessDeniedException | UnsupportedOperationException e){
          System.out.println("     UnsupportedOperationException thrown: Remove operation not permetted!");
      } 
       System.out.println("Printing elements generated by iterator:");
       System.out.print("     ");
       while(iter.hasNext()){
          System.out.print(iter.next().Display()+"; ");
       }
       System.out.println();
       System.out.println();
       
       Iterator<Data1> iterr = null;
       
       try{
          System.out.println("44) Try to get an iterator which generates datas shared with an inexistent friend:");
          iterr = board.getFriendIterator("Giada");
       }
       catch(NotExistingFriendException e){
          System.out.println("     NotExistingFriendException thrown: No friend found!");
      }
       try{
          System.out.println("45) Getting an iterator which generates all datas in board shared with the passed friend username (Gabriele).");
          iterr = board.getFriendIterator("Gabriele");
       }
       catch(NotExistingFriendException e){
          System.out.println("     Iterator not created!");        //This won't be printed
      }
       System.out.println("Printing elements generated by iterator:");
       System.out.print("     ");
       while(iterr.hasNext()){
          System.out.print(iterr.next().Display()+"; ");
       }
       System.out.println();
       System.out.println();
       
       Iterator<Data1> iterrr = null;
       
       try{
          System.out.println("46) Getting an iterator which generates all datas in board shared with the passed friend username (Martina).");
          iterrr = board.getFriendIterator("Martina");
       }
       catch(NotExistingFriendException e){
          System.out.println("     Iterator not created!");        //This won't be printed
      }
       System.out.println("Printing elements generated by iterator:");
       System.out.print("     ");
       while(iterrr.hasNext()){
          System.out.print(iterrr.next().Display()+"; ");
       }
       System.out.println();
       
       try{
           System.out.println("47) Try to remove a category associated to datas (Post):");
           board.removeCategory("Post", psw);
       }
       catch(AccessDeniedException | NotExistingCategoryException | UnsupportedOperationException e){
           System.out.println("     UnsupportedOperationException thrown: Category is associated to datas in board! Please remove datas before removing category.");
       }
       System.out.println();
       try{
           board.status(psw);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       } 
        
        
       
       Bacheca2 board2 = null;
       String psw2 = null;
       System.out.println();
       System.out.println("TESTING BACHECA2 METHODS:");
       System.out.println();
       System.out.println();
       try{
           System.out.println("1) Try to create a board with null password:");
           board2 = new Bacheca2(psw2);
       }
       catch (IllegalArgumentException e){
           System.out.println("     IllegalArgumentException thrown: Null password not accepted!");
       }
       psw2 = new String();
       try{
           System.out.println("2) Try to create a board with empty password:");
           board2 = new Bacheca2(psw2);
       }
       catch (IllegalArgumentException e){
           System.out.println("     IllegalArgumentException thrown: Password is empty!");
       }
       psw2 = "passwor";
       try{
           System.out.println("3) Creation of a board with correct password parameter.");
           board2 = new Bacheca2(psw2);
       }
       catch (IllegalArgumentException e){
           System.out.println("     IllegalArgumentException thrown: Board not created!");   //This won't be printed..
       }
       
       System.out.println();
       
       try{
           System.out.println("4) Try to create category, passing wrong password:");
           board2.createCategory("Post", "wrong");
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     AccessDeniedException thrown: Wrong password!");
       }
       try{
           System.out.println("5) Try to create category, with null name:");
           String name = null;
           board2.createCategory(name, psw2);
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     IllegalArgumentException thrown: Null category name not accepted!");
       }
       try{
           System.out.println("6) Try to create category, with empty name:");
           String name = new String();
           board2.createCategory(name, psw2);
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     IllegalArgumentException thrown: Category name is empty!");
       }
       try{
           System.out.println("7) Creation of a category (Post).");
           String name = new String("Post");
           board2.createCategory(name, psw2);
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     Category not created!");     //This won't be printed..
       }
       try{
           System.out.println("8) Try to create category, with the same name as previous:");
           String name = new String("Post");
           board2.createCategory(name, psw2);
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     ExistingCategoryException thrown: Existing category!");
       }
       try{
           System.out.println("9) Creation of a category (Video).");
           String name = new String("Video");
           board2.createCategory(name, psw2);
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     Category not created!");     //This won't be printed..
       }
       try{
           System.out.println("10) Creation of a category (Image).");
           String name = new String("Image");
           board2.createCategory(name, psw2);
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     Category not created!");     //This won't be printed..
       }
       try{
           System.out.println("11) Creation of a category (Gif).");
           String name = new String("Gif");
           board2.createCategory(name, psw2);
       }
       catch (AccessDeniedException | ExistingCategoryException | IllegalArgumentException e){
           System.out.println("     Category not created!");     //This won't be printed..
       }
       
       System.out.println();
       
       try{
           board2.status(psw2);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
       // GOING TO OMIT TO RETEST AGAIN WRONG PASSWORD CONDITION
       
       try{
           System.out.println("12) Try to remove an inexistent category:");
           board2.removeCategory("Picture", psw2);
       }
       catch(AccessDeniedException | NotExistingCategoryException | UnsupportedOperationException e){
           System.out.println("     NotExistingCategoryException thrown: Not existing category!");
       }
       try{
           System.out.println("13) Try to remove a null named category:");
           String name = null;
           board2.removeCategory(name, psw2);
       }
       catch(AccessDeniedException | NotExistingCategoryException | UnsupportedOperationException e){
           System.out.println("     NotExistingCategoryException thrown: Not existing category!");
       }
       try{
           System.out.println("14) Removal of existing category, Video.");
           board2.removeCategory("Video", psw2);
       }
       catch(AccessDeniedException | NotExistingCategoryException | UnsupportedOperationException e){
           System.out.println("     Category not removed!");     //This won't be printed..
       }
       
       System.out.println();
       
       try{
           board2.status(psw2);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       try{
           System.out.println("15) Try to add a friend to an inexistent category:");
           board2.addFriend("Text", psw2, "Gabriele");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException e){
           System.out.println("     NotExistingCategoryException thrown: Not existing category!");
       }
       try{
           System.out.println("16) Try to add a friend with null name:");
           String name = null;
           board2.addFriend("Text", psw2, name);
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException e){
           System.out.println("     IllegalArgumentException thrown: Null friend name not accepted!");
       }
       try{
           System.out.println("17) Try to add a friend with empty name:");
           String name = null;
           name = new String();
           board2.addFriend("Text", psw2, name);
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException e){
           System.out.println("     IllegalArgumentException thrown: Friend name is empty!");
       }
       try{
           System.out.println("18) Adding a new friend (Gabriele).");
           board2.addFriend("Post", psw2, "Gabriele");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException e){
           System.out.println("     Friend not added!");        //This won't be printed
       }
       try{
           System.out.println("19) Adding a new friend (Martina).");
           board2.addFriend("Image", psw2, "Martina");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException e){
           System.out.println("     Friend not added!");        //This won't be printed
       }
       try{
           System.out.println("20) Adding a new friend (Emanuele).");
           board2.addFriend("Gif", psw2, "Emanuele");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException e){
           System.out.println("     Friend not added!");        //This won't be printed
       }
       try{
           System.out.println("21) Try to add a friend with the same name as previous:");
           board2.addFriend("Post", psw2, "Gabriele");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException e){
           System.out.println("     IllegalArgumentException thrown: Friend name already exists!");
       }
       try{
           System.out.println("22) Try to remove an inexistent friend:");
           board2.removeFriend("Post", psw2, "Giada");
       }
       catch(AccessDeniedException | NotExistingFriendException | NotExistingCategoryException e){
           System.out.println("     NotExistingFriendException thrown: Friend wanted to be removed doesn't exist!");
       }
       try{
           System.out.println("23) Try to remove a null named friend:");
           String name = null;
           board2.removeFriend("Post", psw2, name);
       }
       catch(AccessDeniedException | NotExistingFriendException | NotExistingCategoryException e){
           System.out.println("     NotExistingFriendException thrown: Friend wanted to be removed doesn't exist!");
       }
       try{
           System.out.println("24) Removal of friend Emanuele from category Gif.");
           board2.removeFriend("Gif", psw2, "Emanuele");
       }
       catch(AccessDeniedException | NotExistingFriendException | NotExistingCategoryException e){
           System.out.println("     Friend not removed!");        //This won't be printed
       }
       
       System.out.println();
       
       try{
           board2.status(psw2);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
        
       Primo_dato2 dato1_;
       dato1_ = new Primo_dato2("dato1");
        
       try{
          System.out.println("25) Adding a new data to the board (dato1).");
          boolean result = board2.put(psw2, dato1_, "Post");
          System.out.println("     Put method returned: "+result+".");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException | ExistingDataException | CloneNotSupportedException e){
          System.out.println("     Data not created!");        //This won't be printed
       }
       
       Secondo_dato2 dato2_;
       dato2_ = new Secondo_dato2("dato2");
        
       try{
          System.out.println("26) Adding a new data to the board (dato2).");
          boolean result = board2.put(psw2, dato2_, "Post");
          System.out.println("     Put method returned: "+result+".");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException | ExistingDataException | CloneNotSupportedException e){
          System.out.println("     Data not created!");        //This won't be printed
      }
       
       System.out.println();
       
       try{
           board2.status(psw2);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       Terzo_dato2 dato3_ = null;
       
       try{
          System.out.println("27) Try to add a null data:");
          board2.put(psw2, dato3_, "Post");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException | ExistingDataException | CloneNotSupportedException e){
          System.out.println("     IllegalArgumentException thrown: Null data not accepted!");
      }
       
       dato3_ = new Terzo_dato2("dato2");
       
       try{
          System.out.println("28) Try to add a data with the same name as previous:");
          board2.put(psw2, dato3_, "Post");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException | ExistingDataException | CloneNotSupportedException e){
          System.out.println("     ExistingDataException thrown: Data name already exists!");
      }
       
       dato3_ = new Terzo_dato2("dato3");
       
       try{
          System.out.println("29) Try to add a correctly named data with an inexistent category:");
          board2.put(psw2, dato3_, "Boomerang");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException | ExistingDataException | CloneNotSupportedException e){
          System.out.println("     NotExistingCategoryException thrown: Not existing category!");
      }
       try{
          System.out.println("30) Adding a new data to the board (dato3).");
          boolean result = board2.put(psw2, dato3_, "Post");
          System.out.println("     Put method returned: "+result+".");
       }
       catch(AccessDeniedException | IllegalArgumentException | NotExistingCategoryException | ExistingDataException | CloneNotSupportedException e){
          System.out.println("     Data not created!");        //This won't be printed
      }
       System.out.println();
       
       try{
           board2.status(psw2);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       Secondo_dato2 copy1_ = null;
       Secondo_dato2 inexistent_;
       inexistent_ = new Secondo_dato2("dato4");
       
       try{
          System.out.println("31) Try to get a copy of an inexistent data:");
          copy1_ = (Secondo_dato2) board2.get(psw2, inexistent_);
       }
       catch(AccessDeniedException | NotExistingDataException | CloneNotSupportedException e){
          System.out.println("     NotExistingDataException thrown: Data doesn't exist!");
      }
       
       Secondo_dato2 nullo_ = null;
       
       try{
          System.out.println("32) Try to get a copy of a null data:");
          copy1_ = (Secondo_dato2) board2.get(psw2, nullo_);
       }
       catch(AccessDeniedException | NotExistingDataException | CloneNotSupportedException e){
          System.out.println("     NotExistingDataException thrown: Data doesn't exist!");
      }
     try{
          System.out.println("33) Get a copy of a data (Dato2).");
          copy1_ = (Secondo_dato2) board2.get(psw2, dato2_);
          System.out.println("     "+copy1_.Display());      //Complete display of the data copied
       }
       catch(AccessDeniedException | NotExistingDataException | CloneNotSupportedException e){
          System.out.println("     Data not copied!");        //This won't be printed
      }
       System.out.println();
       
       System.out.println("Modifying copied data into:");
       copy1_.addLike();
       String catt = "N_D";
       copy1_.setCategory(catt);
       System.out.println(copy1.Display());
       System.out.println();
       try{
           board2.status(psw2);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
       System.out.println("Although copy is modified the data into the board remains unchanged.");
       System.out.println();
       
       Secondo_dato2 two_ = null;
       
       try{
          System.out.println("34) Try to remove a null data:");
          board2.remove(psw2, two_);
       }
       catch(AccessDeniedException | NotExistingDataException e){
          System.out.println("     NotExistingDataException thrown: Data doesn't exist!");
      }
       
       two_ = new Secondo_dato2("inexistent");
       
       try{
          System.out.println("35) Try to remove an inexistent data:");
          board2.remove(psw2, two_);
       }
       catch(AccessDeniedException | NotExistingDataException e){
          System.out.println("     NotExistingDataException thrown: Data doesn't exist!");
      }
       
       Terzo_dato2 three_ = new Terzo_dato2("dato3");
       
       try{
          System.out.println("36) Removal of a data (dato3).");
          board2.remove(psw2, three_);
       }
       catch(AccessDeniedException | NotExistingDataException e){
          System.out.println("     Data not removed!");        //This won't be printed
      }
       
       System.out.println();
       try{
           board2.status(psw2);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       List<Data2> lista_ = null;
       
       try{
          System.out.println("37) Try to get a list of datas with an inexistent category:");
          lista_ = board2.getDataCategory(psw2, "boomerang");
       }
       catch(AccessDeniedException | NotExistingCategoryException e){
          System.out.println("     NotExistingCategoryException thrown: Not existing category! List would be empty!");
      }
       try{
          System.out.println("38) Getting a list of datas of passed category (Post):");
          lista_ = board2.getDataCategory(psw2, "Post");
       }
       catch(AccessDeniedException | NotExistingCategoryException e){
          System.out.println("     List not created!");        //This won't be printed
      }
       
       //Print all the elements of the list
       System.out.print("     ");
       System.out.print("Elements of the created list:  ");
        for (Data2 el : lista_) {
            System.out.print(el.Display()+" ;  ");
        }
        System.out.println();
        System.out.println();
        
       try{
          System.out.println("39) Try to add a like by an inexistent friend:");
          board2.insertLike("Giada", dato1_);
       }
       catch(NotExistingFriendException | NotExistingDataException e){
          System.out.println("     NotExistingFriendException thrown: Operation not permitted!");
      } 
        try{
          System.out.println("40) Try to add a like to an inexistent data:");
          board2.insertLike("Gabriele", dato3_);
       }
       catch(NotExistingFriendException | NotExistingDataException e){
          System.out.println("     NotExistingDataException thrown: Data doesn't exist!");
      } 
        try{
          System.out.println("41) Adding one like to a data (dato1).");
          board2.insertLike("Gabriele", dato1_);
       }
       catch(NotExistingFriendException | NotExistingDataException e){
          System.out.println("     Like not added!");        //This won't be printed
      } 
        try{
          System.out.println("42) Adding two likes to a data (dato2).");
          board2.insertLike("Gabriele", dato2_);
          board2.insertLike("Gabriele", dato2_);
       }
       catch(NotExistingFriendException | NotExistingDataException e){
          System.out.println("     Like not added!");        //This won't be printed
      } 
        
        System.out.println();
       try{
           board2.status(psw2);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
        Iterator<Data2> iter_ = null;
        
       try{
          System.out.println("43) Getting an iterator which generates all datas in board sorted considering number of likes (descending order) and trying to remove an element.");
          iter_ = board2.getIterator(psw2);
          iter_.remove();
       }
       catch(AccessDeniedException | UnsupportedOperationException e){
          System.out.println("     UnsupportedOperationException thrown: Remove operation not permetted!");
      } 
       System.out.println("Printing elements generated by iterator:");
       System.out.print("     ");
       while(iter_.hasNext()){
          System.out.print(iter_.next().Display()+"; ");
       }
       System.out.println();
       System.out.println();
       
       Iterator<Data2> iterr_ = null;
       
       try{
          System.out.println("44) Try to get an iterator which generates datas shared with an inexistent friend:");
          iterr_ = board2.getFriendIterator("Giada");
       }
       catch(NotExistingFriendException e){
          System.out.println("     NotExistingFriendException thrown: No friend found!");
      }
       try{
          System.out.println("45) Getting an iterator which generates all datas in board shared with the passed friend username (Gabriele).");
          iterr_ = board2.getFriendIterator("Gabriele");
       }
       catch(NotExistingFriendException e){
          System.out.println("     Iterator not created!");        //This won't be printed
      }
       System.out.println("Printing elements generated by iterator:");
       System.out.print("     ");
       while(iterr_.hasNext()){
          System.out.print(iterr_.next().Display()+"; ");
       }
       System.out.println();
       System.out.println();
       
       Iterator<Data2> iterrr_ = null;
       
       try{
          System.out.println("46) Getting an iterator which generates all datas in board shared with the passed friend username (Martina).");
          iterrr_ = board2.getFriendIterator("Martina");
       }
       catch(NotExistingFriendException e){
          System.out.println("     Iterator not created!");        //This won't be printed
      }
       System.out.println("Printing elements generated by iterator:");
       System.out.print("     ");
       while(iterrr_.hasNext()){
          System.out.print(iterrr_.next().Display()+"; ");
       }
       System.out.println();
       
       try{
           System.out.println("47) Try to remove a category associated to datas (Post):");
           board2.removeCategory("Post", psw2);
       }
       catch(AccessDeniedException | NotExistingCategoryException | UnsupportedOperationException e){
           System.out.println("     UnsupportedOperationException thrown: Category is associated to datas in board! Please remove datas before removing category.");
       }
       System.out.println();
       try{
           board2.status(psw2);
       }
       catch(AccessDeniedException ex) {
           Logger.getLogger(Primo_progetto_intermedio.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
