package fpt.aptech.t2009m1helloworld.entity;

import fpt.aptech.t2009m1helloworld.entity.base.BaseEntity;
import fpt.aptech.t2009m1helloworld.entity.myenum.AccountStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    @BeforeEach
    void setUp() {
        System.out.println("Start running test.");
    }

    @Test
    public void testCreateAccount(){
        Account account = new Account();
        account.setStatus(AccountStatus.ACTIVE);
        System.out.println(account.toString());
    }
}