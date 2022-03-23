package com.pagamento.pix.core.domain.service.pix;

import com.pagamento.pix.application.pix.save.PixRequest;
import com.pagamento.pix.core.domain.aggregates.pix.Pix;

import java.util.List;

public interface PixService {

    void create(PixRequest pix);
    Pix findById(String id);
    List<Pix> findAll();
}
