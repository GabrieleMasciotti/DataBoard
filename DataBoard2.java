/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;
import java.util.List;

/**
 *
 * @author gabriele
 * @param <E>
 */

/* OVERVIEW:
    --> DataBoard2 is a container for storing and displaying generic datas which extend type Data2. It guarantees privacy of datas, allowing modification only to
        the owner and viewing to only added friends (to each category). Moreover it allows added friends to give likes to datas.
    --> TYPICAL ELEMENT: <password, <{category1=[<datas>], category2=[<datas>], ...., categoryN=[<datas>]}>, <{category1=[<friends>], category2=[<friends>], ...., categoryN=[<friends>]}>>
    --> REPRESENTATION INVARIANT: this.password != null && this.password.isEmpty == false
            datas.ketSet().contains(null) == false &&
            friends.keySet().contains(null) == false &&
            datas.ketSet().contains(emptyvalue) == false &&
            friends.keySet().contains(emptyvalue) == false &&
            datas.keySet() == friends.keySet() &&
   for each "categoryI" with I in datas.size(): categoryI != null
                                                categoryI.isEmpty() == false
   for each "z" in datas.get(categoryI).size(): this.datas.get(categoryI) != null &&
                                                this.datas.get(categoryI).get(z) != null &&
                                                this.datas.get(categoryI).get(z).getName() != null &&
                                                this.datas.get(categoryI).get(z).getName().isEmpty == false &&
                                                this.datas.get(categoryI).get(z).getCategory() != null &&
                                                this.datas.get(categoryI).get(z).getCategory().isEmpty() == false &&
                                                this.datas.get(categoryI).get(z).getLikes() >= 0 &&
                                                for each "categoryW" with W in datas.size():
                                                for each "c" in datas.get(categoryW).size(): this.datas.get(categoryI).get(z).getName().equals(this.datas.get(categoryW).get(c).getName()) == false
 for each "categoryJ" with J in friends.size(): categoryJ != null
                                                categoryJ.isEmpty() == false
 for each "u" in friends.get(categoryJ).size(): this.friends.get(categoryJ) != null &&
                                                this.friends.get(categoryJ).get(u).getName() != null &&
                                                this.friends.get(categoryJ).get(u).getName().isEmpty == false &&
                                                for each "b" in friends.get(categoryJ).size(): this.friends.get(categoryJ).get(b).getName().equals(this.friends.get(categoryJ).get(u).getName()) == false
    --> ABSTRACT FUNCTION: AB = [password, <datas.get(category1).get(a), datas.get(category2).get(b), ....., datas.get(categoryN).get(c)>, <friends.get(category1).get(d), friends.get(category2).get(e), ....., friends.get(categoryN).get(f)>]
                with a,b,c,d,e,f,...... in each Vector's size().
*/

