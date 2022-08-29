package com.smalldogg.objects.ch2;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
