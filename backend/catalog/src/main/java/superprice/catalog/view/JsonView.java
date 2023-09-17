package superprice.catalog.view;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import superprice.catalog.model.dao.SessionProvider;
import superprice.catalog.util.ObjectMapperProvider;

public class JsonView <T> {
    T pojo;

    public JsonView (T pojo) {
        this.pojo = pojo;
    }

    public String render () throws JsonProcessingException {
            ObjectMapper mapper = ObjectMapperProvider.mapper();

            return SessionProvider
                    .getInstance()
                    .withSessionRx(
                            session -> mapper.writeValueAsString(pojo)
                    );
    }
}
