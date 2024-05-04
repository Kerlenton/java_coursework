package com.cs322.ors.service;

import com.cs322.ors.db.UserRatingsRepository;
import com.cs322.ors.db.UserRepository;
import com.cs322.ors.model.User;
import com.cs322.ors.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRatingsService {

	@Autowired
	private CensorService censorService;
	
    @Autowired
    private UserRatingsRepository userRatingsRepository;
    @Autowired
    private UserRepository userRepository;

    public List<UserRatings> getAllUserRatings() {
        return userRatingsRepository.findAll();
    }

    public List<UserRatings> getAllUserRatingsByPerson(Long personId){
        User person = userRepository.findById(personId).get();
        return userRatingsRepository.findAllByPerson(person);
    }

    public void addUserRatings(UserRatings userRatings, User currentUser){
    	userRatings.setComments(censorService.censor(userRatings.getComments(), currentUser));
        userRatingsRepository.save(userRatings);
    }

    public double calculateAverageRatings(Long userId){
        User person = userRepository.findById(userId).get();
        double total = 0;
        int size = 1;

        List<UserRatings> totalRatings = userRatingsRepository.findAllByPerson(person);

        if(totalRatings.size() == 0){
            return 0;
        }

        for(int i=0; i<totalRatings.size(); i++){
            if(totalRatings.get(i).getType() == 0) {
                size++;
                total += totalRatings.get(i).getRating();
            }
        }
        return total/size;
    }

    public void updateUserRatings(UserRatings updatedUserRatings){
        userRatingsRepository.save(updatedUserRatings);
    }

    public void deleteUserRatings(Long ratingsId){
        userRatingsRepository.delete(userRatingsRepository.findById(ratingsId).get());
    }


}
