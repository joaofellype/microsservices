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

   private Pix(String id, String idTransaction, User userSend, LocalDateTime dateTransaction, User userReceived, String value) {
      this.id = id;
      this.idTransaction = idTransaction;
      this.userSend = userSend;
      this.dateTransaction = dateTransaction;
      this.userReceived = userReceived;
      this.value = value;
   }

   public  static Pix create(String id, String idTransaction, User userSend, LocalDateTime dateTransaction, User userReceived, String value){
      var pix = new Pix(id, idTransaction,userSend,dateTransaction,userReceived,value);
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

   public User getUserReceived() {
      return userReceived;
   }

   public String getValue() {
      return value;
   }

}

