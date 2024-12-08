package ttps.quecomemos.dto;

import lombok.Data;

import java.util.List;

@Data
public class MenuRequest {
    private String nombre;
    private double precio;
    private boolean vegetariano;
    private List<Long> comidaIds;
}