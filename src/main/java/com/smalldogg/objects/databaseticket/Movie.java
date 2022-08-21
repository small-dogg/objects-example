package com.smalldogg.objects.databaseticket;

import java.time.Duration;
import java.util.List;

/**
 * 이 클래스는 캡슐화를 잘 지킨 것 처럼 보여지지만, 데이터 중심의 설계로 인해, 퍼블릭 인터페이스 만으로 어떠한 정보를 가지고 있는지
 * 노골적으로 나타나고 있다. 뿐만 아니라, 이러한 캡슐화를 위반하는 과도한 접근자와 수정자를 가지고 있다.
 * 앨런 홀럽은 이처럼 접근자와 수정자에 과도하게 의존하는 설계 방식을 추측에 의한 설계 전략이라고 부른다.
 * 객체가 다양한 상황에 사용될 수 있을 것이라는 막연한 추측을 기반으로 설계를 진행했다는 것이다.
 *
 * 퍼블릭 인터페이스에 내부 구현이 노출 -> 캡슐화의 원칙을 위반 및 변경에 취약 -> 추측에 의한 설계 전략
 */
public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions; //협력하지 않고, 할인정책이 리스트로 직접받아옴

    private MovieType movieType;

    //두 값은 할인 조건에 따라 둘중 하나만 사용됨
    private Money discountAmount;
    private double discountPercent;

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public Money getFee() {
        return fee;
    }

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }

    public void setDiscountConditions(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
}
