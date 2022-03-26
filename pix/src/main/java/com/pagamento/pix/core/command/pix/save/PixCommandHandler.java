package com.pagamento.pix.core.command.pix.save;

import com.pagamento.pix.application.pix.save.PixRequest;
import com.pagamento.pix.application.users.save.UserRequest;
import com.pagamento.pix.controller.users.UserController;
import com.pagamento.pix.core.domain.aggregates.pix.Pix;
import com.pagamento.pix.core.domain.aggregates.pix.PixRepository;
import com.pagamento.pix.core.domain.aggregates.users.User;
import com.pagamento.pix.core.domain.service.pix.PixService;
import com.pagamento.pix.core.domain.service.users.CreateUserDomainService;
import com.pagamento.pix.core.domain.shared.exception.NotFoundException;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class PixCommandHandler {

    private final PixService pixService;
    private final PixRepository pixRepository;
    private final CreateUserDomainService createUserDomainService;
    @Autowired
    private UserController userController;

    @Autowired
    public PixCommandHandler(PixService pixService, PixRepository pixRepository, CreateUserDomainService createUserDomainService) {
        this.pixService = pixService;
        this.pixRepository = pixRepository;
        this.createUserDomainService = createUserDomainService;

    }

    public void handle(PixRequest pixRequest) {

        try{
            var userReceived = userController.findById(pixRequest.getIdUserReceived());
            var userSend = userController.findById(pixRequest.getIdUserSend());
            System.out.println(userReceived.getStatusCode());
            if (userReceived.getStatusCode() == HttpStatus.NOT_FOUND || userSend.getStatusCode() == HttpStatus.NOT_FOUND)
                System.out.println(userReceived.getStatusCode());
                throw  new NotFoundException("Users not found");

        }catch (Exception e){

            System.out.println(e.getMessage());
            if(e.getMessage().contains("NOT_FOUND")){
                throw new NotFoundException("Users not Found");
            }
        }


       // pixRequest.setUserSend(userSend.getBody());
       // pixRequest.setUserReceived(userReceived.getBody());
        var pix = pixService.execute(pixRequest.getId(), pixRequest.getIdTransaction(), pixRequest.getDateTransaction(), pixRequest.getValue());
        pix.setUserReceived(setUserReceived( pixRequest.getUserReceived()));
        pix.setUserSend(setUserSend(pixRequest.getUserReceived()));

        pixRepository.save(pix);
    }

    private User setUserReceived( UserRequest userRequest) {
        return createUserDomainService.create(userRequest.getId(), userRequest.getName(), userRequest.getCpf());
    }

    private User setUserSend(UserRequest userRequest) {

           return createUserDomainService.create(userRequest.getId(), userRequest.getName(), userRequest.getCpf());
    }
}
