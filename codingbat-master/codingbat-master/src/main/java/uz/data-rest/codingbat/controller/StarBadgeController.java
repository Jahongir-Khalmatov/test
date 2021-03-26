package uz.raximov.codingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.raximov.codingbat.entity.StarBadge;
import uz.raximov.codingbat.payload.ApiResponse;
import uz.raximov.codingbat.payload.StarBadgeDto;
import uz.raximov.codingbat.service.StarBadgeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/starbadge")
public class StarBadgeController {

    @Autowired
    StarBadgeService starBadgeService;

    /**
     * BARCHA STARBADGE RO'YXATI QAYTARILADI
     * @return List<ApiResponse>
     */
    @GetMapping
    public HttpEntity<?> getAll(){
        List<StarBadge> starBadges = starBadgeService.getAll();
        return ResponseEntity.status(starBadges.size() != 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(starBadges);
    }

    /**
     * STARBADGENI ID BO'YICHA QAYTARADI, ID TOPILMASA NULL QAYTARADI
     * @param id
     * @return Task
     */
    @GetMapping("/{id}")
    public HttpEntity<?> getById(@PathVariable Integer id){
        ApiResponse byId = starBadgeService.getById(id);
        return ResponseEntity.status(byId.isSuccess() ? HttpStatus.OK : HttpStatus.NO_CONTENT).body(byId);
    }

    /**
     * YANGI STARBADGE QO'SHISH
     * @param starBadgeDto
     * @return ApiResponse
     */
    @PostMapping
    public HttpEntity<?> add(@Valid @RequestBody StarBadgeDto starBadgeDto){
        ApiResponse apiResponse = starBadgeService.add(starBadgeDto);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

    /**
     * MAVJUD STARBADGENI O'ZGARTISH
     * @param starBadgeDto
     * @param id
     * @return ApiResponse
     */
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@Valid @RequestBody StarBadgeDto starBadgeDto, @PathVariable Integer id){
        ApiResponse apiResponse = starBadgeService.edit(starBadgeDto, id);
        return ResponseEntity.status(apiResponse.isSuccess() ? HttpStatus.OK : HttpStatus.CONFLICT).body(apiResponse);
    }

//    @DeleteMapping("/{id}")
//    public HttpEntity<?> delete(@PathVariable String id){
////        return ResponseEntity.ok();
//    }
}
