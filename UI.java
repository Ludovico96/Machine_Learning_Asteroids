/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progettovideogioco;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;


public class UI {
    
    public GameManager gm;
    public ImageView im;
    public VBox staticVbox;
    public VBox actionVbox;
    public  Button menu;
    public  Button la1;
    public  Button la2;
    public  Button la3;
    public Button bu1;
    public Button bu2;
    public Button bu3;
    public Label la;
    public Button changeLeft;
    public Button changeRight;
    
    public UI(GameManager gm){
        this.gm=gm;
    }
    
    
    
    public ImageView creatScenario(String imagePath){
        im=new ImageView(imagePath);
        im.setFitHeight(650);
        im.setFitWidth(1000);
        im.setLayoutY(50);
       return im;
    }
    
    public void createMessage(String message){
        la=new Label(message);
        la.setLayoutX(700);
        la.setLayoutY(800);
        la.setStyle("-fx-font-size: 30px; -fx-background-color:black; -fx-text-fill: white");
    }
    
    public ImageView creatObject(String objectPath,int height,int width,int x,int y){
        im=new ImageView(objectPath);
        im.setFitHeight(height);
        im.setFitWidth(width);
        im.setLayoutX(x);
        im.setLayoutY(y);
        return im;
        
    }
    
    public void createStaticMenu(){
    menu =new Button("Action Menu");
    la1=new Button("Action 1");
    la2=new Button("Action 2");
    la3=new Button("Action 3");    
    menu.setStyle("-fx-font-size: 40px; -fx-background-color:black; -fx-text-fill: white; ");
    la1.setStyle("-fx-font-size: 30px; -fx-background-color:black; -fx-text-fill: white; -fx-border-color: white");
    la2.setStyle("-fx-font-size: 30px; -fx-background-color:black; -fx-text-fill: white; -fx-border-color: white");
    la3.setStyle("-fx-font-size: 30px; -fx-background-color:black; -fx-text-fill: white; -fx-border-color: white");
    staticVbox=new VBox();
    staticVbox.getChildren().add(menu);
    staticVbox.getChildren().add(la1);
    staticVbox.getChildren().add(la2);
    staticVbox.getChildren().add(la3);
    staticVbox.setLayoutX(0);
    staticVbox.setLayoutY(700);
    
    }
    
   
    
    public void createObjectMenu(String bu1Action,String bu2Action,String bu3Action){
    bu1=new Button(bu1Action);
    bu2=new Button(bu2Action);
    bu3=new Button(bu3Action);
    bu1.setStyle("-fx-font-size: 30px; -fx-background-color:black; -fx-text-fill: white; -fx-border-color: white");
    bu2.setStyle("-fx-font-size: 30px; -fx-background-color:black; -fx-text-fill: white; -fx-border-color: white");
    bu3.setStyle("-fx-font-size: 30px; -fx-background-color:black; -fx-text-fill: white; -fx-border-color: white");
    actionVbox=new VBox();
    actionVbox.setLayoutX(150);
    actionVbox.setLayoutY(786);
    actionVbox.getChildren().add(bu1);
    actionVbox.getChildren().add(bu2);
    actionVbox.getChildren().add(bu3);
    }
    
    public void createButtonChangeScene(){
        changeLeft=new Button();
         changeRight=new Button();
         changeLeft.setLayoutX(0);
         changeLeft.setLayoutY(300);
         changeRight.setLayoutX(980);
         changeRight.setLayoutY(300);
    }
    
   
    
    
    
}
