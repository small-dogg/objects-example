package com.smalldogg.objects.movieo2o;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
