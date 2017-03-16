package com.example.service;

import com.example.domain.ImageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ImageServiceImpl {

    @Autowired
    private CassandraOperations imageRepository;

    public ImageVO uploadImage(final ImageVO imageVO) {
        return this.imageRepository.insert(imageVO);
    }


    public ImageVO getImage(final UUID imageID) {
        final String getImageCql = "select * from images where image_id = "+imageID;
        //final String getImageCql = "select * from images where image_id = e67ff894-5847-49a7-82f5-87093c0327af";
        return this.imageRepository.selectOne(getImageCql, ImageVO.class);
    }

}
