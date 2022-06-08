package fpt.aptech.t2009m1helloworld.model;

import fpt.aptech.t2009m1helloworld.entity.Account;
import fpt.aptech.t2009m1helloworld.entity.myenum.AccountStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlAccountModelTest {

    private AccountModel model;

    @BeforeEach
    void setUp() {
        model = new MySqlAccountModel();
    }

    @Test
    void save() {
        Account account = new Account();
        account.setUsername("hung01");
        account.setPassword("eyzxcv");
        account.setFullName("Hung");
        account.setStatus(AccountStatus.ACTIVE);
        model.save(account);
    }

    @Test
    void findAll() {
        List<Account> list = model.findAll();
        for (Account ac :
                list) {
            System.out.println(ac.toString());
        }
    }
}