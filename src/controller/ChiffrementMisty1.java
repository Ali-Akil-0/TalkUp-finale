/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import server.UserDatabase;
import view.PrivateChat;

/**
 *
 * @author smart dynabook
 */
public class ChiffrementMisty1 {
    private Connection conn;
    public final String DATABASE_NAME = "chat_db";
    public final String USERNAME = "root";
    public final String PASSWORD = "";
    public final String URL_MYSQL = "jdbc:mysql://localhost/"+DATABASE_NAME;
    
    public final String USER_TABLE = "user_tb";
    	Frame f;
	Button b1, b2;
	public static String t1, t2, t3, t4,tDecript;
    String T4;
    ClientFrame T3;
      private PreparedStatement pst;
    private ResultSet rs;
    private Statement st;
    
	public String Misty1(String Message, String Sender, String Reciever,String akey) {
            
            
		function hxdx = new function();
			char plaintext1[] = (Message).toCharArray();
			char key[] = (akey).toCharArray();

			if (plaintext1.length < 8) {
				char s[] = new char[8];
				System.arraycopy(plaintext1, 0, s, 0, plaintext1.length);
				plaintext1 = new char[8];
				System.arraycopy(s, 0, plaintext1, 0, 8);
			}
			if (key.length < 16) {
				char k[] = new char[16];
				System.arraycopy(key, 0, k, 0, key.length);
				key = new char[16];
				System.arraycopy(k, 0, key, 0, 16);
			}
			char ciphertext1[] = new char[100];
			hxdx.Encrypt(plaintext1, key, ciphertext1);
                        t3 = String.valueOf(ciphertext1);
			System.out.println(String.valueOf(ciphertext1));
			
		    PrivateChat sender;
		    PrivateChat receiver;     
		    PrivateChat serverHost;
		    
		    String RA,RB;
		    RA=PrivateChat.sender;
		    RB=PrivateChat.receiver;
 
		try {	
			Statement st;
			Connection con;
			PreparedStatement stt;
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat_db","root","");
			st = con.createStatement();
  
            try {
            Class.forName("com.mysql.jdbc.Driver");     
            conn = DriverManager.getConnection(URL_MYSQL, USERNAME, PASSWORD);
            System.out.println("Connect successfull");
            try {
            pst = conn.prepareCall("INSERT INTO message(sender,reciever,message)VALUES('"+Sender+"', '"+Reciever+"' , '"+t3+"' )");
            int kq = pst.executeUpdate();
            if(kq > 0) System.out.println("Insert successful!");
//        
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
                        
        } catch (SQLException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error connection! Lỗi kết nối nhé!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
                          
                        
                        
                         try{
                         String sql = "INSERT INTO message(sender,reciever,message)VALUES(?,?,?)";
			stt = con.prepareStatement(sql);			
			stt.setString(1,Sender);
			stt.setString(2,Reciever);
			stt.setString(3,t3);
                        if(stt.executeUpdate()>0)
			{
			System.out.println("Successful!!!");
			}
			
			
			else {
				
		JOptionPane.showMessageDialog(null, "Error!!");
		
		con.close();}
                         }
                         catch(Exception e){
                             System.out.println(e.getMessage());
                         }
			
			
		}
		catch(Exception ex)
		{
                    System.out.println("Nothing will get in the DB");
			System.out.println(ex);
		}
                char[] EcriptedMessage = t3.toCharArray();
                System.out.println("the encripted message");
                System.out.print(EcriptedMessage);
               
                
                
               /* try{
                    System.out.println("Before DEcripting");
                    char ciphertext2[] = new char[30];
			hxdx.Decrypt(ciphertext1, key, ciphertext2);
                        tDecript = String.valueOf(ciphertext2);
                        System.out.println("Decripted ???? : ");
			System.out.print(tDecript);
                        System.out.println("Decripted ???? : ");
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                return tDecript ; */
                    return t3 ; 
		
	}
        /*
public String Misty1Decrypt(char[] ciphertext1) {
            function hxdx = new function();
            //char key[] = ("11001001").toCharArray();
            char key[] = ("11001001").toCharArray();
            try{
                      System.out.println("Before DEcripting");
                       char ciphertext2[] = new char[30];
			hxdx.Decrypt(ciphertext1, key, ciphertext2);
                        tDecript = String.valueOf(ciphertext2);
                        System.out.println("Decripted ???? : "+String.valueOf(ciphertext2));
			//System.out.print(tDecript);
                       System.out.println("Decripted ???? : ");
                       return tDecript ; 
             }
                catch(Exception e){
                    return e.getMessage();
                }
               // return "test";
}  
 */
        
 	public String Misty1Decrypt(String Message,String akey) {
            
            
		function hxdx = new function();
			char plaintext1[] = (Message).toCharArray();
			char key[] = (akey).toCharArray();

			if (plaintext1.length < 8) {
				char s[] = new char[8];
				System.arraycopy(plaintext1, 0, s, 0, plaintext1.length);
				plaintext1 = new char[8];
				System.arraycopy(s, 0, plaintext1, 0, 8);
			}
			if (key.length < 16) {
				char k[] = new char[16];
				System.arraycopy(key, 0, k, 0, key.length);
				key = new char[16];
				System.arraycopy(k, 0, key, 0, 16);
			}
 
                try{
                    System.out.println("Before DEcripting");
                    char ciphertext2[] = new char[30];
			hxdx.Decrypt(plaintext1, key, ciphertext2);
                        tDecript = String.valueOf(ciphertext2);
                        System.out.println("Decripted ???? : ");
			System.out.print(tDecript);
                        System.out.println("Decripted ???? : ");
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
                return tDecript ; 

		
	}       
        
        
        
        
        
        
        
        
}
class function 
{
	int KO[] = new int[32];
	int KI[] = new int[24];
	long KL[] = new long[10];
	int S7[] = { 27, 50, 51, 90, 59, 16, 23, 84, 91, 26, 114, 115, 107, 44,
			102, 73, 31, 36, 19, 108, 55, 46, 63, 74, 93, 15, 64, 86, 37, 81,
			28, 4, 11, 70, 32, 13, 123, 53, 68, 66, 43, 30, 65, 20, 75, 121,
			21, 111, 14, 85, 9, 54, 116, 12, 103, 83, 40, 10, 126, 56, 2, 7,
			96, 41, 25, 18, 101, 47, 48, 57, 8, 104, 95, 120, 42, 76, 100, 69,
			117, 61, 89, 72, 3, 87, 124, 79, 98, 60, 29, 33, 94, 39, 106, 112,
			77, 58, 1, 109, 110, 99, 24, 119, 35, 5, 38, 118, 0, 49, 45, 122,
			127, 97, 80, 34, 17, 6, 71, 22, 82, 78, 113, 62, 105, 67, 52, 92,
			88, 125 };
	int S9[] = { 451, 203, 339, 415, 483, 233, 251, 53, 385, 185, 279, 491,
			307, 9, 45, 211, 199, 330, 55, 126, 235, 356, 403, 472, 163, 286,
			85, 44, 29, 418, 355, 280, 331, 338, 466, 15, 43, 48, 314, 229,
			273, 312, 398, 99, 227, 200, 500, 27, 1, 157, 248, 416, 365, 499,
			28, 326, 125, 209, 130, 490, 387, 301, 244, 414, 467, 221, 482,
			296, 480, 236, 89, 145, 17, 303, 38, 220, 176, 396, 271, 503, 231,
			364, 182, 249, 216, 337, 257, 332, 259, 184, 340, 299, 430, 23,
			113, 12, 71, 88, 127, 420, 308, 297, 132, 349, 413, 434, 419, 72,
			124, 81, 458, 35, 317, 423, 357, 59, 66, 218, 402, 206, 193, 107,
			159, 497, 300, 388, 250, 406, 481, 361, 381, 49, 384, 266, 148,
			474, 390, 318, 284, 96, 373, 463, 103, 281, 101, 104, 153, 336, 8,
			7, 380, 183, 36, 25, 222, 295, 219, 228, 425, 82, 265, 144, 412,
			449, 40, 435, 309, 362, 374, 223, 485, 392, 197, 366, 478, 433,
			195, 479, 54, 238, 494, 240, 147, 73, 154, 438, 105, 129, 293, 11,
			94, 180, 329, 455, 372, 62, 315, 439, 142, 454, 174, 16, 149, 495,
			78, 242, 509, 133, 253, 246, 160, 367, 131, 138, 342, 155, 316,
			263, 359, 152, 464, 489, 3, 510, 189, 290, 137, 210, 399, 18, 51,
			106, 322, 237, 368, 283, 226, 335, 344, 305, 327, 93, 275, 461,
			121, 353, 421, 377, 158, 436, 204, 34, 306, 26, 232, 4, 391, 493,
			407, 57, 447, 471, 39, 395, 198, 156, 208, 334, 108, 52, 498, 110,
			202, 37, 186, 401, 254, 19, 262, 47, 429, 370, 475, 192, 267, 470,
			245, 492, 269, 118, 276, 427, 117, 268, 484, 345, 84, 287, 75, 196,
			446, 247, 41, 164, 14, 496, 119, 77, 378, 134, 139, 179, 369, 191,
			270, 260, 151, 347, 352, 360, 215, 187, 102, 462, 252, 146, 453,
			111, 22, 74, 161, 313, 175, 241, 400, 10, 426, 323, 379, 86, 397,
			358, 212, 507, 333, 404, 410, 135, 504, 291, 167, 440, 321, 60,
			505, 320, 42, 341, 282, 417, 408, 213, 294, 431, 97, 302, 343, 476,
			114, 394, 170, 150, 277, 239, 69, 123, 141, 325, 83, 95, 376, 178,
			46, 32, 469, 63, 457, 487, 428, 68, 56, 20, 177, 363, 171, 181, 90,
			386, 456, 468, 24, 375, 100, 207, 109, 256, 409, 304, 346, 5, 288,
			443, 445, 224, 79, 214, 319, 452, 298, 21, 6, 255, 411, 166, 67,
			136, 80, 351, 488, 289, 115, 382, 188, 194, 201, 371, 393, 501,
			116, 460, 486, 424, 405, 31, 65, 13, 442, 50, 61, 465, 128, 168,
			87, 441, 354, 328, 217, 261, 98, 122, 33, 511, 274, 264, 448, 169,
			285, 432, 422, 205, 243, 92, 258, 91, 473, 324, 502, 173, 165, 58,
			459, 310, 383, 70, 225, 30, 477, 230, 311, 506, 389, 140, 143, 64,
			437, 190, 120, 0, 172, 272, 350, 292, 2, 444, 162, 234, 112, 508,
			278, 348, 76, 450 };

	public long FL(long x, long key)// FL_function
	{
		long XL, XR, KL, KR, YL, YR;
		XL = x >> 16;
		XR = x & 0x0000FFFF;
		KL = key >> 16;
		KR = key & 0x0000FFFF;
		YR = (XL & KL) ^ XR;
		YL = (YR | KR) ^ XL;
		return (YL << 16) | YR;
	}

	public long FLINV(long y, long key)// FLINV_function，FLfunction
	{
		long XL, XR, KL, KR, YL, YR;
		YL = y >> 16;
		YR = y & 0x0000FFFF;
		KL = key >> 16;
		KR = key & 0x0000FFFF;
		XL = (YR | KR) ^ YL;
		XR = (XL & KL) ^ YR;
		return (XL << 16) | XR;
	}

	public long FO(long x, int y, int z)// FOfunction
	{
		int i;
		int KOS[] = new int[4];
		int KIS[] = new int[3];
		System.arraycopy(KO, y, KOS, 0, KOS.length);
		System.arraycopy(KI, z, KIS, 0, KIS.length);
		int L1, L2, L3, R1, R2, R3;
		R1 = FI((KO[0] ^ ((int) (x >> 16) & 0xFFFF)), KI[0])
				^ ((int) (x & 0xFFFF));
		L1 = (int) (x & 0xFFFF);
		R2 = FI((L1 ^ KO[1]), KI[1]) ^ R1;
		L2 = R1;
		R3 = FI((L2 ^ KO[2]), KI[2]) ^ R2;
		L3 = R2 ^ KO[3];
		return (((long) L3) << 16) | ((long) R3);
	}

	public int FI(int x, int KI)// FIfunction
	{
		int L1, L2, L3, R1, R2, R3;
		R1 = S9[((x >> 7) & 0x1FF)] ^ (x & 0x007F);
		L1 = x & 0x7F;
		R2 = S7[L1] ^ (R1 & 0x7F) ^ ((KI >> 9) & 0x7F);
		L2 = R1 ^ (KI & 0x1FF);
		R3 = S9[L2] ^ R2;
		L3 = R2;
		return (L3 << 9) | R3;
	}

	public void KeySchedule(char userkey[]) {
		int tempkey1[] = new int[16];
		int tempkey2[] = new int[16];
		int i;
		for (i = 0; i < 8; i++)
			tempkey1[i] = (((int) userkey[i * 2]) << 8)
					+ ((int) userkey[i * 2 + 1]);
		for (i = 0; i < 8; i++)
			tempkey2[i] = FI(tempkey1[i], tempkey1[(i + 1) % 8]);
		for (i = 0; i < 8; i++) {
			KO[4 * i] = tempkey1[i];
			KO[4 * i + 1] = tempkey1[(i + 2) % 8];
			KO[4 * i + 2] = tempkey1[(i + 7) % 8];
			KO[4 * i + 3] = tempkey1[(i + 4) % 8];
			KI[3 * i] = tempkey2[(i + 5) % 8];
			KI[3 * i + 1] = tempkey2[(i + 1) % 8];
			KI[3 * i + 2] = tempkey2[(i + 3) % 8];
		}
		for (i = 0; i < 10; i++) {
			if (i % 2 == 0)
				KL[i] = (((int) tempkey1[(i + 1) / 2]) << 16)
						| (int) tempkey2[(((i + 1) / 2) + 6) % 8];

			else
				KL[i] = (((int) tempkey2[(i / 2 + 2)]) << 16)
						| (int) tempkey1[((i / 2) + 4) % 8];
		}
	}

	public void Encrypt(char ptext[], char userkey[], char ctext[]) {

		long L0, L1, L2, L3, L4, L5, L6, L7, L8, L9, R0, R1, R2, R3, R4, R5, R6, R7, R8, R9;

		KeySchedule(userkey);
		// Réincarnation, cryptage
		L0 = (((long) ptext[0]) << 24) + (((long) ptext[1]) << 16)
				+ (((long) ptext[2]) << 8) + ((long) ptext[3]);
		R0 = (((long) ptext[4]) << 24) + (((long) ptext[5]) << 16)
				+ (((long) ptext[6]) << 8) + ((long) ptext[7]);

		R1 = FL(L0, KL[0]);
		L1 = FO(R1, 0, 0) ^ FL(R0, KL[1]);
		R2 = L1;
		L2 = FO(R2, 4, 3) ^ R1;

		R3 = FL(L2, KL[2]);
		L3 = FO(R3, 8, 6) ^ FL(R2, KL[3]);
		R4 = L3;
		L4 = FO(R4, 12, 9) ^ R3;

		R5 = FL(L4, KL[4]);
		L5 = FO(R5, 16, 12) ^ FL(R4, KL[5]);
		R6 = L5;
		L6 = FO(R6, 20, 15) ^ R5;

		R7 = FL(L6, KL[6]);
		L7 = FO(R7, 24, 18) ^ FL(R6, KL[7]);
		R8 = L7;
		L8 = FO(R8, 28, 21) ^ R7;

		R9 = FL(L8, KL[8]);
		L9 = FL(R8, KL[9]);

		ctext[0] = (char) ((L9 >> 24) & 0XFF);
		ctext[1] = (char) ((L9 >> 16) & 0XFF);
		ctext[2] = (char) ((L9 >> 8) & 0XFF);
		ctext[3] = (char) (L9 & 0XFF);
		ctext[4] = (char) ((R9 >> 24) & 0XFF);
		ctext[5] = (char) ((R9 >> 16) & 0XFF);
		ctext[6] = (char) ((R9 >> 8) & 0XFF);
		ctext[7] = (char) (R9 & 0XFF);

	}

	public void Decrypt(char ctext[], char userkey[], char ptext[]) {

		long L0, L1, L2, L3, L4, L5, L6, L7, L8, L9, R0, R1, R2, R3, R4, R5, R6, R7, R8, R9;

		KeySchedule(userkey);
		// Ordre inverse, décrypter
		L9 = (((long) ctext[0]) << 24) + (((long) ctext[1]) << 16)
				+ (((long) ctext[2]) << 8) + ((long) ctext[3]);
		R9 = (((long) ctext[4]) << 24) + (((long) ctext[5]) << 16)
				+ (((long) ctext[6]) << 8) + ((long) ctext[7]);

		R8 = FLINV(L9, KL[9]);
		L8 = FO(R8, 28, 21) ^ FLINV(R9, KL[8]);
		R7 = L8;
		L7 = FO(R7, 24, 18) ^ R8;

		R6 = FLINV(L7, KL[7]);
		L6 = FO(R6, 20, 15) ^ FLINV(R7, KL[6]);
		R5 = L6;
		L5 = FO(R5, 16, 12) ^ R6;

		R4 = FLINV(L5, KL[5]);
		L4 = FO(R4, 12, 9) ^ FLINV(R5, KL[4]);
		R3 = L4;
		L3 = FO(R3, 8, 6) ^ R4;

		R2 = FLINV(L3, KL[3]);
		L2 = FO(R2, 4, 3) ^ FLINV(R3, KL[2]);
		R1 = L2;
		L1 = FO(R1, 0, 0) ^ R2;

		R0 = FLINV(L1, KL[1]);
		L0 = FLINV(R1, KL[0]);

		ptext[0] = (char) ((L0 >> 24) & 0XFF);
		ptext[1] = (char) ((L0 >> 16) & 0XFF);
		ptext[2] = (char) ((L0 >> 8) & 0XFF);
		ptext[3] = (char) (L0 & 0XFF);
		ptext[4] = (char) ((R0 >> 24) & 0XFF);
		ptext[5] = (char) ((R0 >> 16) & 0XFF);
		ptext[6] = (char) ((R0 >> 8) & 0XFF);
		ptext[7] = (char) (R0 & 0XFF);
	}

}