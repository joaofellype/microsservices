package com.pagamento.pix.controller.pix;

import com.pagamento.pix.application.pix.save.PixRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PixController {

    @PostMapping("/pix")
    void create(@RequestBody PixRequest pixRequest);

    @GetMapping("/pix/{id}")
    PixRequest findPixId(@PathVariable String id);

}
