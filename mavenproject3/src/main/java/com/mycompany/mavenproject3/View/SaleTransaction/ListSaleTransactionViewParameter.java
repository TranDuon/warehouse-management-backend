/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.ControllerAndView.MotLuotBan;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 *
 * @author azoom
 */
public class ListMotLuotBanViewParameter {
    private LocalDateTime dateTimeFrom;
    private LocalDateTime dateTimeTo;

    public ListMotLuotBanViewParameter(LocalDateTime dateTimeFrom, LocalDateTime dateTimeTo) {
        this.dateTimeFrom = dateTimeFrom;
        this.dateTimeTo = dateTimeTo;
    }

    public LocalDateTime getDateTimeFrom() {
        return dateTimeFrom;
    }

    public LocalDateTime getDateTimeTo() {
        return dateTimeTo;
    }

    public Timestamp getDateTimeFrom_Timestamp() {
        return Timestamp.valueOf(dateTimeFrom);
    }

    public Timestamp getDateTimeTo_Timestamp() {
        return Timestamp.valueOf(dateTimeTo);
    }
    

}
