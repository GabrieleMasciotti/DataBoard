/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gabriele
 */
public class NotExistingDataException extends Exception {

    /**
     * Creates a new instance of <code>NotExistingDataException</code> without
     * detail message.
     */
    public NotExistingDataException() {
    }

    /**
     * Constructs an instance of <code>NotExistingDataException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotExistingDataException(String msg) {
        super(msg);
    }
}
