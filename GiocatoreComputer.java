/*     */ class GiocatoreComputer extends Giocatore
/*     */ {
/*     */   public GiocatoreComputer(byte ID)
/*     */   {
/* 554 */     super(ID);
/*     */   }
/*     */ 
/*     */   public String getNome()
/*     */   {
/* 559 */     return "CPU";
/*     */   }
/*     */ 
/*     */   public byte[] calcolaMossa(Scacchiera SCACCHIERA)
/*     */   {
/* 564 */     byte[] coordinate = new byte[2];
/*     */ 
/* 567 */     if (SCACCHIERA.controlloMossa((byte)1, (byte)8, this.ID))
/*     */     {
/* 569 */       coordinate[0] = 1;
/* 570 */       coordinate[1] = 8;
/*     */     }
/* 572 */     else if (SCACCHIERA.controlloMossa((byte)8, (byte)1, this.ID))
/*     */     {
/* 575 */       coordinate[0] = 8;
/* 576 */       coordinate[1] = 1;
/*     */     }
/* 578 */     else if (SCACCHIERA.controlloMossa((byte)1, (byte)1, this.ID))
/*     */     {
/* 580 */       coordinate[0] = 1;
/* 581 */       coordinate[1] = 1;
/*     */     }
/* 583 */     else if (SCACCHIERA.controlloMossa((byte)8, (byte)8, this.ID))
/*     */     {
/* 585 */       coordinate[0] = 8;
/* 586 */       coordinate[1] = 8;
/*     */     }
/*     */     else
/*     */     {
/* 593 */       byte count = 0;
/* 594 */       for (byte n = 1; n <= 8; n = (byte)(n + 1))
/*     */       {
/* 596 */         for (byte m = 1; m <= 8; m = (byte)(m + 1))
/*     */         {
/* 598 */           if (SCACCHIERA.controlloMossa(n, m, this.ID))
/*     */           {
/* 600 */             count = (byte)(count + 1);
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 605 */       byte[] punteggioMossa = new byte[count];
/* 606 */       byte[] cordM = new byte[count];
/* 607 */       byte[] cordN = new byte[count];
/* 608 */       byte k = 0;
/*     */ 
/* 611 */       for (byte n = 1; n <= 8; n = (byte)(n + 1))
/*     */       {
/* 613 */         for (byte m = 1; m <= 8; m = (byte)(m + 1))
/*     */         {
/* 615 */           if (SCACCHIERA.controlloMossa(n, m, this.ID))
/*     */           {
/* 617 */             cordM[k] = m;
/* 618 */             cordN[k] = n;
/* 619 */             k = (byte)(k + 1);
/*     */           }
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 625 */       for (k = 0; k < count; k = (byte)(k + 1))
/*     */       {
/* 628 */         byte punteggio1 = 0;
/* 629 */         byte punteggio2 = 0;
/* 630 */         byte punteggio3 = 0;
/* 631 */         byte punteggio4 = 0;
/* 632 */         byte punteggio5 = 0;
/* 633 */         byte punteggio6 = 0;
/* 634 */         byte punteggio7 = 0;
/* 635 */         byte punteggio8 = 0;
/*     */ 
/* 638 */         for (byte x = 1; x <= 9; x = (byte)(x + 1))
/*     */         {
                    if ((cordN[k] + x) > 9 || (cordM[k] + x) > 9)
                    {
                        break;
                    }
/* 641 */           if (SCACCHIERA.getArray()[(cordN[k] + x)][cordM[k]] == 0)
/*     */           {
/* 643 */             punteggio1 = 0;
/*     */           }
/* 648 */           else if (SCACCHIERA.getArray()[(cordN[k] + x)][cordM[k]] == 1)
/*     */           {
/* 650 */             punteggio1 = (byte)(punteggio1 + 1);
/*     */ 
/* 653 */             if (SCACCHIERA.getArray()[(cordN[k] + x + 1)][cordM[k]] == 2)
/*     */               break;
/*     */           }
/*     */         }
/*     */         byte tmp407_405 = k;
/*     */         byte[] tmp407_403 = punteggioMossa; tmp407_403[tmp407_405] = ((byte)(tmp407_403[tmp407_405] + punteggio1));
/*     */ 
/* 660 */         for (byte x = 1; x <= 9; x = (byte)(x + 1))
/*     */         {
/* 663 */           if (x > cordN[k])
/*     */           {
/*     */             break;
/*     */           }
/* 667 */           if (SCACCHIERA.getArray()[(cordN[k] - x)][cordM[k]] == 0)
/*     */           {
/* 669 */             punteggio2 = 0;
/*     */           }
/* 674 */           else if (SCACCHIERA.getArray()[(cordN[k] - x)][cordM[k]] == 1)
/*     */           {
/* 676 */             punteggio2 = (byte)(punteggio2 + 1);
/*     */ 
/* 679 */             if (SCACCHIERA.getArray()[(cordN[k] - x - 1)][cordM[k]] == 2)
/*     */               break;
/*     */           }
/*     */         }
/*     */         byte tmp539_537 = k;
/*     */         byte[] tmp539_535 = punteggioMossa; tmp539_535[tmp539_537] = ((byte)(tmp539_535[tmp539_537] + punteggio2));
/*     */ 
/* 686 */         for (byte x = 1; x <= 9; x = (byte)(x + 1))
/*     */         {
/* 689 */           if (x + cordM[k] > 8)
/*     */           {
/*     */             break;
/*     */           }
/* 693 */           if (SCACCHIERA.getArray()[cordN[k]][(cordM[k] + x)] == 0)
/*     */           {
/* 695 */             punteggio3 = 0;
/*     */           }
/*     */ 
/* 699 */           if (SCACCHIERA.getArray()[cordN[k]][(cordM[k] + x)] == 1)
/*     */           {
/* 701 */             punteggio3 = (byte)(punteggio3 + 1);
/*     */ 
/* 704 */             if (SCACCHIERA.getArray()[cordN[k]][(cordM[k] + x + 1)] == 2)
/*     */               break;
/*     */           }
/*     */         }
/*     */         byte tmp669_667 = k;
/*     */         byte[] tmp669_665 = punteggioMossa; tmp669_665[tmp669_667] = ((byte)(tmp669_665[tmp669_667] + punteggio3));
/*     */ 
/* 711 */         for (byte x = 1; x <= 9; x = (byte)(x + 1))
/*     */         {
/* 714 */           if (x > cordM[k])
/*     */           {
/*     */             break;
/*     */           }
/* 718 */           if (SCACCHIERA.getArray()[cordN[k]][(cordM[k] - x)] == 0)
/*     */           {
/* 720 */             punteggio4 = 0;
/*     */           }
/* 725 */           else if (SCACCHIERA.getArray()[cordN[k]][(cordM[k] - x)] == 1)
/*     */           {
/* 727 */             punteggio4 = (byte)(punteggio4 + 1);
/*     */ 
/* 730 */             if (SCACCHIERA.getArray()[cordN[k]][(cordM[k] - x - 1)] == 2)
/*     */               break;
/*     */           }
/*     */         }
/*     */         byte tmp801_799 = k;
/*     */         byte[] tmp801_797 = punteggioMossa; tmp801_797[tmp801_799] = ((byte)(tmp801_797[tmp801_799] + punteggio4));
/*     */ 
/* 737 */         for (byte x = 1; x <= 9; x = (byte)(x + 1))
/*     */         {
                    if ((cordN[k] + x) > 9 || (cordM[k] + x) > 9)
                    {
                        break;
                    }
/* 740 */           if (SCACCHIERA.getArray()[(cordN[k] + x)][(cordM[k] + x)] == 0)
/*     */           {
/* 742 */             punteggio5 = 0;
/*     */           }
/* 747 */           else if (SCACCHIERA.getArray()[(cordN[k] + x)][(cordM[k] + x)] == 1)
/*     */           {
/* 749 */             punteggio5 = (byte)(punteggio5 + 1);
/*     */ 
/* 752 */             if (SCACCHIERA.getArray()[(cordN[k] + x + 1)][(cordM[k] + x + 1)] == 2)
/*     */               break;
/*     */           }
/*     */         }
/*     */         byte tmp929_927 = k;
/*     */         byte[] tmp929_925 = punteggioMossa; tmp929_925[tmp929_927] = ((byte)(tmp929_925[tmp929_927] + punteggio5));
/*     */ 
/* 759 */         for (byte x = 1; x <= 9; x = (byte)(x + 1))
/*     */         {
/* 762 */           if (x > cordM[k] || cordN[k] + x > 9)
/*     */           {
/*     */             break;
/*     */           }
/* 766 */           if (SCACCHIERA.getArray()[(cordN[k] + x)][(cordM[k] - x)] == 0)
/*     */           {
/* 768 */             punteggio6 = 0;
/*     */           }
/* 773 */           else if (SCACCHIERA.getArray()[(cordN[k] + x)][(cordM[k] - x)] == 1)
/*     */           {
/* 775 */             punteggio6 = (byte)(punteggio6 + 1);
/*     */ 
/* 778 */             if (SCACCHIERA.getArray()[(cordN[k] + x + 1)][(cordM[k] - x - 1)] == 2)
/*     */               break;
/*     */           }
/*     */         }
/*     */         byte tmp1072_1070 = k;
/*     */         byte[] tmp1072_1068 = punteggioMossa; tmp1072_1068[tmp1072_1070] = ((byte)(tmp1072_1068[tmp1072_1070] + punteggio6));
/*     */ 
/* 785 */         for (byte x = 1; x <= 9; x = (byte)(x + 1))
/*     */         {
/* 788 */           if (x > cordN[k] || cordM[k] + x > 9)
/*     */           {
/*     */             break;
/*     */           }
/* 792 */           if (SCACCHIERA.getArray()[(cordN[k] - x)][(cordM[k] + x)] == 0)
/*     */           {
/* 794 */             punteggio7 = 0;
/*     */           }
/* 799 */           else if (SCACCHIERA.getArray()[(cordN[k] - x)][(cordM[k] + x)] == 1)
/*     */           {
/* 801 */             punteggio7 = (byte)(punteggio7 + 1);
/*     */ 
/* 804 */             if (SCACCHIERA.getArray()[(cordN[k] - x - 1)][(cordM[k] + x + 1)] == 2)
/*     */               break;
/*     */           }
/*     */         }
/*     */         byte tmp1215_1213 = k;
/*     */         byte[] tmp1215_1211 = punteggioMossa; tmp1215_1211[tmp1215_1213] = ((byte)(tmp1215_1211[tmp1215_1213] + punteggio7));
/*     */ 
/* 811 */         for (byte x = 1; x <= 9; x = (byte)(x + 1))
/*     */         {
/* 814 */           if ((x > cordN[k]) || (x > cordM[k]))
/*     */           {
/*     */             break;
/*     */           }
/* 818 */           if (SCACCHIERA.getArray()[(cordN[k] - x)][(cordM[k] - x)] == 0)
/*     */           {
/* 820 */             punteggio8 = 0;
/*     */           }
/* 825 */           else if (SCACCHIERA.getArray()[(cordN[k] - x)][(cordM[k] - x)] == 1)
/*     */           {
/* 827 */             punteggio8 = (byte)(punteggio8 + 1);
/*     */ 
/* 830 */             if (SCACCHIERA.getArray()[(cordN[k] - x - 1)][(cordM[k] - x - 1)] == 2)
/*     */               break;
/*     */           }
/*     */         }
/*     */         byte tmp1370_1368 = k;
/*     */         byte[] tmp1370_1366 = punteggioMossa; tmp1370_1366[tmp1370_1368] = ((byte)(tmp1370_1366[tmp1370_1368] + punteggio8));
/*     */ 
/* 837 */         if ((cordN[k] == 1) || (cordN[k] == 8) || (cordM[k] == 1) || (cordM[k] == 8))
/*     */         {
/*     */           byte tmp1419_1417 = k;
/*     */           byte[] tmp1419_1415 = punteggioMossa; tmp1419_1415[tmp1419_1417] = ((byte)(tmp1419_1415[tmp1419_1417] + 10));
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 843 */       byte max_k = 0;
/* 844 */       for (k = 0; k < count; k = (byte)(k + 1)) {
/* 845 */         if (punteggioMossa[k] > max_k) {
/* 846 */           max_k = k;
/*     */         }
/*     */       }
/* 849 */       coordinate[0] = cordN[max_k];
/* 850 */       coordinate[1] = cordM[max_k];
/*     */     }
/*     */ 
/* 853 */     return coordinate;
/*     */   }
/*     */ }

/* Location:           /home/shin/Scrivania/Othello.jar
 * Qualified Name:     GiocatoreComputer
 * JD-Core Version:    0.6.2
 */
