package com.pagamento.pix.controller.pix;

import com.pagamento.pix.application.pix.dto.PixDto;
import com.pagamento.pix.application.pix.save.PixRequest;
import com.pagamento.pix.controller.shared.BaseControllerImpl;
import com.pagamento.pix.controller.users.UserController;
import com.pagamento.pix.core.command.pix.save.PixCommandHandler;
import com.pagamento.pix.core.domain.service.pix.PixService;
import com.pagamento.pix.core.domain.shared.exception.DomainException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PixControllerImpl extends BaseControllerImpl<PixDto> implements PixController {
    @Autowired
    private PixService pixService;
    @Autowired
    private UserController userController;
    @Autowired
    private PixCommandHandler pixCommandHandler;


    @Override
    public ResponseEntity<Void> create(PixRequest pixRequest) {
        pixCommandHandler.handle(pixRequest);
        return created();
    }

    @Override
    public PixRequest findPixId(String id) {
        return null;
    }


}
