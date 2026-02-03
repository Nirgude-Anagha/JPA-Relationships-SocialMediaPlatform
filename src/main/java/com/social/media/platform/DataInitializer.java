package com.social.media.platform;

import com.social.media.platform.models.Post;
import com.social.media.platform.models.SocialGroup;
import com.social.media.platform.models.SocialProfile;
import com.social.media.platform.models.SocialUser;
import com.social.media.platform.repositories.PostRepository;
import com.social.media.platform.repositories.SocialGroupRepository;
import com.social.media.platform.repositories.SocialProfileRepository;
import com.social.media.platform.repositories.SocialUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    private final SocialUserRepository socialUserRepository;
    private final SocialProfileRepository socialProfileRepository;
    private final PostRepository postRepository;
    private final SocialGroupRepository socialGroupRepository;

    public DataInitializer(SocialUserRepository socialUserRepository,
                           SocialProfileRepository socialProfileRepository,
                           PostRepository postRepository,
                           SocialGroupRepository socialGroupRepository) {
        this.socialUserRepository = socialUserRepository;
        this.socialProfileRepository = socialProfileRepository;
        this.postRepository = postRepository;
        this.socialGroupRepository = socialGroupRepository;
    }

    @Bean
    public CommandLineRunner initData(){
        return args -> {
            // Data initialization logic
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();

            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);

            SocialGroup group1 = new SocialGroup();
            SocialGroup group2 = new SocialGroup();

            group1.getSocialUsers().add(user1);
            group1.getSocialUsers().add(user2);

            group2.getSocialUsers().add(user2);
            group2.getSocialUsers().add(user3);

            socialGroupRepository.save(group1);
            socialGroupRepository.save(group2);

            Post post1 = new Post();
            post1.setSocialUser(user1);
            Post post2 = new Post();
            post2.setSocialUser(user2);
            Post post3 = new Post();
            post3.setSocialUser(user3);

            postRepository.save(post1);
            postRepository.save(post2);
            postRepository.save(post3);

            SocialProfile profile1 = new SocialProfile();
            profile1.setSocialUser(user1);
            SocialProfile profile2 = new SocialProfile();
            profile2.setSocialUser(user2);
            SocialProfile profile3 = new SocialProfile();
            profile3.setSocialUser(user3);
            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);

            // associate users with groups
            user1.getSocialGroups().add(group1);
            user2.getSocialGroups().add(group1);
            user2.getSocialGroups().add(group2);
            user3.getSocialGroups().add(group2);
            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);

        };
    }


}
