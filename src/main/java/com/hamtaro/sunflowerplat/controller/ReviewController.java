package com.hamtaro.sunflowerplat.controller;

import com.hamtaro.sunflowerplat.dto.ReportDto;
import com.hamtaro.sunflowerplat.dto.EmpathyDto;
import com.hamtaro.sunflowerplat.dto.RequestDto;
import com.hamtaro.sunflowerplat.service.EmpathyService;
import com.hamtaro.sunflowerplat.service.ReviewService;
import com.hamtaro.sunflowerplat.dto.ReviewDto;
import com.hamtaro.sunflowerplat.dto.ReviewSaveDto;
import com.hamtaro.sunflowerplat.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Log4j2
@RestController
@RequestMapping("sunflowerPlate/user")
@RequiredArgsConstructor
public class ReviewController {


    private final ReviewService reviewService;

    private final EmpathyService empathyService;

    //유저 리뷰 삭제
    //리뷰 삭제
    @DeleteMapping("/review/{reviewId}")
    public ResponseEntity<Map<String,String>> deleteReview(@PathVariable Long reviewId){

        return reviewService.reviewDelete(reviewId);
    }

    //리뷰 수정
    //유저 레스토랑 정보 신고 및 수정
    @PostMapping("/restaurant/edit/{requestId}")
    public ResponseEntity<Map<String,String>> requestRestaurant(@PathVariable Long requestId ,
                                                                @RequestBody RequestDto requestDto){

        return reviewService.requestRestaurant(requestDto,requestId);
    }


    //리뷰 작성 후 저장
    @PostMapping("/review/new")
    public ResponseEntity<?> createReview(@RequestPart("reviewSaveDto") ReviewSaveDto reviewSaveDto,
                                          @RequestPart("imageFile") List<MultipartFile> imageFile,
                                          @RequestParam Long restaurantId){
        return reviewService.saveUserReview(reviewSaveDto,imageFile, restaurantId);
    }

    //리뷰 신고하기
    @PostMapping("/report")
    public ResponseEntity<?> alertReview(@RequestBody ReportDto reportDto, @RequestParam Long reviewId){
        return reviewService.reportReview(reportDto, reviewId);
    }

    //좋아요기능
    @PostMapping("/like")
    public ResponseEntity<?> likeButton(@RequestBody @Validated EmpathyDto empathyDto) throws Exception {

        return empathyService.countPlus(empathyDto);
    }
}