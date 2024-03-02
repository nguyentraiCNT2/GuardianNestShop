package com.guardiannestshop.backend.service.impl;

import com.guardiannestshop.backend.Mapper.Opject.*;
import com.guardiannestshop.backend.dto.*;
import com.guardiannestshop.backend.entity.*;
import com.guardiannestshop.backend.repository.*;
import com.guardiannestshop.backend.service.*;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class securityIMPL implements SecurityService {
    @Autowired
    private final UserRepository userRepository;
    private RoleRepository roleRepository;
    private ModelMapper modelMapper;
    private SecurityRepository securityRepository;

    public securityIMPL(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper, SecurityRepository securityRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
        this.securityRepository = securityRepository;
    }


    @Override
    public UserDTO signinAdmin(String username, String password) {
        List<UserEntity> userEntityList = securityRepository.findByUsername(username);

        if (userEntityList.size() == 0){
            throw new RuntimeException("tai khoan nay  khong ton tai");
        }
        for (UserEntity item:userEntityList
        ) {
            if (item.getPassword().equals(password)){
               if (item.getRoleid().getRolename().equals("admin")){
                    UserDTO userDTO = modelMapper.map(item,UserDTO.class);
                    return  userDTO;
                }else {
                   throw new RuntimeException("tai khoan nay khong ton tai");
               }
            }
        }

        throw new RuntimeException("Mật khẩu không đúng");
    }

    @Override
    public UserDTO signinUser(String username, String password) {
        List<UserEntity> userEntityList = securityRepository.findByUsername(username);

        if (userEntityList.size() == 0){
            throw new RuntimeException("tai khoan nay  khong ton tai");
        }
        for (UserEntity item:userEntityList
        ) {
            if (item.getPassword().equals(password)){
                if (item.getRoleid().getRolename().equals("user")){
                    UserDTO userDTO = modelMapper.map(item,UserDTO.class);
                    return  userDTO;
                }else {
                    throw new RuntimeException("tai khoan nay khong ton tai");
                }
            }
        }

        throw new RuntimeException("Mật khẩu không đúng");
    }

    @Override
    public void signup(UserDTO userDTO) {
        if ( userDTO != null) {
            List<UserEntity> userEntityList = securityRepository.findByUsername(userDTO.getUsername());
            Map<String, Object> response = new HashMap<>();
            if (userEntityList.size() != 0){
                throw new RuntimeException("tai khoan nay da ton tai");
            }
            if (userDTO.getPassword().length() < 6){
                throw new RuntimeException("may khau toi thieu la 6 ki tu");
            }else
            if (userDTO.getPassword().length() > 20){
                throw new RuntimeException("may khau toi da la 20 ki tu");
            }else  if (userDTO.getPassword().contains(" ")){
                throw new RuntimeException("may khau khong the chua ky tu trang");
            }else  if (userDTO.getPassword().equals(userDTO.getUsername())){
                throw new RuntimeException("may khau khong the chua ten dang nhap");
            }
                UserEntity user = modelMapper.map(userDTO,UserEntity.class);
                RoleEntity roleEntity = roleRepository.findByRoleid(userDTO.getRoleid()).orElse(null);
                if (user != null) {
                    user.setRoleid(roleEntity);
                    userRepository.save(user);
                } else {
                    throw new RuntimeException("Không lấy được dữ liệu của Entity");
                }

        }
    }

    @Override
    public UserDTO profile(String userid) {
        try {
            UserEntity user = userRepository.findByUserid(userid)
                    .orElseThrow(() -> new EntityNotFoundException("Data not found with ID: " + userid));
            return modelMapper.map(user,UserDTO.class);
        } catch (EntityNotFoundException ex) {
            throw ex;
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching data by ID", e);
        }
    }
}
