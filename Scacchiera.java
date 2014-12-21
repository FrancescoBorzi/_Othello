/*     */ import java.io.PrintStream;
/*     */ 
/*     */ class Scacchiera
/*     */ {
/*  72 */   private static byte[][] SCACCHIERA = new byte[10][10];
/*     */ 
/*     */   public Scacchiera()
/*     */   {
/*  76 */     SCACCHIERA[4][4] = 1;
/*  77 */     SCACCHIERA[4][5] = 2;
/*  78 */     SCACCHIERA[5][4] = 2;
/*  79 */     SCACCHIERA[5][5] = 1;
/*     */   }
/*     */ 
/*     */   public byte[][] getArray()
/*     */   {
/*  85 */     return SCACCHIERA;
/*     */   }
/*     */ 
/*     */   public void elaboraMossa(byte[] coordinate, byte id)
/*     */   {
/*  91 */     byte i = coordinate[0];
/*  92 */     byte j = coordinate[1];
/*     */ 
/*  94 */     SCACCHIERA[i][j] = id;
/*     */ 
/*  96 */     byte c = 0;
/*     */     byte p2;
/*     */     byte p1;
/*  98 */     if (id == 1)
/*     */     {
/* 100 */       p1 = 1;
/* 101 */       p2 = 2;
/*     */     }
/*     */     else
/*     */     {
/* 105 */       p1 = 2;
/* 106 */       p2 = 1;
/*     */     }
/*     */ 
/* 111 */     for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */     {
/* 113 */       if (SCACCHIERA[(i + x)][j] == 0) {
/*     */         break;
/*     */       }
/* 116 */       if (SCACCHIERA[(i + x)][j] == p2)
/*     */       {
/* 118 */         c = (byte)(c + 1);
/* 119 */         if (SCACCHIERA[(i + x + 1)][j] == p1)
/*     */         {
/* 121 */           while (c > 0)
/*     */           {
/* 123 */             SCACCHIERA[(i + x - c + 1)][j] = p1;
/* 124 */             c = (byte)(c - 1);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 130 */     c = 0;
/*     */ 
/* 133 */     for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */     {
/* 135 */       if (x > i) {
/*     */         break;
/*     */       }
/* 138 */       if (SCACCHIERA[(i - x)][j] == 0) {
/*     */         break;
/*     */       }
/* 141 */       if (SCACCHIERA[(i - x)][j] == p2)
/*     */       {
/* 143 */         c = (byte)(c + 1);
/* 144 */         if (SCACCHIERA[(i - x - 1)][j] == p1)
/*     */         {
/* 146 */           while (c > 0)
/*     */           {
/* 148 */             SCACCHIERA[(i - x + c - 1)][j] = p1;
/* 149 */             c = (byte)(c - 1);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 155 */     c = 0;
/*     */ 
/* 158 */     for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */     {
/* 160 */       if (SCACCHIERA[i][(j + x)] == 0) {
/*     */         break;
/*     */       }
/* 163 */       if (SCACCHIERA[i][(j + x)] == p2)
/*     */       {
/* 165 */         c = (byte)(c + 1);
/* 166 */         if (SCACCHIERA[i][(j + x + 1)] == p1)
/*     */         {
/* 168 */           while (c > 0)
/*     */           {
/* 170 */             SCACCHIERA[i][(j + x - c + 1)] = p1;
/* 171 */             c = (byte)(c - 1);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 177 */     c = 0;
/*     */ 
/* 180 */     for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */     {
/* 182 */       if (x > j) {
/*     */         break;
/*     */       }
/* 185 */       if (SCACCHIERA[i][(j - x)] == 0) {
/*     */         break;
/*     */       }
/* 188 */       if (SCACCHIERA[i][(j - x)] == p2)
/*     */       {
/* 190 */         c = (byte)(c + 1);
/* 191 */         if (SCACCHIERA[i][(j - x - 1)] == p1)
/*     */         {
/* 193 */           while (c > 0)
/*     */           {
/* 195 */             SCACCHIERA[i][(j - x + c - 1)] = p1;
/* 196 */             c = (byte)(c - 1);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 202 */     c = 0;
/*     */ 
/* 205 */     for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */     {
/* 207 */       if (SCACCHIERA[(i + x)][(j + x)] == 0) {
/*     */         break;
/*     */       }
/* 210 */       if (SCACCHIERA[(i + x)][(j + x)] == p2)
/*     */       {
/* 212 */         c = (byte)(c + 1);
/* 213 */         if (SCACCHIERA[(i + x + 1)][(j + x + 1)] == p1)
/*     */         {
/* 215 */           while (c > 0)
/*     */           {
/* 217 */             SCACCHIERA[(i + x - c + 1)][(j + x - c + 1)] = p1;
/* 218 */             c = (byte)(c - 1);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 224 */     c = 0;
/*     */ 
/* 227 */     for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */     {
/* 229 */       if (x > j) {
/*     */         break;
/*     */       }
/* 232 */       if (SCACCHIERA[(i + x)][(j - x)] == 0) {
/*     */         break;
/*     */       }
/* 235 */       if (SCACCHIERA[(i + x)][(j - x)] == p2)
/*     */       {
/* 237 */         c = (byte)(c + 1);
/* 238 */         if (SCACCHIERA[(i + x + 1)][(j - x - 1)] == p1)
/*     */         {
/* 240 */           while (c > 0)
/*     */           {
/* 242 */             SCACCHIERA[(i + x - c + 1)][(j - x + c - 1)] = p1;
/* 243 */             c = (byte)(c - 1);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 249 */     c = 0;
/*     */ 
/* 252 */     for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */     {
/* 254 */       if (x > i) {
/*     */         break;
/*     */       }
/* 257 */       if (SCACCHIERA[(i - x)][(j + x)] == 0) {
/*     */         break;
/*     */       }
/* 260 */       if (SCACCHIERA[(i - x)][(j + x)] == p2)
/*     */       {
/* 262 */         c = (byte)(c + 1);
/* 263 */         if (SCACCHIERA[(i - x - 1)][(j + x + 1)] == p1)
/*     */         {
/* 265 */           while (c > 0)
/*     */           {
/* 267 */             SCACCHIERA[(i - x + c - 1)][(j + x - c + 1)] = p1;
/* 268 */             c = (byte)(c - 1);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 274 */     c = 0;
/*     */ 
/* 277 */     for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */     {
/* 279 */       if ((x > i) || (x > i)) {
/*     */         break;
/*     */       }
/* 282 */       if (SCACCHIERA[(i - x)][(j - x)] == 0) {
/*     */         break;
/*     */       }
/* 285 */       if (SCACCHIERA[(i - x)][(j - x)] == p2)
/*     */       {
/* 287 */         c = (byte)(c + 1);
/* 288 */         if (SCACCHIERA[(i - x - 1)][(j - x - 1)] == p1)
/*     */         {
/* 290 */           while (c > 0)
/*     */           {
/* 292 */             SCACCHIERA[(i - x + c - 1)][(j - x + c - 1)] = p1;
/* 293 */             c = (byte)(c - 1);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/* 299 */     c = 0;
/*     */   }
/*     */ 
/*     */   public boolean controlloMossa(byte X, byte Y, byte id)
/*     */   {
/* 306 */     byte i = X;
/* 307 */     byte j = Y;
/*     */ 
/* 309 */     if (SCACCHIERA[i][j] == 0)
/*     */     {
/*     */       byte p2;
/*     */       byte p1;

/* 313 */       if (id == 1)
/*     */       {
/* 315 */         p1 = 1;
/* 316 */         p2 = 2;
/*     */       }
/*     */       else
/*     */       {
/* 320 */         p1 = 2;
/* 321 */         p2 = 1;
/*     */       }
/*     */ 
/* 325 */       if ((SCACCHIERA[(i + 1)][j] != p2) && (SCACCHIERA[i][(j + 1)] != p2) && (SCACCHIERA[(i + 1)][(j + 1)] != p2) && (SCACCHIERA[(i - 1)][j] != p2) && (SCACCHIERA[i][(j - 1)] != p2) && (SCACCHIERA[(i - 1)][(j - 1)] != p2) && (SCACCHIERA[(i + 1)][(j - 1)] != p2) && (SCACCHIERA[(i - 1)][(j + 1)] != p2))
/*     */       {
/* 335 */         return false;
/*     */       }
/*     */ 
/* 341 */       for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */       {
/* 343 */         if (SCACCHIERA[(i + x)][j] == 0) {
/*     */           break;
/*     */         }
/* 346 */         if (SCACCHIERA[(i + x)][j] == p2)
/*     */         {
/* 348 */           if (SCACCHIERA[(i + x + 1)][j] == p1) {
/* 349 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 354 */       for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */       {
/* 356 */         if ((x > i) || (x - i == 0)) {
/*     */           break;
/*     */         }
/* 359 */         if (SCACCHIERA[(i - x)][j] == 0) {
/*     */           break;
/*     */         }
/* 362 */         if (SCACCHIERA[(i - x)][j] == p2)
/*     */         {
/* 364 */           if (SCACCHIERA[(i - x - 1)][j] == p1) {
/* 365 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 370 */       for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */       {
/* 372 */         if (SCACCHIERA[i][(j + x)] == 0) {
/*     */           break;
/*     */         }
/* 375 */         if (SCACCHIERA[i][(j + x)] == p2)
/*     */         {
/* 377 */           if (SCACCHIERA[i][(j + x + 1)] == p1) {
/* 378 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 383 */       for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */       {
/* 385 */         if ((x > j) || (j - x == 0)) {
/*     */           break;
/*     */         }
/* 388 */         if (SCACCHIERA[i][(j - x)] == 0) {
/*     */           break;
/*     */         }
/* 391 */         if (SCACCHIERA[i][(j - x)] == p2)
/*     */         {
/* 394 */           if (SCACCHIERA[i][(j - x - 1)] == p1) {
/* 395 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 400 */       for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */       {
/* 402 */         if (SCACCHIERA[(i + x)][(j + x)] == 0) {
/*     */           break;
/*     */         }
/* 405 */         if (SCACCHIERA[(i + x)][(j + x)] == p2)
/*     */         {
/* 407 */           if (SCACCHIERA[(i + x + 1)][(j + x + 1)] == p1) {
/* 408 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 413 */       for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */       {
/* 415 */         if ((x > j) || (x - j == 0)) {
/*     */           break;
/*     */         }
/* 418 */         if (SCACCHIERA[(i + x)][(j - x)] == 0) {
/*     */           break;
/*     */         }
/* 421 */         if ((SCACCHIERA[(i + x)][(j - x)] == p2) && 
/* 422 */           (SCACCHIERA[(i + x + 1)][(j - x - 1)] == p1)) {
/* 423 */           return true;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/* 428 */       for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */       {
/* 430 */         if ((x > i) || (i - x == 0)) {
/*     */           break;
/*     */         }
/* 433 */         if (SCACCHIERA[(i - x)][(j + x)] == 0) {
/*     */           break;
/*     */         }
/* 436 */         if (SCACCHIERA[(i - x)][(j + x)] == p2)
/*     */         {
/* 438 */           if (SCACCHIERA[(i - x - 1)][(j + x + 1)] == p1) {
/* 439 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */ 
/* 444 */       for (byte x = 1; x <= 8; x = (byte)(x + 1))
/*     */       {
/* 446 */         if ((x > i) || (x > j) || (i - x == 0) || (j - x == 0)) {
/*     */           break;
/*     */         }
/* 449 */         if (SCACCHIERA[(i - x)][(j - x)] == 0) {
/*     */           break;
/*     */         }
/* 452 */         if (SCACCHIERA[(i - x)][(j - x)] == p2)
/*     */         {
/* 454 */           if (SCACCHIERA[(i - x - 1)][(j - x - 1)] == p1) {
/* 455 */             return true;
/*     */           }
/*     */         }
/*     */       }
/* 459 */       return false;
/*     */     }
/*     */ 
/* 462 */     return false;
/*     */   }
/*     */ 
/*     */   public boolean controllaFlusso()
/*     */   {
/* 469 */     for (byte i = 1; i < 9; i = (byte)(i + 1))
/*     */     {
/* 471 */       for (byte j = 1; j < 9; j = (byte)(j + 1))
/*     */       {
/* 473 */         if (SCACCHIERA[i][j] == 0)
/* 474 */           return true;
/*     */       }
/*     */     }
/* 477 */     return false;
/*     */   }
/*     */ 
/*     */   public void stampa(String p1, String p2)
/*     */   {
/* 483 */     System.out.println();
/* 484 */     System.out.println("O * 1 2 3 4 5 6 7 8 x");
/* 485 */     System.out.println("* * * * * * * * * * * * *");
/* 486 */     for (byte i = 1; i < 9; i = (byte)(i + 1))
/*     */     {
/* 488 */       System.out.print(i + " * ");
/* 489 */       for (byte j = 1; j < 9; j = (byte)(j + 1))
/*     */       {
/* 491 */         System.out.print(SCACCHIERA[i][j] + " ");
/*     */       }
/* 493 */       System.out.println();
/*     */     }
/* 495 */     System.out.println("y *\n");
/* 496 */     System.out.println(p1 + ": " + quanti1());
/* 497 */     System.out.println(p2 + ": " + quanti2());
/*     */   }
/*     */ 
/*     */   public byte quanti1()
/*     */   {
/* 504 */     byte count = 0;
/* 505 */     for (int n = 1; n <= 8; n++)
/*     */     {
/* 507 */       for (int m = 1; m <= 8; m++)
/*     */       {
/* 509 */         if (SCACCHIERA[n][m] == 1)
/* 510 */           count = (byte)(count + 1);
/*     */       }
/*     */     }
/* 513 */     return count;
/*     */   }
/*     */ 
/*     */   public byte quanti2()
/*     */   {
/* 519 */     byte count = 0;
/* 520 */     for (int n = 1; n <= 8; n++)
/*     */     {
/* 522 */       for (int m = 1; m <= 8; m++)
/*     */       {
/* 524 */         if (SCACCHIERA[n][m] == 2)
/* 525 */           count = (byte)(count + 1);
/*     */       }
/*     */     }
/* 528 */     return count;
/*     */   }
/*     */ }

/* Location:           /home/shin/Scrivania/Othello.jar
 * Qualified Name:     Scacchiera
 * JD-Core Version:    0.6.2
 */
