package com.library.microservices.app.users.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.microservices.app.commons.controllers.CommonController;
import com.library.microservices.app.commonusuarios.entity.User;
import com.library.microservices.app.users.services.UserService;

@RestController
@RequestMapping("/api/usuarios")
public class UserController extends CommonController<User, UserService>{

    //Inyectar un valor de la variable de entorno
    @Value("${config.balanceador.test}")
    private String balanceadorTest;

    @PutMapping("/{id}")
    public ResponseEntity<?> edit(@RequestBody User user, @PathVariable Long id) {
        Optional<User> userOp = service.findById(id);

        if (!userOp.isPresent())
            return ResponseEntity.notFound().build();

        User userDB = userOp.get();
        userDB.setName(user.getName());
        userDB.setLastName(user.getLastName());
        userDB.setEmail(user.getEmail());

        return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(userDB));
    }


	@GetMapping("/balanceador-test")
	public ResponseEntity<?> balanceadorTest() {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("balanceadorTest", balanceadorTest);
		response.put("usuarios", service.findAll());
		return ResponseEntity.ok(response);
	}
    
    
}
