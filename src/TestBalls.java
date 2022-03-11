import java.awt.Point;

/**
* Cette classe permet de tester la classe Balls.
*/
public class TestBalls {
	public static void main(String[] args) {
		Point[] Balls = new Point[10];

		/** Génération aléatoire de balles.*/
		for (int i=0;i<10;i++) {
			int x = (int)(Math.random() * 1000);
			int y = (int)(Math.random() * 1000);
		    Balls[i] = new Point(x,y);
		}

		Balls lesballes = new Balls(Balls);
		System.out.println(lesballes);
		lesballes.translater(4,4,5,5);
		System.out.println(lesballes);
		lesballes.reInit();
		System.out.println(lesballes);
		System.out.println(lesballes);
		lesballes.translater(4,4,3,3);
		System.out.println(lesballes);
		lesballes.reInit();
		System.out.println(lesballes);
	}
}
