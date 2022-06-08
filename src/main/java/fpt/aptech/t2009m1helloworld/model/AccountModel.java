package fpt.aptech.t2009m1helloworld.model;

import fpt.aptech.t2009m1helloworld.entity.Account;
import fpt.aptech.t2009m1helloworld.entity.User;

import java.util.List;

public interface AccountModel {
    boolean save(Account obj);
    boolean update(int id, Account updateObj);
    boolean delete(int id);
    List<Account> findAll();
    Account findById(int id);
    Account findByUsername(String username);
}
