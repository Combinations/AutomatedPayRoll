/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayRoll;

/**
 *
 * @author James
 */
public class WrongLoginException extends Exception {

    /**
     * Creates a new instance of <code>WrongLoginException</code> without detail
     * message.
     */
    public WrongLoginException() {
    }

    /**
     * Constructs an instance of <code>WrongLoginException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public WrongLoginException(String msg) {
        super(msg);
    }
}
