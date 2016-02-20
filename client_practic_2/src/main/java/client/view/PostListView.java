package client.view;

import client.ClientScris2Application;
import client.controller.Controller;
import client.model.Post;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Narcis2007 on 18.01.2016.
 */
public class PostListView extends HBox {
    private final ClientScris2Application appl;
    private final Controller controller;
    private final ProgressIndicator progress;
    private final ExecutorService executorService;
    private Service<Post[]> service;
    private boolean refreshing=true;

    public PostListView(ClientScris2Application appl, Controller controller) {
        this.executorService= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        this.appl = appl;
        this.controller = controller;
        ObservableList<Node> children = getChildren();


        Button postButton = new Button("Post");
        postButton.setOnAction((event)->{
            Stage stage = new Stage();
            AddPostView addPostView=new AddPostView(appl,controller);
            Scene scene = new Scene(addPostView);
            stage.setScene(scene);
            stage.setTitle("post");
            stage.show();

        });

        children.add(postButton);
        ObservableList<Post> items = FXCollections.observableArrayList ();
//        items.addAll(controller.getUsers());

        progress=new ProgressIndicator();
        progress.setVisible(true);
        children.add(progress);
        ListView<Post> list = new ListView<>();

//            executorService.submit(()->{
//
//                while(refreshing) {
//                    service = controller.getPostsService();
//                    service.setOnSucceeded(e->{
//                    items.addAll((Post[]) e.getSource().getValue());
//                    list.setItems(items);
//                    progress.setVisible(false);
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e1) {
//                        refreshing=false;
//                    }
//                    service.start();
//                });
//                }
//            });
        executorService.submit(()->{
            while(true){

                service = controller.getPostsService();
                service.setOnSucceeded(e->{


                    progress.setVisible(false);

                    items.setAll((Post[]) e.getSource().getValue());
                    list.setItems(items);
                });
                service.start();
                Thread.sleep(2000);

            }

        });

        children.addAll(list);

    }
}
