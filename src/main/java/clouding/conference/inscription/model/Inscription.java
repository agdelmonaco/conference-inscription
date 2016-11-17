package clouding.conference.inscription.model;

import java.io.Serializable;

public class Inscription implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5144134919439189895L;
	private String paperTitle;
	private String mainAuthor;
	private String secundaryAuthors;
	private String summary;
	private String subject;
	private String personalEmail;
	private String gmail;
	private String type;
	private String state;
	
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPaperTitle() {
		return paperTitle;
	}
	public void setPaperTitle(String paperTitle) {
		this.paperTitle = paperTitle;
	}
	public String getMainAuthor() {
		return mainAuthor;
	}
	public void setMainAuthor(String mainAuthor) {
		this.mainAuthor = mainAuthor;
	}
	public String getSecundaryAuthors() {
		return secundaryAuthors;
	}
	public void setSecundaryAuthors(String secundaryAuthors) {
		this.secundaryAuthors = secundaryAuthors;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPersonalEmail() {
		return personalEmail;
	}
	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
