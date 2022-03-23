package com.pagamento.pix.controller.pix;

import com.netflix.discovery.EurekaClient;
import com.pagamento.pix.application.pix.save.PixRequest;
import com.pagamento.pix.controller.users.UserController;
import com.pagamento.pix.core.domain.service.pix.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PixControllerImpl implements PixController {
    @Autowired
    private PixService pixService;
    @Autowired
    private UserController userController;

    @Override
    public void create(PixRequest pixRequest) {
        var user = userController.findById("123");

        System.out.println("O NOME DO USUARIO E "+user.getName());
        pixService.create(pixRequest);
    }

    @Override
    public PixRequest findPixId(String id) {
        return null;
    }


}
