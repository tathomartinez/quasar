package com.ilem.quasar.api.model;

public class ResponseTopSecret {
    private Position position;
    private String message;

    public ResponseTopSecret() {
    }

    public ResponseTopSecret(Position position, String message) {
        this.position = position;
        this.message = message;
    }

    /**
     * @return Position return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * @return String return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
