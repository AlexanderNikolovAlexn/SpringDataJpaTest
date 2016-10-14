package com.samodeika;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bug")
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bug_id")
    private Long bugId;
    private String bugTitle;
    private String bugDesc;
    private Date bugDate;

    public Bug() {

    }

    public Bug(String bugTitle, String bugDesc, Date bugDate) {
        this.bugTitle = bugTitle;
        this.bugDesc = bugDesc;
        this.bugDate = bugDate;
    }

    public Long getBugId() {
        return bugId;
    }

    public String getBugTitle() {
        return bugTitle;
    }

    public String getBugDesc() {
        return bugDesc;
    }

    public Date getBugDate() {
        return bugDate;
    }

    @Override
    public String toString() {
        return String.format(
                "Bug[bugId=%d, bugTitle='%s', bugDesc='%s', bugDate='%s']",
                bugId, bugTitle, bugDesc, bugDate);
    }
}
