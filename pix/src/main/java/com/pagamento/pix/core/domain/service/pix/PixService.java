package com.pagamento.pix.core.domain.service.pix;

import com.pagamento.pix.core.domain.aggregates.pix.Pix;

import java.time.LocalDateTime;
import java.util.List;

public interface PixService {

    Pix execute(String id, String idTransaction, LocalDateTime dateTransaction, String value);

    Pix findById(String id);

    List<Pix> findAll();
}
