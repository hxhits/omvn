package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Record implements Comparable<Record>{
	
	private String phone;
    private Date activationDate;
    private Date deactivationDate;
    
    public Record() {}
    
    public Record(String phone, Date activationDate) {
		super();
		this.phone = phone;
		this.activationDate = activationDate;
	}
    
	public Record(String phone, Date activationDate, Date deactivationDate) {
		super();
		this.phone = phone;
		this.activationDate = activationDate;
		this.deactivationDate = deactivationDate;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getActivationDate() {
		return activationDate;
	}
	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}
	public Date getDeactivationDate() {
		return deactivationDate;
	}
	public void setDeactivationDate(Date deactivationDate) {
		this.deactivationDate = deactivationDate;
	}
	
	private static Date CURRENT_DATE;

    static {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            CURRENT_DATE = sdf.parse(sdf.format(new Date(1514136735000L)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
	public boolean isActive() {
        return (this.getDeactivationDate() == null) || (this.getDeactivationDate().compareTo(CURRENT_DATE) > 0);
    }

	@Override
	public int compareTo(Record that) {
		// TODO Auto-generated method stub
		if (!this.phone.equals(that.phone)) {
            return that.phone.compareTo(this.phone);
        }

        if (!this.activationDate.equals(that.activationDate)) {
            return that.activationDate.compareTo(this.activationDate);
        }

        return that.deactivationDate.compareTo(this.deactivationDate);
	}
	
	
    
}
