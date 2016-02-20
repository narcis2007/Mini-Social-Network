package client.view;

import client.ClientScris2Application;
import client.controller.Controller;
import client.model.Post;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Narcis2007 on 18.01.2016.
 */
public class AddPostView extends VBox {

    private static final java.lang.String SUBMIT = "submit";
    private static final String CANCEL = "Cancel";
    private final ClientScris2Application appl;
    private final Controller controller;
    private final ProgressIndicator progressIndicator;
    private Service<Post> service;

    public AddPostView(ClientScris2Application appl, Controller controller) {
        this.appl = appl;
        this.controller = controller;

        ObservableList<Node> children = getChildren();
        // title
        progressIndicator = new ProgressIndicator();
        progressIndicator.setVisible(false);
        children.add(progressIndicator);

        children.add(new Label("text:"));
        TextField text = new TextField();
        children.add(text);

        // auth button (login or cancel)
        Button submitButton = new Button(SUBMIT);
        submitButton.setOnAction((event)->{
            if(submitButton.getText().equals(SUBMIT)) {
                progressIndicator.setVisible(true);
                submitButton.setText(CANCEL);
                service = controller.addPostService(text.getText());
                service.setOnSucceeded((p) -> {
                    progressIndicator.setVisible(false);
                    submitButton.setText(SUBMIT);
                Stage stage = (Stage) submitButton.getScene().getWindow();
                stage.close();
                });
                service.setOnCancelled(p -> {
                    submitButton.setText(SUBMIT);

                });
                service.start();
            }
            else{
                service.cancel();
                progressIndicator.setVisible(false);
            }

        });  //verific sa fac si cu cancelable action ca la authentication
        children.add(submitButton);
    }
}
