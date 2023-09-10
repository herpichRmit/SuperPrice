package superprice.catalog_sync.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.DefaultAccessorNamingStrategy;

public class ObjectMapperProvider {
    private static ObjectMapper mapper = null;

    private static void init () {
        mapper = new ObjectMapper ();
//        mapper.setAccessorNaming(
//                new DefaultAccessorNamingStrategy.Provider()
//                        .withGetterPrefix( "" )
//                        .withSetterPrefix( "" )
//        );
    }

    public static ObjectMapper mapper () {
        if (mapper == null) {
            init ();
        }

        return mapper;
    }
}
