/*     */ abstract class Giocatore
/*     */ {
/*     */   protected byte ID;
/*     */ 
/*     */   public Giocatore(byte ID)
/*     */   {
/* 538 */     this.ID = ID;
/*     */   }
/*     */ 
/*     */   public byte getID()
/*     */   {
/* 543 */     return this.ID;
/*     */   }
/*     */ 
/*     */   public abstract String getNome();
/*     */ 
/*     */   public abstract byte[] calcolaMossa(Scacchiera paramScacchiera);
/*     */ }

/* Location:           /home/shin/Scrivania/Othello.jar
 * Qualified Name:     Giocatore
 * JD-Core Version:    0.6.2
 */