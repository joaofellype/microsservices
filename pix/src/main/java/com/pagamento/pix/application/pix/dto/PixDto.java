package com.pagamento.pix.application.pix.dto;

import com.pagamento.pix.application.users.save.UserRequest;

import java.time.LocalDateTime;

public class PixDto {

    private String id;
    private String idTransaction;
    private UserRequest userSend;
    private LocalDateTime dateTransaction;
    private UserRequest userReceived;
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public UserRequest getUserSend() {
        return userSend;
    }

    public void setUserSend(UserRequest userSend) {
        this.userSend = userSend;
    }

    public LocalDateTime getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(LocalDateTime dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public UserRequest getUserReceived() {
        return userReceived;
    }

    public void setUserReceived(UserRequest userReceived) {
        this.userReceived = userReceived;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
