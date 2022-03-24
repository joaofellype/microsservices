package com.pagamento.pix.core.command.pix.save;

import com.pagamento.pix.application.pix.save.PixRequest;
import com.pagamento.pix.application.users.save.UserRequest;
import com.pagamento.pix.core.domain.aggregates.pix.Pix;
import com.pagamento.pix.core.domain.aggregates.pix.PixRepository;
import com.pagamento.pix.core.domain.aggregates.users.User;
import com.pagamento.pix.core.domain.service.pix.PixService;
import com.pagamento.pix.core.domain.service.users.CreateUserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PixCommandHandler {

    private final PixService pixService;
    private final PixRepository pixRepository;
    private final CreateUserDomainService createUserDomainService;

    @Autowired
    public PixCommandHandler(PixService pixService, PixRepository pixRepository, CreateUserDomainService createUserDomainService) {
        this.pixService = pixService;
        this.pixRepository = pixRepository;
        this.createUserDomainService = createUserDomainService;

    }

    public void handle(PixRequest pixRequest) {

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
