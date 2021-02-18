/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Comparator;

/**
 *
 * @author gabriele
 * @param <E>
 */

/*
    Abstract class, which implements Comparator interface, used to define a compare method to order the data list considering the number of likes
*/

public class Order2 <E extends Data2> implements Comparator<E>{
    @Override
    public int compare(E data1, E data2){
        return data2.getLikes() - data1.getLikes();
    }
}
