package superprice.catalog.model;

import java.util.UUID;

public interface Image {
    UUID getUuid ();
    String getMimeType ();
    byte [] getData ();
}
