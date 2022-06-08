package fpt.aptech.t2009m1helloworld.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringValidationHelperTest {

    @Test
    void checkValidVietnamesePhone() {
        System.out.println(StringValidationHelper.checkValidVietnamesePhone("0399388831JQK"));
    }
}