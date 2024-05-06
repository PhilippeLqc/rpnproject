package com.elazur.rpn.web.rest;

import com.elazur.rpn.model.Expression;
import com.elazur.rpn.service.RpnService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rpn")
@CrossOrigin(origins = "http://localhost:4200")
public class RpnResource {

    private final RpnService rpnService;
    public RpnResource(RpnService rpnService) {
        this.rpnService = rpnService;
    }

    @PostMapping("/tranform-to-rpn")
    public ResponseEntity<String> transformToRpn(@RequestBody Expression expressionToTransform) {
        String result = rpnService.transformToRpn(expressionToTransform.getExpression());
        return ResponseEntity.ok().body(result);
    }
}