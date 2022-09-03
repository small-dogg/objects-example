package com.smalldogg.objects.ch5;

import java.time.Duration;
import java.util.List;

public abstract class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions; //협력하지 않고, 할인정책이 리스트로 직접받아옴

    public Movie(String title, Duration runningTime, Money fee, List<DiscountCondition> discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditions = discountConditions;
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    public boolean isDiscountable(Screening screening) {
        return discountConditions.stream().anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    abstract protected Money calculateDiscountAmount();

    //이 메서드는 서브클래스에서만 사용해야 하므로 가시성을 public이 아닌 protected로 제한해야 한다.
    protected Money getFee() {
        return fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }
}