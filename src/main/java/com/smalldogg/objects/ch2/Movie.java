package com.smalldogg.objects.ch2;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    /**상속을 통해, DiscountPolicy는 정률과 정액 할인기준이 있는데, Movie 클래스만 보면 둘중 어떤 것을 사용하는지까지 알 수 없다.
     * 대신, 확장성과 유연성이 확보되어있어, 정률 정액 할인기준 뿐만아니라 다른 정책이 신규로 들어오더라도 간편히 확장이 가능하고,
     * 또한 유연하게 정률 정액 할인기준을 선택할 수 있는 장점이 있다.
     */
    /**
     * Movie와 DiscountPolicy는 합성관계로 연결되어있다.
     */
    public Movie(String title, Duration runningTime, Money fee, DefaultDiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
