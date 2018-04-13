package com.amit.message;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import static com.amit.message.MessageController.MESSAGE_RESOURCE;

@RestController
@RequestMapping(value = MESSAGE_RESOURCE)
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class MessageController {
    public static final String MESSAGE_RESOURCE = "message";

    //https://dzone.com/articles/autowiring-using-value-and
    @Value("${MESSAGE:defaultValue}")
    private String message;

    @ApiOperation(value = "Returns a list of cars", response = String.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Message does not exist"),
            @ApiResponse(code = 500, message = "Unexpected failure")})
    @RequestMapping(method = {RequestMethod.GET})
    public ResponseEntity<String> message() {
        return ResponseEntity.ok().body("hello " + message);
    }
}
