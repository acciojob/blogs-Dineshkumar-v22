package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    ImageService imageService1;

    @Autowired
    UserRepository userRepository1;

    public List<Blog> showBlogs(){
        //find all blogs
        try{
            return blogRepository1.findAll();
        }
        catch (Exception e){
            return null;
        }
    }

    public void createAndReturnBlog(Integer userId, String title, String content) {

        try{

            //create a blog at the current time
            Blog blog = new Blog(title,content);

            User user = userRepository1.findById(userId).get();

            blog.setUser(user);
            //updating the blog details
            List<Blog> blogsByUser = user.getBlogList();
            blogsByUser.add(blog);
            user.setBlogList(blogsByUser);
            //Updating the userInformation and changing its blogs
            userRepository1.save(user);

        }
        catch(Exception e){
        }

    }

    public Blog findBlogById(int blogId){

        try{
            return blogRepository1.findById(blogId).get();
        }
        catch(Exception e){
            return null;
        }

    }

    public void addImage(Integer blogId, String description, String dimensions){
        try{
            //add an image to the blog after creating it
            Blog blog = blogRepository1.findById(blogId).get();

            Image image = imageService1.createAndReturn(blog,description,dimensions);

            image.setBlog(blog);

            List<Image> imageList = blog.getImageList();
            if(imageList==null) imageList=new ArrayList<>();
            imageList.add(image);
            blog.setImageList(imageList);

            blogRepository1.save(blog);

        }
        catch(Exception e){}

    }

    public void deleteBlog(int blogId){
        try {
            //delete blog and corresponding images
            blogRepository1.delete(blogRepository1.findById(blogId).get());

        }
        catch(Exception e){}
    }
}
