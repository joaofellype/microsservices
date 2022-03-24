package com.pagamento.pix.controller.pix;

import com.pagamento.pix.application.pix.save.PixRequest;
import com.pagamento.pix.controller.users.UserController;
import com.pagamento.pix.core.command.pix.save.PixCommandHandler;
import com.pagamento.pix.core.domain.service.pix.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PixControllerImpl implements PixController {
    @Autowired
    private PixService pixService;
    @Autowired
    private UserController userController;
    @Autowired
    private PixCommandHandler pixCommandHandler;


    @Override
    public ResponseEntity<Void> create(PixRequest pixRequest) {
        var userReceived = userController.findById(pixRequest.getIdUserReceived());
        var userSend = userController.findById(pixRequest.getIdUserSend());
        if (userReceived == null || userSend == null)
            return ResponseEntity.badRequest().build();

        pixRequest.setUserSend(userSend);
        pixRequest.setUserReceived(userReceived);
        pixCommandHandler.handle(pixRequest);
        return ResponseEntity.ok().build();
    }

    @Override
    public PixRequest findPixId(String id) {
        return null;
    }


}
