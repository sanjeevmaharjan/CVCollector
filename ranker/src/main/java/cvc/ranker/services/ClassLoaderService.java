package cvc.ranker.services;

import java.net.URI;
import java.net.URISyntaxException;

public class ClassLoaderService {

    private ClassLoader classLoader;

    public ClassLoaderService() {
        classLoader = ClassLoader.getSystemClassLoader();
    }

    public URI getResourceUri(String file) throws URISyntaxException {
        return classLoader.getResource(file).toURI();
    }
}
