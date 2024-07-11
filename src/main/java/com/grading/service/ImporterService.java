package com.grading.service;

import java.io.IOException;
import java.io.InputStream;

public interface ImporterService {
    void importData(InputStream inputStream) throws IOException;
    public boolean supports(String type);
}
