package client.entities;

import java.util.ArrayList;
import java.util.List;

public class Dashboard {
    private Long NumCvs;

    private Long submittedToday;

    private Long submittedThisWeek;

    public Long getNumCvs() {
        return NumCvs;
    }

    public Dashboard setNumCvs(Long numCvs) {
        NumCvs = numCvs;
        return this;
    }

    public Long getSubmittedToday() {
        return submittedToday;
    }

    public Dashboard setSubmittedToday(Long submittedToday) {
        this.submittedToday = submittedToday;
        return this;
    }

    public Long getSubmittedThisWeek() {
        return submittedThisWeek;
    }

    public Dashboard setSubmittedThisWeek(Long submittedThisWeek) {
        this.submittedThisWeek = submittedThisWeek;
        return this;
    }
}
