package dev.pos4.pos;

import java.time.LocalDate;
import java.time.LocalDateTime;
public class clockIO {
    LocalDateTime clockIn = null;
    LocalDateTime clockOut = null;
    employee employee;

    public clockIO(LocalDateTime clockInTime, employee employee){
        this.clockIn = clockInTime;
        this.employee = employee;
    }

    public void setClockout(LocalDateTime clockOut){
        this.clockOut = clockOut;
        
    }
}
