package com.smalldogg.objects.ch5;

import java.time.DayOfWeek;
import java.time.LocalTime;

public interface DiscountCondition {
    public boolean isSatisfiedBy(Screening screening);
}
