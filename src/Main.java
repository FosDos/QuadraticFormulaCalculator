import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;

/***********************************************************************************************************************
 * Author: Foster C. Williams
 * Program: JavaFX Quadratic formula calculator
 * Date: Saturday October 14th 2017
 * Version 1.1
 */
public class Main extends Application
{
    Stage window;
    Scene scene1, scene2;
    static Label answer = new Label("");
    static TextField a, b, c;
    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
       primaryStage.setTitle("Fosters Quadratic Calculator!");
       Label directions = new Label("Please enter the variables A B and C for the quadratic formula");
       window = primaryStage;
       VBox grid = new VBox(20);
       grid.setPadding(new Insets(10,10,10,10));

       grid.getChildren().add(directions);

       a = new TextField();
       a.setPromptText("A");

       b = new TextField();
       b.setPromptText("B");

       c = new TextField();
       c.setPromptText("C");

       String response = "";
       grid.getChildren().add(a);
       grid.getChildren().add(b);
       grid.getChildren().add(c);
       Button calc = new Button("Calculate!");
       grid.getChildren().add(calc);
       grid.getChildren().add(answer);

       calc.setOnAction(e -> this.quadratic(a.getText(), b.getText(), c.getText()));

       scene1 = new Scene(grid, 500, 300);
       window.setScene(scene1);
       window.show();


    }

    /******************************************************************************************************************
     *
     * @param x - Equal to the x portion of the quadratic formula, String
     * @param y - Equal to the x portion of the quadratic formula, String
     * @param z - Equal to the x portion of the quadratic formula, String
     */
    public static void quadratic(String x, String y, String z)
    {
        double a1, b1, c1;
        try
        {
            a1 = Double.parseDouble(x);
            b1 = Double.parseDouble(y);
            c1 = Double.parseDouble(z);
        }
        catch(Exception e)
        {
            answer.setText("Incorrect Format! Please Try Again");
            a.clear();
            b.clear();
            c.clear();
            return;

        }
        if((b1*b1 - 4*(a1*c1)) < 0)
        {
            answer.setText("No Solution without complex numbers");
            return;
        }
        double ans1 = (((-1)*b1) + Math.sqrt((b1*b1)*(4*a1*c1)))/(2*a1);
        double ans2 = (((-1)*b1) - Math.sqrt((b1*b1)*(4*a1*c1)))/(2*a1);
        if (ans1==ans2)
        {
            answer.setText("x = " + ans1);
        }
        else
        {
            answer.setText("x = " + ans1 + ", or x = " + ans2);
        }

    }

}
