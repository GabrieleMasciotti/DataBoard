/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gabriele
 */
public class NotExistingCategoryException extends Exception {

    /**
     * Creates a new instance of <code>NotExistingCategoryException</code>
     * without detail message.
     */
    public NotExistingCategoryException() {
    }

    /**
     * Constructs an instance of <code>NotExistingCategoryException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NotExistingCategoryException(String msg) {
        super(msg);
    }
}
