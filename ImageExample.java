import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import javafx.application.Application; 
import javafx.scene.layout.GridPane;
import javafx.scene.input.KeyEvent; 
import javafx.geometry.Pos; 
import javafx.geometry.Insets;
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage;  
import javafx.event.EventHandler; 


public class ImageExample extends Application { 

   private int col = 0;
 
   @Override 
   public void start(Stage stage) throws FileNotFoundException {         
      //Load the image
      Image image = new Image("bunny.png"); 
      
      //Create an image view
      ImageView imageView = new ImageView(image);
      
      //set the size of the image view 
      imageView.setFitHeight(300); 
      
      //preserve the ratio of the image 
      imageView.setPreserveRatio(true);  
      
      GridPane grid = new GridPane();
      grid.setAlignment(Pos.CENTER_LEFT);
      grid.setHgap(10);
      grid.setVgap(10);
      grid.setPadding(new Insets(25, 25, 25, 25));
      grid.setMinWidth(800);
      
      grid.add(imageView,col,0);//place the image in column 0, row 0
      
      Scene scene = new Scene(grid);  
      
      //Handling the key typed event 
      EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() { 
         @Override 
         public void handle(KeyEvent event) { 
            //System.out.println(event);
            if(event.getCharacter().equals("d"))
            { 
				col++;
				grid.getChildren().remove(imageView);
				grid.add(imageView,col,0);
            }
         }           
      };              
      //Adding an event handler to the scene 
      scene.addEventHandler(KeyEvent.KEY_TYPED, keyHandler); 
      
      //Setting title to the Stage 
      stage.setTitle("Loading an image");  
      
      //Adding scene to the stage 
      stage.setScene(scene);
      
      //Displaying the contents of the stage 
      stage.show(); 
   }  
   public static void main(String args[]) { 
      launch(args); 
   } 
}