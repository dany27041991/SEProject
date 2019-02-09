package com.example.universitySE.intservices;

import com.example.universitySE.dtos.RatingDTO;
import com.example.universitySE.models.LastUploadModel;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentServiceInterfaceTest {

    @Mock
    StudentServiceInterface serviceInterface = mock(StudentServiceInterface.class);

    @Test
    public void addRating() {
        RatingDTO ratingDTO = mock(RatingDTO.class);
        serviceInterface.addRating(ratingDTO);
    }

    @Test
    public void getLastUpload() {
        LastUploadModel mobilePersonModel = mock(LastUploadModel.class);
        List<LastUploadModel> mobilePersonModelList = new ArrayList<>();
        mobilePersonModelList.add(mobilePersonModel);
        List<Integer> integers = mock(ArrayList.class);
        when(serviceInterface.getLastUpload(integers)).thenReturn(mobilePersonModelList);

        List<Integer> integers1 = mock(ArrayList.class);
        List<LastUploadModel> lastUploadModelList = serviceInterface.getLastUpload(integers1);
        assertNotEquals(lastUploadModelList, mobilePersonModelList);

    }
}