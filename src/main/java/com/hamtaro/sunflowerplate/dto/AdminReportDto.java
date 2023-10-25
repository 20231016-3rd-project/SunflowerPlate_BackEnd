package com.hamtaro.sunflowerplate.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminReportDto {

    private Long reviewId;

    private Long memberId;

    private String nickName;

    private String memberProfilePicture;

    private String reportCategory;

    private String reportContent;

    private LocalDate reportAt;


}
