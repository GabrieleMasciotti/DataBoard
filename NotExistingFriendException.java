/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author gabriele
 */
public class NotExistingFriendException extends Exception {

    /**
     * Creates a new instance of <code>NotExistingFriend</code> without detail
     * message.
     */
    public NotExistingFriendException() {
    }

    /**
     * Constructs an instance of <code>NotExistingFriend</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotExistingFriendException(String msg) {
        super(msg);
    }
}
