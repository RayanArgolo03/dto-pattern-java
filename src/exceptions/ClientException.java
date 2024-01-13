package exceptions;

import java.io.Serial;

public class ClientException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -5654780941266524046L;

    public ClientException(String message) {
        super(message);
    }
}
