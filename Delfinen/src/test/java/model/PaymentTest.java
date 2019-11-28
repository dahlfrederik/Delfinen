/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author FrederikDahl
 */
public class PaymentTest {

    private Payment p;

    @Before
    public void setup() {
        p = new Payment();
    }

    @Test
    public void testPaymentPrice() {
        Member member = new Member("Frederik", 30366319,22, "Junior", true, true);
        double expResult = 1600;
        double result = p.paymentPrice(member);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPaymentPrice2() {
        Member member = new Member("Frederik", 30366319,17, "Junior", true, true);
        double expResult = 1000;
        double result = p.paymentPrice(member);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPaymentPrice3() {
        Member member = new Member("Frederik",30366319, 61, "Junior", true, true);
        double expResult = 1200;
        double result = p.paymentPrice(member);
        assertEquals(expResult, result, 0.0);
    }

    @Test
    public void testPaymentPrice4() {
        Member member = new Member("Frederik", 30366319, 61, "Junior", true, false);
        double expResult = 500;
        double result = p.paymentPrice(member);
        assertEquals(expResult, result, 0.0);
    }

}
