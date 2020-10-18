/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlambdaaevent;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Miguel
 */
public class JavaFXLambdaAEvent extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(3);
        root.setHgap(1);
        
        //Casilla1
        Label RateL = new Label("Annual Interest Rate: ");
        TextField RateTF = new TextField ("");
        RateTF.setAlignment(Pos.CENTER_RIGHT);
        root.add(RateL, 0, 1);
        root.add(RateTF, 1, 1);
        
        //Casilla2
        Label YearsL = new Label ("Number of Years:");
        TextField YearsTF = new TextField ("");
        YearsTF.setAlignment(Pos.CENTER_RIGHT);
        root.add(YearsL, 0, 2);
        root.add(YearsTF, 1, 2);
        
        //Casilla3
        Label LoanL = new Label ("Loan Amount:");
        TextField LoanTF = new TextField ("");
        LoanTF.setAlignment(Pos.CENTER_RIGHT);
        root.add(LoanL, 0, 3);
        root.add(LoanTF, 1, 3);
        
        //Casilla4
        Label MPayL = new Label ("Monthly Payment:");
        TextField MPayTF = new TextField ("");
        MPayTF.setAlignment(Pos.CENTER_RIGHT);
        root.add(MPayL, 0, 4);
        root.add(MPayTF, 1, 4);

        //Casilla5
        Label ResultL = new Label ("Total Payment:");
        TextField ResultTF = new TextField ("");
        ResultTF.setAlignment(Pos.CENTER_RIGHT);
        ResultTF.setDisable(true);
        root.add(ResultL, 0, 5);
        root.add(ResultTF, 1, 5);
        
        //Botón1
        Button btn = new Button("Calculate");
        root.add(btn, 1, 6);
        GridPane.setHalignment(btn, HPos.RIGHT);
        Scene scene = new Scene(root, 320, 190);
        
        //Handler con la fórmula y declaración de variables
        btn.setOnAction(e-> {
            
            float i=Float.parseFloat(RateTF.getText());
            int n=Integer.parseInt(YearsTF.getText());
            int h=Integer.parseInt(LoanTF.getText());
            
            double exp=(-12*n);
            double r=(i/(100*12));
            double den=1-Math.pow((1+r), exp);
            double m=((h*r)/den);
           
        MPayTF.setText(String.format("%.2f"+ "$", m));
        ResultTF.setText(String.format("%.2f"+ "$", m*(n+12)));

            
        });
        
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
