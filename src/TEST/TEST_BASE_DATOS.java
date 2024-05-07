/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TEST;
import BD.cconexion;
/**
 *
 * @author lucho
 */
public class TEST_BASE_DATOS {
    public static void main(String[] args) {
        cconexion xd = new cconexion();
        var hola = xd.estableceConexion();
    }
}
