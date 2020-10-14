package com.example.Assignment.controller;

import com.example.Assignment.config.ResponseEnum;
import com.example.Assignment.config.ResponsePayload;
import com.example.Assignment.entity.User;
import com.example.Assignment.entity.ViewUser;
import com.example.Assignment.model.*;
import com.example.Assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user-service")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/create-user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload createUser(@RequestBody CreateUserRequestModel model) {

        try {


            User insertedEntity = userService.createUser(model);

            if (insertedEntity != null) {

                return new ResponsePayload(ResponseEnum.OK, insertedEntity);
            }
            return new ResponsePayload(ResponseEnum.NOTFOUND);


        } catch (DataIntegrityViolationException ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND);
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND);
        }


    }

    @PostMapping(value = "/update-user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload updateUser(@RequestBody UpdateUserRequestModel model) {

        try {


            User insertedEntity = userService.updateUser(model);

            if (insertedEntity != null) {

                return new ResponsePayload(ResponseEnum.OK, insertedEntity);
            }
            return new ResponsePayload(ResponseEnum.NOTFOUND);


        } catch (DataIntegrityViolationException ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND);
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND);
        }


    }

    @DeleteMapping(value = "/delete-user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload delete(@RequestBody DeleteUserRequestModel deleteUserRequestModel) {
        try {

            userService.deleteUser(deleteUserRequestModel);

            return new ResponsePayload(ResponseEnum.OK);
        } catch (DataIntegrityViolationException ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND);
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND);
        }
    }


    @PostMapping(value = "/list-user",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload listUser() {

        try {
            List<User> models = userService.listUser();

            if (models != null)
                return new ResponsePayload(ResponseEnum.OK, models);
            else
                return new ResponsePayload(ResponseEnum.NOTFOUND);
        } catch (DataIntegrityViolationException ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND);
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND);
        }
    }

    @PostMapping(value = "/view-user/{ViewerId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload viewUser(@RequestBody ViewUserRequestModel viewUserRequestModel, @PathVariable String ViewerId) {

        try {


            userService.viewUser(viewUserRequestModel, ViewerId);

            return new ResponsePayload(ResponseEnum.OK);


        } catch (DataIntegrityViolationException ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND);
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND);
        }


    }


    @PostMapping(value = "/who-viewed-me",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload whoViewedMe(@RequestBody ViewUserRequestModel viewUserRequestModel) {

        try {
            List<ViewUser> models = userService.whoViewedMe(viewUserRequestModel);


            if (models != null)
                return new ResponsePayload(ResponseEnum.OK, models);
            else
                return new ResponsePayload(ResponseEnum.NOTFOUND);
        } catch (DataIntegrityViolationException ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND);
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND);
        }
    }


}
