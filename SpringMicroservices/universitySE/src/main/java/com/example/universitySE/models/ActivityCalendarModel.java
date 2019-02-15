package com.example.universitySE.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class ActivityCalendarModel {

    @Getter @Setter
    private int id;

    @Getter @Setter
    private ActivityTypeCalendarModel name;
}
