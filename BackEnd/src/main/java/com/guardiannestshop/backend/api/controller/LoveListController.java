package com.guardiannestshop.backend.api.controller;

import com.guardiannestshop.backend.api.output.*;
import com.guardiannestshop.backend.dto.*;
import com.guardiannestshop.backend.service.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/love-list/api")
public class LoveListController {
    @Autowired
    private final LoveListService loveListService;

    public LoveListController(LoveListService loveListService) {
        this.loveListService = loveListService;
    }
    @GetMapping("/admin/love-list/all")
    public LoveListoutput getAll(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        LoveListoutput result = new LoveListoutput();
        result.setPage(page);
        Pageable pageable =  PageRequest.of(page - 1, limit);
        result.setListResult(loveListService.getAll(pageable));
        result.setTotalPage((int) Math.ceil((double) (loveListService.totalItem()) / limit));
        model.addAttribute("LoveListoutput", result);
        return result;
    }
    @GetMapping("/admin/love-list-by-lovelistid/{lovelistid}")
    public ResponseEntity<?> getByUserId(@PathVariable Long lovelistid) {
        try {
            LoveListDTO loveListDTO = loveListService.getByLovelistid(lovelistid);

            return new ResponseEntity<>(loveListDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<UserDTO>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/admin/Love-list-by-userid/{userid}")
    public LoveListoutput getByUserid(@PathVariable String userid,@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        LoveListoutput result = new LoveListoutput();
        result.setPage(page);
        Pageable pageable =  PageRequest.of(page - 1, limit);
        result.setListResult(loveListService.getByUserid(userid,pageable));
        result.setTotalPage((int) Math.ceil((double) (loveListService.totalItem()) / limit));
        model.addAttribute("LoveListoutput", result);
        return result;
    }

    @GetMapping("/admin/Love-list-by-lovelistname/{lovelistname}")
    public LoveListoutput getByLovelistname(@PathVariable String lovelistname,@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        LoveListoutput result = new LoveListoutput();
        result.setPage(page);
        Pageable pageable =  PageRequest.of(page - 1, limit);
        result.setListResult(loveListService.getByLovelistname(lovelistname,pageable));
        result.setTotalPage((int) Math.ceil((double) (loveListService.totalItem()) / limit));
        model.addAttribute("LoveListoutput", result);
        return result;
    }

    @PostMapping("/admin/create-love-list")
    public ResponseEntity<String> createLoveList(@RequestBody LoveListDTO loveListDTO) {
        try {
            loveListService.createLoveList(loveListDTO);
            return new ResponseEntity<>("more success ", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/admin/update-love-list/{lovelistid}")
    public ResponseEntity<String> updateLoveList(@PathVariable Long lovelistid, @RequestBody LoveListDTO loveListDTO) {
        try {
            loveListDTO.setLovelistid(lovelistid);
            loveListService.updateLoveList(loveListDTO);
            return new ResponseEntity<>(loveListDTO+"Cập nhật quyền người dùng thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    // xóa dữ liệu
    @Transactional
    @DeleteMapping("/admin/delete-love-list/{lovelistid}")
    public ResponseEntity<String> deleteUserAccount(@PathVariable Long lovelistid) {
        try {
            loveListService.deleteByLovelistid(lovelistid);
            return new ResponseEntity<>("Xóa Ảnh thành công", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}


