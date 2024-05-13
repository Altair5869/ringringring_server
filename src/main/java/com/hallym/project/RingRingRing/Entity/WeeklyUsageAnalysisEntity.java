package com.hallym.project.RingRingRing.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.GenericGenerator;

import com.hallym.project.RingRingRing.DTO.WeeklyUsageDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weeklyUsage")
public class WeeklyUsageAnalysisEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    @Column(name="weeklyUsage_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private int timestamp;

    private Long duration;

    private LocalDateTime week;

    public WeeklyUsageDTO toDTO() {
        return WeeklyUsageDTO.builder()
                .timestamp(timestamp)
                .duration(duration)
                .week(LocalDateTime.now())
                .build();

    }


}
