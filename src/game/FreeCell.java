package game;

//Importações
import stack.Stack;
import deck.Deck;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.effect.*;


public class FreeCell extends Application {

	//Variáveis
	static int width = 1000;
	static int height = 700;
	static int heightRect = 120;
	static int widthRect = 92;
	static int widthB = 80;
	static int heightB = 30;

	static int heightBL = 140;

	LinkedList<Deck> list = new LinkedList<>();
	LinkedList<Deck> scrambled = new LinkedList<>();

	static double x1 = 70;
	static double x2 = 174;
	static double x3 = 277;
	static double x4 = 385;
	static double x5 = 487;
	static double x6 = 592;
	static double x7 = 695;
	static double x8 = 800;

	static double y1 = 200;
	static double y2 = 200;
	static double y3 = 200;
	static double y4 = 200;
	static double y5 = 200;
	static double y6 = 200;
	static double y7 = 200;
	static double y8 = 200;

	//variável usada para receber a carta a ser removida da pilha
	static ImageView selectedCard;
	
	//variáveis que recebem as informações da carta removida
	//afim de saber se elas podem ir pra outra pilha
	static int suit;
	static int value;
	static int back;

	static int red = 0;
	static int black = 1;

	static int diamond = 1;
	static int hearts = 1;
	static int spades = 1;
	static int clubs = 1;

	//Instanciando as pilhas 
	Stack<ImageView> pile1 = new Stack<>();
	Stack<ImageView> pile2 = new Stack<>();
	Stack<ImageView> pile3 = new Stack<>();
	Stack<ImageView> pile4 = new Stack<>();
	Stack<ImageView> pile5 = new Stack<>();
	Stack<ImageView> pile6 = new Stack<>();
	Stack<ImageView> pile7 = new Stack<>();
	Stack<ImageView> pile8 = new Stack<>();

	//Gerenciadores de layout
	AnchorPane central = new AnchorPane();

	AnchorPane anchor1 = new AnchorPane();
	AnchorPane anchor2 = new AnchorPane();
	AnchorPane anchor3 = new AnchorPane();
	AnchorPane anchor4 = new AnchorPane();
	AnchorPane anchor5 = new AnchorPane();
	AnchorPane anchor6 = new AnchorPane();
	AnchorPane anchor7 = new AnchorPane();
	AnchorPane anchor8 = new AnchorPane();

	AnchorPane anchorBL1 = new AnchorPane();
	AnchorPane anchorBL2 = new AnchorPane();
	AnchorPane anchorBL3 = new AnchorPane();
	AnchorPane anchorBL4 = new AnchorPane();

	AnchorPane anchorBR1 = new AnchorPane();
	AnchorPane anchorBR2 = new AnchorPane();
	AnchorPane anchorBR3 = new AnchorPane();
	AnchorPane anchorBR4 = new AnchorPane();

	static ImageView imageView1;
	static ImageView imageView2;
	static ImageView imageView3;
	static ImageView imageView4;
	
	Reflection reflection = new Reflection();

	//Função para adicionar as imagens dos naipes na pilha definitiva
	public void addSuits() throws FileNotFoundException {
		FileInputStream inputstream1 = new FileInputStream(
				"C:\\Users\\leoco\\eclipse-workspace\\FreeCell\\src\\assets\\cards\\suits\\diamonds.png");
		Image image1 = new Image(inputstream1);
		imageView1 = new ImageView(image1);
		imageView1.setFitHeight(120);
		imageView1.setFitWidth(92);
		imageView1.setX(505);
		imageView1.setY(10);

		FileInputStream inputstream2 = new FileInputStream(
				"C:\\Users\\leoco\\eclipse-workspace\\FreeCell\\src\\assets\\cards\\suits\\hearts.png");
		Image image2 = new Image(inputstream2);
		imageView2 = new ImageView(image2);
		imageView2.setFitHeight(120);
		imageView2.setFitWidth(92);
		imageView2.setX(620);
		imageView2.setY(10);

		FileInputStream inputstream3 = new FileInputStream(
				"C:\\Users\\leoco\\eclipse-workspace\\FreeCell\\src\\assets\\cards\\suits\\spades.png");
		Image image3 = new Image(inputstream3);
		imageView3 = new ImageView(image3);
		imageView3.setFitHeight(120);
		imageView3.setFitWidth(92);
		imageView3.setX(733);
		imageView3.setY(10);

		FileInputStream inputstream4 = new FileInputStream(
				"C:\\Users\\leoco\\eclipse-workspace\\FreeCell\\src\\assets\\cards\\suits\\clubs.png");
		Image image4 = new Image(inputstream4);
		imageView4 = new ImageView(image4);
		imageView4.setFitHeight(120);
		imageView4.setFitWidth(92);
		imageView4.setX(848);
		imageView4.setY(10);
	}

