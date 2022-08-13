package com.smalldogg.objects.movieo2o;

public class NoneDiscountPolicy extends DefaultDiscountPolicy {


    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
