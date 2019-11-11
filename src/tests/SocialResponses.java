package tests;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SocialResponses {

	private String twitter;
	private String instagram;
	//private Map<String, String> keys;
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getInstagram() {
		return instagram;
	}
	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}
	
	@SuppressWarnings("unchecked")
    @JsonProperty("keys")
    private void unpackNested(Map<String, String> keys) {
        this.instagram = (String)keys.get("instagram");
        this.twitter = (String)keys.get("twitter");
    }
//	public Map<String, String> getKeys() {
//		return keys;
//	}
//	public void setKeys(Map<String, String> keys) {
//		this.keys = keys;
//	}
}
