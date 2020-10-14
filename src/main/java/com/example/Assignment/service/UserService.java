package com.example.Assignment.service;

import com.example.Assignment.entity.User;
import com.example.Assignment.entity.ViewUser;
import com.example.Assignment.model.CreateUserRequestModel;
import com.example.Assignment.model.DeleteUserRequestModel;
import com.example.Assignment.model.UpdateUserRequestModel;
import com.example.Assignment.model.ViewUserRequestModel;
import java.util.List;

public interface UserService {

     User createUser(CreateUserRequestModel createUserRequestModel);

    User updateUser(UpdateUserRequestModel updateUserRequestModel);

    void deleteUser(DeleteUserRequestModel deleteUserRequestModel);

    List<User> listUser();

    void viewUser(ViewUserRequestModel viewUserRequestModel,String ViewerId);

    List<ViewUser> whoViewedMe(ViewUserRequestModel viewUserRequestModel);

}
