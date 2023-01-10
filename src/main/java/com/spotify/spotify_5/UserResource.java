package com.spotify.spotify_5;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/user")
@RequestScoped
public class UserResource {

    @Inject
    private UserService userService;

    @GET
    @Produces("text/plain")
    @Path("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users")
    public List<User> getAllUsers(){return userService.getAllUsers();}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public User getUserById(@PathParam("id") Long id){return userService.findUser(id);}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/add_user")
    public User createUser(User user) {
        return userService.insertUser(user);
    }

    @PUT
    @Path("/edit_user/{id}")
    public User editUser(@PathParam("id") Long id, User user) {
        return userService.updateUser(user.getId(), user.getFirstName(), user.getLastName());
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("delete_user/{id}")
    public User deleteUser(@PathParam("id") Long id){return userService.deleteUser(id);}



}