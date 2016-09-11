/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.brocode.tg.logharvester.model.exception;

/**
 *
 * @author G
 */
public class LoggerException extends Exception {

    private static final long serialVersionUID = -3338929240106199568L;

    public LoggerException() {
    }

    public LoggerException(String message) {
        super(message);
    }

    public LoggerException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoggerException(Throwable cause) {
        super(cause);
    }

}
