package com.pagamento.pix.core.domain.aggregates.pix;

import com.pagamento.pix.core.domain.aggregates.users.User;

import java.time.LocalDateTime;

public class Pix {


    private String id;
    private String idTransaction;
    private User userSend;
    private LocalDateTime dateTransaction;
    private User userReceived;
    private String value;

    private Pix(String id, String idTransaction, LocalDateTime dateTransaction, String value) {
        this.id = id;
        this.idTransaction = idTransaction;
        this.dateTransaction = dateTransaction;
        this.value = value;
    }

    public static Pix create(String id, String idTransaction, LocalDateTime dateTransaction, String value) {
        var pix = new Pix(id, idTransaction, dateTransaction, value);
        return pix;
    }

    public String getId() {
        return id;
    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public LocalDateTime getDateTransaction() {
        return dateTransaction;
    }

    public User getUserSend() {
        return userSend;
    }

    public void setUserSend(User userSend) {
        this.userSend = userSend;
    }

    public User getUserReceived() {
        return userReceived;
    }

    public void setUserReceived(User userReceived) {
        this.userReceived = userReceived;
    }

    public String getValue() {
        return value;
    }
}