	public void put() throws FileNotFoundException {

		for (int i = 1; i <= 13; i++) {
			Deck deck = new Deck();

			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\leoco\\eclipse-workspace\\FreeCell\\src\\assets\\cards\\diamonds\\" + i + ".png");
			Image image = new Image(inputstream);
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(120);
			imageView.setFitWidth(92);
			deck.setContainer(imageView);
			deck.setValue(i);
			deck.setSuit(0);

			scrambled.add(deck);
		}

		for (int i = 1; i <= 13; i++) {
			Deck deck = new Deck();

			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\leoco\\eclipse-workspace\\FreeCell\\src\\assets\\cards\\hearts\\" + i + ".png");
			Image image = new Image(inputstream);
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(120);
			imageView.setFitWidth(92);
			deck.setContainer(imageView);
			deck.setValue(i);
			deck.setSuit(1);

			scrambled.add(deck);
		}

		for (int i = 1; i <= 13; i++) {
			Deck deck = new Deck();

			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\leoco\\eclipse-workspace\\FreeCell\\src\\assets\\cards\\spades\\" + i + ".png");
			Image image = new Image(inputstream);
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(120);
			imageView.setFitWidth(92);
			deck.setContainer(imageView);
			deck.setValue(i);
			deck.setSuit(2);

			scrambled.add(deck);
		}

		for (int i = 1; i <= 13; i++) {
			Deck deck = new Deck();

			FileInputStream inputstream = new FileInputStream(
					"C:\\Users\\leoco\\eclipse-workspace\\FreeCell\\src\\assets\\cards\\clubs\\" + i + ".png");
			Image image = new Image(inputstream);
			ImageView imageView = new ImageView(image);
			imageView.setFitHeight(120);
			imageView.setFitWidth(92);
			deck.setContainer(imageView);
			deck.setValue(i);
			deck.setSuit(3);

			scrambled.add(deck);
		}

	}

	//Função usada para embaralhar as cartas, fazendo com que
	//fiquem aleatórias nas pilhas
	public void shuffle() {
		Random random = new Random();
		int num1;

		for (int i = 52; i > 0; i--) {
			num1 = random.nextInt(i);
			list.add(scrambled.remove(num1));
		}
	}

	//Adicionando as cartas nos gerenciadores de layout e nas pilhas
	//para poderem aparecer visualmente no programa
	@SuppressWarnings("static-access")
	public void heap() {
		Random random2 = new Random();
		int num2;

		for (int i = 51; i >= 0; i--) {
			num2 = random2.nextInt(8);

			switch (num2) {
			case 0:
				pile1.include(list.get(i).getContainer());
				anchor1.getChildren().add(list.get(i).getContainer());
				anchor1.setTopAnchor(list.get(i).getContainer(), y1);
				anchor1.setLeftAnchor(list.get(i).getContainer(), x1);

				y1 += 20;

				break;
			case 1:
				pile2.include(list.get(i).getContainer());
				anchor2.getChildren().add(list.get(i).getContainer());
				anchor2.setTopAnchor(list.get(i).getContainer(), y2);
				anchor2.setLeftAnchor(list.get(i).getContainer(), x2);

				y2 += 20;

				break;
			case 2:
				pile3.include(list.get(i).getContainer());
				anchor3.getChildren().add(list.get(i).getContainer());
				anchor3.setTopAnchor(list.get(i).getContainer(), y3);
				anchor3.setLeftAnchor(list.get(i).getContainer(), x3);

				y3 += 20;

				break;
			case 3:
				pile4.include(list.get(i).getContainer());
				anchor4.getChildren().add(list.get(i).getContainer());
				anchor4.setTopAnchor(list.get(i).getContainer(), y4);
				anchor4.setLeftAnchor(list.get(i).getContainer(), x4);

				y4 += 20;

				break;
			case 4:
				pile5.include(list.get(i).getContainer());
				anchor5.getChildren().add(list.get(i).getContainer());
				anchor5.setTopAnchor(list.get(i).getContainer(), y5);
				anchor5.setLeftAnchor(list.get(i).getContainer(), x5);

				y5 += 20;

				break;
			case 5:
				pile6.include(list.get(i).getContainer());
				anchor6.getChildren().add(list.get(i).getContainer());
				anchor6.setTopAnchor(list.get(i).getContainer(), y6);
				anchor6.setLeftAnchor(list.get(i).getContainer(), x6);

				y6 += 20;

				break;
			case 6:
				pile7.include(list.get(i).getContainer());
				anchor7.getChildren().add(list.get(i).getContainer());
				anchor7.setTopAnchor(list.get(i).getContainer(), y7);
				anchor7.setLeftAnchor(list.get(i).getContainer(), x7);

				y7 += 20;

				break;
			case 7:
				pile8.include(list.get(i).getContainer());
				anchor8.getChildren().add(list.get(i).getContainer());
				anchor8.setTopAnchor(list.get(i).getContainer(), y8);
				anchor8.setLeftAnchor(list.get(i).getContainer(), x8);

				y8 += 20;

				break;

			}
		}
	}

	//Função chamada para receber a carta a ser removida da pilha
	//afim de transferi-la para outra pilha
	public boolean isSelect() {
		if (selectedCard == null) {
			return false;
		}
		return true;
	}

	//Função usada para comparar a cor da última carta na pilha
	//com a carta a ser adicionada
	public int Color(int a) {
		if (a == 0 || a == 1) {
			return red;
		} else {
			return black;
		}
	}

