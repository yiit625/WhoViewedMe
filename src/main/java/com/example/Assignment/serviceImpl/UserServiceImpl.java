package com.example.Assignment.serviceImpl;

import com.example.Assignment.entity.User;
import com.example.Assignment.entity.ViewUser;
import com.example.Assignment.enums.EnumStatus;
import com.example.Assignment.model.*;
import com.example.Assignment.repository.UserRepository;
import com.example.Assignment.repository.ViewUserRepository;
import com.example.Assignment.service.UserService;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.jsp.tagext.ValidationMessage;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ViewUserRepository viewUserRepository;

    @Override
    public User createUser(CreateUserRequestModel createUserRequestModel) {
        User user = new User();
        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        user.setUserName(createUserRequestModel.getUserName());
        user.setUserSurname(createUserRequestModel.getUserSurname());
        user.setStatus(EnumStatus.ACTIVE);
        user.setCreatedDate(cal.getTime());

        userRepository.save(user);
       return user;

    }

    @Override
    public User updateUser(UpdateUserRequestModel updateUserRequestModel) {

        User user = userRepository.findById(updateUserRequestModel.getId()).orElseThrow(EntityNotFoundException::new);
        user.setUserName(updateUserRequestModel.getUserName());
        user.setUserSurname(updateUserRequestModel.getUserSurname());
        user.setStatus(EnumStatus.get(updateUserRequestModel.getStatus()));
        userRepository.save(user);

        return user;
    }

    @Override
    public void deleteUser(DeleteUserRequestModel deleteUserRequestModel) {
        User user = userRepository.findById(deleteUserRequestModel.getId()).orElseThrow(EntityNotFoundException::new);
        user.setDeleted(true);
    }

    @Override
    public List<User> listUser() {

        List<User> list = new ArrayList<>();
        userRepository.userList().iterator().forEachRemaining(list::add);


        return list;
    }

    @Override
    public void viewUser(ViewUserRequestModel viewUserRequestModel,String ViewerId) {

        ViewUser viewUser = new ViewUser();

        User user = userRepository.findById(ViewerId).orElseThrow(EntityNotFoundException::new);
        viewUser.setViewerUser(user);

        User user1 = userRepository.findById(viewUserRequestModel.getId()).orElseThrow(EntityNotFoundException::new);
        viewUser.setViewedUser(user1);

        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        viewUser.setViewedDate(cal.getTime());

        viewUserRepository.save(viewUser);
    }

    @Override
    public List<ViewUser> whoViewedMe(ViewUserRequestModel viewUserRequestModel) {

        List<ViewUser> list = viewUserRepository.viewedUserList(viewUserRequestModel.getId());
        List<ViewUser> validatedList = new ArrayList<>();

        Date today = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(today);
        cal.add(Calendar.DAY_OF_MONTH, -30);
        Date today30 = cal.getTime();

        int listSize = list.size();

        for (int i=0 ; i < 20  ; i++) {

            if(listSize > i ) {
                if (list.get(i).getViewedDate().after(today30)) {

                    validatedList.add(list.get(i));
                }
            }
            else break;

        }
        return validatedList;
    }


}
