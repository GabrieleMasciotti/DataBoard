/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gabriele
 */
public class ExistingDataException extends Exception {

    /**
     * Creates a new instance of <code>ExistingDataException</code> without
     * detail message.
     */
    public ExistingDataException() {
    }

    /**
     * Constructs an instance of <code>ExistingDataException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExistingDataException(String msg) {
        super(msg);
    }
}