	//Função usada afim de retornar a carta a sua pilha original caso
	//ela não atenda a "cor" ou ao "valor" exigidos
	@SuppressWarnings("static-access")
	public void goBack(int n, ImageView s) {
		switch (n) {
		case 1:
			anchor1.getChildren().add(s);
			anchor1.setTopAnchor(s, y1);
			anchor1.setLeftAnchor(s, x1);
			pile1.include(s);

			y1 += 20;
			rectangleB1.setY(y1 + 150);
			break;
		case 2:
			anchor2.getChildren().add(s);
			anchor2.setTopAnchor(s, y2);
			anchor2.setLeftAnchor(s, x2);
			pile2.include(s);

			y2 += 20;
			rectangleB2.setY(y2 + 150);
			break;
		case 3:
			anchor3.getChildren().add(s);
			anchor3.setTopAnchor(s, y3);
			anchor3.setLeftAnchor(s, x3);
			pile3.include(s);

			y3 += 20;
			rectangleB3.setY(y3 + 150);
			break;
		case 4:
			anchor4.getChildren().add(s);
			anchor4.setTopAnchor(s, y4);
			anchor4.setLeftAnchor(s, x4);
			pile4.include(s);

			y4 += 20;
			rectangleB4.setY(y4 + 150);
			break;
		case 5:
			anchor5.getChildren().add(s);
			anchor5.setTopAnchor(s, y5);
			anchor5.setLeftAnchor(s, x5);
			pile5.include(s);

			y5 += 20;
			rectangleB5.setY(y5 + 150);
			break;
		case 6:
			anchor6.getChildren().add(s);
			anchor6.setTopAnchor(s, y6);
			anchor6.setLeftAnchor(s, x6);
			pile6.include(s);

			y6 += 20;
			rectangleB6.setY(y6 + 150);
			break;
		case 7:
			anchor7.getChildren().add(s);
			anchor7.setTopAnchor(s, y7);
			anchor7.setLeftAnchor(s, x7);
			pile7.include(s);

			y7 += 20;
			rectangleB7.setY(y7 + 150);
			break;
		case 8:
			anchor8.getChildren().add(s);
			anchor8.setTopAnchor(s, y8);
			anchor8.setLeftAnchor(s, x8);
			pile8.include(s);

			y8 += 20;
			rectangleB8.setY(y8 + 150);
			break;
		case 9:
			anchorBL1.getChildren().add(s);
			anchorBL1.setTopAnchor(s, 10.0);
			anchorBL1.setLeftAnchor(s, 50.0);
			break;
		case 10:
			anchorBL2.getChildren().add(s);
			anchorBL2.setTopAnchor(s, 10.0);
			anchorBL2.setLeftAnchor(s, 164.0);
			break;
		case 11:
			anchorBL3.getChildren().add(s);
			anchorBL3.setTopAnchor(s, 10.0);
			anchorBL3.setLeftAnchor(s, 279.0);
			break;
		case 12:
			anchorBL4.getChildren().add(s);
			anchorBL4.setTopAnchor(s, 10.0);
			anchorBL4.setLeftAnchor(s, 393.0);
			break;
		}
	}

	//Função que reseta todos os atributos 
	public void reset() {
		selectedCard = null;
		suit = 0;
		value = 0;
		back = 0;

		rectangleB1.setFill(Color.RED);
		rectangleB2.setFill(Color.RED);
		rectangleB3.setFill(Color.RED);
		rectangleB4.setFill(Color.RED);
		rectangleB5.setFill(Color.RED);
		rectangleB6.setFill(Color.RED);
		rectangleB7.setFill(Color.RED);
		rectangleB8.setFill(Color.RED);
		rectangleBL1.setFill(Color.RED);
		rectangleBL2.setFill(Color.RED);
		rectangleBL3.setFill(Color.RED);
		rectangleBL4.setFill(Color.RED);
		rectangleBR1.setFill(Color.RED);
		rectangleBR2.setFill(Color.RED);
		rectangleBR3.setFill(Color.RED);
		rectangleBR4.setFill(Color.RED);
	}

	//rectangles uasdos como botões na parte de baixo
	Rectangle rectangleB1 = new Rectangle(widthB, heightB);
	Rectangle rectangleB2 = new Rectangle(widthB, heightB);
	Rectangle rectangleB3 = new Rectangle(widthB, heightB);
	Rectangle rectangleB4 = new Rectangle(widthB, heightB);
	Rectangle rectangleB5 = new Rectangle(widthB, heightB);
	Rectangle rectangleB6 = new Rectangle(widthB, heightB);
	Rectangle rectangleB7 = new Rectangle(widthB, heightB);
	Rectangle rectangleB8 = new Rectangle(widthB, heightB);

	//rectangles usados como botões nas pilhas intermediárias
	Rectangle rectangleBL1 = new Rectangle(65, heightBL, 60, 20);
	Rectangle rectangleBL2 = new Rectangle(180, heightBL, 60, 20);
	Rectangle rectangleBL3 = new Rectangle(290, heightBL, 60, 20);
	Rectangle rectangleBL4 = new Rectangle(405, heightBL, 60, 20);
	Rectangle rectangleBR1 = new Rectangle(525, heightBL, 60, 20);
	Rectangle rectangleBR2 = new Rectangle(635, heightBL, 60, 20);
	Rectangle rectangleBR3 = new Rectangle(750, heightBL, 60, 20);
	Rectangle rectangleBR4 = new Rectangle(865, heightBL, 60, 20);

