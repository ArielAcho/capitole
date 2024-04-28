package ar.com.capitole.domain.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class DateRange {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
