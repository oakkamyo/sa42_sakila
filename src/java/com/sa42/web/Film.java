package com.sa42.web;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.json.Json;
import javax.json.JsonObject;

public class Film {

	private String title;
	private String description;
	private int length;
	private String rating;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public JsonObject asJson() {
		JsonObject fo = Json.createObjectBuilder()
				.add("title", getTitle())
				.add("description", getDescription())
				.add("rating", getRating())
				.add("length", getLength())
				.build();
		return (fo);
	}

	public static Film create(ResultSet rs) throws SQLException {

		Film f = new Film();
		f.setTitle(rs.getString("title"));
		f.setDescription(rs.getString("description"));
		f.setLength(rs.getInt("length"));
		f.setRating(rs.getString("rating"));
		return (f);
	}

}
