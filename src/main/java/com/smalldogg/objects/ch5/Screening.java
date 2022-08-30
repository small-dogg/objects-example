package com.smalldogg.objects.ch5;

import java.time.LocalDateTime;

//Screening은 예매에 대한 정보 전문가인 동시에 Reservation의 창조자이다.
public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Movie calculateFee(int audienceCount) {
        //movie.calculateMovieFee(this)를 통해, 느슨한 결합과 캡슐화를 달성할 수 있다.
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence() {
        return sequence;
    }
}
