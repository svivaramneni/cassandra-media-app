package com.example.domain;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.UUID;


@Table("images")
public class ImageVO implements Serializable {

    @PrimaryKeyColumn(name = "image_id", ordinal = 0, type= PrimaryKeyType.PARTITIONED)
    private UUID imageID;

    @Column(value = "image_name")
    private String imageName;

    @Column(value = "image_content")
    private ByteBuffer imageContent;

    public UUID getImageID() {
        return imageID;
    }

    public void setImageID(UUID imageID) {
        this.imageID = imageID;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public ByteBuffer getImageContent() {
        return imageContent;
    }

    public void setImageContent(ByteBuffer imageContent) {
        this.imageContent = imageContent;
    }
}
