package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;
    @Autowired
    private BlogRepository blogRepository2;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog

        try {
//            int blogId = blog.getId();
//            blog = blogRepository2.findById(blogId).get();

            Image image = new Image(description,dimensions);

            image.setBlog(blog);

            List<Image> imageList = blog.getImageList();
            if(imageList==null) imageList=new ArrayList<>();
            imageList.add(image);
            blog.setImageList(imageList);

            blogRepository2.save(blog);
//
//            blog = blogRepository2.findById(blog.getId()).get();
//            imageList=blog.getImageList();
//            int size = imageList.size();
//
//            return imageList.get(size-1);

            return image;
        }
        catch (Exception e){
            return null;
        }
    }

    public void deleteImage(Image image){

        try{
            imageRepository2.delete(image);
        }
        catch (Exception e){}

    }

    public Image findById(int id) {
        try{
            return imageRepository2.findById(id).get();
        }
        catch(Exception e){
            return null;
        }
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0

        try {
            if (image == null || screenDimensions == null || image.getDimensions() == null) return 0;

            //System.out.println(image.getDimensions()+"  "+screenDimensions+" "+image.getDescription());

            String imageDimension = image.getDimensions();
            String[] dimensions = imageDimension.split("X");
            //int imageArea = Integer.parseInt(dimensions[0])*Integer.parseInt(dimensions[1]);

            String[] screenD = screenDimensions.split("X");
            //int screenArea = Integer.parseInt(screenD[0])*Integer.parseInt(screenD[1]);

            int breadth = Integer.parseInt(screenD[0]) / Integer.parseInt(dimensions[0]);
            int length = Integer.parseInt(screenD[1]) / Integer.parseInt(dimensions[1]);

            if (breadth == 0 || length == 0) {
                breadth = Integer.parseInt(screenD[1]) / Integer.parseInt(dimensions[0]);
                length = Integer.parseInt(screenD[0]) / Integer.parseInt(dimensions[1]);
            }

            return breadth * length;
        }
        catch (Exception e){
           return 0;
        }

    }
}
