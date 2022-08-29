package com.smalldogg.objects.ch2;

public class NoneDiscountPolicy extends DefaultDiscountPolicy {


    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
