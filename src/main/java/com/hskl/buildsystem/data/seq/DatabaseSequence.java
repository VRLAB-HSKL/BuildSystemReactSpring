package com.hskl.buildsystem.data.seq;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Database sequence
 */
@Document(collection = "database_sequences")
public class DatabaseSequence {

    //sequence id
    @Id
    private String id;

    //sequence number
    private long seq;

    //constructor
    public DatabaseSequence() {}

    //id getter
    public String getId() {
        return id;
    }

    //id setter
    public void setId(String id) {
        this.id = id;
    }

    //sequence getter
    public long getSeq() {
        return seq;
    }

    //sequence setter
    public void setSeq(long seq) {
        this.seq = seq;
    }
}
