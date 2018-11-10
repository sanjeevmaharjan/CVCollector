package cvc.ranker.services;

import org.apache.mahout.cf.taste.recommender.Recommender;

public class RecommenderService {

    private Recommender recommender;

    public RecommenderService(Recommender recommender) {
        this.recommender = recommender;
    }

    public Recommender getRecommender() {
        return recommender;
    }

    public void setRecommender(Recommender recommender) {
        this.recommender = recommender;
    }
}
