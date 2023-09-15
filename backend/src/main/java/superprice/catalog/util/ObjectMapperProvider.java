package superprice.catalog.util;

import com.fasterxml.jackson.databind.ObjectMapper;

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
