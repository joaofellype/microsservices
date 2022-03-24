package com.pagamento.pix.core.domain.service.pix;

import com.pagamento.pix.core.domain.aggregates.pix.Pix;
import com.pagamento.pix.core.domain.aggregates.pix.PixRepository;
import com.pagamento.pix.core.domain.shared.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PixServiceImpl implements PixService {

    private PixRepository pixRepository;

    public PixServiceImpl(PixRepository pixRepository) {
        this.pixRepository = pixRepository;
    }

    @Override
    public Pix execute(String id, String idTransaction, LocalDateTime dateTransaction, String value) {

        var pix = pixRepository.findById(id);
        if (pix == null)
            return Pix.create(id, idTransaction, dateTransaction, value);
        return pix;
    }

    @Override
    public Pix findById(String id) {
        var pix = pixRepository.findById(id);
        if (pix == null)
            throw new NotFoundException("Pix not found");
        return pix;
    }

    @Override
    public List<Pix> findAll() {

        var pix = pixRepository.findAll();
        if (pix.isEmpty())
            throw new NotFoundException("Pix not found");
        return pix;
    }
}
