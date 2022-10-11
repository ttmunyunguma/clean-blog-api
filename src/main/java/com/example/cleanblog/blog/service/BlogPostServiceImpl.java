package com.example.cleanblog.blog.service;

import com.example.cleanblog.blog.entity.BlogPost;
import com.example.cleanblog.blog.repository.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class BlogPostServiceImpl implements BlogPostService{

    private final BlogPostRepository blogPostRepository;

    @Override
    public BlogPost addNewBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public BlogPost getBlogPostBySlug(String slug) {
        Optional<BlogPost> optionalBlogPost = blogPostRepository.findBlogPostBySlug(slug);
        return optionalBlogPost.orElse(null);
    }

    @Override
    public List<BlogPost> getAllBlogPosts() {
        List<BlogPost> blogPosts = blogPostRepository.findAll();
        if(blogPosts.isEmpty()){
            seedBlogPost();
            return blogPostRepository.findAll();
        }
        return blogPosts;
    }

    private void seedBlogPost() {
        log.info("**************seeding data");
        BlogPost post1 = BlogPost.builder()
                .heading("Zimswitch new ZIPIT limits Oct 2022")
                .subHeading("Zimswitch has announced new limits for person-to-person transactions")
                .slug("zimswitch-new-zipit-limits-oct-2022")
                .postBody("""
                        Zimswitch has announced new limits for person-to-person transactions. \
                        This limit is now ZW$150 000 per transaction up from ZW$100 000 with the monthly limit now set at ZW$600 000. \
                        These new transaction limits will be taking effect from today, 10 October 2022.
                        Customer Notice
                        ZIPIT LIMIT REVIEW
                        Dear Valued Customer,
                        Please be advised that the ZIPIT person-to-person transaction limit has been reviewed from ZWL$100,000 to ZWL$150,000 with a new monthly limit of ZWL$600,000 effective 10 October 2022.
                        In other words, an individual may now opt to send up to ZWL$150,000 per single transaction, but ultimately being governed by the new maximum limit of ZWL$600,000 per month.
                        """)
                .postedBy("Staff Writer")
                .postedDate(LocalDateTime.now())
                .build();
        blogPostRepository.save(post1);
        BlogPost post2 = BlogPost.builder()
                .heading("HP Pavilion Gaming 15 review – not much better for the price, parliament should consider it")
                .slug("hp-pavilion-gaming-15-review-not-much-better-for-price-parly-should-consider")
                .postBody("""
                        With the $9,200 laptops still in mind, we should look at the $800 one I have been using for a few months. \
                        The performance I am getting from this HP Pavilion Gaming 15 makes me wonder why anyone would ever pay more, \
                        especially $8,500 more.
                                                
                        I will concede that there is someone for whom the $9,200 laptop would be the only option. \
                        I will maintain though that there aren’t 7 such people in Zimbabwe.
                                                
                        HP Pavilion Gaming 15 review
                        Don’t be scared away by the ‘Gaming’ name. Whatever makes for good gaming computers also makes for \
                        a good computer. For the most part.
                        Performance
                        Right from boot up, this laptop does not disappoint. Windows 11 has something called fast start-up and it takes less than 5 seconds to get to the welcome screen. A glaring omission is Windows Hello or a fingerprint scanner. Meaning you’ll have to fiddle with passwords and PINs like a caveman.
                                                
                        Once on, the laptop never feels slow. The 11th Gen i5 processor inside handles all I throw at it with ease. Couple that with decent 3200Mhz DDR4 RAM and not even 94 Chrome tabs can slow this beast down.
                                                
                        I wouldn’t say I’m a power user but the Chrome tabs sometimes get out of hand. The multiple Chrome windows are always accompanied by the Spotify app, Link to Windows, WhatsApp, GIMP (a photo editor), the Adobe Acrobat reader, Word and a few more random apps.
                                                
                        Even with all that going on, this Pavilion doesn’t break a sweat. It still opens new apps or tabs quickly and switching between those apps is a breeze. Everything stays where you left it, no refreshes.
                                                
                        So, I don’t see any scenario in which any Parliamentarian would find this laptop to be too slow for them. Office apps and Chrome, which is where I imagine most of their lives are spent, are child’s play for the Pavilion Gaming.
                                                
                        The keyboard and mouse
                        If you are going to be doing a lot of typing, you’re not going to have a problem with the Pavilion Gaming’s keyboard. There is decent travel on the keys and no mushiness, meaning you have full confidence that a key has been pressed. How fast the brain can think up words to type becomes the bottleneck.
                                                
                        The keyboard is backlit and you’ll love that as you do some typing in the dark when the power utility does its power cut shenanigans. There are two levels of backlight and the dimmer setting is good enough. The brighter one is a little too blinding for my eyes.
                                                
                        Then there is the trackpad. It is textured and offers the perfect amount of resistance. Multi finger gestures are a joy to use and I have no complaints. Except that I wish the trackpad was bigger although I can’t say its small size has affected usability.
                        """)
                .postedBy("Staff Writer")
                .postedDate(LocalDateTime.now())
                .build();
        blogPostRepository.save(post2);
    }

    @Override
    public void deleteBlogPostBySlug(String slug) {
        BlogPost blogPost = getBlogPostBySlug(slug);
        if(blogPost != null)
            blogPostRepository.delete(blogPost);
    }
}
