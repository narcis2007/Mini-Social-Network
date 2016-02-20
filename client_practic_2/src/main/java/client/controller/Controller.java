package client.controller;

import client.model.Post;
import client.service.AppClient;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * Created by Narcis2007 on 18.01.2016.
 */
public class Controller {
    private AppClient client;

    public Controller(AppClient emailClient) {

        this.client = emailClient;
    }

    public Service<Boolean> authService(String usernameText, String passwordText) {
        return new Service<Boolean>() {
            @Override
            protected Task<Boolean> createTask() {
                return new Task<Boolean>() {
                    @Override
                    protected Boolean call() throws Exception {
                        return client.authenticate(usernameText,passwordText);
                    }
                };
            }
        };
    }

    public Service<Post[]> getPostsService() {
        return new Service<Post[]>() {
            @Override
            protected Task<Post[]> createTask() {
                return new Task<Post[]>() {
                    @Override
                    protected Post[] call() throws Exception {
                        return client.getPosts();
                    }
                };
            }
        };
    }

    public Service<Post> addPostService(String text) {
        return new Service<Post>() {
            @Override
            protected Task<Post> createTask() {
                return new Task<Post>() {
                    @Override
                    protected Post call() throws Exception {
                        synchronized (this) {

                            wait(2000);
                        }
                        return client.addPost(text);
                    }
                };
            }
        };
    }
}
