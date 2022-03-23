package com.pagamento.pix.controller.users;

import com.pagamento.pix.application.users.save.UserRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user")
public interface UserController {
    @GetMapping("/{id}")
    public UserRequest findById(@PathVariable String id);
}
