package com.guardiannestshop.backend.api.controller;

import com.guardiannestshop.backend.api.output.*;
import com.guardiannestshop.backend.dto.*;
import com.guardiannestshop.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/ship/api")
public class ShipController {
    @Autowired
    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }
    @GetMapping("/oder/ship/list")
    public ShipOutPut getByOrderstatus(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        ShipOutPut result = new ShipOutPut();
        result.setPage(page);
        Pageable pageable =  PageRequest.of(page - 1, limit);
        result.setListResult(shipService.getAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (shipService.totalItem()) / limit));
        model.addAttribute("userAccountOutput", result);
        return result;
    }
    @GetMapping("/admin/ship-by-id/{shipid}")
    public ResponseEntity<?> getByUserId(@PathVariable Long shipid) {
        try {
            ShipDTO shipDTO = shipService.getByShipid(shipid);

            return new ResponseEntity<>(shipDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
