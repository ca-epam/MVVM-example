package com.example.adrian.mymvvmexample.jpuser.utils;

import com.example.adrian.mymvvmexample.jpuser.viewmodel.UserViewModel;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Address;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Company;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.Geo;
import com.example.adrian.mymvvmexample.jsonplaceholder.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrian_Czigany on 3/16/2017.
 */

public class UsersTestData {

    public static List<User> get() {
        Geo geo = new Geo();
        geo.setLat("lat");
        geo.setLng("lng");
        Address address = new Address();
        address.setCity("city");
        address.setGeo(geo);
        address.setStreet("street");
        address.setSuite("suite");
        address.setZipcode("zipcode");
        Company company = new Company();
        company.setBs("bs");
        company.setCatchPhrase("catchPhrase");
        company.setName("companyname");
        User user = new User();
        user.setAddress(address);
        user.setCompany(company);
        user.setName("user name");
        user.setEmail("email");
        user.setId(1);
        user.setPhone("phone");
        user.setUsername("username");
        user.setWebsite("website");
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user);
        return list;
    }

    public static List<UserViewModel> getUserViewModelData() {
        Geo geo = new Geo();
        geo.setLat("lat");
        geo.setLng("lng");
        Address address = new Address();
        address.setCity("city");
        address.setGeo(geo);
        address.setStreet("street");
        address.setSuite("suite");
        address.setZipcode("zipcode");
        Company company = new Company();
        company.setBs("bs");
        company.setCatchPhrase("catchPhrase");
        company.setName("companyname");
        User user1 = new User();
        user1.setAddress(address);
        user1.setCompany(company);
        user1.setName("user name1");
        user1.setEmail("email1");
        user1.setId(1);
        user1.setPhone("phone1");
        user1.setUsername("username1");
        user1.setWebsite("website1");

        User user2 = new User();
        user2.setAddress(address);
        user2.setCompany(company);
        user2.setName("user name2");
        user2.setEmail("email2");
        user2.setId(1);
        user2.setPhone("phone2");
        user2.setUsername("username2");
        user2.setWebsite("website2");

        List<UserViewModel> list = new ArrayList<>();
        UserViewModel userViewModel1 = new UserViewModel();
        userViewModel1.user = user1;
        UserViewModel userViewModel2 = new UserViewModel();
        userViewModel2.user = user2;
        list.add(userViewModel1);
        list.add(userViewModel2);
        return list;
    }
}
