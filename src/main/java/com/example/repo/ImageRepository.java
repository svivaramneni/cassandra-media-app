package com.example.repo;

import com.example.domain.ImageVO;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;


public interface ImageRepository extends CrudRepository<ImageVO, UUID> {
}
