package cvc.ranker.services;

import org.apache.mahout.cf.taste.model.DataModel;
import org.springframework.stereotype.Service;

@Service
public class DataModelService {

    private DataModel dataModel;

    public DataModelService(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public DataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }
}
