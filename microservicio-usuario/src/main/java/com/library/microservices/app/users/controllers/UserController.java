package com.library.microservices.app.users.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
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
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/usuarios")
public class UserController extends CommonController<User, UserService>{

    //Inyectar un valor de la variable de entorno
    @Value("${config.balanceador.test}")
    private String balanceadorTest;
    
    @GetMapping("sort")
    public void getMethodName() {
    	LinkedHashSet lhs = new LinkedHashSet();
    	lhs.add(3);
    	lhs.add(4);
    	lhs.add(3);
    	lhs.add(5);
    	lhs.add(4);
    	lhs.add(6);
    	lhs.remove(4);
    	
    	Iterator itr = lhs.iterator();
    	while (itr.hasNext()) {
    		System.out.println(itr.next() + " ");
    	}
    }
    


    @PutMapping("/id")
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
