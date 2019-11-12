package exceptions;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class NBPDataException extends Exception {

    public NBPDataException(String message) throws UnsupportedEncodingException {
        super(new String(message.getBytes(StandardCharsets.ISO_8859_1), "ISO-8859-2"));
    }
}
