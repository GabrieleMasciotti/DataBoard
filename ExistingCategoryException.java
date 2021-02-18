/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gabriele
 */
public class ExistingCategoryException extends Exception {

    /**
     * Creates a new instance of <code>ExistingCategoryException</code> without
     * detail message.
     */
    public ExistingCategoryException() {
    }

    /**
     * Constructs an instance of <code>ExistingCategoryException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExistingCategoryException(String msg) {
        super(msg);
    }
}
