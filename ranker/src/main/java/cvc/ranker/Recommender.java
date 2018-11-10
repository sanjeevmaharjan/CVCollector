package cvc.ranker;

import cvc.domain.Cv;
import cvc.ranker.services.ClassLoaderService;
import org.apache.mahout.cf.taste.impl.common.FastByIDMap;
import org.apache.mahout.cf.taste.impl.model.BooleanPreference;
import org.apache.mahout.cf.taste.impl.model.BooleanUserPreferenceArray;
import org.apache.mahout.cf.taste.impl.model.GenericBooleanPrefDataModel;
import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Properties;

public class Recommender {

    @Autowired
    private ClassLoaderService classLoaderService;

    public void run(List<Cv> Cvs) throws URISyntaxException {
        FastByIDMap<PreferenceArray> preferences = new FastByIDMap<>();
        BooleanUserPreferenceArray prefs = new BooleanUserPreferenceArray(Cvs.size());

        prefs.setUserID(0, 0L);
        for (int i = 0; i < Cvs.size(); i++) {
            Cv cv = Cvs.get(i);
            BooleanPreference preference = new BooleanPreference(1L, cv.getId());
            prefs.set(i, preference);
        }
        Cvs = null;

        preferences.put(1L, prefs);

        DataModel model = new GenericDataModel(preferences);
    }
}
