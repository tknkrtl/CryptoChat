package bean;

public class MessageBean {
	private String musername;
	private String mdate;
	private String mmesage;
	

	public MessageBean(String musername, String mdate, String mmesage) {
		super();
		this.musername = musername;
		this.mdate = mdate;
		this.mmesage = mmesage;
	}
	public MessageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMusername() {
		return musername;
	}
	public void setMusername(String musername) {
		this.musername = musername;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public String getMmesage() {
		return mmesage;
	}
	public void setMmesage(String mmesage) {
		this.mmesage = mmesage;
	}

}