public interface DataBoard2 <E extends Data2>{
    /* Creates a new Category
    REQUIRES: passw == this.password (passw must match the board's password)
              Category != null
              Category.isEmpty == false   (the category name must not be empty (has to contain at least a character))
              this.myCategories.contains(Category) == false   (the category list of the board must not yet contain a category with the same name)
    THROWS:   AccessDeniedException if inserted password doesn't match the board's password
              ExistingCategoryException if the Category wanted already exists
              IllegalArgumentException if the passed Category name is null
    MODIFIES: this.myCategories
    EFFECTS:  this.myCategories.post = this.myCategories.pre U {Category}   create a brand new category for the board, if it doesn't already exist
*/
public void createCategory(String Category, String passw) throws AccessDeniedException, ExistingCategoryException, IllegalArgumentException;

/* Removes the entire category
    REQUIRES: passw == this.password (passw must match the board's password)
              this.myCategories.contains(Category) == true   (the category list of the board must contain the category)
              for all i : this.datas.get(i).getCategory().getName() != Category
    THROWS:   AccessDeniedException if inserted password doesn't match the board's password
              NotExistingCategoryException if the Category wanted to be removed doesn't exist
              UnsupportedOperationException if one tries to remove a category which is associated to datas
    MODIFIES: this.myCategories
    EFFECTS:  this.myCategories.post = this.myCategories.pre \ {Category}   removes a category from the baord if it exists
*/
public void removeCategory(String Category, String passw) throws AccessDeniedException, NotExistingCategoryException, UnsupportedOperationException;

/* Add a friend to a category
REQUIRES:     passw == this.password (passw must match the board's password)
              this.myCategories.contains(Category) == true
              friend != null
              friend.isEmpty == false (the friend name must not be empty (has to contain at least a character))
              Category.friends.contains(friend) == false    (friend name already exists)
THROWS:       AccessDeniedException if inserted password doesn't match the board's password
              NotExistingCategoryException if the Category doesn't exist
              IllegalArgumentException if friend name is null, is empty or it already exists
MODIFIES:     this.myCategories.Category.friends
EFFECTS:      this.myCategories.Category.friends.post = this.myCategories.Category.friends.pre U {friend}    add a new friend to a category
*/
public void addFriend(String Category, String passw, String friend) throws AccessDeniedException, IllegalArgumentException, NotExistingCategoryException;

/* Removes a friend from a category
REQUIRES:     passw == this.password (passw must match the board's password)
              this.myCategories.contains(Category) == true
              Category.friends.contains(friend) == true    (friend name wanted to be removed must exist)
THROWS:       AccessDeniedException if inserted password doesn't match the board's password
              NotExistingCategoryException if the Category doesn't exist
              NotExistingFriendException if the friend wanted to be removed doens't exist
MODIFIES:     this.myCategories.Category.friends
EFFECTS:      this.myCategories.Category.friends.post = this.myCategories.Category.friends.pre \ {friend}    removes the friend if it exists
*/
public void removeFriend(String Category, String passw, String friend) throws AccessDeniedException, NotExistingCategoryException, NotExistingFriendException;

/* Adds a new data (a clone of the passed data, to prevent unauthorized modifications) to the board and sets its category if the identity controls passed
REQUIRES:     passw == this.password (passw must match the board's password)
              this.myCategories.contains(Category) == true
              dato != null   (data wanted to be added must created in advance
              this.datas.contains(dato) == false    (a data with name "dato" must not yet exist)
THROWS:       AccessDeniedException if inserted password doesn't match the board's password
              NotExistingCategoryException if the Category doesn't exist
              IllegalArgumentException if the data wanted to be added is null
              ExistingDataException if the data wanted to be added has the same name as an existing data
              CloneNotSupportedException actually never seen that Data1 implements Cloneable interface
MODIFIES:     this.datas
EFFECTS:      this.datas.post = this.datas.pre U {dato}     adds the new data if a such named data doesn't exist
*/
public boolean put(String passw, E dato, String categoria) throws AccessDeniedException, ExistingDataException, NotExistingCategoryException, IllegalArgumentException, CloneNotSupportedException;

/* Gets a copy of a data in the board with all properties, passing a data created with same name
REQUIRES:     passw == this.password (passw must match the board's password)
              this.datas.contains(dato) == true    (a data with name "dato" must exist)
THROWS:       AccessDeniedException if inserted password doesn't match the board's password
              NotExistingDataException if the data wanted does not exist
              CloneNotSupportedException actually never seen that Data implements Cloneable interface
MODIFIES:     nothing
EFFECTS:      returns a copy of the data if it exists 
*/
public E get(String passw, E dato) throws AccessDeniedException, NotExistingDataException, CloneNotSupportedException;

/* Removes the such named data from the board
REQUIRES:     passw == this.password (passw must match the board's password)
              this.datas.contains(dato) == true    (a data with name "dato" must exist)
THROWS:       AccessDeniedException if inserted password doesn't match the board's password
              NotExistingDataException if the data wanted to be removed does not exist
MODIFIES:     this.datas
EFFECTS:      this.datas.post = this.datas.pre \ {dato}     removes and returns the data
*/
public E remove(String passw, E dato) throws AccessDeniedException, NotExistingDataException;

/* Creates the list of datas, in board, of the passed category
REQUIRES:     passw == this.password (passw must match the board's password)
              this.myCategories.contains(Category) == true
THROWS:       AccessDeniedException if inserted password doesn't match the board's password
              NotExistingCategoryException if the Category doesn't exist
MODIFIES:     nothing
EFFECTS:      returns a list of datas of the category passed
*/
public List<E> getDataCategory(String passw, String Category) throws AccessDeniedException, NotExistingCategoryException;

/* Returns an iterator (with no remove permitted) which generates all datas in board sorted considering number of like (descending order)
REQUIRES:     passw == this.password (passw must match the board's password)
THROWS:       AccessDeniedException if inserted password doesn't match the board's password
              UnsupportedOperationException if one tries to remove elements
MODIFIES:     nothing
EFFECTS:      returns an iterator on an immutable list of datas contained in board
*/
public Iterator<E> getIterator(String passw) throws AccessDeniedException, UnsupportedOperationException;

/* Adds a like to a such named data
REQUIRES:     data.getCategory.friends.contains(friend) == true   the friend must be able to add like (his username has to be contained in the category list of friends)
THROWS:       NotExistingFriendException if friend cannot insert a like to that category of datas
              NotExistingDataException if data doesn't exist
MODIFIES:     data.likes
EFFECTS:      data.likes.post = data.likes.pre + 1       increments the number of likes of the data
*/
public void insertLike(String friend, E data) throws NotExistingFriendException, NotExistingDataException;

/* Returns an iterator (with no remove permitted) which generates all datas in board shared with the passed friend username
REQUIRES:     friend is contained in at least one category
THROWS:       NotExistingFriendException if the passed friend username is not found
MODIFIES:     nothing
EFFECTS:      returns an iterator on an immutable list of datas shared with the passed friend (if it exists)
*/
public Iterator<E> getFriendIterator(String friend) throws NotExistingFriendException;
}

