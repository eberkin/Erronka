/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gehigarriak;
import java.util.Scanner;
/**
 *
 * @author ikaltamirapaag1
 */
public class Ariketa1 {
public static void Minuskula (String str1) {
 str1=str1.toLowerCase();
    System.out.println("------------------");
    System.out.println(str1);
} 
public static void main(String[] args) {
    String str1;
    Scanner irakurri = new Scanner(System.in);
    System.out.println("esaldi bat letra haundiz idatzi");
    str1 = irakurri.nextLine();
    Minuskula(str1);
}
}
