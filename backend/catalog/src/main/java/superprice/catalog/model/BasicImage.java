package superprice.catalog.model;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.UUID;

@Entity
public class BasicImage implements Image {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    long id;
    @Column
    UUID uuid;
    @Column
    private String mimeType;
    @Column
    private byte [] data;

    public BasicImage (String mimeType, byte [] data) {
        this.mimeType = mimeType;
        this.data = data.clone();
        this.uuid = UUID.randomUUID();
    }

    @Override
    public UUID getUuid() {
        return this.uuid;
    }

    @Override
    public String getMimeType() {
        return mimeType;
    }

    @Override
    public byte[] getData() {
        return data.clone();
    }
}
