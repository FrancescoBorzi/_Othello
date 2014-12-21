/*    */ import javax.swing.JOptionPane;
/*    */ 
/*    */ public class Main
/*    */ {
/*    */   public static void main(String[] args)
/*    */   {
/*  8 */     Scacchiera SCACCHIERA = new Scacchiera();
/*  9 */     byte mod = Byte.parseByte(JOptionPane.showInputDialog("Benvenuto, desideri giocare in modalita' (1)single-player o (2)PvP?"));
/*    */     Giocatore GIOCATORE1;
/*    */     Giocatore GIOCATORE2;
/* 11 */     switch (mod)
/*    */     {
/*    */     case 1:
/* 15 */       String nome = JOptionPane.showInputDialog("Inserisci il tuo nome");
/* 16 */       GIOCATORE1 = new GiocatoreUmano((byte)1, nome);
/* 17 */       GIOCATORE2 = new GiocatoreComputer((byte)2);
/* 18 */       break;
/*    */     case 2:
/* 22 */       String nome1 = JOptionPane.showInputDialog("Giocatore 1: Inserisci il tuo nome");
/* 23 */       GIOCATORE1 = new GiocatoreUmano((byte)1, nome1);
/* 24 */       String nome2 = JOptionPane.showInputDialog("Giocatore 2: Inserisci il tuo nome");
/* 25 */       GIOCATORE2 = new GiocatoreUmano((byte)2, nome2);
/* 26 */       break;
/*    */     default:
/* 31 */       GIOCATORE1 = new GiocatoreUmano((byte)1, "Giocatore");
/* 32 */       GIOCATORE2 = new GiocatoreComputer((byte)2);
/*    */     }
/*    */ 
/* 37 */     while (SCACCHIERA.controllaFlusso())
/*    */     {
/* 39 */       SCACCHIERA.stampa(GIOCATORE1.getNome(), GIOCATORE2.getNome());
/*    */ 
/* 42 */       if ((SCACCHIERA.quanti2() == 0) || (SCACCHIERA.quanti1() == 0)) {
/*    */         break;
/*    */       }
/* 45 */       SCACCHIERA.elaboraMossa(GIOCATORE1.calcolaMossa(SCACCHIERA), (byte)1);
/*    */ 
/* 48 */       if ((!SCACCHIERA.controllaFlusso()) || (SCACCHIERA.quanti2() == 0) || (SCACCHIERA.quanti1() == 0)) {
/*    */         break;
/*    */       }
/* 51 */       SCACCHIERA.stampa(GIOCATORE1.getNome(), GIOCATORE2.getNome());
/*    */ 
/* 53 */       SCACCHIERA.elaboraMossa(GIOCATORE2.calcolaMossa(SCACCHIERA), (byte)2);
/*    */     }
/*    */ 
/* 56 */     SCACCHIERA.stampa(GIOCATORE1.getNome(), GIOCATORE2.getNome());
/*    */ 
/* 59 */     if (SCACCHIERA.quanti1() > SCACCHIERA.quanti2())
/* 60 */       JOptionPane.showMessageDialog(null, GIOCATORE1.getNome() + " ha vinto!");
/* 61 */     if (SCACCHIERA.quanti2() > SCACCHIERA.quanti1())
/* 62 */       JOptionPane.showMessageDialog(null, GIOCATORE2.getNome() + " ha vinto!");
/* 63 */     if (SCACCHIERA.quanti1() == SCACCHIERA.quanti2()) {
/* 64 */       JOptionPane.showMessageDialog(null, "PAREGGIO!");
/*    */     }
/* 66 */     System.exit(0);
/*    */   }
/*    */ }

/* Location:           /home/shin/Scrivania/Othello.jar
 * Qualified Name:     Main
 * JD-Core Version:    0.6.2
 */