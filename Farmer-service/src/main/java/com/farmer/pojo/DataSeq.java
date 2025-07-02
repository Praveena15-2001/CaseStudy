package com.farmer.pojo;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="sequence")
public class DataSeq {
	
    @Id
    private String id;
    private long seq;

	public DataSeq() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DataSeq(String id, long seq) {
		super();
		this.id = id;
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	@Override
	public String toString() {
		return "DataSeq [id=" + id + ", seq=" + seq + "]";
	}
  
}
