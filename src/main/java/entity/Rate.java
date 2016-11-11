package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Vlad on 11.11.2016.
 */
@Entity
@Table(name = "rates")
public class Rate extends AbstractEntity {

    @Column(name = "startDate", nullable = false, length = 30)
    private Date startDate;
    @Column(name = "endDate", nullable = false, length = 30)
    private Date endDate;
    @Column(name = "allowance", nullable = false)
    private int allowance;


    public Rate(Date startDate, Date endDate, int allowance) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.allowance = allowance;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }
}