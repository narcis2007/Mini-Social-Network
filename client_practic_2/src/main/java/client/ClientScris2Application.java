package client;

import client.controller.Controller;
import client.service.AppClient;
import client.view.AuthView;
import client.view.PostListView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientScris2Application extends Application {

	private Stage stage;
	private Scene scene;
	private static Log log = LogFactory.getLog(ClientScris2Application.class);
	private Controller controller;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage=primaryStage;
		controller=new Controller(AppClient.getEmailClient());
		AuthView authenticationView=new AuthView(this,controller);
		scene=new Scene(authenticationView);
		stage.setScene(scene);
		stage.show();
	}

	public void listView() {
		log.info("listView");
		PostListView listiew=new PostListView(this,controller);
		scene=new Scene(listiew);
		stage.setScene(scene);
	}
}
