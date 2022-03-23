package com.pagamento.pix.core.domain.service.pix;

import com.pagamento.pix.PixApplication;
import com.pagamento.pix.application.pix.save.PixRequest;
import com.pagamento.pix.core.domain.aggregates.pix.Pix;
import com.pagamento.pix.core.domain.aggregates.pix.PixRepository;
import com.pagamento.pix.core.domain.aggregates.users.User;
import com.pagamento.pix.core.domain.shared.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PixServiceImpl implements PixService{

    private PixRepository pixRepository;
    @Autowired
    RestTemplate client = new RestTemplate();

    public PixServiceImpl(PixRepository pixRepository){
        this.pixRepository = pixRepository;
    }
    @Override
    public void create(PixRequest pixRequest) {

        User users = client.getForObject("http://user/{id}", User.class,"123");
        System.out.println(users.getName());
        var pix = Pix.create(pixRequest.getId(),pixRequest.getIdTransaction(),
                User.create(pixRequest.getUserSend().getId(),pixRequest.getUserSend().getName(),pixRequest.getUserSend().getCpf()),
                pixRequest.getDateTransaction(),
                User.create(pixRequest.getUserSend().getId(),pixRequest.getUserSend().getName(),pixRequest.getUserSend().getCpf()),
                pixRequest.getValue());

        pixRepository.save(pix);
    }

    @Override
    public Pix findById(String id) {
        var pix = pixRepository.findById(id);
        if(pix == null)
            throw new NotFoundException("Pix not found");
        return pix;
    }

    @Override
    public List<Pix> findAll() {

        var pix = pixRepository.findAll();
        if(pix.isEmpty())
            throw new NotFoundException("Pix not found");
        return pix;
    }
}
