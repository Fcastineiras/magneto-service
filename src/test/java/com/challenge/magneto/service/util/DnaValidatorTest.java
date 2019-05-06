package com.challenge.magneto.service.util;

import com.challenge.magneto.service.mocks.DnaDtoMocks;
import com.challenge.magneto.service.exception.InvalidDnaException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Fiamma on 2/5/2019.
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DnaValidatorTest {

    @Test
    public void validateValidDna() {
        DnaValidator.isValid(DnaDtoMocks.getValidDna());
    }

    @Test(expected = InvalidDnaException.class)
    public void validateInvalidCharsDna() {
        DnaValidator.isValid(DnaDtoMocks.getInvalidCharDna());
    }

    @Test(expected = InvalidDnaException.class)
    public void validateInvalidFormatDna() {
        DnaValidator.isValid(DnaDtoMocks.getInvalidFormatDna());
    }


}
