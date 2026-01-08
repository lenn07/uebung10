package h2;

public class H2_main {
    public static void main(String[] args) {
		Spielbrett bSpielbrett = new Spielbrett(5);
		bSpielbrett.setBrett(new Feld[][] {{new Feld(false, 'U'),new Feld(false, 'R'), new Feld(false, 'L'),new Feld(false, 'L'), new Feld(false, 'D')},
			                               {new Feld(false, 'L'),new Feld(false, 'R'), new Feld(false, 'L'),new Feld(false, 'L'), new Feld(false, 'D')},
			                               {new Feld(false, 'U'),new Feld(false, 'L'), new Feld(false, 'L'),new Feld(false, 'L'), new Feld(false, 'R')},
			                               {new Feld(false, 'D'),new Feld(false, 'R'), new Feld(false, 'U'),new Feld(false, 'L'), new Feld(false, 'L')},
			                               {new Feld(false, 'U'),new Feld(false, 'R'), new Feld(false, 'L'),new Feld(false, 'D'), new Feld(false, 'D')}});
		Spielstein spielstein = new Spielstein(3, 2, bSpielbrett);
		spielstein.go(6);
	}
}
