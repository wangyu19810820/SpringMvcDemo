package controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by admin on 2017/5/23.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "spitte not found")
public class SpitteNotFoundException extends RuntimeException {
}
