import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Pos;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

 import javafx.scene.image.Image;
 import javafx.scene.image.ImageView;
 import javafx.scene.layout.HBox;
public class App extends Application {
    communication cm = new communication();
    @Override
    public void start(Stage stage) {

    //load image
    Image image = new Image("flower.png");
    ImageView iv2 = new ImageView();
    iv2.setImage(image);
    iv2.setFitWidth(600);
    iv2.setFitHeight(400);
    iv2.setPreserveRatio(false);
    iv2.setSmooth(true);
    iv2.setCache(true);
        
	String address = "192.168.0.1";
        String port = "8200";
	cm.Comms(address, port);

	Label l2 = new Label(cm.inputData);
	View v = new View();

	//Scene scene = new Scene(new StackPane(l2), 960, 1020);
	Scene scene2 = new Scene(v, 600, 400);

	HBox box = new HBox();
	box.getChildren().add(iv2);
	v.getChildren().add(box);
	v.viewSet();

	stage.setTitle("SMDO");
	//stage.setScene(scene);
        //stage.show();
	stage.setScene(scene2);
        stage.show();
    }

class View extends Group{
	public View() {
	}
	public void viewSet() {
		//‹éŒ`
		Rectangle rect = new Rectangle(50,100,100,100);
		Color clr = new Color(1, 0, 0, 1);
		rect.setStroke(clr);//ü‚ÌF‚ğw’è
		rect.setFill(null);//“h‚è‚Â‚Ô‚µ‚ğ‚µ‚È‚¢
		getChildren().add(rect);
 
		//‰~
		Ellipse e = new Ellipse(300,150,50,50);
		e.setFill(Color.BLUE);//Â‚Å“h‚è‚Â‚Ô‚µ
		getChildren().add(e);
 
		//•¶š—ñ
		Text text = new Text(50,280,cm.inputData);
		text.setFont(new Font(50));//•¶š‚Ì‘å‚«‚³w’è
		text.setStroke(Color.RED);//•¶š‚Ì˜g‚ğ—Î‚Å•\¦
		text.setFill(new Color(0,1,0,0.2));//“§–¾‚È—Î‚Å“h‚è‚Â‚Ô‚µ

		String javaVersion = System.getProperty("java.version");
		String javafxVersion = System.getProperty("javafx.version");
		Text text2 = new Text(50,340,"Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
		text2.setFont(new Font(20));//•¶š‚Ì‘å‚«‚³w’è
		text2.setStroke(Color.RED);//•¶š‚Ì˜g‚ğ—Î‚Å•\¦
		getChildren().add(text);
		getChildren().add(text2);
	}
}
    public static void main(String[] args) {
        launch();
    }

}