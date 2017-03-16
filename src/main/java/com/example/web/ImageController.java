package com.example.web;

import com.example.domain.ImageVO;
import com.example.service.HotelService;
import com.example.service.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;


@RestController
@RequestMapping("/api/image")
public class ImageController {

    @Autowired
    private ImageServiceImpl imageService;


    @RequestMapping(value="/v1/image-upload", method=RequestMethod.POST)
    public Object uploadImage(@RequestParam(value = "file", required = true) final MultipartFile file) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Image received :" + file.getOriginalFilename());
        System.out.println("-------------------------------------------------------------------------------");

        ImageVO imageVO = new ImageVO();
        try {
            imageVO.setImageID(UUID.randomUUID());
            ByteBuffer buffer = ByteBuffer.wrap(file.getBytes());
            imageVO.setImageContent(buffer);
            imageVO.setImageName(file.getOriginalFilename());
        }catch (IOException e) {
            System.out.println("IO Exception " + e);
        }

        StopWatch sw = new StopWatch();
        sw.start();
        Object img = this.imageService.uploadImage(imageVO);
        sw.stop();
        System.out.println(sw.shortSummary());
        return img;

    }

    @RequestMapping(value="/v1/image/{imageID}", method=RequestMethod.GET)
    public ImageVO getImage(@PathVariable(value = "imageID") final UUID imageID) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Image ID to retrieve :" + imageID);
        System.out.println("-------------------------------------------------------------------------------");

        //e67ff894-5847-49a7-82f5-87093c0327af

        StopWatch sw = new StopWatch();
        sw.start();
        ImageVO img = imageService.getImage(imageID);
        sw.stop();
        System.out.println(sw.shortSummary());
        return img;

    }
}




