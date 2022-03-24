package com.pagamento.pix.core.domain.aggregates.pix;

import java.util.List;

public interface PixRepository {
    void save(Pix pix);

    Pix findById(String id);

    List<Pix> findAll();
}
