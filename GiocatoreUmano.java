/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ class GiocatoreUmano extends Giocatore
/*     */ {
/*     */   private String nome;
/*     */ 
/*     */   public GiocatoreUmano(byte ID, String nome)
/*     */   {
/* 863 */     super(ID);
/* 864 */     this.nome = nome;
/*     */   }
/*     */ 
/*     */   public String getNome()
/*     */   {
/* 869 */     return this.nome;
/*     */   }
/*     */ 
/*     */   public byte[] calcolaMossa(Scacchiera SCACCHIERA)
/*     */   {
/* 874 */     byte[] coordinate = new byte[2];
/*     */     boolean controllo;
/*     */     do
/*     */     {
/* 879 */       coordinate[1] = Byte.parseByte(JOptionPane.showInputDialog(getNome() + " inserisci coordinate X (inserisci 0 per passare il turno)"));
/* 881 */       if (coordinate[1] != 0)
/*     */       {
/* 883 */         coordinate[0] = Byte.parseByte(JOptionPane.showInputDialog("Inserisci coordinate Y"));
/* 884 */         if ((coordinate[0] > 0) && (coordinate[0] <= 8) && (coordinate[1] > 0) && (coordinate[1] <= 8))
/* 885 */           controllo = SCACCHIERA.controlloMossa(coordinate[0], coordinate[1], this.ID);
/*     */         else
/* 887 */           controllo = false;
/*     */       }
/*     */       else
/*     */       {
/* 891 */         coordinate[0] = 0;
/* 892 */         controllo = true;
/*     */       }
/*     */ 
/* 895 */       if (!controllo)
/* 896 */         JOptionPane.showMessageDialog(null, this.nome + " hai inserito delle coordinate non valide!\nDevi inserire coordinate comprese tra 1 e 8 e devi posizionare la nuova pedina\naccanto ad una pedina avversaria ed allineata con una tua pedina.");
/*     */     }
/* 898 */     while (!controllo);
/*     */ 
/* 900 */     return coordinate;
/*     */   }
/*     */ }

/* Location:           /home/shin/Scrivania/Othello.jar
 * Qualified Name:     GiocatoreUmano
 * JD-Core Version:    0.6.2
 */
