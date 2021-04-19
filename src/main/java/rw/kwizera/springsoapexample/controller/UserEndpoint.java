package rw.kwizera.springsoapexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rw.kwizera.springsoapexample.GetUserRequest;
import rw.kwizera.springsoapexample.GetUserResponse;
import rw.kwizera.springsoapexample.service.UserService;

@Endpoint
public class UserEndpoint {
    @Autowired
    private UserService userService;
    @PayloadRoot(namespace = "http://kwizera.rw/springsoapexample", localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserResponse(@RequestPayload GetUserRequest request) {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        return response;
    }

}
