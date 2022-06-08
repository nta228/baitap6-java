package fpt.aptech.t2009m1helloworld.service;

import fpt.aptech.t2009m1helloworld.entity.Account;
import fpt.aptech.t2009m1helloworld.model.AccountModel;
import fpt.aptech.t2009m1helloworld.model.MySqlAccountModel;

public class AccountService {
    private AccountModel accountModel;

    public AccountService() {
        this.accountModel = new MySqlAccountModel();
    }

    public Account register(Account account) {
        String salt = SHA512Hasher.randomString(7);
        String passwordHash = SHA512Hasher.encode(account.getPassword(), salt);
        account.setPassword(passwordHash + "." + salt);
        accountModel.save(account);
        return account;
    }

    public Account login(String username, String password) {
        Account account = accountModel.findByUsername(username);
        if (account != null && SHA512Hasher.checkPassword(account.getPassword(), password)) {
            return account;
        }
        return null;
    }
}
