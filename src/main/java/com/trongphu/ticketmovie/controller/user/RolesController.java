package com.trongphu.ticketmovie.controller.user;

import com.trongphu.ticketmovie.dto.request.RolesDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
/**
 *
 * @author Trong Phu
 */
@RestController
@RequestMapping("api/v1/roles")
public class RolesController {
    @GetMapping("")
    public ResponseEntity<String> getAllRoles(){
        return ResponseEntity.ok("Chào bạn haha");
    }

    @PostMapping("")
    public ResponseEntity<?> isertRoles(@Valid @RequestBody RolesDTO rolesDTO, BindingResult result){
        if(result.hasErrors()){
            List<String> errorMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
            return ResponseEntity.badRequest().body(errorMessage);
        }
        System.out.println(new Date());
        return ResponseEntity.ok("This is isert roles " + rolesDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateRoles(@PathVariable("id") long id){
        return ResponseEntity.ok("Update roles with id = " + id);
    }
}
