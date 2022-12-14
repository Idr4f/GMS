package co.com.ikitech.api.ikitech;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public abstract class IkitechRestService<D, B> {
    protected String dtoName = "transferObject";
    protected String pathSuccess = "/";

    /**
     *
     * @param businessObject
     * @param transform
     * @return
     */
    protected ResponseEntity<Map<String, Object>> createResponseSuccess(B businessObject,
                                                                        Function<B, D> transform) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.CREATED.value());
        response.put("message", HttpStatus.CREATED);
        response.put("timestamp", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new Date()));
        response.put(dtoName, transform.apply(businessObject));
        return ResponseEntity
                .created(URI.create(pathSuccess))
                .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .body(response);
    }

    /**
     *
     * @param businessObject
     * @param transform
     * @return
     */
    protected ResponseEntity<Map<String, Object>> getResponseSuccess(B businessObject,
                                                                        Function<B, D> transform) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("message", HttpStatus.OK);
        response.put("timestamp", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss").format(new Date()));
        response.put(dtoName, transform.apply(businessObject));
        return ResponseEntity
                .created(URI.create(pathSuccess))
                .contentType(MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE))
                .body(response);
    }
}
