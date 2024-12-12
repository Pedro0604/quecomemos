package ttps.quecomemos.dto;

import lombok.Data;

import java.time.DayOfWeek;

@Data
public class MenuDiarioRequest {
    private DayOfWeek dia;
    private long menuVegetarianoId;
    private long menuNoVegetarianoId;
}