package com.example.universitySE.intservices;

import com.example.universitySE.dtos.RatingDTO;
import com.example.universitySE.models.LastUploadModel;

import java.util.List;

public interface StudentServiceInterface {

    void addRating(RatingDTO ratingDTO);

    List<LastUploadModel> getLastUpload(List<Integer> subjects);

}