	//Função start
	@SuppressWarnings("static-access")
	public void start(Stage stage) throws FileNotFoundException {

		//Implementação das funções
		addSuits();
		put();
		shuffle();
		heap();

		AnchorPane anchor = new AnchorPane();

		//retangulos usados para formar o visual do jogo
		Rectangle rectangleCentral = new Rectangle(width, height);
		rectangleCentral.setTranslateX(0);
		rectangleCentral.setTranslateY(0);
		rectangleCentral.setFill(Color.DARKGREEN);

		Rectangle rectangle1UL = new Rectangle(widthRect, heightRect);
		rectangle1UL.setStroke(Color.BLACK);
		rectangle1UL.setStrokeWidth(2.0);
		rectangle1UL.setFill(Color.FORESTGREEN);

		Rectangle rectangle2UL = new Rectangle(widthRect, heightRect);
		rectangle2UL.setStroke(Color.BLACK);
		rectangle2UL.setStrokeWidth(2.0);
		rectangle2UL.setFill(Color.FORESTGREEN);

		Rectangle rectangle3UL = new Rectangle(widthRect, heightRect);
		rectangle3UL.setStroke(Color.BLACK);
		rectangle3UL.setStrokeWidth(2.0);
		rectangle3UL.setFill(Color.FORESTGREEN);

		Rectangle rectangle4UL = new Rectangle(widthRect, heightRect);
		rectangle4UL.setStroke(Color.BLACK);
		rectangle4UL.setStrokeWidth(2.0);
		rectangle4UL.setFill(Color.FORESTGREEN);

		Line line = new Line();
		line.setFill(Color.BLACK);
		line.setStartX(495);
		line.setStartY(0);
		line.setEndX(495);
		line.setEndY(170);

		Rectangle rectangle5UR = new Rectangle(widthRect, heightRect);
		rectangle5UR.setStroke(Color.BLACK);
		rectangle5UR.setStrokeWidth(2.0);
		rectangle5UR.setFill(Color.FORESTGREEN);

		Rectangle rectangle6UR = new Rectangle(widthRect, heightRect);
		rectangle6UR.setStroke(Color.BLACK);
		rectangle6UR.setStrokeWidth(2.0);
		rectangle6UR.setFill(Color.FORESTGREEN);

		Rectangle rectangle7UR = new Rectangle(widthRect, heightRect);
		rectangle7UR.setStroke(Color.BLACK);
		rectangle7UR.setStrokeWidth(2.0);
		rectangle7UR.setFill(Color.FORESTGREEN);

		Rectangle rectangle8UR = new Rectangle(widthRect, heightRect);
		rectangle8UR.setStroke(Color.BLACK);
		rectangle8UR.setStrokeWidth(2.0);
		rectangle8UR.setFill(Color.FORESTGREEN);

		Line line2 = new Line();
		line2.setFill(Color.BLACK);
		line2.setStartX(0);
		line2.setStartY(170);
		line2.setEndX(1000);
		line2.setEndY(170);

		//Gerenciador de layout que junta os retangulos correspondentes as pilhas
		HBox hbox = new HBox(20, rectangle1UL, rectangle2UL, rectangle3UL, rectangle4UL, rectangle5UR, rectangle6UR,
				rectangle7UR, rectangle8UR);

		Rectangle rectangle9D = new Rectangle(widthRect, heightRect);
		rectangle9D.setStroke(Color.BLACK);
		rectangle9D.setStrokeWidth(2.0);
		rectangle9D.setFill(Color.FORESTGREEN);

		Rectangle rectangle10D = new Rectangle(widthRect, heightRect);
		rectangle10D.setStroke(Color.BLACK);
		rectangle10D.setStrokeWidth(2.0);
		rectangle10D.setFill(Color.FORESTGREEN);

		Rectangle rectangle11D = new Rectangle(widthRect, heightRect);
		rectangle11D.setStroke(Color.BLACK);
		rectangle11D.setStrokeWidth(2.0);
		rectangle11D.setFill(Color.FORESTGREEN);

		Rectangle rectangle12D = new Rectangle(widthRect, heightRect);
		rectangle12D.setStroke(Color.BLACK);
		rectangle12D.setStrokeWidth(2.0);
		rectangle12D.setFill(Color.FORESTGREEN);

		Rectangle rectangle13D = new Rectangle(widthRect, heightRect);
		rectangle13D.setStroke(Color.BLACK);
		rectangle13D.setStrokeWidth(2.0);
		rectangle13D.setFill(Color.FORESTGREEN);

		Rectangle rectangle14D = new Rectangle(widthRect, heightRect);
		rectangle14D.setStroke(Color.BLACK);
		rectangle14D.setStrokeWidth(2.0);
		rectangle14D.setFill(Color.FORESTGREEN);

		Rectangle rectangle15D = new Rectangle(widthRect, heightRect);
		rectangle15D.setStroke(Color.BLACK);
		rectangle15D.setStrokeWidth(2.0);
		rectangle15D.setFill(Color.FORESTGREEN);

		Rectangle rectangle16D = new Rectangle(widthRect, heightRect);
		rectangle16D.setStroke(Color.BLACK);
		rectangle16D.setStrokeWidth(2.0);
		rectangle16D.setFill(Color.FORESTGREEN);

		HBox hbox2 = new HBox(10, rectangle9D, rectangle10D, rectangle11D, rectangle12D, rectangle13D, rectangle14D,
				rectangle15D, rectangle16D);

		anchor.getChildren().addAll(hbox, hbox2, line, line2);
		anchor.setLeftAnchor(hbox, 50.0);
		anchor.setTopAnchor(hbox, 10.0);
		anchor.setTopAnchor(hbox2, 200.0);
		anchor.setLeftAnchor(hbox2, 70.0);

		//Botões usados no jogo
		rectangleBL1.setStroke(Color.BLACK);
		rectangleBL1.setStrokeWidth(2.0);
		rectangleBL1.setFill(Color.RED);

		rectangleBL2.setStroke(Color.BLACK);
		rectangleBL2.setStrokeWidth(2.0);
		rectangleBL2.setFill(Color.RED);

		rectangleBL3.setStroke(Color.BLACK);
		rectangleBL3.setStrokeWidth(2.0);
		rectangleBL3.setFill(Color.RED);

		rectangleBL4.setStroke(Color.BLACK);
		rectangleBL4.setStrokeWidth(2.0);
		rectangleBL4.setFill(Color.RED);

		rectangleBR1.setStroke(Color.BLACK);
		rectangleBR1.setStrokeWidth(2.0);
		rectangleBR1.setFill(Color.RED);

		rectangleBR2.setStroke(Color.BLACK);
		rectangleBR2.setStrokeWidth(2.0);
		rectangleBR2.setFill(Color.RED);

		rectangleBR3.setStroke(Color.BLACK);
		rectangleBR3.setStrokeWidth(2.0);
		rectangleBR3.setFill(Color.RED);

		rectangleBR4.setStroke(Color.BLACK);
		rectangleBR4.setStrokeWidth(2.0);
		rectangleBR4.setFill(Color.RED);

		//Botões nas pilhas normais
		rectangleB1.setX(x1);
		rectangleB1.setY(y1 + 150);
		rectangleB1.setStroke(Color.BLACK);
		rectangleB1.setStrokeWidth(2.0);
		rectangleB1.setFill(Color.RED);

		rectangleB2.setX(x2);
		rectangleB2.setY(y2 + 150);
		rectangleB2.setStroke(Color.BLACK);
		rectangleB2.setStrokeWidth(2.0);
		rectangleB2.setFill(Color.RED);

		rectangleB3.setX(x3);
		rectangleB3.setY(y3 + 150);
		rectangleB3.setStroke(Color.BLACK);
		rectangleB3.setStrokeWidth(2.0);
		rectangleB3.setFill(Color.RED);

		rectangleB4.setX(x4);
		rectangleB4.setY(y4 + 150);
		rectangleB4.setStroke(Color.BLACK);
		rectangleB4.setStrokeWidth(2.0);
		rectangleB4.setFill(Color.RED);

		rectangleB5.setX(x5);
		rectangleB5.setY(y5 + 150);
		rectangleB5.setStroke(Color.BLACK);
		rectangleB5.setStrokeWidth(2.0);
		rectangleB5.setFill(Color.RED);

		rectangleB6.setX(x6);
		rectangleB6.setY(y6 + 150);
		rectangleB6.setStroke(Color.BLACK);
		rectangleB6.setStrokeWidth(2.0);
		rectangleB6.setFill(Color.RED);

		rectangleB7.setX(x7);
		rectangleB7.setY(y7 + 150);
		rectangleB7.setStroke(Color.BLACK);
		rectangleB7.setStrokeWidth(2.0);
		rectangleB7.setFill(Color.RED);

		rectangleB8.setX(x8);
		rectangleB8.setY(y8 + 150);
		rectangleB8.setStroke(Color.BLACK);
		rectangleB8.setStrokeWidth(2.0);
		rectangleB8.setFill(Color.RED);

		//Setando os eventos de mouse nos botões
		rectangleB1.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			//Se nenhuma carta tiver sido selecionada ele remove da pilha
			//afim de adicionar em outra
			if (!isSelect()) {
				for (int i = 0; i <= 51; i++) {
					if (list.get(i).getContainer().equals(pile1.spy())) {
						rectangleB1.setFill(Color.BLUE);
						selectedCard = pile1.spy();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 1;
						anchor1.getChildren().remove(anchor1.getChildren().size() - 1);
						pile1.unStack();

						y1 -= 20;
						rectangleB1.setY(y1 + 150);

						break;
					}
				}

			//Se alguma carta tiver sido selecionada, ele primeiramente verifica se ela esta vazia,
			//se não, ele verifica se ela atende quanto a "cor" e "valor" exigidos
			} else {
				if(anchor1.getChildren().isEmpty()) {
					pile1.include(selectedCard);
					anchor1.getChildren().add(selectedCard);
					anchor1.setTopAnchor(selectedCard, y1);
					anchor1.setLeftAnchor(selectedCard, x1);

					y1 += 20;
					rectangleB1.setY(y1 + 150);

					reset();
				}else {
				for (int i = 0; i <= 51; i++) {
					if (list.get(i).getContainer().equals(pile1.spy())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pile1.include(selectedCard);
								anchor1.getChildren().add(selectedCard);
								anchor1.setTopAnchor(selectedCard, y1);
								anchor1.setLeftAnchor(selectedCard, x1);

								y1 += 20;
								rectangleB1.setY(y1 + 150);

								reset();

								break;
							} else {
								goBack(back, selectedCard);
								reset();

								break;
							}
						} else {
							goBack(back, selectedCard);
							reset();

							break;
						}
					}
				}
			}
			}
		});
		rectangleB2.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 0; i <= 51; i++) {
					if (list.get(i).getContainer().equals(pile2.spy())) {
						rectangleB2.setFill(Color.BLUE);
						selectedCard = pile2.spy();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 2;
						anchor2.getChildren().remove(anchor2.getChildren().size() - 1);
						pile2.unStack();

						y2 -= 20;
						rectangleB2.setY(y2 + 150);

						break;
					}
				}

			} else {
				if(anchor2.getChildren().isEmpty()) {
					pile2.include(selectedCard);
					anchor2.getChildren().add(selectedCard);
					anchor2.setTopAnchor(selectedCard, y2);
					anchor2.setLeftAnchor(selectedCard, x2);

					y2 += 20;
					rectangleB2.setY(y2 + 150);

					reset();
				}else {
				for (int i = 0; i <= 51; i++) {
					if (list.get(i).getContainer().equals(pile2.spy())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pile2.include(selectedCard);
								anchor2.getChildren().add(selectedCard);
								anchor2.setTopAnchor(selectedCard, y2);
								anchor2.setLeftAnchor(selectedCard, x2);

								y2 += 20;
								rectangleB2.setY(y2 + 150);

								reset();

								break;
							} else {
								goBack(back, selectedCard);
								reset();

								break;
							}
						} else {
							goBack(back, selectedCard);
							reset();

							break;
						}

					}
				}
				}
			}
		});
		rectangleB3.addEventFilter(MouseEvent.MOUSE_CLICKED, e ->{
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pile3.spy())) {
						rectangleB3.setFill(Color.BLUE);
						selectedCard = pile3.spy();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 3;
						anchor3.getChildren().remove(anchor3.getChildren().size() - 1);
						pile3.unStack();

						y3 -= 20;
						rectangleB3.setY(y3 + 150);

						break;
					}
				}

			} else {
				if(anchor3.getChildren().isEmpty()) {
					pile3.include(selectedCard);
					anchor3.getChildren().add(selectedCard);
					anchor3.setTopAnchor(selectedCard, y3);
					anchor3.setLeftAnchor(selectedCard, x3);

					y3 += 20;
					rectangleB3.setY(y3 + 150);

					reset();
				}else {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pile3.spy())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pile3.include(selectedCard);
								anchor3.getChildren().add(selectedCard);
								anchor3.setTopAnchor(selectedCard, y3);
								anchor3.setLeftAnchor(selectedCard, x3);

								y3 += 20;
								rectangleB3.setY(y3 + 150);

								reset();

								break;
							} else {
								goBack(back, selectedCard);
								reset();

								break;
							}
						} else {
							goBack(back, selectedCard);
							reset();

							break;
						}
					}
				}
				}
			}
		});
		rectangleB4.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pile4.spy())) {
						rectangleB4.setFill(Color.BLUE);
						selectedCard = pile4.spy();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 4;
						anchor4.getChildren().remove(anchor4.getChildren().size() - 1);
						pile4.unStack();

						y4 -= 20;
						rectangleB4.setY(y4 + 150);

						break;
					}
				}

			} else {
				if(anchor4.getChildren().isEmpty()) {
					pile4.include(selectedCard);
					anchor4.getChildren().add(selectedCard);
					anchor4.setTopAnchor(selectedCard, y4);
					anchor4.setLeftAnchor(selectedCard, x4);

					y4 += 20;
					rectangleB4.setY(y4 + 150);

					reset();
				}else {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pile4.spy())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pile4.include(selectedCard);
								anchor4.getChildren().add(selectedCard);
								anchor4.setTopAnchor(selectedCard, y4);
								anchor4.setLeftAnchor(selectedCard, x4);

								y4 += 20;
								rectangleB4.setY(y4 + 150);

								reset();

								break;
							} else {
								goBack(back, selectedCard);
								reset();

								break;
							}
						} else {
							goBack(back, selectedCard);
							reset();

							break;
						}
					}
				}
				}
			}
		});
		rectangleB5.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pile5.spy())) {
						rectangleB5.setFill(Color.BLUE);
						selectedCard = pile5.spy();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 5;
						anchor5.getChildren().remove(anchor5.getChildren().size() - 1);
						pile5.unStack();

						y5 -= 20;
						rectangleB5.setY(y5 + 150);

						break;
					}
				}

			} else {
				if(anchor5.getChildren().isEmpty()) {
					pile5.include(selectedCard);
					anchor5.getChildren().add(selectedCard);
					anchor5.setTopAnchor(selectedCard, y5);
					anchor5.setLeftAnchor(selectedCard, x5);

					y5 += 20;
					rectangleB5.setY(y5 + 150);

					reset();
				}else {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pile5.spy())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pile5.include(selectedCard);
								anchor5.getChildren().add(selectedCard);
								anchor5.setTopAnchor(selectedCard, y5);
								anchor5.setLeftAnchor(selectedCard, x5);

								y5 += 20;
								rectangleB5.setY(y5 + 150);

								reset();

								break;
							} else {
								goBack(back, selectedCard);
								reset();

								break;
							}
						} else {
							goBack(back, selectedCard);
							reset();

							break;
						}
					}
				}
				}
			}
		});
		rectangleB6.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pile6.spy())) {
						rectangleB6.setFill(Color.BLUE);
						selectedCard = pile6.spy();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 6;
						anchor6.getChildren().remove(anchor6.getChildren().size() - 1);
						pile6.unStack();

						y6 -= 20;
						rectangleB6.setY(y6 + 150);

						break;
					}
				}

			} else {
				if(anchor6.getChildren().isEmpty()) {
					pile6.include(selectedCard);
					anchor6.getChildren().add(selectedCard);
					anchor6.setTopAnchor(selectedCard, y6);
					anchor6.setLeftAnchor(selectedCard, x6);

					y6 += 20;
					rectangleB6.setY(y6 + 150);

					reset();
				}else {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pile6.spy())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pile6.include(selectedCard);
								anchor6.getChildren().add(selectedCard);
								anchor6.setTopAnchor(selectedCard, y6);
								anchor6.setLeftAnchor(selectedCard, x6);

								y6 += 20;
								rectangleB6.setY(y6 + 150);

								reset();

								break;
							} else {
								goBack(back, selectedCard);
								reset();

								break;
							}
						} else {
							goBack(back, selectedCard);
							reset();

							break;
						}
					}
				}
				}
			}
		});
		rectangleB7.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pile7.spy())) {
						rectangleB7.setFill(Color.BLUE);
						selectedCard = pile7.spy();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 7;
						anchor7.getChildren().remove(anchor7.getChildren().size() - 1);
						pile7.unStack();

						y7 -= 20;
						rectangleB7.setY(y7 + 150);

						break;
					}
				}

			} else {
				if(anchor7.getChildren().isEmpty()) {
					pile7.include(selectedCard);
					anchor7.getChildren().add(selectedCard);
					anchor7.setTopAnchor(selectedCard, y7);
					anchor7.setLeftAnchor(selectedCard, x7);

					y7 += 20;
					rectangleB7.setY(y7 + 150);

					reset();
				}else {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pile7.spy())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pile7.include(selectedCard);
								anchor7.getChildren().add(selectedCard);
								anchor7.setTopAnchor(selectedCard, y7);
								anchor7.setLeftAnchor(selectedCard, x7);

								y7 += 20;
								rectangleB7.setY(y7 + 150);

								reset();

								break;
							} else {
								goBack(back, selectedCard);
								reset();

								break;
							}
						} else {
							goBack(back, selectedCard);
							reset();

							break;
						}
					}
				}
				}
			}
		});
		rectangleB8.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pile8.spy())) {
						rectangleB8.setFill(Color.BLUE);
						selectedCard = pile8.spy();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 8;
						anchor8.getChildren().remove(anchor8.getChildren().size() - 1);
						pile8.unStack();

						y8 -= 20;
						rectangleB8.setY(y8 + 150);

						break;
					}
				}

			} else {
				if(anchor8.getChildren().isEmpty()) {
					pile8.include(selectedCard);
					anchor8.getChildren().add(selectedCard);
					anchor8.setTopAnchor(selectedCard, y8);
					anchor8.setLeftAnchor(selectedCard, x8);

					y8 += 20;
					rectangleB8.setY(y8 + 150);

					reset();
				}else {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(pile8.spy())) {
						if (Color(suit) != Color(list.get(i).getSuit())) {
							if (value == list.get(i).getValue() - 1) {
								pile8.include(selectedCard);
								anchor8.getChildren().add(selectedCard);
								anchor8.setTopAnchor(selectedCard, y8);
								anchor8.setLeftAnchor(selectedCard, x8);

								y8 += 20;
								rectangleB8.setY(y8 + 150);

								reset();

								break;
							} else {
								goBack(back, selectedCard);
								reset();

								break;
							}
						} else {
							goBack(back, selectedCard);
							reset();

							break;
						}
					}
				}
				}
			}
		});

		//Eventos dos botões das pilhas intermediárias
		//se nenhuma carta estiver selecionada, ele remove da pilha afim de adicionar em outra
		rectangleBL1.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(anchorBL1.getChildren().get(0))) {
						rectangleBL1.setFill(Color.BLUE);
						selectedCard = list.get(i).getContainer();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 9;
						anchorBL1.getChildren().remove(0);

						break;
					}
				}

			//Se não, ele verifica se ela está vazia afim de adicionar na pilha
			} else {
				if (anchorBL1.getChildren().isEmpty()) {
					anchorBL1.getChildren().add(selectedCard);
					anchorBL1.setTopAnchor(selectedCard, 10.0);
					anchorBL1.setLeftAnchor(selectedCard, 50.0);

					reset();
				} else {
					goBack(back, selectedCard);
					reset();

				}
			}
		});
		rectangleBL2.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(anchorBL2.getChildren().get(0))) {
						rectangleBL2.setFill(Color.BLUE);
						selectedCard = list.get(i).getContainer();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 10;
						anchorBL2.getChildren().remove(0);

						break;
					}
				}

			} else {
				if (anchorBL2.getChildren().isEmpty()) {
					anchorBL2.getChildren().add(selectedCard);
					anchorBL2.setTopAnchor(selectedCard, 10.0);
					anchorBL2.setLeftAnchor(selectedCard, 164.0);

					reset();
				} else {
					goBack(back, selectedCard);
					reset();

				}
			}
		});
		rectangleBL3.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(anchorBL3.getChildren().get(0))) {
						rectangleBL3.setFill(Color.BLUE);
						selectedCard = list.get(i).getContainer();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 11;
						anchorBL3.getChildren().remove(0);

						break;
					}
				}

			} else {
				if (anchorBL3.getChildren().isEmpty()) {
					anchorBL3.getChildren().add(selectedCard);
					anchorBL3.setTopAnchor(selectedCard, 10.0);
					anchorBL3.setLeftAnchor(selectedCard, 279.0);

					reset();
				} else {
					goBack(back, selectedCard);
					reset();

				}
			}
		});
		rectangleBL4.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (!isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (list.get(i).getContainer().equals(anchorBL4.getChildren().get(0))) {
						rectangleBL4.setFill(Color.BLUE);
						selectedCard = list.get(i).getContainer();
						suit = list.get(i).getSuit();
						value = list.get(i).getValue();
						back = 12;
						anchorBL4.getChildren().remove(0);

						break;
					}
				}

			} else {
				if (anchorBL4.getChildren().isEmpty()) {
					anchorBL4.getChildren().add(selectedCard);
					anchorBL4.setTopAnchor(selectedCard, 10.0);
					anchorBL4.setLeftAnchor(selectedCard, 393.0);

					reset();
				} else {
					goBack(back, selectedCard);
					reset();

				}
			}
		});

		//Eventos dos botões das pilhas definitivas
		rectangleBR1.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (value == diamond) { //Só adiciona na pilha se ele corresponder ao valor
						//da variável "diamond" e ao naipe exigidos
						if (suit == 0) {
							anchorBR1.getChildren().add(selectedCard);
							anchorBR1.setTopAnchor(selectedCard, 10.0);
							anchorBR1.setLeftAnchor(selectedCard, 505.0);
							
							diamond++;
							reset();
							break;
						} else {
							goBack(back, selectedCard);
							reset();

						}
					}else{
						goBack(back, selectedCard);
						reset();
					}
				}
			}
		});

		rectangleBR2.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (value == hearts) {
						if (suit == 1) {
							anchorBR2.getChildren().add(selectedCard);
							anchorBR2.setTopAnchor(selectedCard, 10.0);
							anchorBR2.setLeftAnchor(selectedCard, 620.0);
							
							hearts++;
							reset();
							break;
						} else {
							goBack(back, selectedCard);
							reset();

						}
					}else{
						goBack(back, selectedCard);
						reset();
					}
				}
			}
		});

		rectangleBR3.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (value == spades) {
						if (suit == 2) {
							anchorBR3.getChildren().add(selectedCard);
							anchorBR3.setTopAnchor(selectedCard, 10.0);
							anchorBR3.setLeftAnchor(selectedCard, 733.0);
							
							spades++;
							reset();
							break;
						} else {
							goBack(back, selectedCard);
							reset();

						}
					}else{
						goBack(back, selectedCard);
						reset();
					}
				}
			}
		});

		rectangleBR4.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
			if (isSelect()) {
				for (int i = 51; i >= 0; i--) {
					if (value == clubs) {
						if (suit == 3) {
							anchorBR4.getChildren().add(selectedCard);
							anchorBR4.setTopAnchor(selectedCard, 10.0);
							anchorBR4.setLeftAnchor(selectedCard, 848.0);
							
							clubs++;
							reset();
							break;
						} else {
							goBack(back, selectedCard);
							reset();

						}
					}else{
						goBack(back, selectedCard);
						reset();
					}
				}
			}
		});

		//Todos os elementos usados no jogo
		central.getChildren().addAll(rectangleCentral, anchor, anchor1, anchor2, anchor3, anchor4, anchor5, anchor6,
				anchor7, anchor8, rectangleB1, rectangleB2, rectangleB3, rectangleB4, rectangleB5, rectangleB6,
				rectangleB7, rectangleB8, anchorBL1, anchorBL2, anchorBL3, anchorBL4, rectangleBL1, rectangleBL2,
				rectangleBL3, rectangleBL4, rectangleBR1, rectangleBR2, rectangleBR3, rectangleBR4, imageView1,
				imageView2, imageView3, imageView4, anchorBR1, anchorBR2, anchorBR3, anchorBR4);

		Scene scene = new Scene(central, width, height);

		stage.setTitle("Free Cell");
		stage.setScene(scene);
		stage.show();
	}
}